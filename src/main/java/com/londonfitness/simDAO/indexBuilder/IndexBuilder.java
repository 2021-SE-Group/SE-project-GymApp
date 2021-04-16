package com.londonfitness.simDAO.indexBuilder;

import com.londonfitness.simDAO.table.Table;

import java.util.ArrayList;

public abstract class IndexBuilder<T1 extends Table, Tn extends Table> {
    //public ArrayList<Index<T1, Tn>> indexes;
    private final ArrayList<T1> t1s;
    private final ArrayList<Tn> tns_all;

    public IndexBuilder(ArrayList<T1> t1s, ArrayList<Tn> tns_all) {
        this.t1s = t1s;
        this.tns_all = tns_all;
    }

    public void buildIndex() {
        for(T1 t1: t1s) {
            Index<T1, Tn> ind = new Index<>(t1);

            for(Tn tn: tns_all) {
                if(checkIndexing(ind.getT1(), tn)) {
                    ind.addTn(tn);
                    setTnDep(tn, ind);
                }
            }
            setT1Index(t1, ind);
        }

    }

    protected abstract boolean checkIndexing(T1 t1, Tn tn);
    protected abstract void setT1Index(T1 t1, Index<T1, Tn> ind);
    protected abstract void setTnDep(Tn tn, Index<T1, Tn> ind);
}
