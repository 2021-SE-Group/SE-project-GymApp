package com.londonfitness.GUI.ourComponent.steps;

/**
 * -1 is exit, 0 is the first step, n - 1 is the last step, n is finish
 */
public class StepState {
    private final int max;
    private int location;
    private ERRFlag errFlag;

    public StepState(int max, int initial) {
        this.max = max;
        location = initial;
        errFlag = ERRFlag.fine;
    }

    public StepState(int max) {
        this(max, 0);
    }

    public void next() {
        if (location < max) {
            location++;
        } else {
            errFlag = ERRFlag.nextExceed;
        }
    }

    public void back() {
        if (location >= 0) {
            location--;
        } else {
            errFlag = ERRFlag.backExceed;
        }

    }

    public void cancel() {
        location = -1;
    }

    public boolean isCanceled() {
        return location < 0;
    }

    public boolean isFinished() {
        return location >= max;
    }

    public ERRFlag getErrFlag() {
        return errFlag;
    }

    public int getLocation() {
        return location;
    }

    public enum ERRFlag {
        fine, nextExceed, backExceed
    }
}
