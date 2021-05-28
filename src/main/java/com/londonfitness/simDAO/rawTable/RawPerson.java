package com.londonfitness.simDAO.rawTable;

import com.londonfitness.simDAO.table.Table;

public abstract class RawPerson extends RawTable {
    public static final short ADMIN_TYPE = 0;
    public static final short STAFF_TYPE = 1;
    public static final short COACH_TYPE = 2;
    public static final short TRAINER_TYPE = 3;

    public static final String[] typeMask = {"admin", "staff", "coach", "trainer"};

    public RawPerson() {}

    public String ID;
    public String username;
    public String name;
    public short type;
    public boolean expired;
    @Override
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", type=" + typeMask[type] +
                ", expired=" + expired +
                '}';
    }
}
