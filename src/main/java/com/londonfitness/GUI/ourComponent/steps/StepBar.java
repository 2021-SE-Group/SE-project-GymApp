package com.londonfitness.GUI.ourComponent.steps;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StepBar {
    private StepState stepState;
    private GroupLayout layout;

    // Buttons
    private JButton jbt_back;
    private JButton jbt_cancel;
    private JButton jbt_next;

    // layout group
    private GroupLayout.Group horizontal;
    private GroupLayout.Group vertical;

    public StepBar(GroupLayout layout, StepState stepState) {
        this.stepState = stepState;
        this.layout = layout;

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

        // You can modify it to setup listeners here
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
