package com.londonfitness.xmlloader;

import com.londonfitness.ExternKey;
import com.londonfitness.XMLListLoad;
import com.londonfitness.table.Category;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class CategoryLoader extends XMLListLoad<Category> implements ExternKey<Category> {
    private ArrayList<Category> categories;
    public CategoryLoader(NodeList list) {
        super(list);
        categories = result;
    }

    @Override
    protected void scanColumn(Node n, Category category) {
        switch (n.getNodeName()){
            case "ID":
                category.ID = n.getFirstChild().getNodeValue();
                break;
            case "name":
                category.name = n.getFirstChild().getNodeValue();
                break;
            case "parent":
                category.parent = finishKey(n.getFirstChild().getNodeValue());
                break;
        }
    }

    @Override
    protected Category getNewElem() {
        return new Category();
    }

    @Override
    public Category finishKey(String getByID) {
        for (Category c : categories) {
            if (c.ID.equals(getByID)) {
                return c;
            }
        }
        return null;
    }
}
