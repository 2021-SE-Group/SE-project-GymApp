package com.londonfitness.simDAO.table;

import com.londonfitness.simDAO.indexBuilder.Index;
import com.londonfitness.OurDateFormat;
import com.londonfitness.simDAO.table.persons.Coach;
import com.londonfitness.simDAO.table.persons.Trainee;

import java.util.Date;

public class Booking extends Table {
    public Booking() {
    }

    // meta
    @Override
    protected String getTableMeta(short type, String name) {
        return "";
    }

    //<editor-fold defaultstate="collapsed" desc="raw text field">
    public String ID;
    public String coach_ID;
    public String trainee_ID;
    public String lfClass_ID;
    public Date startDate;
    public int times;//class chances' time
    public long repeat;
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
    }//</editor-fold>

    // external key field
    public Coach externKey_coach;
    public Trainee externKey_trainee;
    public LFClass externKey_lfClass;

    // index field
    public Index<Booking, Exchange> index_exchange;
}
