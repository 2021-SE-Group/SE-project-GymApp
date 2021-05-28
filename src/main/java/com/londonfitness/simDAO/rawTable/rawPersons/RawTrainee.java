package com.londonfitness.simDAO.rawTable.rawPersons;

import com.londonfitness.simDAO.rawTable.RawPerson;

public class RawTrainee extends RawPerson {
    public RawTrainee() {
        super();
        this.type = RawPerson.TRAINER_TYPE;
    }

    // meta
    @Override
    protected String getTableMeta(short type, String name) {
        return "";
    }

    public String t_profile_URL;
    @Override
    public String toString() {
        return "Trainee{" +
                "ID='" + ID + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", type=" + RawPerson.typeMask[type] +
                ", expired=" + expired +
                ", t_profile_URL='" + t_profile_URL + '\'' +
                '}';
    }
}
