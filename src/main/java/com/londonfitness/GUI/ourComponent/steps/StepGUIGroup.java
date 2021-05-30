package com.londonfitness.GUI.ourComponent.steps;

import javax.swing.*;

/** Provide a specialized JPanel with a step bar
 *
 * @param <JP>
 */
public class StepGUIGroup<JP extends JPanel> {
    private GroupLayout layout;
    private StepState stepState;
    private JP jp;

    private StepBar stepBar;
    private GroupLayout.Group horizontal;
    private GroupLayout.Group vertical;


    public StepGUIGroup(GroupLayout layout, StepState stepState, JP jp) {
        this.layout = layout;
        this.stepState = stepState;
        this.jp = jp;

        stepBar = new StepBar(layout, stepState);
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