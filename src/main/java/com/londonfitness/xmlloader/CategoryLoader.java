package com.londonfitness.xmlloader;

import com.londonfitness.ExternKey;
import com.londonfitness.XMLLoad;
import com.londonfitness.table.Category;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class CategoryLoader extends XMLLoad<Category> implements ExternKey<Category> {
    private ArrayList<Category> keySource;
    public CategoryLoader(NodeList list) {
        super(list);
        setTable(result);
    }

    @Override
    protected Category loadAttr(Node node) {
        Category c = new Category();
        //System.out.println(node);
        NodeList nl = node.getChildNodes();
        for(int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            if(n.getNodeType() != 3) {
                //System.out.println(n.getNodeName());
                //System.out.println(n.getFirstChild().getNodeValue());
                switch (n.getNodeName()){
                    case "ID":
                        c.ID = n.getFirstChild().getNodeValue();
                        break;
                    case "name":
                        c.name = n.getFirstChild().getNodeValue();
                        break;
                    case "parent":
                        c.parent = finishKey(n.getFirstChild().getNodeValue());
                        break;
                }
            }
        }
        return c;
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
    public void setTable(ArrayList<Category> alt) {
        this.keySource = alt;
    }
}
