package com.londonfitness.model;

import com.londonfitness.OurDateFormat;
import com.londonfitness.simDAO.fileIO.FileScan.ScanXML;
import com.londonfitness.simDAO.fileIO.XMLDocumentBuilder;
import com.londonfitness.simDAO.indexBuilder.RebuildIndexes;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.table.Booking;
import com.londonfitness.simDAO.table.persons.Coach;
import com.londonfitness.simDAO.table.persons.Trainee;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class ModelTimetable {
    private final Iterator<Booking> itBook;
    private final ArrayList<ModelLesson> les;

    public ModelTimetable(Coach coach) {
        /*for(Iterator<Booking>it = coach.index_booking.getTnIter();
            it.hasNext();)
            {
                Booking sch = it.next();
                sch.startDate.getTime() + sch.repeat *
        }

         */
        les = new ArrayList<>();
        this.itBook = coach.index_booking.getTnIter();
        transLate();
    }

    public ModelTimetable(Trainee trainee) {
        les = new ArrayList<>();
        this.itBook = trainee.index_booking.getTnIter();
        transLate();
    }

    public static void main(String[] args) {
        Storage storage = new Storage();
        try {
            XMLDocumentBuilder xmlDocumentBuilder = new XMLDocumentBuilder();
            DocumentBuilder documentBuilder = xmlDocumentBuilder.documentBuilder;

            new ScanXML(
                    documentBuilder,
                    storage,
                    "resources\\",
                    "resources\\data.xml"
            ).scan();
            new RebuildIndexes(storage);
            ModelTimetable fuck = new ModelTimetable(storage.coaches.get(0));
            for (ModelLesson l : fuck.getClassBeTwin(OurDateFormat.fileDate.parse("210423000000").getTime(), OurDateFormat.fileDate.parse("210430000000").getTime())) {
                System.out.println(l);
            }
        } catch (ParserConfigurationException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void transLate() {

        for (Iterator<Booking> it = itBook;
             it.hasNext(); ) {
            Booking sch = it.next();
            for (int i = 0; i < sch.raw.times; i++) {
                les.add(new ModelLesson(sch, i + 1));
            }
        }
    }

    public ArrayList<ModelLesson> getClassBeTwin(long from, long to) {
        ArrayList<ModelLesson> between = new ArrayList<>();
        for (ModelLesson l : les) {
            if (l.getStart() > from && l.getEnd() < to) {
                between.add(l);
            }
        }
        between.sort(new Comparator<ModelLesson>() {
            @Override
            public int compare(ModelLesson o1, ModelLesson o2) {
                return (int) (o2.getStart() - o1.getStart());
            }
        });
        return between;
    }

}
