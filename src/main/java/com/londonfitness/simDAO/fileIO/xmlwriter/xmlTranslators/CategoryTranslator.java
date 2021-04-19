package com.londonfitness.simDAO.fileIO.xmlwriter.xmlTranslators;

import com.londonfitness.simDAO.fileIO.FileScan.ScanXML;
import com.londonfitness.simDAO.fileIO.xmlwriter.TestTT;
import com.londonfitness.simDAO.fileIO.xmlwriter.TranslateXML;
import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.table.Category;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.nio.file.Paths;
import java.util.ArrayList;

public class CategoryTranslator extends TestTT<Category>{

    public CategoryTranslator(Document doc, ArrayList<Category> list, Element root, String list1, String unit1) {
        super(doc, list, root, list1, unit1);
    }

    @Override
    public void setRow(Category category) {


        setCell("ID", category.ID);
        setCell("name", category.name);
        setCell("parent_ID", category.parent_ID);
    }

}
