package com.londonfitness.simDAO.rawTable;

import com.londonfitness.simDAO.table.persons.Coach;

public class RawCoachAbility extends RawTable {
    public RawCoachAbility() {

    }

    // meta
    @Override
    protected String getTableMeta(short type, String name) {
        return "";
    }

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
    }
}