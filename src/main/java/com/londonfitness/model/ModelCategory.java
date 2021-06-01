package com.londonfitness.model;

import com.londonfitness.simDAO.memStorage.Storage;

import com.londonfitness.simDAO.rawTable.RawCategory;
import com.londonfitness.simDAO.table.Booking;
import com.londonfitness.simDAO.table.Category;
import com.londonfitness.simDAO.table.persons.Coach;

public class ModelCategory {
    Category category;
    Storage storage;
    public ModelCategory(Storage storage, Category category) {
        this.category = category;
    }
    public Category createCategory(String ID, String name, String parent_ID){
        RawCategory rawCategory = new RawCategory();
        rawCategory.ID = ID;
        rawCategory.name = name;
        rawCategory.parent_ID = parent_ID;
        return new Category(rawCategory);
    }
    public void deleteCategory(Category category) {

    }

    public void updateCategory(String ID, String name, String parent_ID) {

    }
}
