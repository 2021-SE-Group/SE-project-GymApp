package com.londonfitness;

import com.londonfitness.table.*;
import com.londonfitness.table.persons.*;
import com.londonfitness.xmlloader.*;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Hello world!
 *
 */
public class App 
{
    private static final Date initTime = new Date();
    private static final SimpleDateFormat sdfFileName = new SimpleDateFormat("yyMMddhhmmss");
    private static final String resourcePathName = "resources\\";
    private static final String cacheFileName = resourcePathName + sdfFileName.format(initTime) + "-data.xml";
    private static final String defaultFileName = resourcePathName + "data.xml";

    public static void main( String[] args )
    {
        //Charset charset = Charset.forName("UTF-8");
        // new MemDB and init it
        ArrayList<Category> categories;
        ArrayList<LFClass> lfClasses;
        ArrayList<Admin> admins;
        ArrayList<Staff> staffs;
        ArrayList<Coach> coaches;
        ArrayList<Trainer> trainers;
        ArrayList<Booking> bookings;
        ArrayList<Exchange> exchanges;
        // from xml, load tables into our container
        {
            // load data
            Path resourceRoot = Paths.get(resourcePathName);
            Path dataPath = Paths.get(defaultFileName);

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
            Node class_list = elemRoot.getElementsByTagName("class_list").item(0);
            Node admin_list = elemRoot.getElementsByTagName("admin_list").item(0);
            Node service_list = elemRoot.getElementsByTagName("service_list").item(0);
            Node coach_list = elemRoot.getElementsByTagName("voach_list").item(0);
            Node booking_list = elemRoot.getElementsByTagName("booking_list").item(0);

            // load every list into our container and TODO(establish index, B tree)(may implement inside the container)

            CategoryLoader cateL = new CategoryLoader(category_list.getChildNodes());
            cateL.load();
            categories = cateL.result;

            LFClassLoader clsL = new LFClassLoader(class_list.getChildNodes(), cateL.result);
            clsL.load();
            lfClasses = clsL.result;



            for(Category c : categories) {
                System.out.println(c);
            }
            for(LFClass lfc : lfClasses) {
                System.out.println(lfc);
            }
        }

        /*
        try (BufferedReader reader =
                     Files.newBufferedReader(
                             dataPath,
                             Charset.forName("UTF-8")))
        {

        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        */

        // do service
        {
            // main frame kick in
        }

        // storage tables to new xml file, if all done, change name
        {
            // display a wait-for-a-while window

        }


    }
}
