package com.londonfitness.table;

public class Category {
    public Category() {}
    public Category(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public String ID;
    public String name;
    public Category parent;

    @Override
    public String toString() {
        return "Category{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                '}';
    }
}
