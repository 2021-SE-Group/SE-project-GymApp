package com.londonfitness.GUI.ourComponent.tableGUI;

import com.londonfitness.simDAO.memStorage.Storage;

import javax.swing.*;

public abstract class OurTable<T> {
    public JTable jtb;
    private OurTableModel<T> tm;

    public OurTable(Storage storage) {
        tm = constructModel(storage);
        jtb = new JTable(tm);
    }

    public abstract OurTableModel<T> constructModel(Storage storage);
}
