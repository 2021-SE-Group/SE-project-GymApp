package com.londonfitness.simDAO.table;

import com.londonfitness.simDAO.indexBuilder.Index;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.rawTable.RawBooking;
import com.londonfitness.simDAO.table.persons.Coach;
import com.londonfitness.simDAO.table.persons.Trainee;

import java.util.Date;

public class Booking extends Table<RawBooking> implements ExternKeys{
    // external key field
    public Coach externKey_coach;
    public Trainee externKey_trainee;
    public LFClass externKey_lfClass;

    // index field
    public Index<Booking, Exchange> index_exchange;

    public Booking(RawBooking rawBooking) {
        super(rawBooking);
        index_exchange = new Index<>();
    }

    @Override
    public void insert(Storage storage) {

    }
}
