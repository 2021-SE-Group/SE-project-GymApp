package com.londonfitness.simDAO.rawTable.rawPersons;


import com.londonfitness.simDAO.rawTable.RawPerson;

public class RawCoach extends RawPerson {
    public RawCoach() {
        super();
        this.type = RawPerson.COACH_TYPE;
    }

    // meta
    @Override
    protected String getTableMeta(short type, String name) {
        return "";
    }

    public String c_profile_URL;
    @Override
    public String toString() {
        return "Coach{" +
                "ID='" + ID + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", type=" + RawPerson.typeMask[type] +
                ", expired=" + expired +
                ", c_profile_URL='" + c_profile_URL + '\'' +
                '}';
    }

}
