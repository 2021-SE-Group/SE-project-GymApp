package com.londonfitness.simDAO.table;

import com.londonfitness.OurDateFormat;
import com.londonfitness.simDAO.table.persons.Coach;
import com.londonfitness.simDAO.table.persons.Trainee;
//import sun.tools.jconsole.Tab;

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
    public String booking_ID;
    public String coach_ID;
    //public String trainee_ID;
    //public String lfClass_ID;
    public Date pre_startDate;
    public Date aft_startDate;
    //public int times;//class chances' time
    public long repeat;
    @Override
    public String toString() {
        return "Booking{" +
                "booking_ID='" + booking_ID + '\'' +
                ", coach_ID='" + coach_ID + '\'' +
                ", pre_startDate='" + OurDateFormat.fancyDate.format(pre_startDate) + '\'' +
                ", aft_startDate='" + OurDateFormat.fancyDate.format(aft_startDate) + '\'' +
                ", repeat=" + repeat +
                '}';
    }//</editor-fold>

    // external key field
    public Coach externKey_coach;
    //public Trainee externKey_trainee;
    //public LFClass externKey_lfClass;
    public Booking externKey_booking;

}
