package com.londonfitness;

import java.util.ArrayList;
import java.util.Iterator;

// T1 : 1 - n : T2
public class Index<T1, Tn> {
    protected T1 t1;
    protected ArrayList<Tn> tns;

    public Index() {
        tns = new ArrayList<>();
    }
    public Index(T1 t1) {
        this();
        this.t1 = t1;
    }

    public T1 getT1(){
        return t1;
    }

    public Iterator<Tn> getTnIter() {
        return tns.iterator();
    }

    public void setT1(T1 t1) {
        this.t1 = t1;
    }

    public void addTn(Tn tn)
    {
        this.tns.add(tn);
    }
}
