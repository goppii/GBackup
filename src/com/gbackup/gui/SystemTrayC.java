package com.gbackup.gui;

import com.gbackup.components.SubjectI;
import com.gbackup.components.ObserverI;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;


public class SystemTrayC implements ActionListener, SubjectI {

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
                image = ImageIO.read(getClass().getResource("../../../images/logo.png"));
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
                        notify(this.getClass().getName(), SystemTrayTypesC.TrayIconType.OPEN.getValue());
                }
                System.out.println(m_popupMenu.getItem(i).getName());
            }
        }


        
        
    }

    private Vector<ObserverI> observerVector = new Vector<>();

    @Override
    public void add(ObserverI observer) {
        observerVector.add(observer);
    }

    @Override
    public void notify(String name, int value) {
        for(ObserverI observer : observerVector)
        {
            observer.handleNotify(name, value);
        }
    }

    @Override
    public void remove(ObserverI observer) {
        final boolean remove = observerVector.remove(observer);
    }
}
