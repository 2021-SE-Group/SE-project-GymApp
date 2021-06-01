package com.londonfitness.simDAO.indexBuilder;

import com.londonfitness.simDAO.table.Table;

import java.util.ArrayList;

/**
 * This is used to construct instances for relating items in our simDB.
 * It should be either a static member
 * or a instance that will only be constructed once for every case.
 * The function
 *
 * @param <T1>
 * @param <Tn>
 */
public class IndexBuilder12N<T1 extends Table, Tn extends Table> {
    private final IndexBuilder121<T1, Tn> ind121;

    public IndexBuilder12N(IndexBuilder121<T1, Tn> indexBuilder121) {
        this.ind121 = indexBuilder121;
    }

    public void buildIndex(T1 t1, ArrayList<Tn> tns_all) {
        for (Tn tn : tns_all) {
            ind121.examThenBuild(t1, tn);
        }
    }
}
