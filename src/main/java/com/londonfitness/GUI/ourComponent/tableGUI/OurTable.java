package com.londonfitness.GUI.ourComponent.tableGUI;

import com.londonfitness.simDAO.memStorage.Storage;

import javax.swing.*;

public abstract class OurTable<T> {
    public JTable jtb;
    private OurTableModel<T> tm;
    private Storage storage;

    public OurTable(Storage storage) {
        this.storage = storage;
        tm = constructModel(storage);
        jtb = new JTable(tm);
    }

    public void refresh() {
        jtb.setModel(constructModel(storage));
    }

    public abstract OurTableModel<T> constructModel(Storage storage);
}
