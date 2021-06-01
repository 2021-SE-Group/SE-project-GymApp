package com.londonfitness.simDAO.memStorage;

import com.londonfitness.simDAO.indexBuilder.Index;
import com.londonfitness.simDAO.indexBuilder.IndexBuilder121;
import com.londonfitness.simDAO.table.*;
import com.londonfitness.simDAO.table.persons.Admin;
import com.londonfitness.simDAO.table.persons.Coach;
import com.londonfitness.simDAO.table.persons.Staff;
import com.londonfitness.simDAO.table.persons.Trainee;

import java.util.ArrayList;

public class Storage {
    public static IndexBuilder121<Category, LFClass> categoryLFClassIndexBuilder121
            = new IndexBuilder121<>() {
        @Override
        protected boolean checkIndexing(Category category, LFClass lfClass) {
            return lfClass.raw.category_ID.equals(category.raw.ID);
        }

        @Override
        protected void setTnDep(Category category, LFClass lfClass) {
            lfClass.externKey_category = category;
        }

        @Override
        protected Index<Category, LFClass> getIndex(Category category) {
            return category.index_lfClass;
        }
    };
    public static IndexBuilder121<Category, Category> categoryCategoryIndexBuilder121
            = new IndexBuilder121<>() {
        @Override
        protected boolean checkIndexing(Category category, Category category2) {
            return category2.raw.parent_ID.equals(category.raw.ID);
        }

        @Override
        protected void setTnDep(Category category, Category category2) {
            category2.parent = category;
        }

        @Override
        protected Index<Category, Category> getIndex(Category category) {
            return category.selfIndex;
        }
    };
    public static IndexBuilder121<Coach, Booking> coachBookingIndexBuilder121
            = new IndexBuilder121<>() {
        @Override
        protected boolean checkIndexing(Coach coach, Booking booking) {
            return booking.raw.coach_ID.equals(coach.raw.ID);
        }

        @Override
        protected void setTnDep(Coach coach, Booking booking) {
            booking.externKey_coach = coach;
        }

        @Override
        protected Index<Coach, Booking> getIndex(Coach coach) {
            return coach.index_booking;
        }
    };
    public static IndexBuilder121<Coach, CoachAbility> coachCoachAbilityIndexBuilder121
            = new IndexBuilder121<>() {
        @Override
        protected boolean checkIndexing(Coach coach, CoachAbility coachAbility) {
            return coachAbility.raw.coach_ID.equals(coach.raw.ID);
        }

        @Override
        protected void setTnDep(Coach coach, CoachAbility coachAbility) {
            coachAbility.externKey_coach = coach;
        }

        @Override
        protected Index<Coach, CoachAbility> getIndex(Coach coach) {
            return coach.index_coachAbility;
        }
    };
    public static IndexBuilder121<LFClass, Booking> lfClassBookingIndexBuilder121
            = new IndexBuilder121<>() {
        @Override
        protected boolean checkIndexing(LFClass lfClass, Booking booking) {
            return booking.raw.lfClass_ID.equals(lfClass.raw.ID);
        }

        @Override
        protected void setTnDep(LFClass lfClass, Booking booking) {
            booking.externKey_lfClass = lfClass;
        }

        @Override
        protected Index<LFClass, Booking> getIndex(LFClass lfClass) {
            return lfClass.index_booking;
        }
    };
    public static IndexBuilder121<LFClass, CoachAbility> lfClassCoachAbilityIndexBuilder121
            = new IndexBuilder121<>() {
        @Override
        protected boolean checkIndexing(LFClass lfClass, CoachAbility coachAbility) {
            return coachAbility.raw.lfc_ID.equals(lfClass.raw.ID);
        }

        @Override
        protected void setTnDep(LFClass lfClass, CoachAbility coachAbility) {
            coachAbility.externKey_lfClass = lfClass;
        }

        @Override
        protected Index<LFClass, CoachAbility> getIndex(LFClass lfClass) {
            return lfClass.index_CoachAbility;
        }
    };
    public static IndexBuilder121<Trainee, Booking> traineeBookingIndexBuilder121
            = new IndexBuilder121<>() {
        @Override
        protected boolean checkIndexing(Trainee trainee, Booking booking) {
            return booking.raw.trainee_ID.equals(trainee.raw.ID);
        }

        @Override
        protected void setTnDep(Trainee trainee, Booking booking) {
            booking.externKey_trainee = trainee;
        }

        @Override
        protected Index<Trainee, Booking> getIndex(Trainee trainee) {
            return trainee.index_booking;
        }
    };
    public ArrayList<Category> categories;
    public ArrayList<LFClass> lfClasses;
    public ArrayList<Admin> admins;
    public ArrayList<Staff> staffs;
    public ArrayList<Coach> coaches;
    public ArrayList<Trainee> trainees;
    public ArrayList<Booking> bookings;
    public ArrayList<Exchange> exchanges;
    public ArrayList<CoachAbility> coachAbilities;
    public ArrayList<HistoryRecord> records;
    public Storage() {
        records = new ArrayList<>();
        categories = new ArrayList<>();
        lfClasses = new ArrayList<>();
        admins = new ArrayList<>();
        staffs = new ArrayList<>();
        coaches = new ArrayList<>();
        trainees = new ArrayList<>();
        bookings = new ArrayList<>();
        exchanges = new ArrayList<>();
        coachAbilities = new ArrayList<>();
    }
}
