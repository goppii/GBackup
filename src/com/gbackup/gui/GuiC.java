package com.gbackup.gui;

import com.gbackup.components.FileTreeControllerC;
import com.gbackup.components.FrameControllerC;
import  com.gbackup.components.ObserverInterface;
import com.gbackup.components.PanelControllerC;

import javax.swing.*;
import javax.swing.tree.TreeModel;

public class GuiC implements ObserverInterface {


    FrameControllerC m_frameController = null;

    public GuiC()
    {
        m_frameController = new FrameControllerC("GBackup");
        m_frameController.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        m_frameController.getContentPane().add(new PanelControllerC());

        m_frameController.pack();
        m_frameController.setVisible(false);
    }

    public void setTree(FileTreeControllerC tree)
    {
        m_frameController.getContentPane().add(tree.getView());
    }

    @Override
    public void handleNotify(int i, int j) {

        if(i == SystemTrayTypesC.TrayIconType.OPEN.getValue())
        {
            m_frameController.setVisible(true);
        }
    }
}
