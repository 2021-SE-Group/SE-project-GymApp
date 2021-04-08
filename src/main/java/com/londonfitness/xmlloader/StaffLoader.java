package com.londonfitness.xmlloader;

import com.londonfitness.XMLListLoad;
import com.londonfitness.table.Person;
import com.londonfitness.table.persons.Staff;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class StaffLoader extends XMLListLoad<Staff> {

    public StaffLoader(NodeList list) {
        super(list);
    }

    @Override
    protected void scanColumn(Node n, Staff staff) {
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
            case "privilage_list":
                System.out.println("TODO: parse Staffs' privilage_list");
                staff.privileges = new ArrayList<>();
                break;
        }
    }

    @Override
    protected Staff getNewElem() {
        return new Staff();
    }
}
