package com.gbackup.components;

import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FileTreeMouseListenerC implements MouseListener {

    private JTree m_fileTree = null;
    private int selectedRow = -1;

    public FileTreeMouseListenerC(JTree tree)
    {
        m_fileTree = tree;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        if (SwingUtilities.isRightMouseButton(e))
        {
            selectedRow = m_fileTree.getRowForLocation(e.getX(), e.getY());
            TreePath selPath = m_fileTree.getPathForLocation(e.getX(), e.getY());
            m_fileTree.setSelectionPath(selPath);
            if (selectedRow > -1)
            {
                m_fileTree.setSelectionRow(selectedRow);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
