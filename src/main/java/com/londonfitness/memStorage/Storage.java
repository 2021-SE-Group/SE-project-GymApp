package com.londonfitness.memStorage;

import com.londonfitness.table.*;
import com.londonfitness.table.persons.Admin;
import com.londonfitness.table.persons.Coach;
import com.londonfitness.table.persons.Staff;
import com.londonfitness.table.persons.Trainee;

import java.util.ArrayList;

public class Storage {
    public ArrayList<Category> categories;
    public ArrayList<LFClass> lfClasses;
    public ArrayList<Admin> admins;
    public ArrayList<Staff> staffs;
    public ArrayList<Coach> coaches;
    public ArrayList<Trainee> trainees;
    public ArrayList<Booking> bookings;
    public ArrayList<Exchange> exchanges;
    public ArrayList<CoachAbility> coachAbility;

    public Storage() {
        categories = new ArrayList<>();
        lfClasses = new ArrayList<>();
        admins = new ArrayList<>();
        staffs = new ArrayList<>();
        coaches = new ArrayList<>();
        trainees = new ArrayList<>();
        bookings = new ArrayList<>();
        exchanges = new ArrayList<>();
        coachAbility = new ArrayList<>();
    }
}
