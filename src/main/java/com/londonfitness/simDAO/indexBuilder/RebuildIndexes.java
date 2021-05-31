package com.londonfitness.simDAO.indexBuilder;


import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.table.Booking;
import com.londonfitness.simDAO.table.Category;
import com.londonfitness.simDAO.table.CoachAbility;
import com.londonfitness.simDAO.table.LFClass;
import com.londonfitness.simDAO.table.persons.Coach;
import com.londonfitness.simDAO.table.persons.Trainee;

public class RebuildIndexes {
    public RebuildIndexes(Storage storage) {
        new IndexBuilderN2M<>(
                storage.categories,
                storage.categories,
                new IndexBuilder12N<>(Storage.categoryCategoryIndexBuilder121)
        ).buildIndex();

        new IndexBuilderN2M<>(
                storage.categories,
                storage.lfClasses,
                new IndexBuilder12N<>(Storage.categoryLFClassIndexBuilder121)
        ).buildIndex();

        new IndexBuilderN2M<>(
                storage.coaches,
                storage.bookings,
                new IndexBuilder12N<>(Storage.coachBookingIndexBuilder121)
        ).buildIndex();

        new IndexBuilderN2M<>(
                storage.coaches,
                storage.coachAbilities,
                new IndexBuilder12N<>(Storage.coachCoachAbilityIndexBuilder121)
            ).buildIndex();

        new IndexBuilderN2M<>(
                storage.lfClasses,
                storage.bookings,
                new IndexBuilder12N<>(Storage.lfClassBookingIndexBuilder121)
        ).buildIndex();

        new IndexBuilderN2M<>(
                storage.lfClasses,
                storage.coachAbilities,
                new IndexBuilder12N<>(Storage.lfClassCoachAbilityIndexBuilder121)
        ).buildIndex();

        new IndexBuilderN2M<>(
                storage.trainees,
                storage.bookings,
                new IndexBuilder12N<>(Storage.traineeBookingIndexBuilder121)
        ).buildIndex();

        // copy template
        /*
        new IndexBuilderN2M<>(
                storage,
                storage,
                Storage) {
        }.buildIndex();
         */


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
