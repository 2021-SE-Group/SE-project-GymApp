package com.londonfitness;

import com.londonfitness.GUI.ServicFrame;

import javax.swing.*;

/**
 * Hello world!
 */
public class App extends AppSkeleton {
    public App() {
        super(true, true, true, true, true);
    }

    public static void main(String[] args) {
        new App();
    }

    @Override
    public JFrame bringUpGUI() {
        // do service

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
        JFrame jf = new ServicFrame(getStorage());
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() ->
                jf.setVisible(true)
        );
        return jf;
    }
}
