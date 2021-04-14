package com.londonfitness.memStorage;

import com.londonfitness.Index;
import com.londonfitness.table.Category;
import com.londonfitness.table.LFClass;

public class JoinTable {
    Index<Category, Category> categoryCategoryIndex;
    Index<Category, LFClass> categoryLFClassIndex;

    public JoinTable() {

    }

}
