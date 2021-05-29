package com.londonfitness.GUI.ourComponent.steps;

import javax.swing.*;

public abstract class StepControl {
    private StepState stepState;

    //private boolean hasSetStepState = false;

    /** you will need to new StepState by yourself
     */
    public StepControl(int maxStep) {
        stepState = new StepState(maxStep);
        //hasSetStepState = true;
    }

    protected StepState getStepStete() {
        return stepState;
    }

    /** remember to use it in your constructor
     *
     */
    public abstract void setupListeners();
    public abstract void updateCurrentPane();

    public static void main(String[] args) {
        JFrame jf = new JFrame("test");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GroupLayout layout = new GroupLayout(jf.getContentPane());
        jf.setLayout(layout);

        StepControl testStepControl = new StepControl(3) {
            @Override
            public void setupListeners() {

            }

            @Override
            public void updateCurrentPane() {

            }
        };
    }
}
