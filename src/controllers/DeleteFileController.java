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
public class DeleteFileController {
    
  //  private static final String SRC_FOLDER = "/Users/Katerina/Desktop/music.mp3";
    
    public static void delete1(String path,String name)
    {
        System.out.println("deleted file/directory:"+path+name);
        File directory = new File(path+name);
        
        if(!directory.exists()){
            System.out.println("Directory does not exists");
            System.exit(0);
        }else{
            try{
                delete(directory);
                
            }catch(IOException e){
                e.printStackTrace();
                System.exit(0);
            }
        }
    System.out.println("Done");
    }
    private static void delete(File file)
            throws IOException{
        if (file.isDirectory()){
            if(file.list().length==0){
                file.delete();
                System.out.println("Directory is deleted:" + file.getAbsolutePath());
                
            }else{
                //list all the directory contents
                String files[] = file.list();
                
                for(String temp : files){
                    //construct the file structure
                    File fileDelete = new File(file,temp);
                    //resursive delete
                    delete(fileDelete);
                }
                //check if directory is empty , if empty delete it 
                if(file.list().length==0){
                file.delete();
                System.out.println("Directory is deleted:" + file.getAbsolutePath());
                
                }
                
            }
        }else{
            //if file then delete it
            file.delete();
            System.out.println("File is deleted: " + file.getAbsolutePath());
                    
        }
    }
    
    
}
