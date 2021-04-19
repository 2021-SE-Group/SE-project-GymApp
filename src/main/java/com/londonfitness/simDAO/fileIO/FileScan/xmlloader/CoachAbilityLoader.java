package com.londonfitness.simDAO.fileIO.FileScan.xmlloader;

import com.londonfitness.simDAO.fileIO.FileScan.XMLTableLoad;
import com.londonfitness.simDAO.table.CoachAbility;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class CoachAbilityLoader extends XMLTableLoad<CoachAbility> {
    public CoachAbilityLoader(NodeList list, ArrayList<CoachAbility> res) {
        super(list, res);
    }

    @Override
    protected void scanCell(Node n, CoachAbility coachAbility) {
        switch (n.getNodeName()){
            case "coach_ID":
                coachAbility.coach_ID = n.getFirstChild().getNodeValue();
                break;
            case "lfClass_ID":
                coachAbility.lfc_ID = n.getFirstChild().getNodeValue();
                break;
            case "time":
            coachAbility.time = n.getFirstChild().getNodeValue();
            break;
        }
    }

    @Override
    protected CoachAbility getNewElem() {
        return new CoachAbility();
    }
}
