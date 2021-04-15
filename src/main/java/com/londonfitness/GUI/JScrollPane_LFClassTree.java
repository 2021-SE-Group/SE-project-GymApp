package com.londonfitness.GUI;

import com.londonfitness.table.Category;
import com.londonfitness.table.LFClass;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.ArrayList;
import java.util.Iterator;

public class JScrollPane_LFClassTree extends JScrollPane {
    private ArrayList<Category> categories;
    private ArrayList<LFClass> lfClasses;
    private JTree jt;

    public JScrollPane_LFClassTree(ArrayList<Category> categories, ArrayList<LFClass> lfClasses) {
        this.categories = categories;
        this.lfClasses = lfClasses;

        // root node
        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("London Fitness Classes");

        // tree model
        DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);

        DFTReplicateTree(treeModel, categories.get(0), rootNode);

        // setup JTree and view
        jt = new JTree(treeModel);
        jt.setEditable(false);
        this.setViewportView(jt);
    }

    private void DFTReplicateTree(DefaultTreeModel tm, Category c, DefaultMutableTreeNode dmt) {
        for (Iterator<Category> it = c.selfIndex.getTnIter(); it.hasNext(); ) {
            Category cate = it.next();
            DefaultMutableTreeNode prev = new DefaultMutableTreeNode(cate.name);
            tm.insertNodeInto(prev, dmt, dmt.getChildCount());
            DFTReplicateTree(tm, cate, prev);
        }
    }
}
