package com.londonfitness.GUI.traineeService;

import com.londonfitness.AppSkeleton;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.rawTable.RawBooking;
import com.londonfitness.simDAO.table.Booking;

import javax.swing.*;
import java.awt.*;
import java.text.Format;
import java.util.Formatter;

public class BookingFrame extends JFrame {
    TraineeAddBooking studentAddBooking;
    public BookingFrame(Storage storage, Booking newBooking) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setLayout(new CardLayout());

        EventQueue.invokeLater(() -> {
            studentAddBooking = new TraineeAddBooking(storage, newBooking.raw) {
                @Override
                public void updateCurrentPane() {
                    if(getStepStete().isCanceled()) {
                        dispose();
                    } else if(getStepStete().isFinished()) {
                        EventQueue.invokeLater(() -> {
                            newBooking.insert(storage);
                            System.out.println("insert " + newBooking.raw);
                        });

                        dispose();
                    } else {
                        switch (getStepStete().getLocation()) {
                            case 0:
                                getPanelCategoryStepGUI().setVisible(true);
                                getPanelClassStepGUI().setVisible(false);
                                getPanelCoachStepGUI().setVisible(false);
                                getPanelTraineeInfoStepGUI().setVisible(false);
                                getConclusionStepGUI().setVisible(false);
                                break;
                            case 1:
                                getPanelCategoryStepGUI().setVisible(false);
                                getPanelClassStepGUI().setVisible(true);
                                getPanelCoachStepGUI().setVisible(false);
                                getPanelTraineeInfoStepGUI().setVisible(false);
                                getConclusionStepGUI().setVisible(false);
                                break;
                            case 2:
                                getPanelCategoryStepGUI().setVisible(false);
                                getPanelClassStepGUI().setVisible(false);
                                getPanelCoachStepGUI().setVisible(true);
                                getPanelTraineeInfoStepGUI().setVisible(false);
                                getConclusionStepGUI().setVisible(false);
                                break;
                            case 3:
                                getPanelCategoryStepGUI().setVisible(false);
                                getPanelClassStepGUI().setVisible(false);
                                getPanelCoachStepGUI().setVisible(false);
                                getPanelTraineeInfoStepGUI().setVisible(true);
                                getConclusionStepGUI().setVisible(false);
                                break;
                            case 4:
                                getPanelCategoryStepGUI().setVisible(false);
                                getPanelClassStepGUI().setVisible(false);
                                getPanelCoachStepGUI().setVisible(false);
                                getPanelTraineeInfoStepGUI().setVisible(false);
                                getConclusionStepGUI().setVisible(true);
                                break;
                        }
                    }
                }
            };
            add(studentAddBooking.getPanelCategoryStepGUI());
            add(studentAddBooking.getPanelClassStepGUI());
            add(studentAddBooking.getPanelCoachStepGUI());
            add(studentAddBooking.getPanelTraineeInfoStepGUI());
            add(studentAddBooking.getConclusionStepGUI());
        });
    }

    public static void main(String[] args) {
        AppSkeleton appSkeleton = new AppSkeleton(true, true, true, true, false) {
            @Override
            public JFrame bringUpGUI() {
                return new BookingFrame(this.getStorage(), new Booking(new RawBooking()));
            }
        };
    }
}
