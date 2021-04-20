package com.londonfitness.simDAO.fileIO.xmlwriter;

import com.londonfitness.OurDateFormat;
import com.londonfitness.simDAO.fileIO.FileScan.ScanXML;
import com.londonfitness.simDAO.fileIO.XMLDocumentBuilder;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.table.*;
import com.londonfitness.simDAO.table.persons.Admin;
import com.londonfitness.simDAO.table.persons.Coach;
import com.londonfitness.simDAO.table.persons.Staff;
import com.londonfitness.simDAO.table.persons.Trainee;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.nio.file.Path;
import java.nio.file.Paths;


public class WriteXML {
    private final Path dataPath;
    private final Storage storage;
    private DocumentBuilder db;

    public WriteXML(DocumentBuilder db, Path dataPath, Storage storage) {
        this.db = db;
        this.dataPath = dataPath;
        this.storage = storage;
    }

    public void translate() {

        assert db != null;
        Document doc = db.newDocument();

        doc.setXmlStandalone(true);
        Element record_list = doc.createElement("record_list");
        translateList(doc, record_list);
        doc.appendChild(record_list);


        TransformerFactory tff=TransformerFactory.newInstance();
        Transformer tf= null;
        try {
            tf = tff.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }

        assert tf != null;
        tf.setOutputProperty(OutputKeys.INDENT, "yes");
        try {
            tf.transform(new DOMSource(doc), new StreamResult(dataPath.toFile()));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private void translateList(Document doc, Element root) {
        new XMLTableTranslator<>(
                doc, root,
                "category_list", "category",
                storage.categories
        ) {
            @Override
            public void setRow(Category category) {
                setCell("ID", category.ID);
                setCell("name", category.name);
                setCell("parent_ID", category.parent_ID);
            }
        }.write();


        new XMLTableTranslator<>(
                doc, root,
                "lfClass_list", "lfClass",
                storage.lfClasses
        ) {
            @Override
            public void setRow(LFClass lfClass) {
                setCell("ID", lfClass.ID);
                setCell("name", lfClass.name);
                setCell("duration", Long.toString(lfClass.duration));
                setCell("resource_URL", lfClass.resource_URL);
                setCell("category_ID", lfClass.category_ID);

            }
        }.write();

        new XMLTableTranslator<>(
                doc, root,
                "admin_list", "admin",
                storage.admins
        ) {
            @Override
            public void setRow(Admin admin) {
                setCell("ID", admin.ID);
                setCell("username", admin.username);
                setCell("name", admin.name);
                if (admin.expired)
                    setCell("expired", "T");
                else
                    setCell("expired", "F");
            }
        }.write();

        new XMLTableTranslator<>(
                doc, root,
                "staff_list", "staff",
                storage.staffs
        ) {
            @Override
            public void setRow(Staff staff) {
                setCell("ID", staff.ID);
                setCell("username", staff.username);
                setCell("name", staff.name);
                if (staff.expired)
                    setCell("expired", "T");
                else
                    setCell("expired", "F");
            }
        }.write();

        new XMLTableTranslator<>(
                doc, root,
                "coach_list", "coach",
                storage.coaches
        ) {
            @Override
            public void setRow(Coach coach) {
                setCell("ID", coach.ID);
                setCell("username", coach.username);
                setCell("name", coach.name);
                if (coach.expired)
                    setCell("expired", "T");
                else
                    setCell("expired", "F");
                setCell("c_profile_URL", coach.c_profile_URL);
            }
        }.write();

        new XMLTableTranslator<>(
                doc, root,
                "coach_ability_class_list", "ability_class",
                storage.coachAbilities
        ) {
            @Override
            public void setRow(CoachAbility coachAbility) {
                setCell("coach_ID", coachAbility.coach_ID);
                setCell("lfClass_ID", coachAbility.lfc_ID);
                setCell("time", coachAbility.time);
            }
        }.write();

        new XMLTableTranslator<>(
                doc, root,
                "trainee_list", "trainee",
                storage.trainees
        ) {
            @Override
            public void setRow(Trainee trainee) {
                setCell("ID", trainee.ID);
                setCell("username", trainee.username);
                setCell("name", trainee.name);
                if (trainee.expired)
                    setCell("expired", "T");
                else
                    setCell("expired", "F");
                setCell("t_profile_URL", trainee.t_profile_URL);
            }
        }.write();

        new XMLTableTranslator<>(
                doc, root,
                "booking_list", "booking",
                storage.bookings) {
            @Override
            public void setRow(Booking booking) {
                /*
                public String ID;
                public String coach_ID;
                public String trainee_ID;
                public String lfClass_ID;
                public Date startDate;
                public int times;//class chances' time
                public long repeat;
                */
                setCell("ID", booking.ID);
                setCell("coach_ID", booking.coach_ID);
                setCell("trainee_ID", booking.trainee_ID);
                setCell("lfClass_ID", booking.lfClass_ID);
                setCell("startDate", OurDateFormat.fileDate.format(booking.startDate));
                setCell("times", Integer.toString(booking.times));
                setCell("repeat", Long.toString(booking.repeat));
            }
        }.write();

        new XMLTableTranslator<>(
                doc, root,
                "exchange_list", "exchange",
                storage.exchanges
        ) {
            @Override
            public void setRow(Exchange exchange) {
                // TODO
            }
        }.write();

        new XMLTableTranslator<>(
                doc, root,
                "history_list", "record",
                storage.records
        ) {
            @Override
            public void setRow(Record record) {
                // TODO
            }
        }.write();
    }

    @Test
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
            new WriteXML(
                    documentBuilder,
                    Paths.get("testResources\\testData.xml"),
                    storage
            ).translate();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
