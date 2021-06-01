package com.londonfitness.model;

import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.rawTable.rawPersons.RawCoach;
import com.londonfitness.simDAO.rawTable.rawPersons.RawTrainee;
import com.londonfitness.simDAO.table.persons.Coach;
import com.londonfitness.simDAO.table.persons.Trainee;

public class ModelTrainee {
    Trainee trainee;
    ModelVIP vip;
    Storage storage;
    public ModelTrainee(Trainee trainee) {
        this.trainee = trainee;
        this.vip = new ModelVIP(trainee);
    }

    public Trainee createTrainee(String id,String name,short type, String username,boolean expired, String t_profile_URL) {
        RawTrainee rawTrainee = new RawTrainee();
        rawTrainee.ID = id;
        rawTrainee.name = name;
        rawTrainee.type = type;
        rawTrainee.username = username;
        rawTrainee.expired = expired;
        rawTrainee.t_profile_URL = t_profile_URL;
        Trainee t = new Trainee(rawTrainee);
        t.insert(storage);
        return t;
    }

    public void deleteTrainee(Trainee trainee) {

    }

    public void updateTrainee(String... args) {

    }

    public ModelVIP getVipState() {
        return vip;
    }
}
