package com.londonfitness.simDAO.table;

import com.londonfitness.simDAO.indexBuilder.Index;
import com.londonfitness.simDAO.indexBuilder.IndexBuilderN21;
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
        selfIndex = new Index<>();
        index_lfClass = new Index<>();
    }

    private static final IndexBuilderN21<Category, Category> categoryCategoryIndexBuilderN21
            = new IndexBuilderN21<>(Storage.categoryCategoryIndexBuilder121);

    @Override
    public void insert(Storage storage) {
        storage.categories.add(this);
        categoryCategoryIndexBuilderN21.buildBackwardIndex(storage.categories, this);
    }
}
