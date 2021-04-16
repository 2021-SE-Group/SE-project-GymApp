package com.londonfitness.simDAO.indexBuilder.indexBuilders;



import com.londonfitness.simDAO.indexBuilder.Index;
import com.londonfitness.simDAO.indexBuilder.IndexBuilder;
import com.londonfitness.simDAO.table.Booking;
import com.londonfitness.simDAO.table.persons.Trainee;

import java.util.ArrayList;

public class Trainee_BookingIndexBuilder extends IndexBuilder<Trainee, Booking> {
    public Trainee_BookingIndexBuilder(ArrayList<Trainee> trainees, ArrayList<Booking> tns_all) {
        super(trainees, tns_all);
    }

    @Override
    protected boolean checkIndexing(Trainee trainee, Booking booking) {
        return booking.trainee_ID.equals(trainee.ID);
    }

    @Override
    protected void setT1Index(Trainee trainee, Index<Trainee, Booking> ind) {
        trainee.index_booking = ind;
    }

    @Override
    protected void setTnDep(Booking booking, Index<Trainee, Booking> ind) {
        booking.externKey_trainee = ind.getT1();
    }
}
