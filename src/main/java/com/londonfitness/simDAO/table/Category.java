package com.londonfitness.simDAO.table;

import com.londonfitness.simDAO.indexBuilder.Index;
import com.londonfitness.simDAO.rawTable.RawCategory;

public class Category extends Table<RawCategory> {
    // external key field
    public Category parent;

    // index field
    public Index<Category, Category> selfIndex;
    public Index<Category, LFClass> index_lfClass;

    public Category(RawCategory rawCategory) {
        super(rawCategory);
    }
}
