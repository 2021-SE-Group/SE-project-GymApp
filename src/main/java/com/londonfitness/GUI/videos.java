package com.londonfitness.GUI;



import com.londonfitness.simDAO.memStorage.Storage;

import javax.swing.*;
import java.awt.*;

public class videos extends JPanel {
    Storage storage;
    public videos(Storage storage) {
        this.storage = storage;
        this.initComponent();
        this.setVisible(true);
    }
    private void initComponent() {
        GroupLayout gl_panel = new GroupLayout(this);
        JLabel lblNewLabel = new JLabel("Available videos");
        JTextPane txtpnIfYouHave = new JTextPane();
        JButton btnBookedVideos = new JButton("Booked videos");
        JTextPane txtpnIfYouAre = new JTextPane();
        JButton btnNewButton = new JButton("Some free videos");

        gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(gl_panel.createParallelGroup()
                        .addComponent(lblNewLabel)
                        .addComponent(txtpnIfYouHave)
                        .addComponent(btnBookedVideos)
                        .addComponent(txtpnIfYouAre)
                        .addComponent(btnNewButton)
                )
        );
        gl_panel.setVerticalGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel)
                        .addComponent(lblNewLabel)
                        .addComponent(txtpnIfYouHave)
                        .addComponent(btnBookedVideos)
                        .addComponent(txtpnIfYouAre)
                        .addComponent(btnNewButton)
        );


        lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));


        txtpnIfYouHave.setText("If you have booked some videos, watch your exclusive videos");
        txtpnIfYouHave.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 10));
        //txtpnIfYouHave.setBackground(Color.ORANGE);


        btnBookedVideos.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));


        txtpnIfYouAre.setText("If you are new here, watch some free videos to get familiar with us");
        txtpnIfYouAre.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 10));
        //txtpnIfYouAre.setBackground(Color.ORANGE);


        btnNewButton.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 15));


        this.setLayout(gl_panel);

    }
}