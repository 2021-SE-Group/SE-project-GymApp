package com.londonfitness.GUI;

import com.londonfitness.simDAO.memStorage.Storage;

import javax.swing.*;
import java.awt.*;

public class StudentPanel extends JPanel {
    private final JLabel lblUserInterface = new JLabel("USER INTERFACE");
    Storage storage;
    JButton btnNewButton_1;
    JButton btnNewButton_2;

    public StudentPanel(Storage storage) {
        this.storage = storage;
        this.initComponent();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame jf = new JFrame("test");
                StudentPanel sp = new StudentPanel(new Storage());
                sp.setVisible(true);
                jf.add(sp);
                try {
                    jf.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initComponent() {
        btnNewButton_1 = new JButton("class reschedule");

        btnNewButton_2 = new JButton("history");

        JButton btnNewButton_3 = new JButton("membership");

        JButton btnNewButton_4 = new JButton("trainers");

        JButton btnNewButton = new JButton("timetable");

        JLabel lblNewLabel = new JLabel("USER Frame");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
        GroupLayout gl_panel = new GroupLayout(this);
        gl_panel.setHorizontalGroup(
                gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGap(36)
                                                .addGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btnNewButton_2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnNewButton_4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(gl_panel.createSequentialGroup()
                                                .addGap(44)
                                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
                gl_panel.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panel.createSequentialGroup()
                                .addComponent(lblNewLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnNewButton)
                                .addGap(25)
                                .addComponent(btnNewButton_1)
                                .addGap(28)
                                .addComponent(btnNewButton_2)
                                .addGap(28)
                                .addComponent(btnNewButton_3)
                                .addGap(32)
                                .addComponent(btnNewButton_4)
                                .addContainerGap(70, Short.MAX_VALUE))
        );
        this.setLayout(gl_panel);
    }
}
