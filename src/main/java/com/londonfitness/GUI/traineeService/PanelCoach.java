package com.londonfitness.GUI.traineeService;

import com.londonfitness.AppSkeleton;
import com.londonfitness.GUI.ourComponent.tableGUI.OurTable;
import com.londonfitness.GUI.ourComponent.tableGUI.OurTableModel;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.table.persons.Coach;

import javax.swing.*;

public class PanelCoach extends JPanel {
    OurTable<Coach> ourTable;
    JScrollPane jsp;

    public PanelCoach(Storage storage) {
        ourTable = new OurTable<>(storage) {
            @Override
            public OurTableModel<Coach> constructModel(Storage storage) {
                return new OurTableModel<>(storage.coaches, 3) {
                    @Override
                    public Object getValueAtColumn(Coach coach, int columnIndex) {
                        switch (columnIndex) {
                            case 0:
                                return coach.raw.ID;
                            case 1:
                                return coach.raw.username;
                            case 2:
                                return coach.raw.name;
                        }
                        return "";
                    }

                    @Override
                    public void setValueAtColumn(Object aValue, Coach coach, int columnIndex) {

                    }

                    @Override
                    public String getColumnName(int columnIndex) {
                        switch (columnIndex) {
                            case 0:
                                return "ID";
                            case 1:
                                return "Username";
                            case 2:
                                return "name";
                        }
                        return "";
                    }

                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return String.class;
                    }

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return false;
                    }
                };
            }
        };
        jsp = new JScrollPane(ourTable.jtb);
        jsp.createVerticalScrollBar();
        this.add(jsp);
    }

    public static void main(String[] args) {
        new AppSkeleton(true, true, true, false, false) {

            @Override
            public JFrame bringUpGUI() {
                JFrame jf = new JFrame("test");
                java.awt.EventQueue.invokeLater(() -> {
                    jf.setSize(1000, 600);
                    jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    jf.add(new PanelCoach(storage));
                    jf.setVisible(true);
                });
                return jf;
            }
        };
    }

    public JTable getTable() {
        return ourTable.jtb;
    }
}
