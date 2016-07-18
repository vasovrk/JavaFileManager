/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.io.File;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author vasovourka
 */
public class TreeController {
    
    public static void treeInit (DefaultMutableTreeNode root,File curNode){
        
     
    }

    public static DefaultMutableTreeNode treeSubCreation(DefaultMutableTreeNode root, File subDir) {
        File[] subItems = subDir.listFiles();
        for (File file : subItems) {
            if (!(file.isHidden())) {
                DefaultMutableTreeNode parent = new DefaultMutableTreeNode(file);
                if (file.isDirectory()) {
                    treeSubCreation(parent, file);
                    //treeSub(parent, file);
                    root.add(parent);
                } else {
                    root.add(parent);
                }
            }
            
        }
        
        return root;
    }
    public static DefaultMutableTreeNode treeSub(DefaultMutableTreeNode root, File subDir) {
        File[] subItems = subDir.listFiles();
        for (File file : subItems) {
            if (!(file.isHidden())) {
                DefaultMutableTreeNode parent = new DefaultMutableTreeNode(file);
                if (file.isDirectory()) {
                   // treeSubCreation(parent, file);
                    root.add(parent);
                } else {
                    root.add(parent);
                }
            }
            
        }
        return root;
    }

    public static DefaultTreeModel treeCreation(final JTree tree, File dir) {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(dir);
        tree.setShowsRootHandles(true);
        root = treeSubCreation(root, dir);
        DefaultTreeModel model = new DefaultTreeModel(root);
        tree.setModel(model);
        //model.nodeStructureChanged(root);
        return model;
    }

    
    
}
