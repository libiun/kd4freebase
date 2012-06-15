package kd4freebase.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import kd4freebase.model.DoQuery;

public class InputDialog extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;
    private JFileChooser chooser = new JFileChooser();
    private DefaultTableModel tableMode = new DefaultTableModel();
    private DoQuery doQuery;

    public DefaultTableModel getTableMode() {
        return tableMode;
    }

    public InputDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initFileChooser();
    }

    private void initFileChooser() {
        //获取原来已有的过滤器
        FileFilter[] fileFilter = chooser.getChoosableFileFilters();
        int fSize = fileFilter.length;
        for (int i = 0; i < fSize; i++) {
            chooser.removeChoosableFileFilter(fileFilter[i]);
        }

        chooser.addChoosableFileFilter(new FileFilter() {

            private boolean flag;

            @Override
            public boolean accept(File f) {
                if (f.getName().toLowerCase().endsWith(".json")) {
                    flag = true;
                } else if (f.isDirectory()) {
                    flag = true;
                } else {
                    flag = false;
                }
                return flag;
            }

            @Override
            public String getDescription() {
                return "json文件";
            }
        });
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jScrollPane1 = new JScrollPane();
        jTextAreaInputArea = new JTextArea();
        jButtonDoQuery = new JButton();
        jButtonLoadFromFile = new JButton();
        jLabelQueryStatus = new JLabel();
        jButtonDispose = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("查询输入窗口");
        setLocationByPlatform(true);

        jScrollPane1.setBorder(BorderFactory.createTitledBorder("Input Area"));

        jTextAreaInputArea.setColumns(20);
        jTextAreaInputArea.setFont(new Font("Monospaced", 0, 16));
        jTextAreaInputArea.setRows(5);
        jTextAreaInputArea.setText("[{\n  \"master:id\":        null,\n  \"p1:name\":      null,\n  \"p2:calling_code\": null,\n  \"type\":         \"/location/country\",\n  \"limit\":        30\n}]​");
        jScrollPane1.setViewportView(jTextAreaInputArea);

        jButtonDoQuery.setText("Query");
        jButtonDoQuery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonDoQueryActionPerformed(evt);
            }
        });

        jButtonLoadFromFile.setText("Input From File");
        jButtonLoadFromFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonLoadFromFileActionPerformed(evt);
            }
        });

        jLabelQueryStatus.setText("status");

        jButtonDispose.setText("Ok");
        jButtonDispose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonDisposeActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonLoadFromFile)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jButtonDoQuery, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jButtonDispose)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jLabelQueryStatus))
            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 873, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 554, GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jButtonDispose, Alignment.TRAILING)
                    .addComponent(jButtonDoQuery, Alignment.TRAILING)
                    .addComponent(jButtonLoadFromFile, Alignment.TRAILING)))
            .addGroup(layout.createSequentialGroup()
                .addGap(575, 575, 575)
                .addComponent(jLabelQueryStatus))
        );

        pack();
    }//GEN-END:initComponents

    private void jButtonLoadFromFileActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonLoadFromFileActionPerformed
        int in = chooser.showOpenDialog(this);
        File selectFile = chooser.getSelectedFile();

        if (null == selectFile || JFileChooser.CANCEL_OPTION == in) {
            //没有选择文件或取消选择
            return;
        } else {
            int choose = JOptionPane.showConfirmDialog(this, "你确定打开文件？", "请确认！", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (choose == JOptionPane.NO_OPTION) {
                //选错文件之类
                return;
            } else {
                String temp = "";
                BufferedReader bf = null;
                setTitle(selectFile.getPath());
                try {
                    int size = (int) selectFile.length();
                    byte[] tempArray = new byte[size];
                    FileInputStream fin = new FileInputStream(selectFile);
                    fin.read(tempArray);
                    temp = new String(tempArray);
                    this.jTextAreaInputArea.setText(temp);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }//GEN-LAST:event_jButtonLoadFromFileActionPerformed

    private void jButtonDoQueryActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonDoQueryActionPerformed
        String queryText = jTextAreaInputArea.getText().trim();
        if ("".equals(queryText)) {
            JOptionPane.showMessageDialog(this, "Please input query string", "提示：", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        doQuery = new DoQuery("myquery", queryText);
        try {
            tableMode = doQuery.excuteQuery();
            jLabelQueryStatus.setText("query successful");
        } catch (Exception ex) {
            jLabelQueryStatus.setText("wrong,please check the mql is correct");
        }

    }//GEN-LAST:event_jButtonDoQueryActionPerformed

    private void jButtonDisposeActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonDisposeActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonDisposeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    JButton jButtonDispose;
    JButton jButtonDoQuery;
    JButton jButtonLoadFromFile;
    JLabel jLabelQueryStatus;
    JScrollPane jScrollPane1;
    JTextArea jTextAreaInputArea;
    // End of variables declaration//GEN-END:variables
}
