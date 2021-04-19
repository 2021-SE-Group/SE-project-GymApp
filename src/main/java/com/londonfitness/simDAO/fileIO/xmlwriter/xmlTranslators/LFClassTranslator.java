package com.londonfitness.simDAO.fileIO.xmlwriter.xmlTranslators;

import com.londonfitness.simDAO.fileIO.xmlwriter.TestTT;
import com.londonfitness.simDAO.table.LFClass;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;

public class LFClassTranslator extends TestTT<LFClass> {
    public LFClassTranslator(Document doc, ArrayList<LFClass> list, Element root, String list1, String unit1) {
        super(doc, list, root, list1, unit1);
    }

    @Override
    public void setRow(LFClass lfClass) {
        setCell("ID", lfClass.ID);
        setCell("name", lfClass.name);
        setCell("category_ID", lfClass.category_ID);
        setCell("duration", Long.toString(lfClass.duration));
    }
}
