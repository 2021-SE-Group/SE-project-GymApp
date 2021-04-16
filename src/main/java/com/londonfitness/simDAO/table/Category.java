package com.londonfitness.simDAO.table;

import com.londonfitness.simDAO.indexBuilder.Index;

public class Category extends Table {
    public Category() {

    }

    // meta
    @Override
    protected String getTableMeta(short type, String name) {
        return new String();
    }

    //<editor-fold defaultstate="collapsed" desc="raw text field">
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
    }//</editor-fold>

    // external key field
    public Category parent;

    // index field
    public Index<Category, Category> selfIndex;
    public Index<Category, LFClass> index_lfClass;
}
