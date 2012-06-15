package kd4freebase.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import kd4freebase.model.TranTableModelToDataset;
import kd4freebase.util.PassLog;
import weka.core.Instances;

public class QueryDataPanel extends javax.swing.JPanel implements MainFramePanel {

    private static final long serialVersionUID = 1L;
    private InputDialog inputDialog;
    private DefaultTableModel table3;
    protected MainFrame mainFrame = null;
    protected Instances instances;
    protected PropertyChangeSupport m_Support = new PropertyChangeSupport(this);

    public QueryDataPanel() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanel1 = new JPanel();
        jButtonFristQuery = new JButton();
        jButtonSecondQuery = new JButton();
        jButtonMoreQuery = new JButton();
        jButtonMergeTwoTables = new JButton();
        jButtonReset = new JButton();
        jButtonSaveToArff = new JButton();
        jButtonJustOneQuery = new JButton();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jButtonLoadArff = new JButton();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jScrollPane2 = new JScrollPane();
        jTable2 = new JTable();
        jScrollPane3 = new JScrollPane();
        jTable3 = new JTable();

        jPanel1.setBorder(BorderFactory.createTitledBorder("Add Query"));

        jButtonFristQuery.setText("Add First Query");
        jButtonFristQuery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonFristQueryActionPerformed(evt);
            }
        });

        jButtonSecondQuery.setText("Add Second Query");
        jButtonSecondQuery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonSecondQueryActionPerformed(evt);
            }
        });

        jButtonMoreQuery.setText("Add More Query ?");

        jButtonMergeTwoTables.setText("Merge Two Results");
        jButtonMergeTwoTables.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonMergeTwoTablesActionPerformed(evt);
            }
        });

        jButtonReset.setText("Reset");
        jButtonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });

        jButtonSaveToArff.setText("Save Merged ToArff");
        jButtonSaveToArff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonSaveToArffActionPerformed(evt);
            }
        });

        jButtonJustOneQuery.setText("Just One Query");
        jButtonJustOneQuery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonJustOneQueryActionPerformed(evt);
            }
        });

        jLabel1.setText("Simple Query");

        jLabel2.setText("Complex Query");

        jLabel3.setText("Data Control");

        jButtonLoadArff.setText("Load Data");
        jButtonLoadArff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonLoadArffActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jButtonLoadArff, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jButtonReset, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jButtonJustOneQuery, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jButtonFristQuery, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jButtonSecondQuery, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jButtonMoreQuery, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jButtonMergeTwoTables, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jButtonSaveToArff, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jButtonJustOneQuery)
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jButtonFristQuery)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jButtonSecondQuery)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jButtonMoreQuery)
                .addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jButtonMergeTwoTables)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jButtonSaveToArff, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jButtonLoadArff, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jButtonReset, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        jScrollPane1.setBorder(BorderFactory.createTitledBorder("1th Query Result"));

        jTable1.setModel(new DefaultTableModel());
        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setBorder(BorderFactory.createTitledBorder("2ed Query Result"));

        jTable2.setModel(new DefaultTableModel());
        jScrollPane2.setViewportView(jTable2);

        jScrollPane3.setBorder(BorderFactory.createTitledBorder("After Merged"));

        jTable3.setModel(new DefaultTableModel());
        jScrollPane3.setViewportView(jTable3);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(Alignment.LEADING)
                            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, Alignment.TRAILING, 0, 0, Short.MAX_VALUE))
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }//GEN-END:initComponents

    private void jButtonMergeTwoTablesActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonMergeTwoTablesActionPerformed

        DefaultTableModel table1 = (DefaultTableModel) jTable1.getModel();
        DefaultTableModel table2 = (DefaultTableModel) jTable2.getModel();
        table3 = (DefaultTableModel) jTable3.getModel();

        String masterColumnName = "";
        int masterColumnIndex1 = 0;
        int masterColumnIndex2 = 0;
        for (int i = 0; i < table1.getColumnCount(); i++) {
            for (int j = 0; j < table2.getColumnCount(); j++) {
                if (table1.getColumnName(i).equals(table2.getColumnName(j))) {
                    masterColumnName = table1.getColumnName(i);
                    masterColumnIndex1 = i;
                    masterColumnIndex2 = j;
                }
            }
        }

        if ("".equals(masterColumnName)) {
            PassLog.s(this, "no master attribute same, can't merge two unrelated results");
            return;
        }

        //[[first row],[second row],[third row],...]
        Vector allRowVector1 = table1.getDataVector();
        Vector allRowVector2 = table2.getDataVector();
        ArrayList<Vector> afterMerge = new ArrayList<Vector>();
        for (Iterator it1 = allRowVector1.iterator(); it1.hasNext();) {
            Vector v1 = (Vector) it1.next();
            Object value = v1.get(masterColumnIndex1);
            for (Iterator it2 = allRowVector2.iterator(); it2.hasNext();) {
                Vector v2 = (Vector) it2.next();
                Object value2 = v2.get(masterColumnIndex2);
                if (null != value && value.equals(value2)) {
                    v1.addAll(v2);
                    v1.remove(value2);
                    afterMerge.add(v1);
                }
            }
        }
        jButtonMergeTwoTables.setEnabled(false);
        //System.out.println(afterMerge);

        for (int i = 0; i < table1.getColumnCount() + table2.getColumnCount() - 1; i++) {
            table3.addColumn("col" + i);
        }
        for (Iterator<Vector> it = afterMerge.iterator(); it.hasNext();) {
            Vector vector = it.next();
            table3.addRow(vector);
        }
        PassLog.s(this, "Query One and Two Results were merged and showed on Table Three");
    }//GEN-LAST:event_jButtonMergeTwoTablesActionPerformed

    private void jButtonFristQueryActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonFristQueryActionPerformed

        inputDialog = new InputDialog(null, true);
        inputDialog.setVisible(true);

        jTable1.setModel(inputDialog.getTableMode());
        PassLog.s(this, "First Query was Done");
    }//GEN-LAST:event_jButtonFristQueryActionPerformed

    private void jButtonSecondQueryActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonSecondQueryActionPerformed
        inputDialog = new InputDialog(null, true);
        inputDialog.setVisible(true);

        jTable2.setModel(inputDialog.getTableMode());
        PassLog.s(this, "Second Query was Done");
    }//GEN-LAST:event_jButtonSecondQueryActionPerformed

    private void jButtonResetActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        resetGui();
        setInstances(null);

        for (int j = 1; j < mainFrame.jTabbedPane.getTabCount(); j++) {
            mainFrame.jTabbedPane.setEnabledAt(j, false);
        }

        jTable1.setModel(new DefaultTableModel());
        jTable2.setModel(new DefaultTableModel());
        jTable3.setModel(new DefaultTableModel());

        PassLog.s(this, "System were initialized");
    }//GEN-LAST:event_jButtonResetActionPerformed

    private void jButtonSaveToArffActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonSaveToArffActionPerformed
        try {
            if (null == table3 || 0 == table3.getColumnCount()) {
                PassLog.s(this, "no merged data");
                return;
            }

            for (int i = 0; i < table3.getColumnCount(); i++) {
                if ("".equals(table3.getValueAt(0, i))) {
                    JOptionPane.showMessageDialog(this, "请先填满第一行空白元素");
                    return;
                }
            }

            TranTableModelToDataset t = new TranTableModelToDataset(jTable3.getModel());
            JFileChooser saver = new JFileChooser();
            saver.setCurrentDirectory(new File("resources"));
            saver.addChoosableFileFilter(new FileFilter() {

                @Override
                public boolean accept(File f) {
                    return f.getName().toLowerCase().endsWith(".arff");
                }

                @Override
                public String getDescription() {
                    return "arff file";
                }
            });

            saver.setDialogType(JFileChooser.SAVE_DIALOG);
            int index = saver.showDialog(this, "保存文件");
            String saveplace = "";
            if (JFileChooser.APPROVE_OPTION == index) {
                saveplace = saver.getSelectedFile() + ".arff";
                // System.out.println(saveplace);
            } else {
                return;
            }
            try {
                Boolean s = t.saveTableModelToArff(saveplace);
                if (s) {
                    PassLog.s(this, "保存Arff到:" + saveplace);
                } else {
                    throw new Exception("转换table到arff模型错误");
                }
            } catch (IOException ex) {
                PassLog.s(this, ex.getMessage());
            } catch (Exception e) {
                PassLog.s(this, "转换table到arff模型错误：" + e.getMessage());
            }
            //设置成员变量
            instances = new Instances(new FileReader(new File(saveplace)));
            m_Support.firePropertyChange("", null, instances);
        } catch (Exception ex) {
            System.out.println("QueryDataPanel set Instances error");
        }
        //System.out.println(instances);
    }//GEN-LAST:event_jButtonSaveToArffActionPerformed

    private void jButtonJustOneQueryActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonJustOneQueryActionPerformed
        simpleQuerysetComponentDisable();
        inputDialog = new InputDialog(null, true);
        inputDialog.setVisible(true);

        table3 = inputDialog.getTableMode();
        jTable3.setModel(table3);
        PassLog.s(this, "Simple Query was Done");


    }//GEN-LAST:event_jButtonJustOneQueryActionPerformed

    private void jButtonLoadArffActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonLoadArffActionPerformed
        try {
            instances = new Instances(new FileReader(new File("d://quake836.arff")));
            m_Support.firePropertyChange("", null, instances);
        } catch (Exception ex) {
            PassLog.s(this, "get d: quake836.arff wrong：" + ex.getMessage());
        }

    }//GEN-LAST:event_jButtonLoadArffActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    JButton jButtonFristQuery;
    JButton jButtonJustOneQuery;
    JButton jButtonLoadArff;
    JButton jButtonMergeTwoTables;
    JButton jButtonMoreQuery;
    JButton jButtonReset;
    JButton jButtonSaveToArff;
    JButton jButtonSecondQuery;
    JLabel jLabel1;
    JLabel jLabel2;
    JLabel jLabel3;
    JPanel jPanel1;
    JScrollPane jScrollPane1;
    JScrollPane jScrollPane2;
    JScrollPane jScrollPane3;
    JTable jTable1;
    JTable jTable2;
    JTable jTable3;
    // End of variables declaration//GEN-END:variables

    private void simpleQuerysetComponentDisable() {
        jButtonFristQuery.setEnabled(false);
        jButtonSecondQuery.setEnabled(false);
        jButtonMoreQuery.setEnabled(false);
        jButtonMergeTwoTables.setEnabled(false);
    }

    private void resetGui() {
        jButtonMergeTwoTables.setEnabled(true);
        jButtonFristQuery.setEnabled(true);
        jButtonSecondQuery.setEnabled(true);
        jButtonMoreQuery.setEnabled(true);
        jButtonMergeTwoTables.setEnabled(true);
    }

    @Override
    public void setMainFrame(MainFrame parent) {
        mainFrame = parent;
    }

    @Override
    public MainFrame getMainFrame() {
        return mainFrame;
    }

    @Override
    public void setInstances(Instances inst) {
        instances = inst;
        m_Support.firePropertyChange("", null, null);
    }

    public Instances getInstances() {
        return instances;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener l) {

        m_Support.addPropertyChangeListener(l);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener l) {

        m_Support.removePropertyChangeListener(l);
    }
}
