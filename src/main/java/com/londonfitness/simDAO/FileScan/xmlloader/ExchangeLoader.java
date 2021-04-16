package com.londonfitness.simDAO.FileScan.xmlloader;

import com.londonfitness.simDAO.FileScan.XMLTableLoad;
import com.londonfitness.simDAO.table.Exchange;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class ExchangeLoader extends XMLTableLoad<Exchange> {
    public ExchangeLoader(NodeList list, ArrayList<Exchange> res) {
        super(list, res);
    }

    @Override
    protected void scanCell(Node n, Exchange exchange) {

    }

    @Override
    protected Exchange getNewElem() {
        return null;
    }
}
