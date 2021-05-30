package com.londonfitness.model;

import com.londonfitness.simDAO.table.persons.Coach;
import com.londonfitness.simDAO.table.persons.Trainee;

public class ModelTrainee {
    Trainee trainee;
    ModelVIP vip;
    public ModelTrainee() {

    }

    public ModelTrainee(Trainee trainee) {
        this.trainee = trainee;
        this.vip = new ModelVIP(trainee);
    }

    public Trainee createTrainee(String... args) {
        return null;
    }

    public void deleteTrainee(Trainee trainee) {

    }

    public void updateTrainee(String... args) {

    }

    public ModelVIP getVipState() {
        return vip;
    }
}
