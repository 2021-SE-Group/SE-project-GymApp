package com.londonfitness.GUI.traineeService;

import com.londonfitness.GUI.ourComponent.form.FormGUI;
import com.londonfitness.GUI.ourComponent.form.FormItem;
import com.londonfitness.OurDateFormat;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class PanelTraineeInfo extends FormGUI {
    public PanelTraineeInfo() {
        super(new ArrayList<>() {
            {
                add(new FormItem("Your ID "));
                add(new FormItem("Start at "));
                add(new FormItem("times "));
                add(new FormItem("class interval(days) "));
            }
        });
    }
    public String getID() {
        return getItems().get(0).content;
    }
    public Date getStartDate() {
        try {
            return OurDateFormat.fancyDate.parse(getItems().get(1).content);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public int getTimes() {
        return Integer.parseInt(getItems().get(2).content);
    }
    public long getRepeat() {
        return 60L * 60 * 24 * 1000 * Integer.parseInt(getItems().get(3).content);
    }
}
