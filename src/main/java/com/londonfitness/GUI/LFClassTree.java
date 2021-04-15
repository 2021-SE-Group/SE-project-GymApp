package com.londonfitness.GUI;

import com.londonfitness.table.Category;
import com.londonfitness.table.LFClass;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Enumeration;

public class LFClassTree extends JScrollPane {
    ArrayList<Category> categories;
    ArrayList<LFClass> lfClasses;
    private JTree jt;
    private DefaultMutableTreeNode root;

    public LFClassTree(ArrayList<Category> categories, ArrayList<LFClass> lfClasses) {
        this.categories = categories;
        this.lfClasses = lfClasses;
        root = new DefaultMutableTreeNode("London Fitness Classes");
        /*
        for(Category cate: categories) {
            root.add();
        }
        */

        // display
        jt = new JTree(root);
        this.setViewportView(jt);
    }

    private void createNode(TreeNode root) {

    }

    private DefaultMutableTreeNode DFTCreatenodes() {
        return null;
    }
    /*
    public void constructTree() {
        for(Category ct : categories) {
            ct
        }
    }

    class resolvingNode extends Category{
        ArrayList<resolvingNode> children;
        ArrayList<LFClass> leaves;
    }

     */
}
