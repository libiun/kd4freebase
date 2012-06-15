package kd4freebase.gui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;

public class MainFrame extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    protected QueryDataPanel queryData = new QueryDataPanel();
    protected ArffEditorPanel arffEditor = new ArffEditorPanel();
    protected Vector<MainFramePanel> m_Panels = new Vector<MainFramePanel>();
    private String[] classname = {"kd4freebase.gui.ClassifyPanel",
        "kd4freebase.gui.ClusterPanel", "kd4freebase.gui.AssociatePanel"};
    private String[] panelName = {"Classify", "Cluster", "Associate"};
//no visualizationPanel

    public MainFrame() {
        initComponents();

        jTabbedPane.addTab("Query Freebase", queryData);
        jTabbedPane.addTab("Arff Editor", arffEditor);
        jTabbedPane.setEnabledAt(1, false);
        for (int i = 0; i < classname.length; i++) {
            try {
                MainFramePanel panel = (MainFramePanel) Class.forName(classname[i]).newInstance();
                panel.setMainFrame(this);

                m_Panels.add(panel);
                jTabbedPane.addTab(panelName[i], (JPanel) panel);
                jTabbedPane.setEnabledAt(i + 2, false);

                queryData.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        for (int i = 0; i < m_Panels.size(); i++) {
                            arffEditor.setInstances(queryData.getInstances());
                            m_Panels.get(i).setInstances(queryData.getInstances());
                            jTabbedPane.setEnabledAt(i + 1, true);
                            jTabbedPane.setEnabledAt(jTabbedPane.getTabCount() - 1, true);
                        }
                    }
                });
                arffEditor.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        for (int i = 0; i < m_Panels.size(); i++) {
                            m_Panels.get(i).setInstances(arffEditor.getInstances());
                        }
                    }
                });
                arffEditor.setMainFrame(this);
                queryData.setMainFrame(this);
            } catch (Exception ex) {
                //Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("error");
            }
        }

    }

    public JTabbedPane getjTabbedPane() {
        return jTabbedPane;
    }

    public Vector<MainFramePanel> getM_Panels() {
        return m_Panels;
    }

    public QueryDataPanel getQueryData() {
        return queryData;
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jTabbedPane = new JTabbedPane();
        logPanel1 = new LogPanel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("KD4Freebase By LIJUN");
        setLocationByPlatform(true);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addComponent(logPanel1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
            .addComponent(jTabbedPane, GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane, GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(logPanel1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                MainFrame m = new MainFrame();
                m.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    JTabbedPane jTabbedPane;
    LogPanel logPanel1;
    // End of variables declaration//GEN-END:variables
}
