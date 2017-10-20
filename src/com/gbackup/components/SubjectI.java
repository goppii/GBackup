package com.gbackup.components;

public interface SubjectI {
    void add(ObserverI observer);
    void notify(int i, int j);
    void remove(ObserverI observer);
}
