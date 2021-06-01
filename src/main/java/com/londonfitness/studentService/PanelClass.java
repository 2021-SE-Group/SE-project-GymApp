package com.londonfitness.studentService;

import com.londonfitness.AppSkeleton;
import com.londonfitness.GUI.ourComponent.tableGUI.OurTable;
import com.londonfitness.GUI.ourComponent.tableGUI.OurTableModel;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.table.Category;
import com.londonfitness.simDAO.table.LFClass;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;


public class PanelClass extends JPanel{
    JButton selectClass;
    OurTable<LFClass> ourTable;
    Category category;
    Storage storage;
    ArrayList<LFClass> classes;
    JScrollPane jScrollPane;

    public PanelClass(Storage storage, Category category){
        this.storage = storage;
        selectClass = new JButton("class select");
        classes = new ArrayList<>();
        this.category = category;

        for (Iterator<LFClass> it = category.index_lfClass.getTnIter(); it.hasNext();) {
            classes.add(it.next());
        }
        ourTable = new OurTable<>(storage) {
            @Override
            public OurTableModel<LFClass> constructModel(Storage storage) {
                return new OurTableModel<>(classes, 3) {
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
                    public Object getValueAtColumn(LFClass lfClass, int columnIndex) {
                        switch (columnIndex){
                            case 0:
                                return lfClass.externKey_category.raw.name;
                            case 1:
                                return lfClass.raw.ID;
                            case 2:
                                return lfClass.raw.coach_ID;
                            default:
                                return "";
                        }
                    }

                    @Override
                    public void setValueAtColumn(Object aValue, LFClass lfClass, int columnIndex) {

                    }
                };
            }
        };
        jScrollPane = new JScrollPane(ourTable.jtb);
        jScrollPane.createHorizontalScrollBar();
        jScrollPane.createVerticalScrollBar();
        selectClass.addActionListener(e -> {
            if (ourTable.jtb.getSelectedRow() < 0) {
                JFrame jff = new JFrame("warning");
                JPanel jpn = new JPanel();
                jff.setSize(200, 120);


                GroupLayout groupLayout = new GroupLayout(jpn);
                jpn.setLayout(groupLayout);
                groupLayout.setAutoCreateGaps(true);
                groupLayout.setAutoCreateContainerGaps(true);

                JLabel jb = new JLabel("You should select 1 course.");
                JButton jbt = new JButton("cancel");
                jbt.addActionListener((event) -> {
                    jff.dispose();
                });

                GroupLayout.Group horizontal = groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(jb).addComponent(jbt);
                GroupLayout.Group vertical = groupLayout.createSequentialGroup().addComponent(jb).addComponent(jbt);
                groupLayout.setHorizontalGroup(horizontal);
                groupLayout.setVerticalGroup(vertical);
                jff.setContentPane(jpn);

                java.awt.EventQueue.invokeLater(() -> jff.setVisible(true));

            } else {
                System.out.println(
                        classes.get(
                                ourTable.jtb.getSelectedRow()
                        ).raw);
            }
        });

        this.add(this.ourTable.jtb);
        this.add(this.selectClass);
    }

    public JButton getSelectClass() {
        return selectClass;
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
                    PanelClass pc = new PanelClass(this.getStorage(), this.getStorage().categories.get(4));
                    jf.setContentPane(pc);
                    jf.setVisible(true);
                });
                return jf;
            }
        };
    }
}
