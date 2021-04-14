package com.londonfitness;

import com.londonfitness.FileScan.ScanXML;
import com.londonfitness.FileScan.XMLErrorHandler;
import com.londonfitness.memStorage.Storage;
import com.londonfitness.table.*;
import com.londonfitness.table.persons.*;
import com.londonfitness.FileScan.xmlloader.*;
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
import java.util.Calendar;
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
        Storage storage = new Storage();

        // from xml, load tables into our container
        {
            ScanXML sx = new ScanXML(storage, resourcePathName, defaultFileName);
        }

        // from storage, build up indexes
        {

        }

        // do service
        {
            // prepare

            // main frame kick in

        }

        // storage tables to new xml file, if all done, change name
        {
            // display a wait-for-a-while window
            // gen DOM
            // write
            // change name
        }


    }
}
