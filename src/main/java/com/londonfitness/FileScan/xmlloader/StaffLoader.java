package com.londonfitness.FileScan.xmlloader;

import com.londonfitness.FileScan.XMLTableLoad;
import com.londonfitness.table.persons.Staff;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class StaffLoader extends XMLTableLoad<Staff> {

    public StaffLoader(NodeList list, ArrayList<Staff> res) {
        super(list, res);
    }

    @Override
    protected void scanCell(Node n, Staff staff) {
        switch (n.getNodeName()) {
            case "ID":
                staff.ID = n.getFirstChild().getNodeValue();
                break;
            case "username":
                staff.username = n.getFirstChild().getNodeValue();
                break;
            case "name":
                staff.name = n.getFirstChild().getNodeValue();
                break;
            case "expire":
                staff.expired = false;
                if(n.getFirstChild().getNodeValue() == "t" || n.getFirstChild().getNodeValue() == "T")
                    staff.expired = true;
                break;
        }
    }

    @Override
    protected Staff getNewElem() {
        return new Staff();
    }
}
