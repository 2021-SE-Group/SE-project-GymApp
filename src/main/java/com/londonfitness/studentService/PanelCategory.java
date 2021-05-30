package com.londonfitness.studentService;

import com.londonfitness.AppSkeleton;
import com.londonfitness.GUI.ServicFrame;
import com.londonfitness.GUI.ourComponent.tableGUI.OurTable;
import com.londonfitness.GUI.ourComponent.tableGUI.OurTableModel;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.table.Category;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class PanelCategory extends JPanel{
    JButton selectCategory;
    OurTable<Category> ourTable;

    public PanelCategory(Storage storage){
        selectCategory = new JButton("category");
        ourTable = new OurTable<>(storage) {
            @Override
            public OurTableModel<Category> constructModel(Storage storage) {
                ArrayList<Category> a = storage.categories;


                return new OurTableModel<Category>(storage.categories, 2) {
                    @Override
                    public String getColumnName(int columnIndex) {
                        if(columnIndex == 0){
                            return "ID";
                        }
                        else {
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
        this.add(this.ourTable.jtb);
        this.add(this.selectCategory);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AppSkeleton() {

            @Override
            public void bringUpGUI() {
                java.awt.EventQueue.invokeLater(() -> {
                    JFrame jf = new JFrame("test");
                    jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    jf.add(new PanelCategory(this.getStorage()));
                    jf.setVisible(true);
                });
            }
        };
    }
}
