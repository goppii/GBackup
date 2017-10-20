package com.gbackup.gui;

import com.gbackup.components.*;

import javax.swing.*;
import java.awt.*;

public class GuiC implements ObserverI {


    private FrameControllerC m_frameController = null;

    public GuiC()
    {
        m_frameController = new FrameControllerC("GBackup");
        m_frameController.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        m_frameController.setMinimumSize(new Dimension(400, 400));

        PathControllerC pathController = new PathControllerC();

        FileTreeControllerC fileTree = new FileTreeControllerC(new JTree());
        fileTree.setPathController(pathController);

        //main panel
        PanelControllerC mainPanel = new PanelControllerC();
        mainPanel.setLayout(new GridLayout(2,1));

        PanelControllerC buttonPanel = new PanelControllerC();
        buttonPanel.setLayout(new GridLayout(1,3));

        JButton addPathButton = new JButton();
        AddPathActionListenerC addPathListener = new AddPathActionListenerC(addPathButton);
        addPathListener.add(fileTree);
        addPathListener.setPathController(pathController);

        addPathButton.addActionListener(addPathListener);
        addPathButton.setName("AddPathButton");
        addPathButton.setText("Add");

        buttonPanel.add(addPathButton);
        buttonPanel.add(new ButtonControllerC());
        buttonPanel.add(new ButtonControllerC());

        mainPanel.add(fileTree.getTree());
        mainPanel.add(buttonPanel);

        m_frameController.getContentPane().add(mainPanel);

        m_frameController.pack();
        //m_frameController.setVisible(false);
    }

    @Override
    public void handleNotify(int i, int j) {

        if(i == SystemTrayTypesC.TrayIconType.OPEN.getValue())
        {
            m_frameController.setVisible(true);
        }
    }
}
