package com.londonfitness;

import com.londonfitness.simDAO.fileIO.FileScan.ScanXML;
import com.londonfitness.GUI.ServicFrame;
import com.londonfitness.simDAO.fileIO.XMLDocumentBuilder;
import com.londonfitness.simDAO.fileIO.xmlwriter.WriteXML;
import com.londonfitness.simDAO.indexBuilder.RebuildIndexes;
import com.londonfitness.simDAO.memStorage.Storage;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import java.util.Date;


/**
 * Hello world!
 *
 */
public class App 
{
    private static final Date initTime = new Date();
    private static final SimpleDateFormat sdfFileName = new SimpleDateFormat("yyMMddhhmmss");
    private static final String resourcePathName = "resources\\";
    private static final String cacheFileName = resourcePathName + sdfFileName.format(initTime) + "-data.xml";
    private static final String defaultFileName = resourcePathName + "data.xml";

    public static void main( String[] args )
    {
        // new MemDB and init it
        final Storage storage = new Storage();

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

            // do service
            {
                // prepare
                // main frame kick in
                /* Set the Default look and feel */
                //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Default".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException
                        | UnsupportedLookAndFeelException
                        | IllegalAccessException
                        | InstantiationException ex) {
                    java.util.logging.Logger.getLogger(ServicFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                //</editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(() -> new ServicFrame(storage).setVisible(true));
            }

            // storage tables to new xml file, if all done, change name
            /*
            display a wait-for-a-while window
            gen DOM
            write
            change name
            */
            /*
            {
                System.out.println("Start to save data file.");
                new WriteXML(xdb.documentBuilder, Paths.get(defaultFileName), storage).translate();
                System.out.println("Data file saved.");
            }
             */
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
