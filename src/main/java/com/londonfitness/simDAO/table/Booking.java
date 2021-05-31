package com.londonfitness.simDAO.table;

import com.londonfitness.simDAO.indexBuilder.Index;
import com.londonfitness.simDAO.indexBuilder.IndexBuilderN21;
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

    private static final IndexBuilderN21<Coach, Booking> coachBookingIndexBuilderN21
            = new IndexBuilderN21<> (Storage.coachBookingIndexBuilder121);
    private static final IndexBuilderN21<Trainee, Booking> traineeBookingIndexBuilderN21
            = new IndexBuilderN21<>(Storage.traineeBookingIndexBuilder121);
    private static final IndexBuilderN21<LFClass, Booking> lfClassBookingIndexBuilderN21
            = new IndexBuilderN21<>(Storage.lfClassBookingIndexBuilder121);
    @Override
    public void insert(Storage storage) {
        storage.bookings.add(this);
        coachBookingIndexBuilderN21.buildBackwardIndex(storage.coaches, this);
        traineeBookingIndexBuilderN21.buildBackwardIndex(storage.trainees, this);
        lfClassBookingIndexBuilderN21.buildBackwardIndex(storage.lfClasses, this);
    }
}
