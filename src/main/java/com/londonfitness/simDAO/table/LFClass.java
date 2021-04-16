package com.londonfitness.simDAO.table;

import com.londonfitness.simDAO.indexBuilder.Index;

public class LFClass extends Table {
    public LFClass() {

    }

    // meta
    @Override
    protected String getTableMeta(short type, String name) {
        return "";
    }

    //<editor-fold defaultstate="collapsed" desc="raw text field">
    public String ID;
    public String name;
    public String category_ID;
    public Long duration;
    @Override
    public String toString() {
        return "LFClass{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", category_ID='" + category_ID + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }//</editor-fold>

    // external key field
    public Category externKey_category;

    // index field
    public Index<LFClass, Booking> index_booking;
    public Index<LFClass, CoachAbility> index_CoachAbility;
}