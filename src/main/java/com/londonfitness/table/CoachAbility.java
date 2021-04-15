package com.londonfitness.table;

public class CoachAbility {
    public String lfc_ID;
    public String time;
    public String coach_ID;

    public CoachAbility() {
    }

    @Override
    public String toString() {
        return "coachAbility{" +
                "lfclass_ID=" + lfc_ID +
                ", coach_ID='" + coach_ID + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}