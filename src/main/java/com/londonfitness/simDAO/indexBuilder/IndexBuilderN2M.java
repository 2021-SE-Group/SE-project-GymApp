package com.londonfitness.simDAO.indexBuilder;

import com.londonfitness.simDAO.table.Table;

import java.util.ArrayList;

public class IndexBuilderN2M<
        T1 extends Table,
        Tn extends Table> {
    private final ArrayList<T1> t1s;
    private final ArrayList<Tn> tns_all;
    private IndexBuilder12N<T1, Tn> ib;

    public IndexBuilderN2M(ArrayList<T1> t1s, ArrayList<Tn> tns_all, IndexBuilder12N<T1, Tn> ib) {
        this.t1s = t1s;
        this.tns_all = tns_all;
        this.ib = ib;
    }

    public void buildIndex() {
        for(T1 t1: t1s) {
            ib.buildIndex(t1, tns_all);
        }
    }
}
