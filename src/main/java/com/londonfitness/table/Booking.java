package com.londonfitness.table;

import com.londonfitness.Index;
import com.londonfitness.OurDateFormat;
import com.londonfitness.Table;
import com.londonfitness.table.persons.Coach;
import com.londonfitness.table.persons.Trainee;

import java.util.Date;

public class Booking extends Table {

    public Booking() {
        Category.ColumnMeta = new String[][]{
                { "ID", "coach_ID", "trainee_ID", "lfClass_ID"},
                {},
                {"startDate"},
                {},
                {"repeat"}};
    }
    public String ID;
    public String coach_ID;
    public String trainee_ID;
    public String lfClass_ID;
    public Date startDate;
    public long repeat;

    //LFClass lfClasss;
    //Coach coach;
    //Trainee trainer;

    @Override
    public String toString() {
        return "Booking{" +
                "ID=\'" + ID + '\'' +
                ", coach_ID=\'" + coach_ID + '\'' +
                ", trainee_ID=\'" + trainee_ID + '\'' +
                ", lfClasss_ID=\'" + lfClass_ID + '\'' +
                ", startDate=\'" + OurDateFormat.fancyDate.format(startDate) + '\'' +
                ", repeat=" + repeat +
                '}';
    }

    public Coach externKey_coach;
    public Trainee externKey_trainee;
    public LFClass externKey_lfClass;

}
