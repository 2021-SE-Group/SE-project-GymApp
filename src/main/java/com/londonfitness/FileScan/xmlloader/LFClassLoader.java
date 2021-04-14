package com.londonfitness.FileScan.xmlloader;

import com.londonfitness.FileScan.XMLTableLoad;
import com.londonfitness.table.LFClass;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class LFClassLoader extends XMLTableLoad<LFClass> {
    public LFClassLoader(NodeList list, ArrayList<LFClass> res) {
        super(list, res);
    }

    @Override
    protected void scanCell(Node n, LFClass lfClass) {
        switch (n.getNodeName()){
            case "ID":
                lfClass.ID = n.getFirstChild().getNodeValue();
                break;
            case "name":
                lfClass.name = n.getFirstChild().getNodeValue();
                break;
            case "category_ID":
                lfClass.category_ID = n.getFirstChild().getNodeValue();
                break;
        }
    }

    @Override
    protected LFClass getNewElem() {
        return new LFClass();
    }
}
