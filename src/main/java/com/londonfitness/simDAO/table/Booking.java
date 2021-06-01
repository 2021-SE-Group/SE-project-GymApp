package com.londonfitness.simDAO.table;

import com.londonfitness.AppSkeleton;
import com.londonfitness.simDAO.indexBuilder.Index;
import com.londonfitness.simDAO.indexBuilder.IndexBuilderN21;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.rawTable.RawBooking;
import com.londonfitness.simDAO.table.persons.Coach;
import com.londonfitness.simDAO.table.persons.Trainee;
import org.junit.jupiter.api.Test;

import javax.swing.*;
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
        System.out.println("add coach - booking");
        coachBookingIndexBuilderN21.buildBackwardIndex(storage.coaches, this);
        System.out.println("coach - booking done, add trainee - booking");
        traineeBookingIndexBuilderN21.buildBackwardIndex(storage.trainees, this);
        System.out.println("trainee - booking done, add lfclass - booking");
        lfClassBookingIndexBuilderN21.buildBackwardIndex(storage.lfClasses, this);
        System.out.println("trainee - booking done");
    }

    public static void main(String[] args) {
        new AppSkeleton(true, true, true, true, false) {
            @Override
            public JFrame bringUpGUI() {
                Booking b = new Booking(new RawBooking());
                b.raw.ID = "B004";
                b.raw.coach_ID = "C001";
                b.raw.trainee_ID = "T001";
                b.raw.lfClass_ID = "03";
                b.raw.startDate = new Date();
                b.raw.times = 20;
                b.raw.repeat = 259200000;
                b.raw.quit = false;

                b.insert(storage);
                return new JFrame("test");
            }
        };
    }
}
