package com.londonfitness.FileScan;

import com.londonfitness.FileScan.xmlloader.*;
import com.londonfitness.memStorage.Storage;
import com.londonfitness.table.Booking;
import com.londonfitness.table.Category;
import com.londonfitness.table.CoachAbility;
import com.londonfitness.table.LFClass;
import com.londonfitness.table.persons.Admin;
import com.londonfitness.table.persons.Coach;
import com.londonfitness.table.persons.Staff;
import com.londonfitness.table.persons.Trainee;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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

public class  ScanXML {
    private Path resourceRoot;
    private Path dataPath;
    private Storage storage;
    public ScanXML(Storage storage, String resourcePathName, String defaultFileName) {
        resourceRoot = Paths.get(resourcePathName);
        dataPath = Paths.get(defaultFileName);
        this.storage = storage;
        scan();
    }

    private void scan() {
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

        //System.out.println(dataFile.exists());

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //dbf.setNamespaceAware(true);
        //dbf.setValidating(true);
        OutputStreamWriter errorWriter = new OutputStreamWriter(System.err, StandardCharsets.UTF_8);

        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
            db.setErrorHandler(new XMLErrorHandler(new PrintWriter(errorWriter, true)));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        Document doc = null;
        try {
            assert db != null;
            doc = db.parse(dataFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }


        assert doc != null;
        Element elemRoot = doc.getDocumentElement();
        elemRoot.normalize();

        // get all the lists
        Node category_list = elemRoot.getElementsByTagName("category_list").item(0);
        CategoryLoader cateL = new CategoryLoader(category_list.getChildNodes(), storage.categories);
        cateL.load();

        Node class_list = elemRoot.getElementsByTagName("lfClass_list").item(0);
        LFClassLoader clsL = new LFClassLoader(class_list.getChildNodes(), storage.lfClasses);
        clsL.load();

        Node admin_list = elemRoot.getElementsByTagName("admin_list").item(0);
        AdminLoader admL = new AdminLoader(admin_list.getChildNodes(), storage.admins);
        admL.load();

        Node staff_list = elemRoot.getElementsByTagName("staff_list").item(0);
        StaffLoader stfL = new StaffLoader(staff_list.getChildNodes(), storage.staffs);
        stfL.load();

        Node coach_list = elemRoot.getElementsByTagName("coach_list").item(0);
        CoachLoader cchL = new CoachLoader(coach_list.getChildNodes(), storage.coaches);
        cchL.load();

        Node coachAbility_list = elemRoot.getElementsByTagName("coach_ability_class_list").item(0);
        CoachAbilityLoader ccahL = new CoachAbilityLoader(coachAbility_list.getChildNodes(), storage.coachAbility);
        ccahL.load();

        Node trainee_list = elemRoot.getElementsByTagName("trainee_list").item(0);
        TraineeLoader traL = new TraineeLoader(trainee_list.getChildNodes(), storage.trainees);
        traL.load();

        Node booking_list = elemRoot.getElementsByTagName("booking_list").item(0);
        BookingLoader bokL = new BookingLoader(booking_list.getChildNodes(), storage.bookings);
        bokL.load();
        // Node exchange_list = elemRoot.getElementsByTagName("exchange_list").item(0);

        ///* only for developing, when done, delete
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
        for (CoachAbility ccah : storage.coachAbility) {
            System.out.println(ccah);
        }
        for (Trainee tra : storage.trainees) {
            System.out.println(tra);
        }
        for(Booking bok: storage.bookings) {
            System.out.println(bok);
        }
        //*/
    }
}
