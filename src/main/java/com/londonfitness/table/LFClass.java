package com.londonfitness.table;

public class LFClass {
    public LFClass() {}
    public LFClass(String ID, String name, Category category) {
        this.ID = ID;
        this.name = name;
        this.category = category;
    }

    public String ID;
    public String name;
    public Category category;

    @Override
    public String toString() {
        return "LFClass{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}
