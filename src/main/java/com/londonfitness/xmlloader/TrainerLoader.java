package com.londonfitness.xmlloader;

import com.londonfitness.XMLListLoad;
import com.londonfitness.table.persons.Trainer;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TrainerLoader extends XMLListLoad<Trainer> {
    public TrainerLoader(NodeList list) {
        super(list);
    }

    @Override
    protected void scanColumn(Node n, Trainer trainer) {
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
