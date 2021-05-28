package com.londonfitness.simDAO.table.persons;

import com.londonfitness.simDAO.rawTable.rawPersons.RawAdmin;
import com.londonfitness.simDAO.table.Table;

public class Admin extends Table<RawAdmin> {
    public Admin(RawAdmin rawAdmin) {
        super(rawAdmin);
    }
}
