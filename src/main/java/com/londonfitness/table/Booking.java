package com.londonfitness.table;

import com.londonfitness.OurDateFormat;
import com.londonfitness.Table;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking extends Table {

    public Booking() {
        Category.ColumnMeta = new String[][]{
                {"coach_ID", "trainer_ID", "lfClass_ID"},
                {},
                {"startDate"},
                {},
                {"repeat"}};
    }

    public String coach_ID;
    public String trainer_ID;
    public String lfClass_ID;
    public Date startDate;
    public long repeat;

    //LFClass lfClasss;
    //Coach coach;
    //Trainer trainer;

    @Override
    public String toString() {
        return "Booking{" +
                "coach_ID=\'" + coach_ID + '\'' +
                ", trainer_ID=\'" + trainer_ID + '\'' +
                ", lfClasss_ID=\'" + lfClass_ID + '\'' +
                ", startDate=\'" + OurDateFormat.fancyDate.format(startDate) + '\'' +
                ", repeat=" + repeat +
                '}';
    }
}
