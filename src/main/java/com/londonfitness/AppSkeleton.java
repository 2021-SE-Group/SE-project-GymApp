package com.londonfitness;

import com.londonfitness.GUI.ServicFrame;
import com.londonfitness.simDAO.fileIO.FileScan.ScanXML;
import com.londonfitness.simDAO.fileIO.XMLDocumentBuilder;
import com.londonfitness.simDAO.indexBuilder.RebuildIndexes;
import com.londonfitness.simDAO.memStorage.Storage;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public abstract class AppSkeleton {
    private static final Date initTime = new Date();
    private static final SimpleDateFormat sdfFileName = new SimpleDateFormat("yyMMddhhmmss");
    private static final String resourcePathName = "resources\\";
    private static final String cacheFileName = resourcePathName + sdfFileName.format(initTime) + "-data.xml";
    private static final String defaultFileName = resourcePathName + "data.xml";

    protected Storage storage;

    public AppSkeleton() {
        storage = new Storage();
        try {
            XMLDocumentBuilder xdb = new XMLDocumentBuilder();

            // from xml, load tables into our container
            {
                System.out.println("Start to scan data file.");
                new ScanXML(xdb.documentBuilder, storage, resourcePathName, defaultFileName).scan();
                System.out.println("Finish scanning data file.");
            }

            // from storage, build up indexes
            {
                System.out.println("Start to build up indexes.");
                new RebuildIndexes(storage);
                System.out.println("Finish building indexes.");
            }
            bringUpGUI();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public Storage getStorage() {
        return storage;
    }

    public abstract void bringUpGUI();
}
