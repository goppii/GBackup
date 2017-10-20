package com.gbackup.components;

import java.util.Vector;

public class SubjectC implements SubjectI {

    private Vector<ObserverI> observerVector = new Vector<>();

    @Override
    public void add(ObserverI observer) {
        observerVector.add(observer);
    }

    @Override
    public void notify(int i, int j) {
        for(ObserverI observer : observerVector)
        {
            observer.handleNotify(i, j);
        }
    }

    @Override
    public void remove(ObserverI observer) {
        final boolean remove = observerVector.remove(observer);
    }
}
