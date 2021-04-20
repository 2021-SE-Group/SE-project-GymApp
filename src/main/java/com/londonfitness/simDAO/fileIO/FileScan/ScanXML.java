package com.londonfitness.simDAO.fileIO.FileScan;

import com.londonfitness.OurDateFormat;
import com.londonfitness.simDAO.fileIO.XMLErrorHandler;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.table.*;
import com.londonfitness.simDAO.table.persons.Admin;
import com.londonfitness.simDAO.table.persons.Coach;
import com.londonfitness.simDAO.table.persons.Staff;
import com.londonfitness.simDAO.table.persons.Trainee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;

public class ScanXML {
    private final Path resourceRoot;
    private final Path dataPath;
    private final Storage storage;
    private DocumentBuilder db;
    private Element elemRoot;

    public ScanXML(DocumentBuilder documentBuilder, Storage storage, String resourcePathName, String defaultFileName) {
        this.db = documentBuilder;
        resourceRoot = Paths.get(resourcePathName);
        dataPath = Paths.get(defaultFileName);
        this.storage = storage;
    }

    public void scan() {
        // check existance of resource path and all needed file.
        if (Files.exists(resourceRoot)) {
            // if resorce exists, check if is dir
            if (!Files.isDirectory(resourceRoot)) {
                System.err.println("Wrong, there is a file named resouce, we need a directory.");
            }
        } else {
            // if resource not exists, create.
            try {
                Files.createDirectories(resourceRoot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File dataFile = dataPath.toFile();
        if (!dataFile.exists()) {
            try {
                Files.createFile(dataPath);
                // initiate
            } catch (IOException e) {
                // fail to create the file.
                e.printStackTrace();
            }
        }

        Document doc = null;
        try {
            assert db != null;
            doc = db.parse(dataFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        assert doc != null;
        elemRoot = doc.getDocumentElement();
        elemRoot.normalize();

        scanList();

        // TODO: comment when release
        checkLoad();
    }

    private NodeList getList(Element elemRoot, String listName) {
        return elemRoot.getElementsByTagName(listName).item(0).getChildNodes();
    }

    private void scanList() {
        new XMLTableLoader<>(
                getList(elemRoot, "category_list"),
                storage.categories) {
            @Override
            protected void scanCell(Node n, Category category) {
                switch (n.getNodeName()) {
                    case "ID":
                        category.ID = n.getTextContent();
                        break;
                    case "name":
                        category.name = n.getTextContent();
                        break;
                    case "parent_ID":
                        category.parent_ID = n.getTextContent();
                        break;
                }
            }

            @Override
            protected Category getNewInstanceOfType() {
                return new Category();
            }
        }.load();

        new XMLTableLoader<>(
                getList(elemRoot, "lfClass_list"),
                storage.lfClasses) {
            @Override
            protected void scanCell(Node n, LFClass lfClass) {
                switch (n.getNodeName()) {
                    case "ID":
                        lfClass.ID = n.getTextContent();
                        break;
                    case "name":
                        lfClass.name = n.getTextContent();
                        break;
                    case "category_ID":
                        lfClass.category_ID = n.getTextContent();
                        break;
                    case "duration":
                        lfClass.duration = Long.parseLong(n.getTextContent());
                        break;
                    case "resource_URL":
                        lfClass.resource_URL = n.getTextContent();
                        break;
                }
            }

            @Override
            protected LFClass getNewInstanceOfType() {
                return new LFClass();
            }
        }.load();

        new XMLTableLoader<>(
                getList(elemRoot, "admin_list"),
                storage.admins) {
            @Override
            protected void scanCell(Node n, Admin admin) {
                switch (n.getNodeName()) {
                    case "ID":
                        admin.ID = n.getTextContent();
                        break;
                    case "username":
                        admin.username = n.getTextContent();
                        break;
                    case "name":
                        admin.name = n.getTextContent();
                        break;
                    case "expire":
                        admin.expired = n.getTextContent().equals("t") || n.getTextContent().equals("T");
                        break;
                }
            }

            @Override
            protected Admin getNewInstanceOfType() {
                return new Admin();
            }
        }.load();

        new XMLTableLoader<>(
                getList(elemRoot, "staff_list"),
                storage.staffs) {
            @Override
            protected void scanCell(Node n, Staff staff) {
                switch (n.getNodeName()) {
                    case "ID":
                        staff.ID = n.getTextContent();
                        break;
                    case "username":
                        staff.username = n.getTextContent();
                        break;
                    case "name":
                        staff.name = n.getTextContent();
                        break;
                    case "expire":
                        staff.expired = n.getTextContent().equals("t") || n.getTextContent().equals("T");
                        break;
                }
            }

            @Override
            protected Staff getNewInstanceOfType() {
                return new Staff();
            }
        }.load();

        new XMLTableLoader<>(
                getList(elemRoot, "coach_list"),
                storage.coaches) {
            @Override
            protected void scanCell(Node n, Coach coach) {
                switch (n.getNodeName()) {
                    case "ID":
                        coach.ID = n.getTextContent();
                        break;
                    case "username":
                        coach.username = n.getTextContent();
                        break;
                    case "name":
                        coach.name = n.getTextContent();
                        break;
                    case "expire":
                        coach.expired = n.getTextContent().equals("t") || n.getTextContent().equals("T");
                        break;
                    case "c_profile_URL":
                        coach.c_profile_URL = n.getTextContent();
                        break;
                }
            }

            @Override
            protected Coach getNewInstanceOfType() {
                return new Coach();
            }
        }.load();

        new XMLTableLoader<>(
                getList(elemRoot, "coach_ability_class_list"),
                storage.coachAbilities) {
            @Override
            protected void scanCell(Node n, CoachAbility coachAbility) {
                switch (n.getNodeName()) {
                    case "coach_ID":
                        coachAbility.coach_ID = n.getTextContent();
                        break;
                    case "lfClass_ID":
                        coachAbility.lfc_ID = n.getTextContent();
                        break;
                    case "time":
                        coachAbility.time = n.getTextContent();
                        break;
                }
            }

            @Override
            protected CoachAbility getNewInstanceOfType() {
                return new CoachAbility();
            }
        }.load();

        new XMLTableLoader<>(
                getList(elemRoot, "trainee_list"),
                storage.trainees) {
            @Override
            protected void scanCell(Node n, Trainee trainee) {
                switch (n.getNodeName()) {
                    case "ID":
                        trainee.ID = n.getTextContent();
                        break;
                    case "username":
                        trainee.username = n.getTextContent();
                        break;
                    case "name":
                        trainee.name = n.getTextContent();
                        break;
                    case "expire":
                        trainee.expired = n.getTextContent().equals("t") || n.getTextContent().equals("T");
                        break;
                    case "t_profile_URL":
                        trainee.t_profile_URL = n.getTextContent();
                        break;
                }
            }

            @Override
            protected Trainee getNewInstanceOfType() {
                return new Trainee();
            }
        }.load();

        new XMLTableLoader<>(
                getList(elemRoot, "booking_list"),
                storage.bookings) {
            @Override
            protected void scanCell(Node n, Booking booking) {
                switch (n.getNodeName()) {
                    case "ID":
                        booking.ID = n.getTextContent();
                        break;
                    case "coach_ID":
                        booking.coach_ID = n.getTextContent();
                        break;
                    case "trainee_ID":
                        booking.trainee_ID = n.getTextContent();
                        break;
                    case "lfClass_ID":
                        booking.lfClass_ID = n.getTextContent();
                        break;
                    case "startDate":
                        try {
                            booking.startDate = OurDateFormat.fileDate.parse(n.getTextContent());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "times":
                        booking.times = Integer.parseInt(n.getTextContent());
                        break;
                    case "repeat":
                        booking.repeat = Long.parseLong(n.getTextContent());
                        break;
                }
            }

            @Override
            protected Booking getNewInstanceOfType() {
                return new Booking();
            }
        }.load();

        new XMLTableLoader<>(
                getList(elemRoot, "exchange_list"),
                storage.exchanges) {
            @Override
            protected void scanCell(Node n, Exchange exchange) {
                switch (n.getNodeName()) {
                    case "booking_ID":
                        exchange.booking_ID = n.getTextContent();
                        break;
                    case "coach_ID":
                        exchange.coach_ID = n.getTextContent();
                        break;
                    case "pre_startDate":
                        try {
                            exchange.pre_startDate = OurDateFormat.fileDate.parse(n.getTextContent());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "aft_startDate":
                        try {
                            exchange.aft_startDate = OurDateFormat.fileDate.parse(n.getTextContent());
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        break;
                    case "repeat":
                        exchange.repeat = Long.parseLong(n.getTextContent());
                        break;
                }
            }

            @Override
            protected Exchange getNewInstanceOfType() {
                return new Exchange();
            }
        }.load();

        new XMLTableLoader<>(
                getList(elemRoot, "history_list"),
                storage.records
        ) {
            @Override
            protected void scanCell(Node n, Record record) {
                // TODO
            }

            @Override
            protected Record getNewInstanceOfType() {
                return new Record();
            }
        }.load();
    }

    @Deprecated
    public void checkLoad() {
        for (Category c : storage.categories) {
            System.out.println(c);
        }
        for (LFClass lfc : storage.lfClasses) {
            System.out.println(lfc);
        }
        for (Admin adm : storage.admins) {
            System.out.println(adm);
        }
        for (Staff stf : storage.staffs) {
            System.out.println(stf);
        }
        for (Coach cch : storage.coaches) {
            System.out.println(cch);
        }
        for (CoachAbility ccah : storage.coachAbilities) {
            System.out.println(ccah);
        }
        for (Trainee tra : storage.trainees) {
            System.out.println(tra);
        }
        for (Booking bok : storage.bookings) {
            System.out.println(bok);
        }
        for(Exchange exc : storage.exchanges) {
            System.out.println(exc);
        }
    }
}
