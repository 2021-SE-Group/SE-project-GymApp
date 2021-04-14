package com.londonfitness;

import java.util.ArrayList;
import java.util.Iterator;

// T1 : 1 - n : T2
public abstract class Index<T1, Tn> {
    public abstract T1 getT1();
    public abstract Iterator<Tn> getTnIter();
    public abstract void setT1(T1 t1);
    public abstract void addTn(Tn tn);
}
