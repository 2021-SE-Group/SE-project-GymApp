package com.londonfitness.table.persons;

import com.londonfitness.Index;
import com.londonfitness.table.Booking;
import com.londonfitness.table.Person;

import java.util.ArrayList;

public class Staff extends Person {
    public Staff() {
        super();
        this.type = Person.STAFF_TYPE;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "ID='" + ID + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", type=" + Person.typeMask[type] +
                ", expired=" + expired +
                '}';
    }
    public Index<Staff, Booking> index_booking;
}
