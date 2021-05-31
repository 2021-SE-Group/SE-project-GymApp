package com.londonfitness.simDAO.table.persons;

import com.londonfitness.simDAO.indexBuilder.Index;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.rawTable.rawPersons.RawCoach;
import com.londonfitness.simDAO.table.Booking;
import com.londonfitness.simDAO.table.CoachAbility;
import com.londonfitness.simDAO.table.Table;

public class Coach extends Table<RawCoach> {
    // external key field

    // index field
    public Index<Coach, CoachAbility> index_coachAbility;
    public Index<Coach, Booking> index_booking;

    public Coach(RawCoach rawCoach) {
        super(rawCoach);
        index_coachAbility = new Index<>();
        index_booking = new Index<>();
    }

    @Override
    public void insert(Storage storage) {
        storage.coaches.add(this);
    }
}
