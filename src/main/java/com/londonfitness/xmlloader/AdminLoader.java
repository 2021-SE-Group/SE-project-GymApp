package com.londonfitness.xmlloader;

import com.londonfitness.XMLListLoad;
import com.londonfitness.table.Person;
import com.londonfitness.table.persons.Admin;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AdminLoader extends XMLListLoad<Admin> {

    public AdminLoader(NodeList list) {
        super(list);
    }

    @Override
    protected void scanColumn(Node n, Admin admin) {
        switch (n.getNodeName()) {
            case "ID":
                admin.ID = n.getFirstChild().getNodeValue();
                break;
            case "username":
                admin.username = n.getFirstChild().getNodeValue();
                break;
            case "name":
                admin.name = n.getFirstChild().getNodeValue();
                break;
            case "expire":
                admin.expired = false;
                if(n.getFirstChild().getNodeValue() == "t" || n.getFirstChild().getNodeValue() == "T")
                    admin.expired = true;
                break;
        }
    }

    @Override
    protected Admin getNewElem() {
        return new Admin();
    }
    /*
    @Override
    protected Admin loadAttr(Node node) {
        Admin a = new Admin();
        a.type = Person.ADMIN_TYPE;
        NodeList nl = node.getChildNodes();
        for(int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            if (n.getNodeType() != 3) {
                switch (n.getNodeName()) {
                    case "ID":
                        a.ID = n.getFirstChild().getNodeValue();
                        break;
                    case "username":
                        a.username = n.getFirstChild().getNodeValue();
                        break;
                    case "name":
                        a.name = n.getFirstChild().getNodeValue();
                        break;
                    case "expire":
                        a.expired = false;
                        if(n.getFirstChild().getNodeValue() == "t" || n.getFirstChild().getNodeValue() == "T")
                            a.expired = true;
                        break;
                }
            }
        }
        return a;
    }

     */
}
