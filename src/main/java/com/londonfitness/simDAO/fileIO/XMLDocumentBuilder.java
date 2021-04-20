package com.londonfitness.simDAO.fileIO;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class XMLDocumentBuilder {
    public DocumentBuilder documentBuilder;

    public XMLDocumentBuilder() throws ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        OutputStreamWriter errorWriter = new OutputStreamWriter(System.err, StandardCharsets.UTF_8);

        documentBuilder = dbf.newDocumentBuilder();
        documentBuilder.setErrorHandler(new XMLErrorHandler(new PrintWriter(errorWriter, true)));
    }
}
