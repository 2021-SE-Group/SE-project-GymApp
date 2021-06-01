package com.londonfitness.model;

import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.rawTable.rawPersons.RawCoach;
import com.londonfitness.simDAO.table.persons.Coach;

public class ModelCoach {
    ModelTimetable modelTimetable;
    Coach coach;
    Storage storage;

    public ModelCoach(Storage storage, Coach coach) {
        this.coach = coach;
        this.modelTimetable = new ModelTimetable(coach);
    }

    public Coach createCoach(String id,String name,short type, String username,boolean expired, String c_profile_URL) {
        RawCoach rawCoach = new RawCoach();
        rawCoach.ID = id;
        rawCoach.name = name;
        rawCoach.type = type;
        rawCoach.username = username;
        rawCoach.expired = expired;
        rawCoach.c_profile_URL = c_profile_URL;
        Coach c = new Coach(rawCoach);
        c.insert(storage);
        return c;
    }

    public void deleteCoach(Coach coach) {

    }

    public void updateCoach(String id,String name) {

    }

    public ModelTimetable getTimeTable() {
        return modelTimetable;
    }

}
