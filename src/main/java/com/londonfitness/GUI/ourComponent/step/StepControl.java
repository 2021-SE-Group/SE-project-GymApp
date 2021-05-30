package com.londonfitness.GUI.ourComponent.step;

import com.londonfitness.GUI.STALL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StepControl extends JPanel{
    // JPanel navigation;
    // GUI
    private StepPanel1 sp1;
    private StepPanel2 sp2;
    private StepPanel3 sp3;

    // control state
    private StepState ss;

    public StepControl(){
        ss = new StepState();

        sp1 = new StepPanel1(ss);
        sp2 = new StepPanel2(ss);
        sp3 = new StepPanel3(ss);

        this.add(sp1);
        this.add(sp2);
        this.add(sp3);

        ss.location = 1;
        updateGUI();



        sp1.getStepBar().getNext().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ss.location++;
                updateGUI();
            }
        });
        sp2.getStepBar().getNext().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ss.location++;
                updateGUI();
            }
        });
        sp3.getStepBar().getNext().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ss.location++;
                updateGUI();
            }
        });
    }

    public void updateGUI() {
        sp1.setVisible(false);
        sp2.setVisible(false);
        sp3.setVisible(false);

        switch (ss.location) {
            case 1:
                sp1.setVisible(true);
                break;
            case 2:
                sp2.setVisible(true);
                break;
            case 3:
                sp3.setVisible(true);
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame("test");
        jf.add(new StepControl());
        jf.setVisible(true);
    }
}
