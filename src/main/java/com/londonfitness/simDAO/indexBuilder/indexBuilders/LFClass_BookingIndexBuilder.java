package com.londonfitness.simDAO.indexBuilder.indexBuilders;



import com.londonfitness.simDAO.indexBuilder.Index;
import com.londonfitness.simDAO.indexBuilder.IndexBuilder;
import com.londonfitness.simDAO.table.Booking;
import com.londonfitness.simDAO.table.LFClass;

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
