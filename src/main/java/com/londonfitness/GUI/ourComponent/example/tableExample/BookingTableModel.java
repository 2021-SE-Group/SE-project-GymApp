package com.londonfitness.GUI.ourComponent.example.tableExample;

import com.londonfitness.OurDateFormat;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.table.Booking;


import javax.swing.table.AbstractTableModel;

public class BookingTableModel extends AbstractTableModel{
    private Storage storage;
    public BookingTableModel(Storage storage){this.storage = storage;}
    @Override
    public int getRowCount() {
        return storage.bookings.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Booking booking;
        booking = storage.bookings.get(rowIndex);
        switch (columnIndex){
            case 0:
                return booking.raw.coach_ID;
            case 1:
                return booking.externKey_coach.raw.name;
            case 2:
                return  booking.raw.trainee_ID;
            case 3:
                return booking.externKey_trainee.raw.name;
            case 4:
                return booking.raw.lfClass_ID;
            case 5:
                return booking.externKey_lfClass.raw.name;
            case 6:
                return OurDateFormat.fancyDate.format(booking.raw.startDate);
            case 7:
                return booking.raw.repeat;
            case 8:
                return null;
        }
        return null;
    }

}
