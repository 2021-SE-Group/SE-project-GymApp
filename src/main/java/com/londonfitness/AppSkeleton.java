package com.londonfitness;

import com.londonfitness.simDAO.fileIO.FileScan.ScanXML;
import com.londonfitness.simDAO.fileIO.XMLDocumentBuilder;
import com.londonfitness.simDAO.fileIO.xmlwriter.WriteXML;
import com.londonfitness.simDAO.indexBuilder.RebuildIndexes;
import com.londonfitness.simDAO.memStorage.Storage;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public abstract class AppSkeleton {
    private static final Date initTime = new Date();
    private static final SimpleDateFormat sdfFileName = new SimpleDateFormat("yyMMddhhmmss");
    private static final String resourcePathName = "resources\\";
    private static final String cachePathName = "cache\\";
    private static final String cacheFileName = resourcePathName + sdfFileName.format(initTime) + "-data.xml";
    private static final String defaultFileName = resourcePathName + "data.xml";

    protected Storage storage;
    private String lastSaved = null;
    private JFrame jf;

    public AppSkeleton(boolean load, boolean index, boolean buildGUI, boolean autosave, boolean replaceData) {
        storage = new Storage();

        boolean hasDirectories = true;

        try {
            if(!Paths.get(resourcePathName).toFile().exists())
            {
                hasDirectories = Paths.get(resourcePathName).toFile().createNewFile();
            }

            if(!Paths.get(cachePathName).toFile().exists())
            {
                hasDirectories = hasDirectories && Paths.get(cachePathName).toFile().createNewFile();
            }

            XMLDocumentBuilder xdb = new XMLDocumentBuilder();

            // from xml, load tables into our container
            if (load) {
                System.out.println("Start to scan data file.");
                new ScanXML(xdb.documentBuilder, storage, resourcePathName, defaultFileName).scan();
                System.out.println("Finish scanning data file.");
            }

            // from storage, build up indexes
            if (index) {
                System.out.println("Start to build up indexes.");
                new RebuildIndexes(storage);
                System.out.println("Finish building indexes.");
            }

            if (buildGUI) {
                java.awt.EventQueue.invokeLater(() -> {
                    jf = bringUpGUI();
                    jf.addWindowListener(new WindowListener() {
                        @Override
                        public void windowOpened(WindowEvent e) {

                        }

                        @Override
                        public void windowClosing(WindowEvent e) {
                            if (autosave) {
                                lastSaved = "cache\\save" + OurDateFormat.fileDate.format(new Date()) + ".xml";
                                System.out.println("Start to save data file.\nFile will be saved to \"" + lastSaved + '\"');

                                new WriteXML(
                                        xdb.documentBuilder,
                                        Paths.get(lastSaved),
                                        storage
                                ).translate();
                                System.out.println("Data file saved.");
                            }

                            if(replaceData) {
                                // move file to data directory and rename
                                System.out.println("Replacing main data file with latest save.");
                                if(lastSaved != null) {

                                    if(Paths.get(defaultFileName).toFile().delete()
                                            && Paths.get(lastSaved).toFile()
                                            .renameTo(Paths.get(defaultFileName).toFile())) {
                                        System.out.println("Now the data is newest");
                                    } else {
                                        System.out.println("Move file failed.");
                                    }
                                } else {
                                    System.out.println("Currently no save");
                                }
                            }
                        }

                        @Override
                        public void windowClosed(WindowEvent e) {

                        }

                        @Override
                        public void windowIconified(WindowEvent e) {

                        }

                        @Override
                        public void windowDeiconified(WindowEvent e) {

                        }

                        @Override
                        public void windowActivated(WindowEvent e) {

                        }

                        @Override
                        public void windowDeactivated(WindowEvent e) {

                        }
                    });
                    jf.setVisible(true);
                });

            } else {
                if (autosave) {
                    lastSaved = "cache\\save" + OurDateFormat.fileDate.format(new Date()) + ".xml";
                    System.out.println("Start to save data file.\nFile will be saved to \"" + lastSaved + '\"');

                    new WriteXML(
                            xdb.documentBuilder,
                            Paths.get(lastSaved),
                            storage
                    ).translate();
                    System.out.println("Data file saved.");
                }

                if(replaceData) {
                    // move file to data directory and rename
                    System.out.println("Replacing main data file with latest save.");
                    if(lastSaved != null) {

                        if(Paths.get(defaultFileName).toFile().delete()
                                && Paths.get(lastSaved).toFile()
                                .renameTo(Paths.get(defaultFileName).toFile())) {
                            System.out.println("Now the data is newest");
                        } else {
                            System.out.println("Move file failed.");
                        }
                    } else {
                        System.out.println("Currently no save");
                    }
                }
            }
        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    public Storage getStorage() {
        return storage;
    }

    public abstract JFrame bringUpGUI();
}
