package com.londonfitness.model;

import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.rawTable.RawBooking;
import com.londonfitness.simDAO.table.Booking;

import java.util.Date;

public class ModelBooking {
    Booking booking;
    Storage storage;

    public ModelBooking(Storage storage, Booking booking) {
        this.booking = booking;
    }

    public Booking createBooking(String id, String coach_ID, String trainee_ID, String lfClass_ID, Date startDate, int times, long repeat, boolean quit) {
        RawBooking rawBooking = new RawBooking();
        rawBooking.ID = id;
        rawBooking.coach_ID = coach_ID;
        rawBooking.trainee_ID = trainee_ID;
        rawBooking.lfClass_ID = lfClass_ID;
        rawBooking.startDate = startDate;
        rawBooking.times = times;
        rawBooking.repeat = repeat;
        rawBooking.quit = quit;
        Booking b = new Booking(rawBooking);
        b.insert(storage);
        return b;
    }

    public void deleteBooking(Booking booking) {

    }

    public void updateBooking(String id, String coach_ID, String trainee_ID, String lfClass_ID, Date startDate, int times, long repeat, boolean quit) {

    }
}
