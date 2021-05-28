package com.londonfitness.simDAO.rawTable;

import com.londonfitness.OurDateFormat;
import com.londonfitness.simDAO.table.persons.Coach;

import java.util.Date;

public class RawExchange extends RawTable {
    public RawExchange() {
    }

    // meta
    @Override
    protected String getTableMeta(short type, String name) {
        return "";
    }

    public String exchange_ID;
    public String booking_ID;
    public String coach_ID;
    public Date aft_startDate;
    public Date pre_startDate;
    public long duration;
    @Override
    public String toString() {
        return "Exchange{" +
                "exchange_ID='" + exchange_ID + '\'' +
                "booking_ID='" + booking_ID + '\'' +
                ", coach_ID='" + coach_ID + '\'' +
                ", pre_startDate='" + OurDateFormat.fancyDate.format(pre_startDate) + '\'' +
                ", aft_startDate='" + OurDateFormat.fancyDate.format(aft_startDate) + '\'' +
                ", duration=" + duration +
                '}';
    }
}


