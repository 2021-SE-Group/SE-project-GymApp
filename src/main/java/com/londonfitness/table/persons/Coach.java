package com.londonfitness.table.persons;

import com.londonfitness.table.LFClass;
import com.londonfitness.table.Person;

import java.util.ArrayList;

public class Coach extends Person {
    public ArrayList<CoachAbility> coachAbilities;
    public String c_profile_URL;

    public Coach() {
        super();
        coachAbilities = new ArrayList<>();
        this.type = Person.COACH_TYPE;
    }

    public class CoachAbility {
        LFClass lfc;
        String time;

        @Override
        public String toString() {
            return "coachAbility{" +
                    "lfc=" + lfc +
                    ", time='" + time + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        String coachAb = "[";
        for (CoachAbility ca : coachAbilities) {
            coachAb += ca + ", ";
        }
        coachAb += "]";

        return "Coach{" +
                "ID='" + ID + '\'' +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", type=" + Person.typeMask[type] +
                ", expired=" + expired +
                ", coachAbilities=" + coachAb +
                ", c_profile_URL='" + c_profile_URL + '\'' +
                '}';
    }
}
