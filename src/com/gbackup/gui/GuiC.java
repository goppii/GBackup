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
        pathController.add(fileTree);

        //main panel
        PanelControllerC mainPanel = new PanelControllerC();
        mainPanel.setLayout(new GridLayout(2,2));

        PanelControllerC fileInfoPanel = new PanelControllerC();
        fileInfoPanel.setLayout(new GridLayout(2,2));

        JLabel sizeName = new JLabel();
        sizeName.setText("Size:");
        fileInfoPanel.add(sizeName);

        fileInfoPanel.add(new JLabel());

        JLabel quantityName = new JLabel();
        quantityName.setText("Quantity:");
        fileInfoPanel.add(quantityName);

        fileInfoPanel.add(new JLabel());

        PanelControllerC buttonPanel = new PanelControllerC();
        buttonPanel.setLayout(new GridLayout(1,3));
        buttonPanel.setMaximumSize(new Dimension(40, 20));

        JButton addPathButton = new JButton();
        AddPathActionListenerC addPathListener = new AddPathActionListenerC(addPathButton);
        addPathListener.setPathController(pathController);

        addPathButton.addActionListener(addPathListener);
        addPathButton.setName("AddPathButton");
        addPathButton.setText("Add");

        buttonPanel.add(addPathButton);
        buttonPanel.add(new ButtonControllerC());
        buttonPanel.add(new ButtonControllerC());

        mainPanel.add(new JScrollPane(fileTree.getTree()));
        mainPanel.add(fileInfoPanel);
        mainPanel.add(buttonPanel);

        m_frameController.getContentPane().add(mainPanel);

        m_frameController.pack();
        //m_frameController.setVisible(false);
    }

    @Override
    public void handleNotify(String name, int value) {

        if(value == SystemTrayTypesC.TrayIconType.OPEN.getValue())
        {
            m_frameController.setVisible(true);
        }
    }
}
