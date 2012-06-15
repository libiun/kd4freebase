package kd4freebase.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.table.TableModel;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffSaver;

/**
 *
 * @author Administrator
 * 把TableModel转换为weka的Dataset
 */
public class TranTableModelToDataset {

    private TableModel tableModel;
    private FastVector attributes = new FastVector();

    public TranTableModelToDataset(TableModel tableModel) {
        this.tableModel = tableModel;
    }

    public boolean saveTableModelToArff(String saveplace) throws IOException {
        //返回boolean只可能会返回true，意味程序无异常执行到最后
        //如果程序出现Runtime异常，就会返回异常，boolean类型得不到判断
        //@attribute
        Boolean success=false;
        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            String colname = tableModel.getColumnName(i);
            String colElementClass = tableModel.getValueAt(0, i).getClass().getName();

            if ("java.lang.String".equals(colElementClass)) {
                //如果元素是string类型
                attributes.addElement(new Attribute(colname, (FastVector) null));
            } else if ("java.lang.Double".equals(colElementClass) || "java.lang.Long".equals(colElementClass) || "java.lang.Integer".equals(colElementClass)) {
                //如果元素是数字numeric,nominal和date类型没有定义,目前来看freebase date_of_birt这种/type/datetime也是用string来存数据的
                attributes.addElement(new Attribute(colname));
            }
        }
        Instances dataset = new Instances("mydataset", attributes, 0);

        //@data
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Instance instanceRow = new Instance(dataset.numAttributes());
            instanceRow.setDataset(dataset);
            for (int j = 0; j < dataset.numAttributes(); j++) {
                if (dataset.attribute(j).isNumeric()) {
                    if (null != tableModel.getValueAt(i, j)) {
                        instanceRow.setValue(j, Double.parseDouble(String.valueOf(tableModel.getValueAt(i, j))));
                    } else {
                        instanceRow.setMissing(j);
                    }

                } else if (dataset.attribute(j).isString()) {
                    if ("".equals(tableModel.getValueAt(i, j))) {
                        instanceRow.setMissing(j);
                    } else {
                        instanceRow.setValue(j, (String) tableModel.getValueAt(i, j));
                    }
                }
            }
            dataset.add(instanceRow);
        }
        //System.out.println(dataset);
        ArffSaver saver = new ArffSaver();
        saver.setInstances(dataset);
        saver.setDestination(new FileOutputStream(new File(saveplace)));
        saver.writeBatch();
        
        success=true;
        return success;
        
    }
}
