package com.londonfitness.indexBuilder.indexBuilders;

import com.londonfitness.Index;
import com.londonfitness.indexBuilder.IndexBuilder;
import com.londonfitness.table.Category;

import java.util.ArrayList;

public class CategorySelfIndexBuilder extends IndexBuilder<Category, Category> {
    public CategorySelfIndexBuilder(ArrayList<Category> categories) {
        super(categories, categories);
    }

    @Override
    protected boolean checkIndexing(Category category, Category category2) {
        return category2.parent_ID.equals(category.ID);
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
