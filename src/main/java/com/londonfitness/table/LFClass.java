package com.londonfitness.table;

import com.londonfitness.Index;
import com.londonfitness.Table;
import com.londonfitness.table.persons.Trainee;

public class LFClass extends Table {
    public LFClass() {
        LFClass.ColumnMeta = new String[][]{{"ID", "name", "category_ID"}, {}, {"duration"}, {}, {}};
    }
    public LFClass(String ID, String name, String category_ID) {
        this();
        this.ID = ID;
        this.name = name;
        this.category_ID = category_ID;
    }

    public String ID;
    public String name;
    public String category_ID;
    public Long duration;
    // public Category category;

    @Override
    public String toString() {
        return "LFClass{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", category_ID=\'" + category_ID + '\'' +
                '}';
    }
    public Index<LFClass, Booking> index_booking;
}
