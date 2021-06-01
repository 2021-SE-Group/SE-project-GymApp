package com.londonfitness.GUI.ourComponent.steps;

import javax.swing.*;

/**
 * Provide a specialized JPanel with a step bar
 *
 * @param <JP>
 */
public class StepGUIGroup<JP extends JPanel> {
    private final JP jp;

    private final StepBar stepBar;
    private final GroupLayout.Group horizontal;
    private final GroupLayout.Group vertical;


    public StepGUIGroup(GroupLayout layout, StepState stepState, JP jp) {
        this.jp = jp;

        stepBar = new StepBar(stepState, layout);
        horizontal = layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(jp)
                .addGroup(stepBar.getHorizontal());
        vertical = layout.createSequentialGroup()
                .addComponent(jp)
                .addGroup(stepBar.getVertical());
    }

    public GroupLayout.Group getVertical() {
        return vertical;
    }

    public GroupLayout.Group getHorizontal() {
        return horizontal;
    }

    public JP getPanel() {
        return jp;
    }

    public StepBar getStepBar() {
        return stepBar;
    }
}
