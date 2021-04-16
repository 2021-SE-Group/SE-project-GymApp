package com.londonfitness.table;

import com.londonfitness.Table;

public class Record extends Table {

    @Override
    protected String getTableMeta(short type, String name) {
        return "";
    }
    public String c_profile_URL;
    //public String BookingID;
    //public int CLASSNum;
    public String Date;
    public String Coach;
    public String Status;
    @Override
    public String toString() {
        return "Record{" +
                "Date=" + Date + '\'' +
                ", Coach='" + Coach + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }
}
