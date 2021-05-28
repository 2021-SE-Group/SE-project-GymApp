package com.londonfitness.simDAO.table;

import com.londonfitness.simDAO.indexBuilder.Index;
import com.londonfitness.simDAO.rawTable.RawLFClass;

import java.util.Iterator;

public class LFClass extends Table<RawLFClass> {
    // external key field
    public Category externKey_category;

    // index field
    public Index<LFClass, Booking> index_booking;
    public Index<LFClass, CoachAbility> index_CoachAbility;

    public LFClass(RawLFClass rawLFClass) {
        super(rawLFClass);
    }
}
