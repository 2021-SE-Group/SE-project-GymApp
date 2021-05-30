package com.londonfitness.GUI.ourComponent.example.tableExample;

import com.londonfitness.GUI.ourComponent.tableGUI.OurTable;
import com.londonfitness.GUI.ourComponent.tableGUI.OurTableModel;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.table.Booking;
import com.londonfitness.simDAO.table.persons.Trainee;

import java.util.ArrayList;
import java.util.Iterator;

public class BookingGUI2 extends OurTable<TraineeBookingJoinTableItem> {

    public BookingGUI2(Storage storage) {
        super(storage);
    }

    @Override
    public OurTableModel<TraineeBookingJoinTableItem> constructModel(Storage storage) {
        ArrayList<TraineeBookingJoinTableItem> a = new ArrayList<>();
        for(Trainee t: storage.trainees) {
            for(Iterator<Booking> it = t.index_booking.getTnIter(); it.hasNext();) {
                Booking b = it.next();
                a.add(new TraineeBookingJoinTableItem(t.raw.ID, t.raw.name, b.raw.ID, b.externKey_lfClass.raw.ID, b.externKey_lfClass.raw.name));
            }
        }

         return new OurTableModel<>(a, 5) {
             @Override
             public Object getValueAtColumn(TraineeBookingJoinTableItem traineeBookingJoinTableItem, int columnIndex) {
                 switch (columnIndex) {
                     case 0:
                         return traineeBookingJoinTableItem.Trainee_ID;
                     case 1:
                         return traineeBookingJoinTableItem.Trainee_name;
                     case 2:
                         return traineeBookingJoinTableItem.Booking_ID;
                     case 3:
                         return traineeBookingJoinTableItem.LFClass_ID;
                     case 4:
                         return traineeBookingJoinTableItem.LFClass_name;
                     default:
                         return null;
                 }
             }

             @Override
             public void setValueAtColumn(Object aValue, TraineeBookingJoinTableItem traineeBookingJoinTableItem, int columnIndex) {
                 switch (columnIndex) {
                     case 0:
                         traineeBookingJoinTableItem.Trainee_ID = (String) aValue;
                     case 1:
                         traineeBookingJoinTableItem.Trainee_name = (String) aValue;
                     case 2:
                         traineeBookingJoinTableItem.Booking_ID = (String) aValue;
                     case 3:
                         traineeBookingJoinTableItem.LFClass_ID = (String) aValue;
                     case 4:
                         traineeBookingJoinTableItem.LFClass_name = (String) aValue;
                 }
             }

             @Override
             public String getColumnName(int columnIndex) {
                 switch (columnIndex) {
                     case 0:
                         return "Trainee's ID";
                     case 1:
                         return "Trainee's name";
                     default:
                         return "lazy";
                 }
             }

             @Override
             public Class<?> getColumnClass(int columnIndex) {
                 return String.class;
             }

             @Override
             public boolean isCellEditable(int rowIndex, int columnIndex) {
                 return false;
             }
         };
    }
}
