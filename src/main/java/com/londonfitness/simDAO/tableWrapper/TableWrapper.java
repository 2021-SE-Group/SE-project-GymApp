package com.londonfitness.simDAO.tableWrapper;

import com.londonfitness.simDAO.table.Table;

import java.util.Date;

public abstract class TableWrapper<T extends Table> {
    public abstract String getStringcell(String col);
    public abstract Date getDateCell(String col);
    public abstract Integer getIntegerCell(String col);
    //public abatract
}
