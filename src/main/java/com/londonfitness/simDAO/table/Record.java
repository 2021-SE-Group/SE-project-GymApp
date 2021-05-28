package com.londonfitness.simDAO.table;


import com.londonfitness.simDAO.rawTable.RawTable;
// TODO
public class Record extends RawTable{

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
