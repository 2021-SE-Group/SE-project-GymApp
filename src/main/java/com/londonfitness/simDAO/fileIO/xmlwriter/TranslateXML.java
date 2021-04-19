package com.londonfitness.simDAO.fileIO.xmlwriter;

import com.londonfitness.simDAO.fileIO.XMLErrorHandler;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TranslateXML {
    private Path dataPath;

    public TranslateXML(Path dataPath) {
        this.dataPath = dataPath;
    }

    public void translate() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //dbf.setNamespaceAware(true);
        //dbf.setValidating(true);
        OutputStreamWriter errorWriter = new OutputStreamWriter(System.err, StandardCharsets.UTF_8);

        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();

            db.setErrorHandler(new XMLErrorHandler(new PrintWriter(errorWriter, true)));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document doc = null;
        assert db != null;
        doc = db.newDocument();

        doc.setXmlStandalone(true);
        Element record_list = doc.createElement("record_list");
        translateList(doc, record_list);
        doc.appendChild(record_list);


        TransformerFactory tff=TransformerFactory.newInstance();
        Transformer tf= null;
        try {
            tf = tff.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }

        assert tf != null;
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        try {
            tf.transform(new DOMSource(doc), new StreamResult(dataPath.toFile()));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private void translateList(Document doc, Element root) {
        Element bookstore=doc.createElement("bookStore");
        //向bookstore根节点中添加字节点book
        Element book=doc.createElement("book");
        Element name=doc.createElement("name");
        book.appendChild(name);
        name.setTextContent("小王子");
        book.setAttribute("id", "1");
        //将book节点添加到bookstore根节点中
        bookstore.appendChild(book);
        //将bookstore节点（已经包含了book）,添加到dom树中
        root.appendChild(bookstore);
        //doc.appendChild(bookstore);
    }

    public static void main(String[] args) {
        TranslateXML tx = new TranslateXML(Paths.get("testResources\\data.xml"));
        tx.translate();
    }
}
