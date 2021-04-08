package com.londonfitness.xmlloader;

import com.londonfitness.ExternKey;
import com.londonfitness.XMLListLoad;
import com.londonfitness.table.Category;
import com.londonfitness.table.LFClass;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class LFClassLoader extends XMLListLoad<LFClass> implements ExternKey<Category> {
    private ArrayList<Category> categories;
    public LFClassLoader(NodeList list, ArrayList<Category> externalKey) {
        super(list);
        categories = externalKey;
    }

    @Override
    public Category finishKey(String getByID) {
        for(Category c: categories) {
            if(c.ID.equals(getByID)) {
                return c;
            }
        }
        return null;
    }


    @Override
    protected void scanColumn(Node n, LFClass lfClass) {
        switch (n.getNodeName()){
            case "ID":
                lfClass.ID = n.getFirstChild().getNodeValue();
                break;
            case "name":
                lfClass.name = n.getFirstChild().getNodeValue();
                break;
            case "category":
                lfClass.category = finishKey(n.getFirstChild().getNodeValue());
                break;
        }
    }

    @Override
    protected LFClass getNewElem() {
        return new LFClass();
    }
}
