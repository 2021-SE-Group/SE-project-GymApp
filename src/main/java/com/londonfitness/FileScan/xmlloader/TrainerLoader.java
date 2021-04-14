package com.londonfitness.FileScan.xmlloader;

import com.londonfitness.FileScan.XMLTableLoad;
import com.londonfitness.table.persons.Trainer;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class TrainerLoader extends XMLTableLoad<Trainer> {

    public TrainerLoader(NodeList list, ArrayList<Trainer> res) {
        super(list, res);
    }

    @Override
    protected void scanCell(Node n, Trainer trainer) {
        switch (n.getNodeName()) {
            case "ID":
                trainer.ID = n.getFirstChild().getNodeValue();
                break;
            case "username":
                trainer.username = n.getFirstChild().getNodeValue();
                break;
            case "name":
                trainer.name = n.getFirstChild().getNodeValue();
                break;
            case "expire":
                trainer.expired = false;
                if(n.getFirstChild().getNodeValue() == "t" || n.getFirstChild().getNodeValue() == "T")
                    trainer.expired = true;
                break;
            case "t_profile_URL":
                trainer.t_profile_URL = n.getFirstChild().getNodeValue();
                break;
        }
    }

    @Override
    protected Trainer getNewElem() {
        return new Trainer();
    }
}
