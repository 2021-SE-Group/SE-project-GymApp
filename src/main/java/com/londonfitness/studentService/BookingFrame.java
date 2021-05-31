package com.londonfitness.studentService;

import com.londonfitness.AppSkeleton;
import com.londonfitness.simDAO.memStorage.Storage;

import javax.swing.*;
import java.awt.*;

public class BookingFrame extends JFrame {
    StudentCategory studentCategory;
    public BookingFrame(Storage storage) {
        setLayout(new CardLayout());
        studentCategory = new StudentCategory(storage, this);
    }

    public static void main(String[] args) {
        AppSkeleton appSkeleton = new AppSkeleton(true, true, true, false, false) {
            @Override
            public JFrame bringUpGUI() {
                return new BookingFrame(this.getStorage());
            }
        };
    }
}
