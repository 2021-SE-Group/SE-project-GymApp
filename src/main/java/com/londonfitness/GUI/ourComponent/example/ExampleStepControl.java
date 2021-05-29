package com.londonfitness.GUI.ourComponent.example;

import com.londonfitness.GUI.ourComponent.form.FormGUI;
import com.londonfitness.GUI.ourComponent.form.FormItem;
import com.londonfitness.GUI.ourComponent.steps.StepControl;
import com.londonfitness.GUI.ourComponent.steps.StepGUI;
import com.londonfitness.GUI.ourComponent.steps.StepGUIGroup;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public abstract class ExampleStepControl extends StepControl {
    private ArrayList<FormItem> f1;
    private ArrayList<FormItem> f2;
    private ArrayList<FormItem> f3;

    public StepGUI<FormGUI> step1;
    public StepGUI<FormGUI> step2;
    public StepGUI<FormGUI> step3;

    public ExampleStepControl() {
        super(3);
        f1 = new ArrayList<>() {
            {
                add(new FormItem("step 1 item 1"));
                add(new FormItem("step 1 item 2"));
            }
        };
        f2 = new ArrayList<>() {
            {
                add(new FormItem("step 2 item 1"));
                add(new FormItem("step 2 item 2"));
            }
        };
        f3 = new ArrayList<>() {
            {
                add(new FormItem("step 3 item 1"));
                add(new FormItem("step 3 item 2"));
            }
        };

        step1 = new StepGUI<>(getStepStete(), new FormGUI(f1));
        step2 = new StepGUI<>(getStepStete(), new FormGUI(f2));
        step3 = new StepGUI<>(getStepStete(), new FormGUI(f3));

        setupListeners();
    }

        @Override
    public void setupListeners() {
        step1.getStepGUIGroup().getStepBar().getJbt_back()
                .addActionListener(e -> {
                    getStepStete().back();
                    updateCurrentPane();
                });

        step1.getStepGUIGroup().getStepBar().getJbt_cancel()
                .addActionListener(e -> {
                    getStepStete().cancel();
                    updateCurrentPane();
                });

        step1.getStepGUIGroup().getStepBar().getJbt_next()
                .addActionListener(e -> {
                    getStepStete().next();
                    updateCurrentPane();
                });

            step2.getStepGUIGroup().getStepBar().getJbt_back()
                    .addActionListener(e -> {
                        getStepStete().back();
                        updateCurrentPane();
                    });

            step2.getStepGUIGroup().getStepBar().getJbt_cancel()
                    .addActionListener(e -> {
                        getStepStete().cancel();
                        updateCurrentPane();
                    });

            step2.getStepGUIGroup().getStepBar().getJbt_next()
                    .addActionListener(e -> {
                        getStepStete().next();
                        updateCurrentPane();
                    });

            step3.getStepGUIGroup().getStepBar().getJbt_back()
                    .addActionListener(e -> {
                        getStepStete().back();
                        updateCurrentPane();
                    });

            step3.getStepGUIGroup().getStepBar().getJbt_cancel()
                    .addActionListener(e -> {
                        getStepStete().cancel();
                        updateCurrentPane();
                    });

            step3.getStepGUIGroup().getStepBar().getJbt_next()
                    .addActionListener(e -> {
                        getStepStete().next();
                        updateCurrentPane();
                    });
    }
}
