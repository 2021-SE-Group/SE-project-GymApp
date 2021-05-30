package com.londonfitness.GUI.ourComponent.tableGUI.example;

public class TraineeBookingJoinTableItem {
    public TraineeBookingJoinTableItem(
            String tid,
            String tnm,
            String bid,
            String cid,
            String cnm

    ) {
        Trainee_ID = tid;
        Trainee_name = tnm;
        Booking_ID = bid;
        LFClass_ID = cid;
        LFClass_name = cnm;
    }
    public String Trainee_ID;
    public String Trainee_name;
    public String Booking_ID;
    public String LFClass_ID;
    public String LFClass_name;
}
