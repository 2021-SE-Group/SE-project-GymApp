package com.londonfitness.GUI.ourComponent.example;

import javax.swing.*;
import java.awt.*;

public class ExampleStepApplication {

    public static void main(String[] args) {
        JFrame jf = new JFrame("test");
        jf.setLayout(new CardLayout());

        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ExampleStepControl example = new ExampleStepControl() {
            @Override
            public void updateCurrentPane() {
                if(getStepStete().isCanceled()) {
                    jf.dispose();
                } else if(getStepStete().isFinished()){
                    jf.dispose();
                    // do something, up to you
                } else {
                    switch (getStepStete().getLocation()) {
                        case 0:
                            step1.setVisible(true);
                            step2.setVisible(false);
                            step3.setVisible(false);
                            break;
                        case 1:
                            step1.setVisible(false);
                            step2.setVisible(true);
                            step3.setVisible(false);
                            break;
                        case 2:
                            step1.setVisible(false);
                            step2.setVisible(false);
                            step3.setVisible(true);
                            break;
                            /*
                        default:
                            step1.setVisible(false);
                            step2.setVisible(false);
                            step3.setVisible(false);
                            break;

                             */
                    }
                }

            }
        };

        jf.add(example.step1);
        jf.add(example.step2);
        jf.add(example.step3);
        example.updateCurrentPane();

        jf.setVisible(true);
    }
}
