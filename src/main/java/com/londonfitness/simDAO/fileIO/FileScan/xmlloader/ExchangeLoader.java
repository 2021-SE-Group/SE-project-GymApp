package com.londonfitness.simDAO.fileIO.FileScan.xmlloader;

import com.londonfitness.simDAO.fileIO.FileScan.XMLTableLoad;
import com.londonfitness.OurDateFormat;
import com.londonfitness.simDAO.table.Exchange;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.text.ParseException;
import java.util.ArrayList;

public class ExchangeLoader extends XMLTableLoad<Exchange> {
    public ExchangeLoader(NodeList list, ArrayList<Exchange> res) {
        super(list, res);
    }

    @Override
    protected void scanCell(Node n, Exchange exchange) {
        switch (n.getNodeName()){
            case "booking_ID":
                exchange.booking_ID = n.getFirstChild().getNodeValue();
                break;
            case "coach_ID":
                exchange.coach_ID = n.getFirstChild().getNodeValue();
                break;
            case "pre_startDate":
                try {
                    exchange.pre_startDate = OurDateFormat.fileDate.parse(n.getFirstChild().getNodeValue()) ;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "aft_startDate":
                try {
                    exchange.aft_startDate = OurDateFormat.fileDate.parse(n.getFirstChild().getNodeValue()) ;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "repeat":
                exchange.repeat = Long.parseLong(n.getFirstChild().getNodeValue());
                break;
        }
    }

    @Override
    protected Exchange getNewElem() {
        return new Exchange();
    }
}
