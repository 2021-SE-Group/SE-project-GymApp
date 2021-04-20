package com.londonfitness.simDAO.memStorage;

import com.londonfitness.simDAO.table.*;
import com.londonfitness.simDAO.table.persons.Admin;
import com.londonfitness.simDAO.table.persons.Coach;
import com.londonfitness.simDAO.table.persons.Staff;
import com.londonfitness.simDAO.table.persons.Trainee;

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
    public ArrayList<CoachAbility> coachAbilities;
    public ArrayList<Record> records;

    public Storage() {
        records = new ArrayList<>();
        categories = new ArrayList<>();
        lfClasses = new ArrayList<>();
        admins = new ArrayList<>();
        staffs = new ArrayList<>();
        coaches = new ArrayList<>();
        trainees = new ArrayList<>();
        bookings = new ArrayList<>();
        exchanges = new ArrayList<>();
        coachAbilities = new ArrayList<>();
    }
}
