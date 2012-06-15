package kd4freebase.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import weka.core.Instances;
import weka.filters.unsupervised.attribute.Normalize;
import weka.filters.Filter;

public class NormalizeDialog extends javax.swing.JDialog {

    protected Instances instances;
    protected Instances newData = null;
    //private String comboxSelectedString = "False";

    public Instances getInstances() {
        return newData;
    }

    public NormalizeDialog(java.awt.Frame parent, boolean modal, Instances inst) {
        super(parent, modal);
        instances = inst;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jComboBox1 = new JComboBox();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jTextFieldScale = new JTextField();
        jTextFieldTranslation = new JTextField();
        jButtonOk = new JButton();
        jButtonCancel = new JButton();

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Normalize numeric");
        setLocationByPlatform(true);
        setModal(true);
        setResizable(false);

        jLabel1.setText("Normalizes all numeric values");

        jLabel2.setText("ingoreClass");

        jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "True", "False" }));

        jLabel3.setText("scale");

        jLabel4.setText("translation");

        jTextFieldScale.setText("1.0");

        jTextFieldTranslation.setText("0.0");

        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jButtonCancel.setText("cancel");
        jButtonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                    .addComponent(jTextFieldTranslation, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                                    .addComponent(jTextFieldScale, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonOk)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCancel)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldScale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldTranslation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jButtonCancel)
                    .addComponent(jButtonOk))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

    private void jButtonCancelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        newData = instances;
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonOkActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        try {
            Normalize filter = new Normalize();
            newData = new Instances(instances);
            Double scale = Double.valueOf(jTextFieldScale.getText().trim());
            Double tran = Double.valueOf(jTextFieldTranslation.getText().trim());
            filter.setScale(scale);
            filter.setTranslation(tran);
            filter.setInputFormat(newData);
            newData = Filter.useFilter(newData, filter);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "A error occured");
            return;
        }
        dispose();

    }//GEN-LAST:event_jButtonOkActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JButton jButtonCancel;
    public JButton jButtonOk;
    public JComboBox jComboBox1;
    public JLabel jLabel1;
    public JLabel jLabel2;
    public JLabel jLabel3;
    public JLabel jLabel4;
    public JTextField jTextFieldScale;
    public JTextField jTextFieldTranslation;
    // End of variables declaration//GEN-END:variables
}
