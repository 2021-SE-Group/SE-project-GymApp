package com.londonfitness;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class XMLLoad<T> {
    private NodeList list;
    protected ArrayList<T> result;

    //boolean done = true;

    public XMLLoad(NodeList list) {
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

    protected abstract T loadAttr(Node node);
}
