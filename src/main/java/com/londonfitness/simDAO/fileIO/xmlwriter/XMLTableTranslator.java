package com.londonfitness.simDAO.fileIO.xmlwriter;

import com.londonfitness.simDAO.table.Table;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;

public abstract class XMLTableTranslator<T extends Table>{
    private final Document doc;
    private final ArrayList <T> list;
    private final Element root;
    private final String listName;
    private final String unitName;

    private Element t_unit;

    public XMLTableTranslator(Document doc, Element root,
                              String listName, String unitName,
                              ArrayList<T> list)
    {
        this.doc = doc;
        this.list = list;
        this.root = root;
        this.listName = listName;
        this.unitName = unitName;
    }

    public void write(){
        Element t_list = doc.createElement(listName);
        for(T t: list){
            t_unit = doc.createElement(unitName);
            setRow(t);
            t_list.appendChild(t_unit);
        }
        root.appendChild(t_list);
    }

    protected void setCell(String cellName, String text) {
        Element cell = doc.createElement(cellName);
        cell.setTextContent(text);
        t_unit.appendChild(cell);
    }

    public abstract void setRow(T t);
}

