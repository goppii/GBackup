package com.gbackup.components;

public class PathControllerTypesC {

    public enum PathEventType
    {
        ADD(0), UPDATE(1), REMOVE(2);

        private final int value;
        private PathEventType(int value)
        {
            this.value = value;
        }

        public int getValue()
        {
            return value;
        }
    }
}
