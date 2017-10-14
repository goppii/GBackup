package com.gbackup.gui;

import com.gbackup.components.SubjectInterface;
import com.gbackup.components.ObserverInterface;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;


public class SystemTrayC implements ActionListener, SubjectInterface {

    private PopupMenu m_popupMenu = null;


    public SystemTrayC()
    {

    }

    public boolean create()
    {
        boolean success = false;

        if(SystemTray.isSupported())
        {
            success = true;

            SystemTray systemTray = SystemTray.getSystemTray();
            Image image = null;
            try
            {
                image = ImageIO.read(getClass().getResource("../../../images/information.gif"));
            }
            catch (IOException e)
            {
                e.printStackTrace();
                success = false;
            }

            m_popupMenu = new PopupMenu();
            MenuItem openItem = new MenuItem("Open");
            openItem.setName("Open");
            openItem.addActionListener(this);
            MenuItem backupItem = new MenuItem("Backup");
            MenuItem exitItem = new MenuItem("Exit");

            m_popupMenu.add(openItem);
            m_popupMenu.add(backupItem);
            m_popupMenu.add(exitItem);


            TrayIcon systemTrayIcon = new TrayIcon(image, "GBackup", m_popupMenu);

            systemTrayIcon.setImageAutoSize(true);

            try
            {
                systemTray.add(systemTrayIcon);
            }
            catch (AWTException e)
            {
                System.err.println("TrayIcon could not be added.");
                success = false;
            }
        }

        return success;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());

        for(int i = 0; i < m_popupMenu.getItemCount(); ++i)
        {
            if(e.getSource() == m_popupMenu.getItem(i))
            {
                if(m_popupMenu.getItem(i).getName().equals("Open"))
                {
                        notify(SystemTrayTypesC.TrayIconType.OPEN.getValue(), 0);
                }
                System.out.println(m_popupMenu.getItem(i).getName());
            }
        }


        
        
    }

    private Vector<ObserverInterface> observerVector = new Vector<ObserverInterface>();

    @Override
    public void add(ObserverInterface observer) {
        observerVector.add(observer);
    }

    @Override
    public void notify(int i, int j) {
        for(ObserverInterface observer : observerVector)
        {
            observer.handleNotify(i, j);
        }
    }

    @Override
    public void remove(ObserverInterface observer) {
        final boolean remove = observerVector.remove(observer);
    }
}
