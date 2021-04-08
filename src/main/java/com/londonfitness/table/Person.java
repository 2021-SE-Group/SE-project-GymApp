package com.londonfitness.table;

public abstract class Person {
    public static final short ADMIN_TYPE = 0;
    public static final short STAFF_TYPE = 1;
    public static final short COACH_TYPE = 2;
    public static final short TRAINER_TYPE = 3;

    public static final String[] typeMask = {"admin", "staff", "coach", "trainer"};

    public Person() {}
    public Person(String ID, String username, String name, short type) {
        this.ID = ID;
        this.username = username;
        this.name = name;
        this.type = type;
        this.expired = false;
    }

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
