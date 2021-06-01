package com.londonfitness.GUI.traineeService;

import com.londonfitness.GUI.ourComponent.steps.StepBar;
import com.londonfitness.GUI.ourComponent.steps.StepControl;
import com.londonfitness.GUI.ourComponent.steps.StepGUI;
import com.londonfitness.GUI.ourComponent.utilFrames.WarningFrame;
import com.londonfitness.OurDateFormat;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.rawTable.RawBooking;
import com.londonfitness.simDAO.table.Category;
import com.londonfitness.simDAO.table.LFClass;
import com.londonfitness.simDAO.table.persons.Coach;

import javax.swing.*;

public abstract class TraineeAddBooking extends StepControl {
    private Storage storage;

    private Category currentCategory;
    private LFClass currentLFClass;
    private Coach currentCoach;

    private RawBooking blancRawBooking;

    private StepGUI<PanelCategory> panelCategoryStepGUI;
    private StepGUI<PanelClass> panelClassStepGUI;
    private StepGUI<PanelCoach> panelCoachStepGUI;
    private StepGUI<PanelTraineeInfo> panelTraineeInfoStepGUI;

    private StepGUI<JPanel> conclusionStepGUI;

    private JTextArea jta_conclusion;

    /**
     * you will need to new StepState by yourself
     *
     * @param storage
     */
    public TraineeAddBooking(Storage storage, RawBooking blancRawBooking) {
        super(5);
        this.storage = storage;
        this.blancRawBooking = blancRawBooking;

        jta_conclusion = new JTextArea();

        panelCategoryStepGUI = new StepGUI<>(getStepStete(), new PanelCategory(storage));
        panelClassStepGUI = new StepGUI<>(getStepStete(), new PanelClass(storage));
        panelCoachStepGUI = new StepGUI<>(getStepStete(), new PanelCoach(storage));
        panelTraineeInfoStepGUI = new StepGUI<>(getStepStete(), new PanelTraineeInfo());

        conclusionStepGUI = new StepGUI<>(getStepStete(), new JPanel());
        conclusionStepGUI.getStepGUIGroup().getPanel().add(jta_conclusion);
        setupListeners();
    }

    @Override
    public void setupListeners() {
        PanelCategory pca = panelCategoryStepGUI.getStepGUIGroup().getPanel();
        PanelClass pcl = panelClassStepGUI.getStepGUIGroup().getPanel();
        PanelCoach pco = panelCoachStepGUI.getStepGUIGroup().getPanel();
        PanelTraineeInfo pti = panelTraineeInfoStepGUI.getStepGUIGroup().getPanel();
        JPanel pcc = conclusionStepGUI.getStepGUIGroup().getPanel();

        StepBar sca = panelCategoryStepGUI.getStepGUIGroup().getStepBar();
        StepBar scl = panelClassStepGUI.getStepGUIGroup().getStepBar();
        StepBar sco = panelCoachStepGUI.getStepGUIGroup().getStepBar();
        StepBar sti = panelTraineeInfoStepGUI.getStepGUIGroup().getStepBar();
        StepBar scc = conclusionStepGUI.getStepGUIGroup().getStepBar();

        sca.getJbt_next().addActionListener(e -> {
            int temp = pca.getTable().getSelectedRow();
            if(temp >= 0) {
                currentCategory = storage.categories.get(temp);
            } else {
                currentCategory = null;
            }
            pcl.resetCategoryAndRefresh(currentCategory);

            getStepStete().next();
            updateCurrentPane();
        });
        sca.getJbt_cancel().addActionListener(e -> {
            getStepStete().cancel();
            updateCurrentPane();
        });
        sca.getJbt_back().addActionListener(e -> {
            getStepStete().back();
            updateCurrentPane();
        });
        scl.getJbt_next().addActionListener(e -> {
            int temp = pcl.getTable().getSelectedRow();
            if(temp >= 0) {
                currentLFClass = pcl.getClasses().get(temp);
                getStepStete().next();
                updateCurrentPane();
            } else {
                new WarningFrame("You must select a class").setVisible(true);
            }

        });
        scl.getJbt_cancel().addActionListener(e -> {
            getStepStete().cancel();
            updateCurrentPane();
        });
        scl.getJbt_back().addActionListener(e -> {
            currentCategory = null;
            getStepStete().back();
            updateCurrentPane();
        });

        sco.getJbt_next().addActionListener(e -> {
            int temp = pco.getTable().getSelectedRow();
            if(temp >= 0) {
                currentCoach = storage.coaches.get(temp);
                getStepStete().next();
                updateCurrentPane();
            } else {
                new WarningFrame("You must select a coach").setVisible(true);
            }
        });
        sco.getJbt_cancel().addActionListener(e -> {
            getStepStete().cancel();
            updateCurrentPane();
        });
        sco.getJbt_back().addActionListener(e -> {
            getStepStete().back();
            updateCurrentPane();
        });

        sti.getJbt_next().addActionListener(e -> {
            pti.retrieve();
            try {
                blancRawBooking.ID = "B" + String.format("%03d", storage.bookings.size() + 1);
                blancRawBooking.lfClass_ID = getCurrentLFClass().raw.ID;
                blancRawBooking.coach_ID = getCurrentCoach().raw.ID;

                blancRawBooking.trainee_ID = pti.getID();
                blancRawBooking.startDate = pti.getStartDate();
                blancRawBooking.times = pti.getTimes();
                blancRawBooking.repeat = pti.getRepeat();
                blancRawBooking.quit = false;
            } catch (NullPointerException nullPointerException) {
                nullPointerException.printStackTrace();
            }

            jta_conclusion.setText(
                    "You(" + blancRawBooking.trainee_ID + ") will add a booking,\n  the coach is "
                            + currentCoach.raw.name + ",\n  the class is "
                            + currentLFClass.raw.name + ",\n  the first class start at "
                            + OurDateFormat.fancyDate.format(blancRawBooking.startDate) + ",\n  you will have this class every "
                            + blancRawBooking.repeat / 1000 / 60 / 60 / 24 + " days for "
                            + blancRawBooking.times + " times."
                    );

            getStepStete().next();
            updateCurrentPane();

        });
        sti.getJbt_cancel().addActionListener(e -> {
            getStepStete().cancel();
            updateCurrentPane();
        });
        sti.getJbt_back().addActionListener(e -> {
            getStepStete().back();
            updateCurrentPane();
        });

        scc.getJbt_next().addActionListener(e -> {
            getStepStete().next();
            updateCurrentPane();

        });
        scc.getJbt_cancel().addActionListener(e -> {
            getStepStete().cancel();
            updateCurrentPane();
        });
        scc.getJbt_back().addActionListener(e -> {
            getStepStete().back();
            updateCurrentPane();
        });

    }

    public StepGUI<JPanel> getConclusionStepGUI() {
        return conclusionStepGUI;
    }
    public StepGUI<PanelCategory> getPanelCategoryStepGUI() {
        return panelCategoryStepGUI;
    }
    public StepGUI<PanelClass> getPanelClassStepGUI() {
        return panelClassStepGUI;
    }
    public StepGUI<PanelCoach> getPanelCoachStepGUI() {
        return panelCoachStepGUI;
    }
    public StepGUI<PanelTraineeInfo> getPanelTraineeInfoStepGUI() {
        return panelTraineeInfoStepGUI;
    }
    public LFClass getCurrentLFClass() {
        return currentLFClass;
    }
    public Coach getCurrentCoach() {
        return currentCoach;
    }
}



