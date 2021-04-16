package com.londonfitness.GUI;



import com.londonfitness.simDAO.memStorage.Storage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Lessons extends JPanel {
    Storage storage;
    JButton btnNewButton_1;
    private JTable table;
    private JLabel lblTrainer;
    private JLabel lblUserInterface;

    public Lessons(Storage storage) {
        this.storage = storage;
        this.initComponent();
        this.setVisible(true);
    }
    private void initComponent() {
        GroupLayout gl_panel = new GroupLayout(this);
        lblUserInterface = new JLabel("USER INTERFACE");
        JScrollPane scrollPane = new JScrollPane();
        lblTrainer = new JLabel("Your Lessons");
        btnNewButton_1 = new JButton("Add a comment");
        table = new JTable();

        gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(gl_panel.createParallelGroup()
                        .addComponent(lblTrainer)
                        .addComponent(scrollPane))
                .addComponent(btnNewButton_1));
        gl_panel.setVerticalGroup(gl_panel.createSequentialGroup()
                .addComponent(lblTrainer)
                .addComponent(scrollPane)
                .addComponent(btnNewButton_1));

        table.setModel(new DefaultTableModel(
                new Object[][] {
                        {null, "", null},
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
                new String[] {
                        "Name", "Date", "Comment"
                }
        ));
        scrollPane.setViewportView(table);

        lblTrainer.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 40));

        btnNewButton_1.setBackground(Color.RED);
        btnNewButton_1.setFont(new Font("Berlin Sans FB Demi", Font.BOLD | Font.ITALIC, 15));
        this.setLayout(gl_panel);
        }
    }
