package com.londonfitness.indexBuilder;

import com.londonfitness.Index;
import com.londonfitness.Table;

import java.util.ArrayList;

public abstract class IndexBuilder<T1 extends Table, Tn extends Table> {
    //public ArrayList<Index<T1, Tn>> indexes;
    private ArrayList<T1> t1s;
    private ArrayList<Tn> tns_all;

    public void buildIndex() {
        for(T1 t1: t1s) {
            Index<T1, Tn> ind = new Index<>(t1);

            for(Tn tn: tns_all) {
                if(checkIndexing(ind.getT1(), tn)) {
                    ind.addTn(tn);
                }
            }
            setT1Index(ind);
        }

    }

    protected abstract boolean checkIndexing(T1 t1, Tn tn);
    protected abstract void setT1Index(Index<T1, Tn> ind);
    protected abstract Index<T1, Tn> getT1Index();
}
