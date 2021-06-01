package com.londonfitness.model;

import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.rawTable.rawPersons.RawAdmin;
import com.londonfitness.simDAO.rawTable.rawPersons.RawStaff;
import com.londonfitness.simDAO.table.persons.Admin;
import com.londonfitness.simDAO.table.persons.Staff;

public class ModelStaff {
    Staff staff;
    Storage storage;
    public ModelStaff(Storage storage, Staff staff) {
        this.staff = staff;
    }

    public Staff createStaff(String id,String name,short type, String username,boolean expired) {
        RawStaff rawStaff = new RawStaff();
        rawStaff.ID = id;
        rawStaff.name = name;
        rawStaff.type = type;
        rawStaff.username = username;
        rawStaff.expired = expired;
        Staff s = new Staff(rawStaff);
        s.insert(storage);
        return s;
    }

    public void deleteStaff(Admin admin) {

    }

    public void updateStaff(String id,String name,short type, String username,boolean expired) {

    }

}
