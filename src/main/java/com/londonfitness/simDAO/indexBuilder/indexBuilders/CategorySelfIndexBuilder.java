package com.londonfitness.simDAO.indexBuilder.indexBuilders;

import com.londonfitness.simDAO.indexBuilder.Index;
import com.londonfitness.simDAO.indexBuilder.IndexBuilder;
import com.londonfitness.simDAO.table.Category;

import java.util.ArrayList;

public class CategorySelfIndexBuilder extends IndexBuilder<Category, Category> {
    public CategorySelfIndexBuilder(ArrayList<Category> categories) {
        super(categories, categories);
    }

    @Override
    protected boolean checkIndexing(Category category, Category category2) {
        return category2.raw.parent_ID.equals(category.raw.ID);
    }

    @Override
    protected void setT1Index(Category category, Index<Category, Category> ind) {
        category.selfIndex = ind;
    }

    @Override
    protected void setTnDep(Category category, Index<Category, Category> ind) {
        category.parent = ind.getT1();
    }
}
