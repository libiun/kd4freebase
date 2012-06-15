package kd4freebase.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author libiun
 */
public class LogPanel extends javax.swing.JPanel {

    private static final long serialVersionUID = 1L;

    public LogPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jScrollPane1 = new JScrollPane();
        jTextAreaLog = new JTextArea();

        setBorder(BorderFactory.createTitledBorder("LOG"));

        jTextAreaLog.setColumns(20);
        jTextAreaLog.setEditable(false);
        jTextAreaLog.setRows(5);
        jTextAreaLog.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jTextAreaLogMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTextAreaLog);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
        );
    }//GEN-END:initComponents

    private void jTextAreaLogMouseClicked(MouseEvent evt) {//GEN-FIRST:event_jTextAreaLogMouseClicked

        if (evt.getClickCount() == 2) {
            jTextAreaLog.setText("");
        }
    }//GEN-LAST:event_jTextAreaLogMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public JScrollPane jScrollPane1;
    public JTextArea jTextAreaLog;
    // End of variables declaration//GEN-END:variables

    public void setLogMessage(String log) {
        jTextAreaLog.append((new SimpleDateFormat("HH:mm:ss - ")).format(new Date()) + log + "\n");
    }
}
