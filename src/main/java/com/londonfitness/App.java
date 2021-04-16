package com.londonfitness;

import com.londonfitness.simDAO.FileScan.ScanXML;
import com.londonfitness.GUI.ServicFrame;
import com.londonfitness.simDAO.indexBuilder.RebuildIndexes;
import com.londonfitness.simDAO.memStorage.Storage;

import javax.swing.*;
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
        //Charset charset = Charset.forName("UTF-8");
        // new MemDB and init it
        final Storage storage = new Storage();

        // from xml, load tables into our container
        {
            System.out.println("Start to scan data file.");
            new ScanXML(storage, resourcePathName, defaultFileName);
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
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new ServicFrame(storage).setVisible(true);
                }
            });
        }

        // storage tables to new xml file, if all done, change name
        /*
          display a wait-for-a-while window
          gen DOM
          write
          change name
         */
        {


        }


    }
}
