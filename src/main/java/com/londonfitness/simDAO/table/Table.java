package com.londonfitness.simDAO.table;

import com.londonfitness.simDAO.memStorage.Storage;

public abstract class Table <T> implements ExternKeys{
    public T raw;
    public Table (T t) {
        this.raw = t;
    }

    /*
    public static final short columnType_String = 0;
    public static final short columnType_Integer = 1;
    public static final short columnType_Date = 2;
    public static final short columnType_Boolean = 3;
    public static final short columnType_Long = 4;

    protected abstract String getTableMeta(short type, String name);
    /*
    public abstract void setCell_String(String colName, String content);
    public abstract String getCell_String(String colName);

    public abstract void setCell_Integer(String colName, Integer content);
    public abstract Integer getCell_Interger(String colName);

    public abstract void setCell_Date(String colName, Date content);
    public abstract Date getCell_Date(String colName);

    public abstract void setCell_Boolean(String colName, Boolean content);
    public abstract Boolean getCell_Boolean(String colName);

    public abstract void setCell_Long(String colName, Long content);
    public abstract Long getCell_Long(String colName);


     */
}
