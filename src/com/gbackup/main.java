package com.gbackup;

import com.gbackup.components.FileTreeControllerC;
import com.gbackup.gui.GuiC;
import com.gbackup.gui.SystemTrayC;

public class main {

    public static void main(String [ ] args)
    {
        GuiC mainGui = new GuiC();

        FileTreeControllerC fileTree = new FileTreeControllerC("myFileTree");
        mainGui.setTree(fileTree);

        SystemTrayC mySystemTray = new SystemTrayC();
        mySystemTray.create();

        mySystemTray.add(mainGui);
    }

}
