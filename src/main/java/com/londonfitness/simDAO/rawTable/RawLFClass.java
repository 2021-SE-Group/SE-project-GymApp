package com.londonfitness.simDAO.rawTable;

public class RawLFClass extends RawTable {
    public RawLFClass() {
    }

    // meta
    @Override
    protected String getTableMeta(short type, String name) {
        return "";
    }

    public String ID;
    public String name;
    public String coach_ID;
    public String category_ID;
    public Long duration;
    public String resource_URL;
    @Override
    public String toString() {
        return "LFClass{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", coach_ID='" + coach_ID + '\'' +
                ", duration='" + duration + '\'' +
                ", resource_URL='" + resource_URL + '\'' +
                ", category_ID='" + category_ID + '\'' +
                '}';
    }
}
