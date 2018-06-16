package com.power.designpattern.visitor;

import com.power.designpattern.composite.FileTreatmentExcetion;

import java.util.Iterator;

public abstract class Entry implements Element {
    public abstract String getName();
    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentExcetion {
        throw new FileTreatmentExcetion();
    }

    public Iterator iterator() throws FileTreatmentExcetion {
        throw new FileTreatmentExcetion();
    }

    public String toString() {
        return getName() +" (" + getSize() + ")";
    }
}
