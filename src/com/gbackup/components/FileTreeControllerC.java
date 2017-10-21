package com.gbackup.components;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FileTreeControllerC implements ObserverI {

    private JTree m_fileTree = null;
    private PathControllerC m_pathController = null;
    private FileTreeSelectionListenerC m_fileTreeSelectionListener = null;

    public FileTreeControllerC(JTree tree)
    {
        m_fileTree = tree;

        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Backup paths");
        m_fileTree.setModel(new DefaultTreeModel(rootNode, true));

        FileTreeMouseListenerC mouseListener = new FileTreeMouseListenerC(m_fileTree);
        m_fileTreeSelectionListener = new FileTreeSelectionListenerC(m_fileTree);

        m_fileTree.addMouseListener(mouseListener);
        m_fileTree.addTreeSelectionListener(m_fileTreeSelectionListener);
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
    public void handleNotify(String name, int value)
    {
        if(name.equals(FileTreeSelectionListenerC.class.getName()))
        {
            String nodeName = m_fileTreeSelectionListener.getSelectedNode();
        }

        if(name.equals(PathControllerC.class.getName())) {
            if (null != m_pathController) {
                DefaultMutableTreeNode root = (DefaultMutableTreeNode) m_fileTree.getModel().getRoot();
                root.removeAllChildren();

                for (String path : m_pathController.getPaths()) {
                    root.add(new DefaultMutableTreeNode(path));
                }

                DefaultTreeModel model = (DefaultTreeModel) m_fileTree.getModel();

                model.reload();
            }
            System.out.println("Add path notification received");
        }
    }


}
