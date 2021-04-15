package com.londonfitness.table.persons;

import com.londonfitness.Index;
import com.londonfitness.table.Booking;
import com.londonfitness.table.CoachAbility;
import com.londonfitness.table.Person;

import java.util.ArrayList;

public class Coach extends Person {
    public String c_profile_URL;

    public Coach() {
        super();
        this.type = Person.COACH_TYPE;
    }

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
    }

    public Index<Coach, Booking> index_booking;
}
