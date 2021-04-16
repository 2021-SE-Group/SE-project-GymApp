package com.londonfitness.GUI;

import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.table.Record;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class HistoryPanel extends JPanel {
    Storage storage;
    private final JLabel lblUserInterface = new JLabel("History");
    JButton btnNewButton_1;
    JButton btnNewButton_2;

    public HistoryPanel(Storage storage) {
        this.storage = storage;
        //this.initComponent();
        this.setVisible(true);

    }


    private void initComponent(ArrayList<Record> records) {
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
        Object[][] HP = new Object[records.size()][3];
        for (int i = 0; i < records.size(); i++) {
            Record r = records.get(i);
            HP[i][0] = r.Date;
            HP[i][1] = r.Coach;
            HP[i][2] = r.Status;
        }
        JTable table = new JTable();
        table.setModel(new DefaultTableModel(
                HP,
                new String[]{
                        "DATE", "TRAINER", "STATUS"
                }
        ));
        scrollPane.setViewportView(table);
    }
}
