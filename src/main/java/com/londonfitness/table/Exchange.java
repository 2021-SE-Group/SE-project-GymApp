package com.londonfitness.table;

import com.londonfitness.OurDateFormat;
import com.londonfitness.Table;
import com.londonfitness.table.persons.Coach;
import com.londonfitness.table.persons.Trainee;

import java.util.Date;

public class Exchange extends Table {
    public Exchange() {
    }

    // meta
    @Override
    protected String getTableMeta(short type, String name) {
        return "";
    }

    //<editor-fold defaultstate="collapsed" desc="raw text field">
    //public String ID;
    //book PreTime DATE - Change Time   user_ID coach_ID
    public String booking_ID;
    public String coach_ID;
    //public String trainee_ID;
    //public String lfClass_ID;//class_ID
    public Date aft_startDate;
    public Date pre_startDate;
    public long repeat;
    @Override
    public String toString() {
        return "Exchange{" +
                "booking_ID='" + booking_ID + '\'' +
                ", coach_ID='" + coach_ID + '\'' +
                ", pre_startDate='" + OurDateFormat.fancyDate.format(pre_startDate) + '\'' +
                ", aft_startDate='" + OurDateFormat.fancyDate.format(aft_startDate) + '\'' +
                ", repeat=" + repeat +
                '}';
    }//</editor-fold>

    // external key field
    public Coach externKey_coach;
    public Booking externKey_booking;
    //public Trainee externKey_trainee;
    //public LFClass externKey_lfClass;

}
