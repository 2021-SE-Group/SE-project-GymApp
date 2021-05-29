package com.londonfitness.GUI.ourComponent.form;

import com.londonfitness.simDAO.rawTable.rawPersons.RawTrainee;
import com.londonfitness.simDAO.table.persons.Trainee;

import javax.swing.*;
import java.util.ArrayList;

public class FormGUI extends JPanel {
    private GroupLayout layout;
    private ArrayList<FormItem> items;

    private ArrayList<JLabel> labels;
    private ArrayList<JTextField> textFields;
    private GroupLayout.Group horizontal;
    private GroupLayout.Group vertical;

    public FormGUI(ArrayList<FormItem> items) {
        this.items = items;

        layout = new GroupLayout(this);
        this.setLayout(layout);

        labels = new ArrayList<>();
        textFields = new ArrayList<>();
        horizontal = layout.createSequentialGroup();
        vertical = layout.createSequentialGroup();

        GroupLayout.ParallelGroup paraGroupLabel = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
        GroupLayout.ParallelGroup paraGroupContent = layout.createParallelGroup(GroupLayout.Alignment.LEADING);

        JLabel tempLabel;
        JTextField tempTextField;
        for(FormItem item: items) {
            tempLabel = new JLabel(item.label);
            tempTextField = new JTextField(item.content);

            labels.add(tempLabel);
            textFields.add(tempTextField);

            paraGroupLabel = paraGroupLabel.addComponent(tempLabel);
            paraGroupContent = paraGroupContent.addComponent(tempTextField);

            vertical = vertical.addGroup(
                    layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(tempLabel)
                    .addComponent(tempTextField)
            );
        }

        horizontal = horizontal
                .addGroup(paraGroupLabel)
                .addGroup(paraGroupContent);

        layout.setHorizontalGroup(horizontal);
        layout.setVerticalGroup(vertical);
    }

    public void retrieve() {
        for(int i = 0; i < items.size(); i++) {
            items.get(i).content = textFields.get(i).getText();
        }
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame("test");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ArrayList<FormItem> form = new ArrayList<>() {
            {
                add(new FormItem("step 1 item 1"));
                add(new FormItem("step 1 item 2"));
            }
        };

        jf.add(new FormGUI(form));
        jf.setVisible(true);
    }


}
