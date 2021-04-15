package com.londonfitness.indexBuilder;

import com.londonfitness.indexBuilder.indexBuilders.CategorySelfIndexBuilder;
import com.londonfitness.indexBuilder.indexBuilders.Category_LFClassIndexBuilder;
import com.londonfitness.memStorage.Storage;
import com.londonfitness.table.Category;

import java.util.Iterator;

public class RebuildIndexes {
    public RebuildIndexes(Storage storage) {
        CategorySelfIndexBuilder ccb = new CategorySelfIndexBuilder(storage.categories);
        ccb.buildIndex();

        Category_LFClassIndexBuilder clb = new Category_LFClassIndexBuilder(storage.categories, storage.lfClasses);
        clb.buildIndex();

        ///* only for developing, when done, delete
        DFT(storage.categories.get(0));
        //*/
    }

    ///* only for developing, when done, delete
    private void DFT(Category category) {
        System.out.println(category);
        for (Iterator<Category> it = category.selfIndex.getTnIter(); it.hasNext(); ) {
            Category  cate = it.next();
            DFT(cate);
        }
    }
    //*/
}
