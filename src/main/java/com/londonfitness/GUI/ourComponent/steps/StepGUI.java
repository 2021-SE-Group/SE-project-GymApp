package com.londonfitness.GUI.ourComponent.steps;

import com.londonfitness.GUI.ourComponent.form.FormGUI;
import com.londonfitness.GUI.ourComponent.form.FormItem;

import javax.swing.*;
import java.util.ArrayList;

public class StepGUI<JP extends JPanel> extends JPanel {
    private GroupLayout layout;
    private StepGUIGroup<JP> stepGUIGroup;

    public StepGUI(StepState stepState, JP jp) {
        layout = new GroupLayout(this);
        setLayout(layout);

        stepGUIGroup = new StepGUIGroup<>(layout, stepState, jp);
        layout.setHorizontalGroup(stepGUIGroup.getHorizontal());
        layout.setVerticalGroup(stepGUIGroup.getVertical());
    }

    public StepGUIGroup<JP> getStepGUIGroup() {
        return stepGUIGroup;
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame("test");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jf.add(new StepGUI<>(new StepState(3), new JPanel()));

        jf.setVisible(true);
    }
}
