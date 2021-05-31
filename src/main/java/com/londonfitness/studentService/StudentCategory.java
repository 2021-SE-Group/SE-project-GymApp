package com.londonfitness.studentService;

import com.londonfitness.GUI.ourComponent.steps.StepControl;
import com.londonfitness.GUI.ourComponent.steps.StepGUI;
import com.londonfitness.GUI.ourComponent.steps.StepState;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.table.Category;
import com.londonfitness.simDAO.table.LFClass;

import javax.swing.*;

public class StudentCategory extends StepControl {
    Storage storage;
    Category currentCategory;
    LFClass currentLFClass;

    StepGUI<PanelCategory> panelCategoryStepGUI;
    StepGUI<PanelClass> panelClassStepGUI;
    StepGUI<JPanel> conclusionStepGUI;

    JFrame jf;

    /**
     * you will need to new StepState by yourself
     *
     * @param storage
     */
    public StudentCategory(Storage storage, JFrame jf) {
        super(3);
        this.storage = storage;
        this.jf = jf;
        panelCategoryStepGUI = new StepGUI<>(this.getStepStete(), new PanelCategory(storage));
        setupListeners();
    }

    @Override
    public void setupListeners() {
        //panelCategoryStepGUI
        panelCategoryStepGUI.getStepGUIGroup().getPanel().getSelectCategory().addActionListener((event)->{
            if (panelCategoryStepGUI.getStepGUIGroup().getPanel().getTable().getSelectedRow() < 0) {
                JFrame jff = new JFrame("warning");
                JPanel jpn = new JPanel();
                jff.setSize(200, 120);


                GroupLayout groupLayout = new GroupLayout(jpn);
                jpn.setLayout(groupLayout);
                groupLayout.setAutoCreateGaps(true);
                groupLayout.setAutoCreateContainerGaps(true);

                JLabel jb = new JLabel("You should select 1 course.");
                JButton jbt = new JButton("cancel");
                jbt.addActionListener((event1) -> {
                    jff.dispose();
                });

                GroupLayout.Group horizontal = groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(jb).addComponent(jbt);
                GroupLayout.Group vertical = groupLayout.createSequentialGroup().addComponent(jb).addComponent(jbt);
                groupLayout.setHorizontalGroup(horizontal);
                groupLayout.setVerticalGroup(vertical);
                jff.setContentPane(jpn);

                java.awt.EventQueue.invokeLater(() -> jff.setVisible(true));

            } else {
                this.currentCategory = storage.categories.get(
                        panelCategoryStepGUI.getStepGUIGroup().getPanel().getTable().getSelectedRow());
                java.awt.EventQueue.invokeLater(()->{
                    panelClassStepGUI = new StepGUI<>(getStepStete(), new PanelClass(storage, currentCategory));
                    panelClassStepGUI.getStepGUIGroup().getPanel().getSelectClass().addActionListener((event2)->{
                        JPanel conclusion = new JPanel();
                        conclusion.add(new JLabel("Category is:\n" + currentCategory.raw + ",\nclass is:\n" + currentLFClass));
                        conclusionStepGUI = new StepGUI<>(getStepStete(), conclusion);
                    });
                });
            }
        });



    }

    @Override
    public void updateCurrentPane() {
        if(getStepStete().isCanceled() || getStepStete().isFinished()) {
            jf.dispose();
        } else {
            switch (getStepStete().getLocation()){
                case 0:
                    panelCategoryStepGUI.setVisible(true);
                    break;
                case 1:
                    panelCategoryStepGUI.setVisible(false);
                    panelClassStepGUI.setVisible(true);
                    break;
                case 2:
                    panelClassStepGUI.setVisible(false);
                    panelCategoryStepGUI.setVisible(false);
                    conclusionStepGUI.setVisible(true);
                    break;
            }
        }
    }

    public static void main(){

    }
}



