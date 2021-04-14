package com.londonfitness.FileScan;

import com.londonfitness.Table;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * TODO: refactor XMLTableLoad using this
 * @param <T>
 */
public abstract class XMLRowLoad<T extends Table> {
    protected T loadRow(Node node) {
        T t = getNewElem();
        NodeList nl = node.getChildNodes();
        for(int i = 0; i < nl.getLength(); i++) {
            Node n = nl.item(i);
            if(n.getNodeType() != 3) {
                loadCell(n, t);
            }
        }
        return t;
    }

    protected void loadCell(Node n, T t) {

    }


    protected abstract T getNewElem();
}
