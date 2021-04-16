package com.londonfitness.simDAO.table.persons;

import com.londonfitness.simDAO.indexBuilder.Index;
import com.londonfitness.simDAO.table.Booking;
import com.londonfitness.simDAO.table.Person;

public class Staff extends Person {
    public Staff() {
        super();
        this.type = Person.STAFF_TYPE;
    }

    // meta
    @Override
    protected String getTableMeta(short type, String name) {
        return new String();
    }

    //<editor-fold defaultstate="collapsed" desc="raw text field">
    @Override
    public String toString() {
        return "Staff{" +
                "ID='" + ID + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", type=" + Person.typeMask[type] +
                ", expired=" + expired +
                '}';
    }//</editor-fold>

    // index field
    public Index<Staff, Booking> index_booking;
}
