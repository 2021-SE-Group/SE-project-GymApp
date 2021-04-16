package com.londonfitness.simDAO.table.persons;

import com.londonfitness.simDAO.indexBuilder.Index;
import com.londonfitness.simDAO.table.Booking;
import com.londonfitness.simDAO.table.CoachAbility;
import com.londonfitness.simDAO.table.Person;

public class Coach extends Person {
    public Coach() {
        super();
        this.type = Person.COACH_TYPE;
    }

    // meta
    @Override
    protected String getTableMeta(short type, String name) {
        return "";
    }

    //<editor-fold defaultstate="collapsed" desc="raw text field">
    public String c_profile_URL;
    @Override
    public String toString() {
        return "Coach{" +
                "ID='" + ID + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", type=" + Person.typeMask[type] +
                ", expired=" + expired +
                ", c_profile_URL='" + c_profile_URL + '\'' +
                '}';
    }//</editor-fold>

    // external key field

    // index field
    public Index<Coach, CoachAbility> index_coachAbility;
    public Index<Coach, Booking> index_booking;
}
