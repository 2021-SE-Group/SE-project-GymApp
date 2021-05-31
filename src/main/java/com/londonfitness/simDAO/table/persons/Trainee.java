package com.londonfitness.simDAO.table.persons;

import com.londonfitness.simDAO.indexBuilder.Index;
import com.londonfitness.simDAO.rawTable.rawPersons.RawTrainee;
import com.londonfitness.simDAO.table.Booking;
import com.londonfitness.simDAO.table.Table;

public class Trainee extends Table<RawTrainee> {
    // index field
    public Index<Trainee, Booking> index_booking;

    public Trainee(RawTrainee rawTrainee) {
        super(rawTrainee);
        index_booking = new Index<>();
    }
}
