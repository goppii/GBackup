package com.gbackup.gui;

import com.gbackup.components.FileTreeControllerC;

import javax.swing.*;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGui {
    private JButton doSomethingButton;
    private JPanel myfield;
    private FileTreeControllerC m_fileTree = null;

    public MainGui()
    {
        doSomethingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "HelloWorld");
            }
        });


        m_fileTree = new FileTreeControllerC("SpeacialNode");


        //fileTreeGui.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

    }

    public JPanel getPanel()
    {
        return  myfield;
    }

}
