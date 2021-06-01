package com.londonfitness.simDAO.indexBuilder;

import com.londonfitness.simDAO.table.Table;

/**
 * This is used to construct static instances for relating items in our simDB.
 *
 * @param <T1>
 * @param <Tn>
 */
public abstract class IndexBuilder121<T1 extends Table, Tn extends Table> {
    public void examThenBuild(T1 t1, Tn tn) {
        if (checkIndexing(t1, tn)) {
            getIndex(t1).addTn(tn);
            setTnDep(t1, tn);
        }
    }

    protected abstract boolean checkIndexing(T1 t1, Tn tn);

    protected abstract void setTnDep(T1 t1, Tn tn);

    protected abstract Index<T1, Tn> getIndex(T1 t1);
}
