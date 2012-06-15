package kd4freebase.model;

import com.narphorium.freebase.query.Parameter;
import com.narphorium.freebase.query.Query;
import com.narphorium.freebase.query.io.QueryParser;
import com.narphorium.freebase.results.Result;
import com.narphorium.freebase.results.ResultSet;
import com.narphorium.freebase.services.ReadService;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class DoQuery {

    protected ReadService readService;
    protected QueryParser queryParser;
    protected Query query;
    protected ResultSet resultSet;
    protected List<Parameter> params;
    protected ArrayList<String> paramNames;

    public DoQuery(File file) {
        readService = new ReadService();
        queryParser = new QueryParser();
        query = queryParser.parse(file);
        params = query.getParameters();
        paramNames = getParamNames();
    }

    public DoQuery(String queryName, String queryString) {
        readService = new ReadService();
        queryParser = new QueryParser();
        query = queryParser.parse(queryName, queryString);
        params = query.getParameters();
        paramNames = getParamNames();
    }

    //只被构造函数调用给成员变量赋值
    private ArrayList<String> getParamNames() {
        //获取p0:name前面的p0，用来构造表的头和arff的属性，非常重要
        //这些变量需要在查询中指定
        ArrayList<String> paramNamesTemp = new ArrayList<String>();
        for (Iterator<Parameter> it = params.iterator(); it.hasNext();) {
            //getName()->p0, getId()->name
            String paramNameString = it.next().getName();
            paramNamesTemp.add(paramNameString);
        }
        return paramNamesTemp;
    }

    public DefaultTableModel excuteQuery() throws Exception {
        /**
         * @return 返回查询结果构造的TableModel
         */
        //设置TableModel的列
        DefaultTableModel tableModel = new DefaultTableModel();
        for (String s : paramNames) {
            tableModel.addColumn(s);
        }

        //构造行
        resultSet = readService.read(query);
        while (resultSet.hasNext()) {

            Vector v = new Vector();
            Result result = resultSet.next();
            for (Iterator<String> iterator = paramNames.iterator(); iterator.hasNext();) {
                String s = iterator.next();
                v.add(result.getObject(s));
            }
            tableModel.addRow(v);
        }
        return tableModel;
    }

    //this example showes that freebase's /type/datetime is string
//    public static void main(String[] args) {
//        String s="[{\"master:id\":null, \"p0:name\":\"michael jackson\", \"type\":\"/people/person\", \"p1:date_of_birth\": null,\"limit\":"+ "10}]";
//        ReadService readService=new ReadService();
//        QueryParser queryParser=new QueryParser();
//        Query query=queryParser.parse("my", s);
//        try{
//            ResultSet resultSet=readService.read(query);
//            while(resultSet.hasNext()){
//                Result result=resultSet.next();
//                System.out.println(result.getObject("p1").getClass());
//            }
//        }catch(Exception e){
//            
//        }
//    }

}
