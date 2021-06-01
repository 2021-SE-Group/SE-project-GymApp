package com.londonfitness.GUI;

import com.londonfitness.simDAO.memStorage.Storage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class HistoryPanel extends JPanel {
    private final JLabel lblUserInterface = new JLabel("History");
    Storage storage;
    JButton btnNewButton_1;
    JButton btnNewButton_2;

    public HistoryPanel(Storage storage) {
        this.storage = storage;
        this.initComponent();
        this.setVisible(true);

    }

    private void initComponent() {
        JLabel lblNewLabel = new JLabel("HISTORY");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));

        JScrollPane scrollPane = new JScrollPane();
        GroupLayout gl_panel = new GroupLayout(this);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGap(216)
                                                .addComponent(lblNewLabel))
                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 519, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGap(5)
                                .addComponent(lblNewLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
        );

        JTable table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                        {null, null, null},
                },
                new String[]{
                        "DATE", "TRAINER", "STATUS"
                }
        ));
        scrollPane.setViewportView(table);
    }
}
