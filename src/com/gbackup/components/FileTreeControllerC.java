package com.gbackup.components;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class FileTreeControllerC implements ObserverI {

    private JTree m_fileTree = null;
    private PathControllerC m_pathController = null;

    public FileTreeControllerC(JTree tree)
    {
        m_fileTree = tree;

        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Backup paths");
        m_fileTree.setModel(new DefaultTreeModel(rootNode, true));
    }

    public JTree getTree()
    {
        return m_fileTree;
    }


    public void setPathController(PathControllerC pathController)
    {
        m_pathController = pathController;
    }

    @Override
    public void handleNotify(int i, int j)
    {
        if(null != m_pathController)
        {
            DefaultMutableTreeNode root = (DefaultMutableTreeNode)m_fileTree.getModel().getRoot();
            root.removeAllChildren();

            for (String path : m_pathController.getPaths())
            {
                root.add(new DefaultMutableTreeNode(path));
            }

            DefaultTreeModel model = (DefaultTreeModel) m_fileTree.getModel();

            model.reload();
        }
        System.out.println("Add path notification received");
    }
}
