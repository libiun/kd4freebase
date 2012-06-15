package kd4freebase.gui;

import java.awt.Component;
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
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import weka.core.Instances;
import weka.filters.unsupervised.attribute.Add;
import weka.filters.Filter;

public class AddDialog extends javax.swing.JDialog {

    protected Instances instances;
    protected Instances newData = null;
    private String comboxSelectedString = "nominal";

    public Instances getInstances() {
        return newData;
    }

    public AddDialog(java.awt.Frame parent, boolean modal, Instances inst) {
        super(parent, modal);
        instances = inst;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jTextFieldIndex = new JTextField();
        jTextFieldName = new JTextField();
        jTextFieldNominal = new JTextField();
        jLabel4 = new JLabel();
        jComboBox1 = new JComboBox();
        jLabel5 = new JLabel();
        jButtonOk = new JButton();
        jButtonCancel = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add a attribute");
        setLocationByPlatform(true);
        setModal(true);
        setResizable(false);

        jLabel1.setText("Add a attribute to dataset");

        jLabel2.setText("attributeIndex");

        jLabel3.setText("attributeName");

        jTextFieldIndex.setText("last");

        jTextFieldName.setText("unnamed");

        jLabel4.setText("nominal");

        jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "nominal", "string", "numeric" }));
        jComboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel5.setText("attributeType");

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(Alignment.LEADING)
                            .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                                    .addComponent(jTextFieldName, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                                    .addComponent(jTextFieldIndex, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                                    .addComponent(jTextFieldNominal, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonOk)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jButtonCancel)
                        .addGap(23, 23, 23))))
        );

        layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButtonCancel, jButtonOk});

        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldIndex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jTextFieldNominal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jButtonOk)
                    .addComponent(jButtonCancel))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

    private void jButtonCancelActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        newData = instances;
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonOkActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        Add filter = new Add();
        newData = new Instances(instances);

        if ("nominal".equals(comboxSelectedString)) {
            try {
                filter.setAttributeIndex(jTextFieldIndex.getText().trim());
                filter.setNominalLabels(jTextFieldNominal.getText().trim());
                filter.setAttributeName(jTextFieldName.getText().trim());
                filter.setInputFormat(newData);
                newData = Filter.useFilter(newData, filter);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "A error occured");
                return;
            }

        } else if ("numeric".equals(comboxSelectedString)) {
            try {
                filter.setAttributeIndex(jTextFieldIndex.getText().trim());
                filter.setAttributeName(jTextFieldName.getText().trim());
                filter.setInputFormat(newData);
                newData = Filter.useFilter(newData, filter);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "A error occured");
                return;
            }
        } else if ("string".equals(comboxSelectedString)) {
            try {
                filter.setAttributeIndex(jTextFieldIndex.getText().trim());
                filter.setAttributeName(jTextFieldName.getText().trim());
                String[] opString = {"-T", "STR"};
                filter.setOptions(opString);
                filter.setInputFormat(newData);
                newData = Filter.useFilter(newData, filter);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "A error occured");
                return;
            }
        }
        // System.out.println(newData);
        dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jComboBox1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        comboxSelectedString = (String) cb.getSelectedItem();
    }//GEN-LAST:event_jComboBox1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JButton jButtonCancel;
    public JButton jButtonOk;
    public JComboBox jComboBox1;
    public JLabel jLabel1;
    public JLabel jLabel2;
    public JLabel jLabel3;
    public JLabel jLabel4;
    public JLabel jLabel5;
    public JTextField jTextFieldIndex;
    public JTextField jTextFieldName;
    public JTextField jTextFieldNominal;
    // End of variables declaration//GEN-END:variables
}
