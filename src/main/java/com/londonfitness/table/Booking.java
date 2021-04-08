package com.londonfitness.table;

import com.londonfitness.table.persons.Coach;
import com.londonfitness.table.persons.Trainer;

import java.util.Date;

public class Booking {
    public Booking() {}
    Coach coach;
    Trainer trainer;
    LFClass lfClasss;
    Date startDate;
    long repeat;

    @Override
    public String toString() {
        return "Booking{" +
                "coach=" + coach +
                ", trainer=" + trainer +
                ", lfClasss=" + lfClasss +
                ", startDate=" + startDate +
                ", repeat=" + repeat +
                '}';
    }
}
