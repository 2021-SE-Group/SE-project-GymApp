package com.londonfitness.simDAO.FileScan.xmlloader;

import com.londonfitness.simDAO.FileScan.XMLTableLoad;
import com.londonfitness.simDAO.table.persons.Trainee;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class TraineeLoader extends XMLTableLoad<Trainee> {

    public TraineeLoader(NodeList list, ArrayList<Trainee> res) {
        super(list, res);
    }

    @Override
    protected void scanCell(Node n, Trainee trainee) {
        switch (n.getNodeName()) {
            case "ID":
                trainee.ID = n.getFirstChild().getNodeValue();
                break;
            case "username":
                trainee.username = n.getFirstChild().getNodeValue();
                break;
            case "name":
                trainee.name = n.getFirstChild().getNodeValue();
                break;
            case "expire":
                trainee.expired = false;
                if(n.getFirstChild().getNodeValue() == "t" || n.getFirstChild().getNodeValue() == "T")
                    trainee.expired = true;
                break;
            case "t_profile_URL":
                trainee.t_profile_URL = n.getFirstChild().getNodeValue();
                break;
        }
    }

    @Override
    protected Trainee getNewElem() {
        return new Trainee();
    }
}
