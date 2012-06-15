package kd4freebase.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import kd4freebase.util.PassLog;
import weka.core.Instances;
import weka.gui.explorer.ClassifierPanel;

public class ClassifyPanel extends javax.swing.JPanel implements MainFramePanel{

    public ClassifyPanel() {
        initComponents();
      
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        classifierPanel1 = new ClassifierPanel();
        jButtonUpdate = new JButton();

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonUpdate)
                .addContainerGap(550, Short.MAX_VALUE))
            .addComponent(classifierPanel1, GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonUpdate)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(classifierPanel1, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void jButtonUpdateActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        if(null==instances){
            PassLog.s(this, "Must query data first");
            return;
        }
        classifierPanel1.setInstances(instances);
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public ClassifierPanel classifierPanel1;
    public JButton jButtonUpdate;
    // End of variables declaration//GEN-END:variables

    protected MainFrame mainFrame=null;
    protected Instances instances;
    @Override
    public void setMainFrame(MainFrame parent) {
        mainFrame=parent;
    }

    @Override
    public MainFrame getMainFrame() {
        return mainFrame;
    }

    @Override
    public void setInstances(Instances inst) {
        instances=inst;
    }
}
