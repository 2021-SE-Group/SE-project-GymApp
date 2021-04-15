package com.londonfitness.table.persons;

import com.londonfitness.table.Person;

public class Admin extends Person {
    public Admin() {
        super();
        this.type = Person.ADMIN_TYPE;
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

    @Override
    protected String getTableMeta(short type, String name) {
        return new String();
    }
}
