package com.londonfitness.simDAO.table;

import com.londonfitness.simDAO.indexBuilder.Index;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.rawTable.RawCategory;

public class Category extends Table<RawCategory> implements ExternKeys{
    // external key field
    public Category parent;

    // index field
    public Index<Category, Category> selfIndex;
    public Index<Category, LFClass> index_lfClass;

    public Category(RawCategory rawCategory) {
        super(rawCategory);
    }

    @Override
    public void insert(Storage storage) {

    }

    @Override
    public void update(Storage storage) {

    }
}
