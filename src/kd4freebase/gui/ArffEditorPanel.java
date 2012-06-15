package kd4freebase.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import kd4freebase.util.PassLog;
import weka.core.Instances;
import weka.gui.arffviewer.ArffPanel;

public class ArffEditorPanel extends JPanel implements MainFramePanel {
    
    private static final long serialVersionUID = 1L;
    protected MainFrame mainFrame = null;
    protected Instances instances;
    protected PropertyChangeSupport m_Support = new PropertyChangeSupport(this);
    
    public ArffEditorPanel() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jButtonUpdate = new JButton();
        arffPanel1 = new ArffPanel();
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTree1 = new JTree();
        jButtonApply = new JButton();

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jPanel1.setBorder(BorderFactory.createTitledBorder("Do Filter"));
        DefaultMutableTreeNode treeNode1 = new DefaultMutableTreeNode("Filters");
        DefaultMutableTreeNode treeNode2 = new DefaultMutableTreeNode("unsupervised");
        DefaultMutableTreeNode treeNode3 = new DefaultMutableTreeNode("attribute");
        DefaultMutableTreeNode treeNode4 = new DefaultMutableTreeNode("Add");
        treeNode3.add(treeNode4);
        treeNode4 = new DefaultMutableTreeNode("Normalize");
        treeNode3.add(treeNode4);
        treeNode4 = new DefaultMutableTreeNode("StringToNominal");
        treeNode3.add(treeNode4);
        treeNode2.add(treeNode3);
        treeNode3 = new DefaultMutableTreeNode("instance");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new DefaultMutableTreeNode("supervised");
        treeNode3 = new DefaultMutableTreeNode("attribute");
        treeNode2.add(treeNode3);
        treeNode3 = new DefaultMutableTreeNode("instance");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        jTree1.setModel(new DefaultTreeModel(treeNode1));
        jTree1.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent evt) {
                jTree1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jTree1);

        jButtonApply.setText("Apply");
        jButtonApply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonApplyActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
                    .addComponent(jButtonApply, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jButtonApply))
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(arffPanel1, GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                    .addComponent(jButtonUpdate))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButtonUpdate)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(arffPanel1, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }//GEN-END:initComponents
    
    private void jButtonUpdateActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        if (null == instances) {
            PassLog.s(this, "Must query data first");
            return;
        }
        // instancesSummaryPanel1.setInstances(instances);
        arffPanel1.setInstances(instances);
        //System.out.println(arffPanel1.getInstances());
    }//GEN-LAST:event_jButtonUpdateActionPerformed
    private TreePath tp;
    private DefaultMutableTreeNode tempNode;
    protected AddDialog addDialog;
    protected NormalizeDialog normalizeDialog;
    protected StringToNominalDialog stringToNominalDialog;
    private void jTree1ValueChanged(TreeSelectionEvent evt) {//GEN-FIRST:event_jTree1ValueChanged
        tp = evt.getNewLeadSelectionPath();
        tempNode = (DefaultMutableTreeNode) tp.getLastPathComponent();
    }//GEN-LAST:event_jTree1ValueChanged
    
    private void jButtonApplyActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonApplyActionPerformed
        if (null == tempNode) {
            JOptionPane.showMessageDialog(this, "Please choose a filter");
            return;
        }
        if ("Add".equals(tempNode.toString())) {
            addDialog = new AddDialog(null, true, instances);
            addDialog.setVisible(true);
            
            instances = addDialog.getInstances();
            m_Support.firePropertyChange("", null, instances);
            // System.out.println(instances);
        } else if ("Normalize".equals(tempNode.toString())) {
            normalizeDialog = new NormalizeDialog(null, true, instances);
            normalizeDialog.setVisible(true);
            
            instances = normalizeDialog.getInstances();
            m_Support.firePropertyChange("", null, instances);
            
        }else if("StringToNominal".endsWith(tempNode.toString())){
            stringToNominalDialog=new StringToNominalDialog(null, true, instances);
            stringToNominalDialog.setVisible(true);
            
            instances=stringToNominalDialog.getInstances();
            m_Support.firePropertyChange("",null,instances);
        }
    }//GEN-LAST:event_jButtonApplyActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    ArffPanel arffPanel1;
    JButton jButtonApply;
    JButton jButtonUpdate;
    JPanel jPanel1;
    JScrollPane jScrollPane1;
    JTree jTree1;
    // End of variables declaration//GEN-END:variables

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
