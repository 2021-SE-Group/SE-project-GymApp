package com.londonfitness.simDAO.fileIO.FileScan;

import com.londonfitness.simDAO.table.Table;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;

public abstract class XMLTableLoader<T extends Table> {
    private final NodeList list;
    protected ArrayList<T> result;

    public XMLTableLoader(NodeList list, ArrayList<T> res) {
        this.list = list;
        this.result = res;
    }

    public void load() {
        for (int i = 0; i < list.getLength(); i++) {
            Node n = list.item(i);
            if (n.getNodeType() != 3) {
                T t = loadRow(n);
                result.add(t);
            }
        }
    }

    private T loadRow(Node node) {
        T t = getNewInstanceOfType();

        NodeList nl = node.getChildNodes();
        for (int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            if (n.getNodeType() != 3) {
                scanCell(n, t);
            }
        }
        return t;
    }

    protected abstract void scanCell(Node n, T t);

    protected abstract T getNewInstanceOfType();
}
