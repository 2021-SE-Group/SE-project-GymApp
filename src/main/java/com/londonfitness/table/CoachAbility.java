package com.londonfitness.table;

import com.londonfitness.Table;
import com.londonfitness.table.persons.Coach;

public class CoachAbility extends Table {
    public CoachAbility() {

    }

    // meta
    @Override
    protected String getTableMeta(short type, String name) {
        return "";
    }

    //<editor-fold defaultstate="collapsed" desc="raw text field">
    public String lfc_ID;
    public String time;
    public String coach_ID;
    @Override
    public String toString() {
        return "coachAbility{" +
                "lfclass_ID=" + lfc_ID +
                ", coach_ID='" + coach_ID + '\'' +
                ", time='" + time + '\'' +
                '}';
    }//</editor-fold>

    // external key filed
    public LFClass lfClass;
    public Coach coach;
}