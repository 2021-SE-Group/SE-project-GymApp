package com.londonfitness.xmlloader;

import com.londonfitness.ExternKey;
import com.londonfitness.XMLListLoad;
import com.londonfitness.table.LFClass;
import com.londonfitness.table.persons.Coach;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class CoachLoader extends XMLListLoad<Coach> implements ExternKey<LFClass> {
    public CoachLoader(NodeList list) {
        super(list);
    }

    @Override
    protected void scanColumn(Node n, Coach coach) {
        switch (n.getNodeName()) {
            case "ID":
                coach.ID = n.getFirstChild().getNodeValue();
                break;
            case "username":
                coach.username = n.getFirstChild().getNodeValue();
                break;
            case "name":
                coach.name = n.getFirstChild().getNodeValue();
                break;
            case "expire":
                coach.expired = false;
                if(n.getFirstChild().getNodeValue() == "t" || n.getFirstChild().getNodeValue() == "T")
                    coach.expired = true;
                break;
            case "c_profile_URL":
                coach.c_profile_URL = n.getFirstChild().getNodeValue();
                break;
            case "ability_class_list":
                System.out.println("TODO: ability_class_list for coach");
                break;
        }
    }

    @Override
    protected Coach getNewElem() {
        return new Coach();
    }

    @Override
    public LFClass finishKey(String getByID) {
        return null;
    }
}
