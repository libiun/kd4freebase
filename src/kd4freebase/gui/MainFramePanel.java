package kd4freebase.gui;

import weka.core.Instances;

public interface MainFramePanel {

    public void setMainFrame(MainFrame parent);

    public MainFrame getMainFrame();

    public void setInstances(Instances inst);
}
