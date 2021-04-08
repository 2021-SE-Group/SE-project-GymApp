package com.londonfitness.table;

import com.londonfitness.table.persons.Coach;
import com.londonfitness.table.persons.Trainer;

import java.util.Date;

public class Booking {
    public Booking() {}
    CoachTrainerPair ctPair;
    LFClass lfClasss;
    Date startDate;
    long repeat;

    @Override
    public String toString() {
        return "Booking{" +
                "coach=" + ctPair.coach +
                ", trainer=" + ctPair.trainer +
                ", lfClasss=" + lfClasss +
                ", startDate=" + startDate +
                ", repeat=" + repeat +
                '}';
    }
}
