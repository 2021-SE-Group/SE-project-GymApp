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
public class IndexBuilderN21<T1 extends Table, Tn extends Table> {
    private final IndexBuilder121<T1, Tn> ind121;

    public IndexBuilderN21(IndexBuilder121<T1, Tn> indexBuilder121) {
        this.ind121 = indexBuilder121;
    }

    public void buildBackwardIndex(ArrayList<T1> t1s, Tn tn) {
        for (T1 t1 : t1s) {
            ind121.examThenBuild(t1, tn);
        }
    }
}
