package com.londonfitness.simDAO.indexBuilder.indexBuilders;

import com.londonfitness.simDAO.indexBuilder.Index;
import com.londonfitness.simDAO.indexBuilder.IndexBuilder;
import com.londonfitness.simDAO.table.Category;
import com.londonfitness.simDAO.table.LFClass;

import java.util.ArrayList;

public class Category_LFClassIndexBuilder extends IndexBuilder<Category, LFClass> {
    public Category_LFClassIndexBuilder(ArrayList<Category> categories, ArrayList<LFClass> tns_all) {
        super(categories, tns_all);
    }

    @Override
    protected boolean checkIndexing(Category category, LFClass lfClass) {
        return lfClass.category_ID.equals(category.ID);
    }

    @Override
    protected void setT1Index(Category category, Index<Category, LFClass> ind) {
        category.index_lfClass = ind;
    }
}
