package com.londonfitness.GUI.ourComponent.steps;

import javax.swing.*;

public class StepBar {
    // Buttons
    private final JButton jbt_back;
    private final JButton jbt_cancel;
    private final JButton jbt_next;

    // layout group
    private final GroupLayout.Group horizontal;
    private final GroupLayout.Group vertical;

    public StepBar(StepState stepState, GroupLayout layout) {
        jbt_back = new JButton("back");
        jbt_cancel = new JButton("cancel");
        jbt_next = new JButton("next");

        horizontal = layout
                .createSequentialGroup()
                .addComponent(jbt_back)
                .addContainerGap()
                .addComponent(jbt_cancel)
                .addContainerGap()
                .addComponent(jbt_next);

        vertical = layout
                .createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(jbt_back)
                .addComponent(jbt_cancel)
                .addComponent(jbt_next);

        layout.setVerticalGroup(vertical);
        layout.setHorizontalGroup(horizontal);
    }

    public JButton getJbt_back() {
        return jbt_back;
    }

    public JButton getJbt_cancel() {
        return jbt_cancel;
    }

    public JButton getJbt_next() {
        return jbt_next;
    }

    public GroupLayout.Group getHorizontal() {
        return horizontal;
    }

    public GroupLayout.Group getVertical() {
        return vertical;
    }
}
