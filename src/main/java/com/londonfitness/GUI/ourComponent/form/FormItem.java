package com.londonfitness.GUI.ourComponent.form;

public class FormItem {
    public String label;
    public String content;

    public FormItem(String label) {
        this(label, "");
    }

    public FormItem(String label, String content) {
        this.label = label;
        this.content = content;
    }
}
