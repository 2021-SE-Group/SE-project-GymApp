package com.londonfitness.xmlloader;

import com.londonfitness.ExternKey;
import com.londonfitness.XMLLoad;
import com.londonfitness.table.Category;
import com.londonfitness.table.LFClass;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class LFClassLoader extends XMLLoad<LFClass> implements ExternKey<Category> {
    private ArrayList<Category> keySource;
    public LFClassLoader(NodeList list, ArrayList<Category> externalKey) {
        super(list);
        setTable(externalKey);
    }

    @Override
    protected LFClass loadAttr(Node node) {
        LFClass lfc = new LFClass();
        //System.out.println(node);
        NodeList nl = node.getChildNodes();
        for(int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            if(n.getNodeType() != 3) {
                //System.out.println(n.getNodeName());
                //System.out.println(n.getFirstChild().getNodeValue());
                switch (n.getNodeName()){
                    case "ID":
                        lfc.ID = n.getFirstChild().getNodeValue();
                        break;
                    case "name":
                        lfc.name = n.getFirstChild().getNodeValue();
                        break;
                    case "category":
                        lfc.category = finishKey(n.getFirstChild().getNodeValue());
                        break;
                }
            }
        }
        return lfc;
    }

    @Override
    public Category finishKey(String getByID) {
        for(Category c: getTable()) {
            if(c.ID.equals(getByID)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Category> getTable() {
        return this.keySource;
    }

    @Override
    public void setTable(ArrayList<Category> table) {
        this.keySource = table;
    }
}
