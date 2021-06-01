package com.londonfitness.GUI.traineeService;

import com.londonfitness.AppSkeleton;
import com.londonfitness.GUI.ourComponent.tableGUI.OurTable;
import com.londonfitness.GUI.ourComponent.tableGUI.OurTableModel;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.table.Category;
import com.londonfitness.simDAO.table.LFClass;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;


public class PanelClass extends JPanel {
    private OurTable<LFClass> ourTable;
    private JScrollPane jScrollPane;

    private Category category;
    private Storage storage;

    private ArrayList<LFClass> classes;

    public PanelClass(Storage storage) {
        this.storage = storage;
        this.category = null;

        resetData(category);

        ourTable = new OurTable<>(storage) {
            @Override
            public OurTableModel<LFClass> constructModel(Storage storage) {
                return renewJTableModel();
            }
        };
        jScrollPane = new JScrollPane(ourTable.jtb);
        jScrollPane.createHorizontalScrollBar();
        jScrollPane.createVerticalScrollBar();

        this.add(jScrollPane);
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
                    PanelClass pc = new PanelClass(this.getStorage());
                    pc.resetCategoryAndRefresh(storage.categories.get(4));
                    jf.setContentPane(pc);
                    jf.setVisible(true);
                });
                return jf;
            }
        };
    }

    private OurTableModel<LFClass> renewJTableModel() {
        return new OurTableModel<>(classes, 5) {
            @Override
            public String getColumnName(int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return "Category";
                    case 1:
                        return "Class ID";
                    case 2:
                        return "Class Name";
                    case 3:
                        return "Price";
                    case 4:
                        return "Duration";
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
            @Override
            public Object getValueAtColumn(LFClass lfClass, int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return lfClass.externKey_category.raw.name;
                    case 1:
                        return lfClass.raw.ID;
                    case 2:
                        return lfClass.raw.name;
                    case 3:
                        return lfClass.raw.price.toString();
                    case 4:
                        return lfClass.raw.duration / 1000 / 60 + "min";
                    default:
                        return "";
                }
            }
            @Override
            public void setValueAtColumn(Object aValue, LFClass lfClass, int columnIndex) { }
        };
    }

    private void resetData(Category category) {
        this.category = category;
        if (category == null) {
            classes = storage.lfClasses;
        } else {
            classes = new ArrayList<>();
            for (Iterator<LFClass> it = category.index_lfClass.getTnIter(); it.hasNext(); ) {
                classes.add(it.next());
            }
        }
    }

    public void resetCategoryAndRefresh(Category category) {
        resetData(category);
        getTable().setModel(renewJTableModel());
    }

    public JTable getTable() {
        return ourTable.jtb;
    }

    public ArrayList<LFClass> getClasses() {
        return classes;
    }
}
