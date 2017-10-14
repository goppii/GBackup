package com.gbackup.components;

public interface SubjectInterface {
    public void add(ObserverInterface observer);
    public void notify(int i, int j);
    public void remove(ObserverInterface observer);
}
