package com.londonfitness.GUI;

import com.londonfitness.memStorage.Storage;

import javax.swing.*;

public class JScrollPane_CoachTable extends JScrollPane {
    private JTable CoachTable;
    private Storage storage;


    public JScrollPane_CoachTable(Storage storage) {
        Object[][] CP = new Object[storage.coaches.size()][4];
        for (int i = 0; i < storage.coaches.size(); i++) {
            CP[i][0] = storage.coaches.get(i).ID;
            CP[i][1] = storage.coaches.get(i).username;
            CP[i][2] = storage.coaches.get(i).name;
            CP[i][3] = storage.coaches.get(i).c_profile_URL;
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
