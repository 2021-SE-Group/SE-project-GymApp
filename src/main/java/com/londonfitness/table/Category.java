package com.londonfitness.table;

import com.londonfitness.Table;

public class Category extends Table {
    public Category() {
        Category.ColumnMeta = new String[][]{{"ID", "name", "parent_ID"}, {}, {}, {}};
    }
    public Category(String ID, String name, String parent_ID) {
        this();
        this.ID = ID;
        this.name = name;
        this.parent_ID = parent_ID;
    }

    public String ID;
    public String name;
    public String parent_ID;
    //public Category parent;

    @Override
    public String toString() {
        return "Category{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", parent_ID=\'" + parent_ID + '\'' +
                '}';
    }
}
