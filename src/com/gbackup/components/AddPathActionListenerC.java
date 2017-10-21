package com.gbackup.components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class AddPathActionListenerC implements ActionListener {

    private JFileChooser m_fileChooser = null;
    private JComponent m_parentComponent = null;
    private PathControllerC m_pathController = null;

    public AddPathActionListenerC(JComponent parentComponent)
    {
        m_parentComponent = parentComponent;
        m_fileChooser = new JFileChooser();

        m_fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        m_fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button Add Clicked");

        int result = m_fileChooser.showOpenDialog(m_parentComponent);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = m_fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            if(null != m_pathController)
            {
                m_pathController.addPath(selectedFile.getAbsolutePath());
            }
        }
    }

    public void setPathController(PathControllerC pathController)
    {
        m_pathController = pathController;
    }
}
