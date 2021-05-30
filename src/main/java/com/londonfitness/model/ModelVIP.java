package com.londonfitness.model;

import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.table.Booking;
import com.londonfitness.simDAO.table.persons.Trainee;

import java.math.BigDecimal;
import java.util.Iterator;

public class ModelVIP{
    private Iterator<Trainee> price;
    Storage storage;
    int flag;
    BigDecimal total = new BigDecimal(0);
    public ModelVIP(Trainee trainee){
        for(Iterator<Booking>it = trainee.index_booking.getTnIter(); it.hasNext();){
            total.add(it.next().externKey_lfClass.raw.price);
        }
        int a = total.compareTo(BigDecimal.valueOf(500));
        if(a==1||a==0){
            flag = 1;
        }
        else{
            flag = 0;
        }
    }

}
