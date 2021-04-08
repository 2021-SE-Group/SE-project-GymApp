package com.londonfitness.table.persons;

import com.londonfitness.table.Person;

public class Trainer extends Person {
    public Trainer() {
        super();
        this.type = Person.TRAINER_TYPE;
    }
    public String t_profile_URL;

    @Override
    public String toString() {
        return "Trainer{" +
                "ID='" + ID + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", type=" + Person.typeMask[type] +
                ", expired=" + expired +
                ", t_profile_URL='" + t_profile_URL + '\'' +
                '}';
    }
}
