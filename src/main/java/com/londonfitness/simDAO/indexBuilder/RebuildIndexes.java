package com.londonfitness.simDAO.indexBuilder;

import com.londonfitness.simDAO.indexBuilder.indexBuilders.*;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.table.Category;

import java.util.Iterator;

public class RebuildIndexes {
    public RebuildIndexes(Storage storage) {
        CategorySelfIndexBuilder ccb = new CategorySelfIndexBuilder(storage.categories);
        ccb.buildIndex();

        Category_LFClassIndexBuilder clb = new Category_LFClassIndexBuilder(storage.categories, storage.lfClasses);
        clb.buildIndex();

        LFClass_BookingIndexBuilder lbb = new LFClass_BookingIndexBuilder(storage.lfClasses, storage.bookings);
        lbb.buildIndex();

        Trainee_BookingIndexBuilder tbb = new Trainee_BookingIndexBuilder(storage.trainees, storage.bookings);
        tbb.buildIndex();

        Coach_BookingIndexBuilder cbb = new Coach_BookingIndexBuilder(storage.coaches, storage.bookings);
        cbb.buildIndex();
        /* only for developing, when done, delete
        DFT(storage.categories.get(0));
        //*/
    }

    /* only for developing, when done, delete
    private void DFT(Category category) {
        System.out.println(category.raw);
        for (Iterator<Category> it = category.selfIndex.getTnIter(); it.hasNext(); ) {
            Category  cate = it.next();
            DFT(cate);
        }
    }
    //*/
}
