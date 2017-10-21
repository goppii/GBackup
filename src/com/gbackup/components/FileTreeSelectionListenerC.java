package com.gbackup.components;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class FileTreeSelectionListenerC extends SubjectC implements TreeSelectionListener {

    private JTree m_fileTree = null;
    private String m_selectedNode;

    public FileTreeSelectionListenerC(JTree tree)
    {
        m_fileTree = tree;
    }

    @Override
    public void valueChanged(TreeSelectionEvent e)
    {
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)m_fileTree.getLastSelectedPathComponent();
        notify(this.getClass().getName(),1);

        m_selectedNode = selectedNode.toString();
    }

    public String getSelectedNode()
    {
        return m_selectedNode;
    }
}
