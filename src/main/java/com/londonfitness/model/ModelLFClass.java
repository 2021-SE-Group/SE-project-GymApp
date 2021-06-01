package com.londonfitness.model;

import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.rawTable.RawCategory;
import com.londonfitness.simDAO.rawTable.RawLFClass;
import com.londonfitness.simDAO.table.Booking;
import com.londonfitness.simDAO.table.LFClass;

import java.math.BigDecimal;

public class ModelLFClass {
    LFClass lfClass;
    Storage storage;
    public ModelLFClass(Storage storage, LFClass lfClass) {
        this.lfClass = lfClass;
    }
    public LFClass createLFClass(String ID, String name, String coach_ID, String category_ID, Long duration, String resource_URL, BigDecimal price){
        RawLFClass rawLFClass = new RawLFClass();
        rawLFClass.coach_ID = coach_ID;
        rawLFClass.ID = ID;
        rawLFClass.name = name;
        rawLFClass.category_ID = category_ID;
        rawLFClass.duration = duration;
        rawLFClass.price = price;
        rawLFClass.resource_URL = resource_URL;
        return new LFClass(rawLFClass);

    }
    public void deleteLFClass(LFClass lfClass) {

    }
    public void updateLFClass(String ID, String name, String coach_ID, String category_ID, Long duration, String resource_URL, BigDecimal price){

    }
}
