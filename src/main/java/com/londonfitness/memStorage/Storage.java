package com.londonfitness.memStorage;

import com.londonfitness.table.Booking;
import com.londonfitness.table.Category;
import com.londonfitness.table.Exchange;
import com.londonfitness.table.LFClass;
import com.londonfitness.table.persons.Admin;
import com.londonfitness.table.persons.Coach;
import com.londonfitness.table.persons.Staff;
import com.londonfitness.table.persons.Trainer;

import java.util.ArrayList;

public class Storage {
    public ArrayList<Category> categories;
    public ArrayList<LFClass> lfClasses;
    public ArrayList<Admin> admins;
    public ArrayList<Staff> staffs;
    public ArrayList<Coach> coaches;
    public ArrayList<Trainer> trainers;
    public ArrayList<Booking> bookings;
    public ArrayList<Exchange> exchanges;

    public Storage() {
        categories = new ArrayList<>();
        lfClasses = new ArrayList<>();
        admins = new ArrayList<>();
        staffs = new ArrayList<>();
        coaches = new ArrayList<>();
        trainers = new ArrayList<>();
        bookings = new ArrayList<>();
        exchanges = new ArrayList<>();
    }
}
