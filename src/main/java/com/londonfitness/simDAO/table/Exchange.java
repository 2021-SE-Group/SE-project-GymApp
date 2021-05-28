package com.londonfitness.simDAO.table;

import com.londonfitness.OurDateFormat;
import com.londonfitness.simDAO.rawTable.RawExchange;
import com.londonfitness.simDAO.table.persons.Coach;

import java.util.Date;

public class Exchange extends Table<RawExchange> {
    // external key field
    public Coach externKey_coach;
    public Booking externKey_booking;

    public Exchange(RawExchange rawExchange) {
        super(rawExchange);
    }
    //public Trainee externKey_trainee;
    //public LFClass externKey_lfClass;

}


