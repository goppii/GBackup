package com.gbackup.components;

public interface SubjectI {
    void add(ObserverI observer);
    void notify(String name, int value);
    void remove(ObserverI observer);
}
