package com.londonfitness.simDAO.table;

import com.londonfitness.OurDateFormat;
import com.londonfitness.simDAO.indexBuilder.IndexBuilderN21;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.rawTable.RawExchange;
import com.londonfitness.simDAO.table.persons.Coach;

import java.util.Date;

public class Exchange extends Table<RawExchange> implements ExternKeys{
    // external key field
    public Coach externKey_coach;
    public Booking externKey_booking;

    public Exchange(RawExchange rawExchange) {
        super(rawExchange);
    }
    /*
    private static final IndexBuilderN21<Coach, Exchange> co
            = new IndexBuilderN21<>()


     */
    @Override
    public void insert(Storage storage) {

    }
}


