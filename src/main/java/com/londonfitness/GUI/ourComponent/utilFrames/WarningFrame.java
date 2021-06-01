package com.londonfitness.GUI.ourComponent.utilFrames;

import javax.swing.*;
import java.awt.*;

public class WarningFrame extends JFrame {
    private final JButton jbt;

    public WarningFrame(String warn, int width, int height) {
        super("warning");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel jp = new JPanel();

        GroupLayout layout = new GroupLayout(jp);
        jp.setLayout(layout);

        JLabel jlb = new JLabel(warn);
        jbt = new JButton("confirm");
        jbt.addActionListener((e) -> dispose());

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(jlb)
                        .addComponent(jbt));
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(jlb)
                        .addContainerGap(20, 50)
                        .addComponent(jbt));
        jp.setVisible(true);

        this.setSize(width, height);

        this.setLayout(new FlowLayout());
        this.add(jp);
    }

    public WarningFrame(String warn) {
        this(warn, 300, 150);
    }

    public static void main(String[] args) {
        JFrame jf = new WarningFrame("give a warning.");
        jf.setVisible(true);
    }

    public JButton getJbt() {
        return jbt;
    }
}
