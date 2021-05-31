package com.londonfitness.studentService;

import com.londonfitness.AppSkeleton;
import com.londonfitness.GUI.JScrollPane_CoachTable;
import com.londonfitness.GUI.ourComponent.tableGUI.OurTable;
import com.londonfitness.GUI.ourComponent.tableGUI.OurTableModel;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.table.Category;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class PanelCategory extends JPanel{
    private JButton selectCategory;
    private OurTable<Category> ourTable;
    private JScrollPane jScrollPane;

    public PanelCategory(Storage storage){
        selectCategory = new JButton("category");
        selectCategory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        ourTable = new OurTable<>(storage) {
            @Override
            public OurTableModel<Category> constructModel(Storage storage) {
                ArrayList<Category> a = storage.categories;


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
        jScrollPane = new JScrollPane(ourTable.jtb);
        jScrollPane.createHorizontalScrollBar();
        jScrollPane.createVerticalScrollBar();
        this.add(this.jScrollPane);
        this.add(this.selectCategory);
    }

    public JButton getSelectCategory() {
        return selectCategory;
    }

    public JTable getTable() {
        return ourTable.jtb;
    }

    public static void main(String[] args) {
        new AppSkeleton(true, true, true, false, false) {

            @Override
            public JFrame bringUpGUI() {
                JFrame jf = new JFrame("test");

                jf.setSize(1000, 600);

                java.awt.EventQueue.invokeLater(() -> {
                    jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    jf.setLayout(null);
                    PanelCategory pc = new PanelCategory(this.getStorage());
                    jf.setContentPane(pc);
                    jf.setVisible(true);
                });
                return jf;
            }
        };
    }
}
