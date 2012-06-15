package kd4freebase.util;

import java.awt.Component;
import javax.swing.JComponent;
import kd4freebase.gui.LogPanel;

public class PassLog {

    public static void s(JComponent component, String s) {
        //为jframe,tabbedpane里面的jpanel设置的方法
        //this jpanel -> getRootpane ->jtabbedpane->getcontentpane ->the outer jframe->getcomponents->[logpanel,tabbedpane]
        Component[] c = component.getRootPane().getContentPane().getComponents();
        LogPanel l = (LogPanel) c[0];
        l.setLogMessage(s);
    }
}
