package kd4freebase.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import kd4freebase.util.PassLog;
import weka.core.Instances;
import weka.gui.explorer.ClustererPanel;

public class ClusterPanel extends javax.swing.JPanel implements MainFramePanel {

    public ClusterPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jButton1 = new JButton();
        clustererPanel1 = new ClustererPanel();

        jButton1.setText("Update");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(522, Short.MAX_VALUE))
            .addComponent(clustererPanel1, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(clustererPanel1, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE))
        );
    }//GEN-END:initComponents

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if(null==instances){
            PassLog.s(this, "Must query data first");
            return;
        }
        clustererPanel1.setInstances(instances);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public ClustererPanel clustererPanel1;
    public JButton jButton1;
    // End of variables declaration//GEN-END:variables

    protected Instances instances;
    protected MainFrame mainFrame=null;
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
