package com.londonfitness.GUI.ourComponent.step;

import javax.swing.*;
import java.awt.*;

public class StepBar{
    private JButton jbt_next;
    private JButton jbt_cancel;
    private JButton jbt_prev;

    private GroupLayout.Group horizontal;
    private GroupLayout.Group vertical;

    public StepBar(GroupLayout layout) {
        jbt_prev = new JButton("previous");
        jbt_cancel = new JButton("cancel");
        jbt_next = new JButton("next");

        horizontal = layout.createSequentialGroup();
        vertical = layout.createParallelGroup();

        horizontal.addComponent(jbt_prev).addComponent(jbt_cancel).addComponent(jbt_next);
        vertical.addComponent(jbt_prev).addComponent(jbt_cancel).addComponent(jbt_next);
    }

    public GroupLayout.Group getHorizontalGroup() {
        return horizontal;
    }

    public GroupLayout.Group getVerticalGroup() {
        return vertical;
    }

    public JButton getPrev() {
        return this.jbt_prev;
    }
    public JButton getCancel() {
        return this.jbt_cancel;
    }
    public JButton getNext() {
        return this.jbt_next;
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame("test");
        GroupLayout layout = new GroupLayout(jf.getContentPane());
        jf.getContentPane().setLayout(layout);
        StepBar sb = new StepBar(layout);

        layout.setHorizontalGroup(sb.getHorizontalGroup());
        layout.setVerticalGroup(sb.getVerticalGroup());

        jf.setVisible(true);
    }
}
