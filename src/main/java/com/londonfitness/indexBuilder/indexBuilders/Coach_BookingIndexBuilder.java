package com.londonfitness.indexBuilder.indexBuilders;

import com.londonfitness.Index;
import com.londonfitness.indexBuilder.IndexBuilder;
import com.londonfitness.table.Booking;
import com.londonfitness.table.persons.Coach;

import java.util.ArrayList;

public class Coach_BookingIndexBuilder extends IndexBuilder<Coach, Booking> {
    public Coach_BookingIndexBuilder(ArrayList<Coach> coaches, ArrayList<Booking> tns_all) {
        super(coaches, tns_all);
    }

    @Override
    protected boolean checkIndexing(Coach coach, Booking booking) {
        return booking.coach_ID.equals(coach.ID);
    }

    @Override
    protected void setT1Index(Coach coach, Index<Coach, Booking> ind) {
        coach.index_booking = ind;
    }

    @Override
    protected void setTnDep(Booking booking, Index<Coach, Booking> ind) {
        booking.externKey_coach = ind.getT1();
    }
}
