package com.londonfitness.GUI;

import com.londonfitness.simDAO.table.Category;
import com.londonfitness.simDAO.table.LFClass;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

public class JScrollPane_LFClassTree extends JScrollPane {
    private final ArrayList<Category> categories;
    private final ArrayList<LFClass> lfClasses;
    private final JTree jt;

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
            DefaultMutableTreeNode prev = new DefaultMutableTreeNode(cate.raw.name);
            tm.insertNodeInto(prev, dmt, dmt.getChildCount());
            DFTReplicateTree(tm, cate, prev);
        }
        for (Iterator<LFClass> it = c.index_lfClass.getTnIter(); it.hasNext(); ) {
            LFClass lfc = it.next();
            tm.insertNodeInto(new DefaultMutableTreeNode(lfc.raw.name), dmt, dmt.getChildCount());
        }
    }

    public class OurTreeNode implements TreeNode {
        OurTreeNode parent;
        ArrayList<OurTreeNode> children;

        @Override
        public TreeNode getChildAt(int childIndex) {
            return children.get(childIndex);
        }

        @Override
        public int getChildCount() {
            return children.size();
        }

        @Override
        public TreeNode getParent() {
            return parent;
        }

        @Override
        public int getIndex(TreeNode node) {
            return parent.children.indexOf(node);
        }

        @Override
        public boolean getAllowsChildren() {
            return false;
        }

        @Override
        public boolean isLeaf() {
            return false;
        }

        @Override
        public Enumeration<? extends TreeNode> children() {
            return null;
        }
    }
}
