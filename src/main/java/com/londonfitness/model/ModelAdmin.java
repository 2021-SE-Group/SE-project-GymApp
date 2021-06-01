package com.londonfitness.model;

import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.rawTable.rawPersons.RawAdmin;
import com.londonfitness.simDAO.table.persons.Admin;

public class ModelAdmin {
    Admin admin;
    Storage storage;

    public ModelAdmin(Storage storage, Admin admin) {
        this.admin = admin;
    }

    public Admin createAdmin(String id, String name, short type, String username, boolean expired) {
        RawAdmin rawAdmin = new RawAdmin();
        rawAdmin.ID = id;
        rawAdmin.name = name;
        rawAdmin.type = type;
        rawAdmin.username = username;
        rawAdmin.expired = expired;
        Admin a = new Admin(rawAdmin);
        a.insert(storage);
        return a;
    }

    public void deleteAdmin(Admin admin) {

    }

    public void updateAdmin(String id, String name, short type, String username, boolean expired) {

    }

}
