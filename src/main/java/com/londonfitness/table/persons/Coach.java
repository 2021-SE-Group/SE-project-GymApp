package com.londonfitness.table.persons;

import com.londonfitness.table.LFClass;
import com.londonfitness.table.Person;

import java.util.ArrayList;

public class Coach extends Person {
    public Coach() {super();}
    public class abilityClass {
        LFClass lfc;
        String time;
    }
    ArrayList<abilityClass> coachAbility;
    String c_profile_URL;
}
