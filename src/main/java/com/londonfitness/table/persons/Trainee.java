package com.londonfitness.table.persons;

import com.londonfitness.Index;
import com.londonfitness.table.Booking;
import com.londonfitness.table.Person;

public class Trainee extends Person {
    public Trainee() {
        super();
        this.type = Person.TRAINER_TYPE;
    }
    public String t_profile_URL;

    @Override
    public String toString() {
        return "Trainee{" +
                "ID='" + ID + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", type=" + Person.typeMask[type] +
                ", expired=" + expired +
                ", t_profile_URL='" + t_profile_URL + '\'' +
                '}';
    }
    public Index<Trainee, Booking> index_booking;
}
