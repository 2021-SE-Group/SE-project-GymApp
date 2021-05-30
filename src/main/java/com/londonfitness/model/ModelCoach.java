package com.londonfitness.model;

import com.londonfitness.simDAO.table.persons.Coach;

public class ModelCoach {
    ModelTimetable modelTimetable;
    Coach coach;

    public ModelCoach() {

    }

    public ModelCoach(Coach coach) {
        this.coach = coach;
        this.modelTimetable = new ModelTimetable(coach);
    }

    public Coach createCoach(String... args) {
        return null;
    }

    public void deleteCoach(Coach coach) {

    }

    public void updateCoach(String... args) {

    }

    public ModelTimetable getTimeTable() {
        return modelTimetable;
    }

}
