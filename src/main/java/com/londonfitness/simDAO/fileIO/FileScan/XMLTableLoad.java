package com.londonfitness.simDAO.fileIO.FileScan;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public abstract class XMLTableLoad<T> {
    private NodeList list;
    protected ArrayList<T> result;

    //boolean done = true;

    public XMLTableLoad(NodeList list, ArrayList<T> res) {
        this.list = list;
        this.result = res;
    }

    public void load() {
        for(int i = 0; i < list.getLength(); i++) {
            Node n = list.item(i);
            if(n.getNodeType() != 3) {
                T t = loadRow(n);
                result.add(t);
            }
        }
    }

    protected T loadRow(Node node) {
        T t = getNewElem();
        //System.out.println(node);
        NodeList nl = node.getChildNodes();
        for(int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            if(n.getNodeType() != 3) {
                //System.out.println(n.getNodeName());
                //System.out.println(n.getFirstChild().getNodeValue());
                scanCell(n, t);
            }
        }
        return t;
    }

    protected abstract void scanCell(Node n, T t);

    protected abstract T getNewElem();
}
