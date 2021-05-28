package com.londonfitness.GUI.ourComponent;

import com.londonfitness.simDAO.memStorage.Storage;

import javax.swing.*;
import java.util.ArrayList;

public abstract class OurTable<T> {
    public JTable jtb;
    private OurTableModel<T> tm;

    public OurTable(Storage storage) {
        tm = constructModel(storage);
        jtb = new JTable(tm);
        jtb.setVisible(true);
    }

    public abstract OurTableModel<T> constructModel(Storage storage);
}
