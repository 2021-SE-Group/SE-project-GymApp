package com.londonfitness.GUI.ourComponent.steps;

import javax.swing.*;
import java.awt.*;

public class StepGUI<JP extends JPanel> extends JPanel {
    private final GroupLayout layout;
    private final StepGUIGroup<JP> stepGUIGroup;

    public StepGUI(StepState stepState, JP jp) {
        layout = new GroupLayout(this);
        setLayout(layout);

        stepGUIGroup = new StepGUIGroup<>(layout, stepState, jp);
        layout.setHorizontalGroup(stepGUIGroup.getHorizontal());
        layout.setVerticalGroup(stepGUIGroup.getVertical());
        layout.preferredLayoutSize(this);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame("test");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setExtendedState(Frame.MAXIMIZED_BOTH);

        jf.add(new StepGUI<>(new StepState(3), new JPanel()));

        jf.setVisible(true);
    }

    public StepGUIGroup<JP> getStepGUIGroup() {
        return stepGUIGroup;
    }
}
