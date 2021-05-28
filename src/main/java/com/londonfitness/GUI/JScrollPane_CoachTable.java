package com.londonfitness.GUI;

import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.table.persons.Coach;

import javax.swing.*;
import java.util.ArrayList;

public class JScrollPane_CoachTable extends JScrollPane {
    private JTable CoachTable;
    private Storage storage;

    public JScrollPane_CoachTable(ArrayList<Coach> coaches) {
        Object[][] CP = new Object[coaches.size()][4];
        for (int i = 0; i < coaches.size(); i++) {
            Coach c = coaches.get(i);
            CP[i][0] = c.raw.ID;
            CP[i][1] = c.raw.username;
            CP[i][2] = c.raw.name;
            CP[i][3] = c.raw.c_profile_URL;
        }
        CoachTable = new JTable();
        CoachTable.setModel(new javax.swing.table.DefaultTableModel(
                CP,
                new String [] {
                        "ID", "username", "name", "profile"
                }
        ));
        this.setViewportView(CoachTable);
    }
}
