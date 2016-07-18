/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Katerina
 */
public class CreateFolderController {
  public static void createfolder(String folderName) throws IOException{
        File dir = new File(folderName);
        dir.mkdir();
        
        if(dir.createNewFile()){
            System.out.println("Folder is created");
            
        }else{
            System.out.println("Folder already exists");
        }
  }
    
}
