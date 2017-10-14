package com.gbackup.components;

import javax.swing.*;

public class FrameControllerC extends JFrame{

    public FrameControllerC(String applicationName)
    {
        this.setName(applicationName);
    }

    public JFrame getView()
    {
        return this;
    }
}
