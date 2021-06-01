package com.londonfitness.GUI.traineeService;

import com.londonfitness.GUI.ourComponent.steps.StepGUI;

import javax.swing.*;
import java.awt.*;

public class BookingFrame extends JFrame {

    public BookingFrame(StepGUI<PanelCategory> panelCategoryStepGUI, StepGUI<PanelClass> panelClassStepGUI, StepGUI<PanelCoach> panelCoachStepGUI, StepGUI<PanelTraineeInfo> panelTraineeInfoStepGUI, StepGUI<JPanel> conclusionStepGUI) {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new CardLayout());
        add(panelCategoryStepGUI);
        add(panelClassStepGUI);
        add(panelCoachStepGUI);
        add(panelTraineeInfoStepGUI);
        add(conclusionStepGUI);
    }

    public static void main(String[] args) {
        /*
        AppSkeleton appSkeleton = new AppSkeleton(true, true, true, true, false) {
            @Override
            public JFrame bringUpGUI() {
                return new BookingFrame();
            }
        };

         */
    }
}
