package com.londonfitness.GUI;

import com.londonfitness.simDAO.memStorage.Storage;

import javax.swing.*;

public class ManagementFrame extends JFrame {
    private final Storage storage;

    public ManagementFrame(Storage storage) {
        this.storage = storage;
        initComponents();
    }

    public void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gym Service");

        JTabbedPane jtp_top = new JTabbedPane();
        JTabbedPane jtp_service = new JTabbedPane();
        JTabbedPane jtp_view = new JTabbedPane();

        jtp_top.addTab("data view", jtp_view);
        jtp_top.addTab("management services", jtp_service);
    }

}
