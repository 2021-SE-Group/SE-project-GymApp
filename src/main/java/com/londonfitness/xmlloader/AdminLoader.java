package com.londonfitness.xmlloader;

import com.londonfitness.XMLLoad;
import com.londonfitness.table.persons.Admin;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AdminLoader extends XMLLoad<Admin> {

    public AdminLoader(NodeList list) {
        super(list);
    }

    @Override
    protected Admin loadAttr(Node node) {
        Admin admin = new Admin();
        NodeList nl = node.getChildNodes();
        for(int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            if (n.getNodeType() != 3) {
                switch (n.getNodeName()) {

                }
            }
        }
        return null;
    }
}
