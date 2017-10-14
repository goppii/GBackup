package com.gbackup.components;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class FileTreeControllerC extends JTree{


    public FileTreeControllerC(String rootNodeName)
    {
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(rootNodeName);
        this.setModel(new DefaultTreeModel(rootNode, true));
    };

    public void init()
    {
        //m_treeModel.
    }

    public JTree getView()
    {
        return this;
    }


}
