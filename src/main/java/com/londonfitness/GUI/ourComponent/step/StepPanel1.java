package com.londonfitness.GUI.ourComponent.step;

import javax.swing.*;

public class StepPanel1 extends JPanel {
    private StepState ss;

    private JLabel jl = new JLabel("1");
    private StepBar sb;

    private GroupLayout.Group horizontal;
    private GroupLayout.Group vertical;

    public StepPanel1(StepState ss){
        this.ss = ss;

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);

        sb = new StepBar(layout);

        horizontal = layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(jl)
                .addGroup(sb.getHorizontalGroup());

        vertical = layout.createSequentialGroup()
                .addComponent(jl)
                .addGroup(sb.getVerticalGroup());

        layout.setHorizontalGroup(horizontal);
        layout.setVerticalGroup(vertical);

        this.add(jl);
        this.setVisible(false);
    }

    public StepBar getStepBar() {
        return this.sb;
    }
}
