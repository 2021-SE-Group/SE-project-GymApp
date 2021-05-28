package com.londonfitness.simDAO.rawTable;

import com.londonfitness.OurDateFormat;

import java.util.Date;

public class RawBooking extends RawTable {
    public RawBooking() {
    }

    // meta
    @Override
    protected String getTableMeta(short type, String name) {
        return "";
    }

    public String ID;
    public String coach_ID;
    public String trainee_ID;
    public String lfClass_ID;
    public Date startDate;
    public int times; //class chances' time
    public long repeat; // after time duration of repeat ms, next class starts
    @Override
    public String toString() {
        return "Booking{" +
                "ID='" + ID + '\'' +
                ", coach_ID='" + coach_ID + '\'' +
                ", trainee_ID='" + trainee_ID + '\'' +
                ", lfClasss_ID='" + lfClass_ID + '\'' +
                ", startDate='" + OurDateFormat.fancyDate.format(startDate) + '\'' +
                ", times=" + times +
                ", repeat=" + repeat +
                '}';
    }
}
