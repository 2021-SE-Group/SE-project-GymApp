package com.londonfitness.FileScan.xmlloader;

import com.londonfitness.FileScan.XMLTableLoad;
import com.londonfitness.OurDateFormat;
import com.londonfitness.table.Booking;
import com.londonfitness.table.persons.Coach;
import com.londonfitness.table.persons.Trainer;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.text.ParseException;
import java.util.ArrayList;

public class BookingLoader extends XMLTableLoad<Booking> {

    public BookingLoader(NodeList list, ArrayList<Booking> res) {
        super(list, res);
    }

    @Override
    protected void scanCell(Node n, Booking booking) {
        switch (n.getNodeName()){
            case "coach_ID":
                booking.coach_ID = n.getFirstChild().getNodeValue();
                break;
            case "trainer_ID":
                booking.trainer_ID = n.getFirstChild().getNodeValue();
                break;
            case "lfClass_ID":
                booking.lfClass_ID = n.getFirstChild().getNodeValue();
                break;
            case "startDate":
                try {
                    booking.startDate = OurDateFormat.fileDate.parse(n.getFirstChild().getNodeValue()) ;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "repeat":
                booking.repeat = Long.parseLong(n.getFirstChild().getNodeValue());
                break;
        }
    }

    @Override
    protected Booking getNewElem() {
        return new Booking();
    }


}
