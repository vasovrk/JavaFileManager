/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JTable;
import javax.swing.JTree;

/**
 *
 * @author vasovourka
 */
public class ViewFilesController {
    //return list of files (listFiles)
    //List<File> getFilesForDir(dir)
    //showFiles(List<File>) 
    public void listFilesFolder(File dir, JTable table, final JTree tree) {
        // System.out.println("arxiko directory:" + dir);
        //get all the files from a directory
        
        File[] fList = dir.listFiles();
        String fileName = null;
        int i = 0;

        long size = 0;
        for (File file : fList) {//?
            // System.out.println("file:" + file);
            if (!(file.isHidden())) {
                fileName = file.getName();
                table.setValueAt(fileName, i, 0);
                if (file.isFile()) {
                    table.setValueAt("file", i, 2);
                    size = file.length();
                    table.setValueAt(size + "Bytes", i, 1);
                } else if (file.isDirectory()) {
                    table.setValueAt("folder", i, 2);
                    table.setValueAt("---", i, 1);
                    //TODO:find folder size
                }
                i++;

            }
        }

    }
    /*public static List<File> listf(String directoryName) {
    File directory = new File(directoryName);
    
    List<File> resultList = new ArrayList<File>();
    
    // get all the files from a directory
    File[] fList = directory.listFiles();
    resultList.addAll(Arrays.asList(fList));
    for (File file : fList) {
    if (file.isFile()) {
    System.out.println(file.getAbsolutePath());
    } else if (file.isDirectory()) {
    resultList.addAll(listf(file.getAbsolutePath()));
    }
    }
    //System.out.println(fList);
    return resultList;
    } */
}

