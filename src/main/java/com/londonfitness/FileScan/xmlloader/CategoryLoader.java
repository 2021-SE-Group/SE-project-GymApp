package com.londonfitness.FileScan.xmlloader;

import com.londonfitness.FileScan.XMLTableLoad;
import com.londonfitness.table.Category;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public class CategoryLoader extends XMLTableLoad<Category> {
    public CategoryLoader(NodeList list, ArrayList<Category> res) {
        super(list, res);
    }

    @Override
    protected void scanCell(Node n, Category category) {
        switch (n.getNodeName()){
            case "ID":
                category.ID = n.getFirstChild().getNodeValue();
                break;
            case "name":
                category.name = n.getFirstChild().getNodeValue();
                break;
            case "parent_ID":
                category.parent_ID = n.getFirstChild().getNodeValue();
                break;
        }
    }

    @Override
    protected Category getNewElem() {
        return new Category();
    }
}
