package com.londonfitness.simDAO.fileIO.xmlwriter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;

public abstract class TestTT <T>{
    private Document doc;
    private ArrayList <T> list;
    private Element root;
    private Element t_unit;
    private String listName;
    private String unitName;
    public TestTT(Document doc, ArrayList <T> list, Element root, String listName, String unitName)
    {
        this.doc = doc;
        this.list = list;
        this.root = root;
        this.listName = listName;
        this.unitName = unitName;
    }

    public void write(){
        Element category_list = doc.createElement(listName);
        for(T t: list){
            this.t_unit = doc.createElement(unitName);

            setRow(t);

            category_list.appendChild(t_unit);

        }
        root.appendChild(category_list);
    }

    public void setCell(String cellName, String text) {
        Element cell = doc.createElement(cellName);
        cell.setTextContent(text);
        t_unit.appendChild(cell);
    }

    public abstract void setRow(T t);
}

