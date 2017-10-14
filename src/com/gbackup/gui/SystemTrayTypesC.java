package com.gbackup.gui;

public class SystemTrayTypesC {

    public enum TrayIconType
    {
        OPEN(0), EXIT(1), BACKUP(2);

        private final int value;
        private TrayIconType(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }
    }
}
