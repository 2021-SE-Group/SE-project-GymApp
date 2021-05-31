package com.londonfitness.simDAO.table;

import com.londonfitness.simDAO.indexBuilder.Index;
import com.londonfitness.simDAO.indexBuilder.IndexBuilderN21;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.rawTable.RawLFClass;

import java.util.Iterator;

public class LFClass extends Table<RawLFClass> implements ExternKeys{
    // external key field
    public Category externKey_category;

    // index field
    public Index<LFClass, Booking> index_booking;
    public Index<LFClass, CoachAbility> index_CoachAbility;

    public LFClass(RawLFClass rawLFClass) {
        super(rawLFClass);
        index_booking = new Index<>();
        index_CoachAbility = new Index<>();
    }

    private static final IndexBuilderN21<Category, LFClass> categoryLFClassIndexBuilderN21
            = new IndexBuilderN21<>(Storage.categoryLFClassIndexBuilder121);

    @Override
    public void insert(Storage storage) {
        storage.lfClasses.add(this);
        categoryLFClassIndexBuilderN21.buildBackwardIndex(storage.categories, this);
    }
}
