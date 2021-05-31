package com.londonfitness.simDAO.table.persons;

import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.rawTable.rawPersons.RawStaff;
import com.londonfitness.simDAO.table.Table;

public class Staff extends Table<RawStaff> {
    public Staff(RawStaff rawStaff) {
        super(rawStaff);
    }

    @Override
    public void insert(Storage storage) {
        storage.staffs.add(this);
    }
    // index field
    //public Index<Staff, Booking> index_booking;
}
