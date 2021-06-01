package com.londonfitness.model;

import com.londonfitness.simDAO.table.Booking;

public class ModelLesson {
    public Booking store1;
    public int store2;

    public ModelLesson(Booking store1, int store2) {
        this.store1 = store1;
        this.store2 = store2;
    }

    public long getStart() {
        return store1.raw.startDate.getTime() + store2 * store1.raw.repeat;
    }

    public long getEnd() {
        return store1.raw.startDate.getTime() + store2 * store1.raw.repeat + store1.externKey_lfClass.raw.duration;
    }

    @Override
    public String toString() {
        return "ModelLesson{" +
                "store1=" + store1 +
                ", store2=" + store2 +
                '}';
    }
}
