package com.londonfitness;

import com.londonfitness.GUI.ServicFrame;

import javax.swing.*;


/**
 * Hello world!
 *
 */
public class App extends AppSkeleton {
    @Override
    public void bringUpGUI() {
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
            java.awt.EventQueue.invokeLater(() -> new ServicFrame(getStorage()).setVisible(true));
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
    }

    public static void main(String[] args) {
        new App();
    }
}
