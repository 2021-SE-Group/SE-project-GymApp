package com.londonfitness.simDAO.rawTable.rawPersons;

import com.londonfitness.simDAO.rawTable.RawPerson;

public class RawAdmin extends RawPerson {
    public RawAdmin() {
        super();
        this.type = RawPerson.ADMIN_TYPE;
    }

    @Override
    protected String getTableMeta(short type, String name) {
        return new String();
    }

    @Override
    public String toString() {
        return "Admin{" +
                "ID='" + ID + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", type=" + typeMask[type] +
                ", expired=" + expired +
                '}';
    }
}
