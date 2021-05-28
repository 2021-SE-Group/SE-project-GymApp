package com.londonfitness.simDAO.rawTable;

import com.londonfitness.simDAO.indexBuilder.Index;

public class RawCategory extends RawTable {
    public RawCategory() {

    }

    // meta
    @Override
    protected String getTableMeta(short type, String name) {
        return "";
    }

    public String ID;
    public String name;
    public String parent_ID;
    @Override
    public String toString() {
        return "Category{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", parent_ID='" + parent_ID + '\'' +
                '}';
    }
}
