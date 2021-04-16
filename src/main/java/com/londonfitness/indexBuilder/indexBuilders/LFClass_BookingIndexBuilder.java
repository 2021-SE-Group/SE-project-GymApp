package com.londonfitness.indexBuilder.indexBuilders;

import com.londonfitness.Index;
import com.londonfitness.indexBuilder.IndexBuilder;
import com.londonfitness.table.Booking;
import com.londonfitness.table.Category;
import com.londonfitness.table.LFClass;

import java.util.ArrayList;

public class LFClass_BookingIndexBuilder extends IndexBuilder<LFClass, Booking> {
    public LFClass_BookingIndexBuilder(ArrayList<LFClass> lfClasses, ArrayList<Booking> tns_all) {
        super(lfClasses, tns_all);
    }

    @Override
    protected boolean checkIndexing(LFClass lfClass, Booking booking) {
        return booking.lfClass_ID.equals(lfClass.ID);
    }

    @Override
    protected void setT1Index(LFClass lfClass, Index<LFClass, Booking> ind) {
        lfClass.index_booking = ind;
    }

    @Override
    protected void setTnDep(Booking booking, Index<LFClass, Booking> ind) {
        booking.externKey_lfClass = ind.getT1();
    }
}
