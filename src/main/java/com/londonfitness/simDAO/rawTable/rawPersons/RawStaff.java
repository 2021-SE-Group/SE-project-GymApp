package com.londonfitness.simDAO.rawTable.rawPersons;

import com.londonfitness.simDAO.rawTable.RawPerson;

public class RawStaff extends RawPerson {
    public RawStaff() {
        super();
        this.type = RawPerson.STAFF_TYPE;
    }

    // meta
    @Override
    protected String getTableMeta(short type, String name) {
        return "";
    }

    @Override
    public String toString() {
        return "Staff{" +
                "ID='" + ID + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", type=" + RawPerson.typeMask[type] +
                ", expired=" + expired +
                '}';
    }
}
