package com.londonfitness.GUI.ourComponent.steps;

public abstract class StepControl {
    private final StepState stepState;

    //private boolean hasSetStepState = false;

    /**
     * you will need to new StepState by yourself
     */
    public StepControl(int maxStep) {
        stepState = new StepState(maxStep);
        //hasSetStepState = true;
    }

    protected StepState getStepStete() {
        return stepState;
    }

    /**
     * remember to use it in your constructor
     */
    public abstract void setupListeners();

    public abstract void updateCurrentPane();
}
