package com.londonfitness.simDAO.rawTable;

import java.math.BigDecimal;
import java.text.DecimalFormat;

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
    public BigDecimal price;
    @Override
    public String toString() {
        return "LFClass{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", coach_ID='" + coach_ID + '\'' +
                ", duration=" + duration +
                ", resource_URL='" + resource_URL + '\'' +
                ", category_ID='" + category_ID + '\'' +
                ", price=" + price +
                '}';
    }
}
