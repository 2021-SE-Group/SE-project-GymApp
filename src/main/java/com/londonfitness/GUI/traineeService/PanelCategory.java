package com.londonfitness.GUI.traineeService;

import com.londonfitness.AppSkeleton;
import com.londonfitness.GUI.ourComponent.tableGUI.OurTable;
import com.londonfitness.GUI.ourComponent.tableGUI.OurTableModel;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.table.Category;

import javax.swing.*;
import java.util.ArrayList;


public class PanelCategory extends JPanel{
    OurTable<Category> ourTable;
    JScrollPane jsp;

    public PanelCategory(Storage storage){
        ourTable = new OurTable<>(storage) {
            @Override
            public OurTableModel<Category> constructModel(Storage storage) {
                return new OurTableModel<>(storage.categories, 2) {
                    @Override
                    public String getColumnName(int columnIndex) {
                        if (columnIndex == 0) {
                            return "ID";
                        } else {
                            return "Category";
                        }
                    }

                    @Override
                    public Class<?> getColumnClass(int columnIndex) {
                        return String.class;
                    }

                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return false;
                    }

                    @Override
                    public Object getValueAtColumn(Category category, int columnIndex) {
                        if (columnIndex == 0) {
                            return category.raw.ID;
                        } else {
                            return category.raw.name;
                        }
                    }

                    @Override
                    public void setValueAtColumn(Object aValue, Category category, int columnIndex) {
                        if (columnIndex == 0) {
                            category.raw.ID = (String) aValue;
                        } else {
                            category.raw.name = (String) aValue;
                        }
                    }
                };
            }
        };
        jsp = new JScrollPane(ourTable.jtb);
        jsp.createVerticalScrollBar();
        this.add(jsp);
    }

    public JTable getTable() {
        return ourTable.jtb;
    }

    public static void main(String[] args) {
        new AppSkeleton(true, true, true, false, false) {

            @Override
            public JFrame bringUpGUI() {
                JFrame jf = new JFrame("test");
                java.awt.EventQueue.invokeLater(() -> {
                    jf.setSize(1000, 600);
                    jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    jf.add(new PanelCategory(this.getStorage()));
                    jf.setVisible(true);
                });
                return jf;
            }
        };
    }
}
