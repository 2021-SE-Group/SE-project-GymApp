package com.londonfitness;

import com.londonfitness.table.Category;

import java.util.ArrayList;

public interface ExternKey<T> {
    T finishKey(String getByID);
    ArrayList<T> getTable();
    void setTable(ArrayList<T> table);
}
