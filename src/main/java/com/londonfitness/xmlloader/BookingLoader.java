package com.londonfitness.xmlloader;

import com.londonfitness.ExternKey;
import com.londonfitness.XMLListLoad;
import com.londonfitness.table.Booking;
import com.londonfitness.table.CoachTrainerPair;
import com.londonfitness.table.persons.Coach;
import com.londonfitness.table.persons.Trainer;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class BookingLoader extends XMLListLoad<Booking> implements ExternKey<Trainer >{
    ArrayList<Trainer> trainers;
    ArrayList<Coach> coaches;
    ArrayList<CoachTrainerPair> ctPairs;

    public BookingLoader(NodeList list) {
        super(list);
    }

    public BookingLoader(
            NodeList list,
            ArrayList<Trainer> trainers,
            ArrayList<Coach> coaches,
            ArrayList<CoachTrainerPair> ctPairs) {
        super(list);
        this.coaches = coaches;
        this.trainers = trainers;
        this.ctPairs = ctPairs;
    }

    @Override
    protected void scanColumn(Node n, Booking booking) {

    }

    @Override
    protected Booking getNewElem() {
        return null;
    }

    @Override
    public Trainer finishKey(String getByID) {
        return null;
    }
}
