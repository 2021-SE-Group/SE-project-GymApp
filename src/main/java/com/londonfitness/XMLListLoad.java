package com.londonfitness;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public abstract class XMLListLoad<T> {
    private NodeList list;
    protected ArrayList<T> result;

    //boolean done = true;

    public XMLListLoad(NodeList list) {
        this.list = list;
        this.result = new ArrayList<>();
    }

    public void load() {
        for(int i = 0; i < list.getLength(); i++) {
            Node n = list.item(i);
            if(n.getNodeType() != 3) {
                T t = loadAttr(n);
                result.add(t);
            }
        }
    }

    protected T loadAttr(Node node) {
        T t = getNewElem();
        //System.out.println(node);
        NodeList nl = node.getChildNodes();
        for(int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            if(n.getNodeType() != 3) {
                //System.out.println(n.getNodeName());
                //System.out.println(n.getFirstChild().getNodeValue());
                scanColumn(n, t);
            }
        }
        return t;
    }

    protected abstract void scanColumn(Node n, T t);

    protected abstract T getNewElem();
}
