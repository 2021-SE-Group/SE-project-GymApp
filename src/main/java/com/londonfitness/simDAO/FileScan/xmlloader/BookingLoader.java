package com.londonfitness.simDAO.FileScan.xmlloader;

import com.londonfitness.simDAO.FileScan.XMLTableLoad;
import com.londonfitness.OurDateFormat;
import com.londonfitness.simDAO.table.Booking;
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
            case "ID":
                booking.ID = n.getFirstChild().getNodeValue();
                break;
            case "coach_ID":
                booking.coach_ID = n.getFirstChild().getNodeValue();
                break;
            case "trainee_ID":
                booking.trainee_ID = n.getFirstChild().getNodeValue();
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
