/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Katerina
 */
public class CopyFileController {
    public static void copy1(String str1,String str2)
    {
        File srcFolder = new File(str1);
        File destFolder = new File(str2);
        
        //elenxos an iparxei to arxeio
       
        if(!srcFolder.exists()){
        System.out.println("Directory does not exists!");
        //System.exit(0);
        
        }else{
            try{
                copyFolder(srcFolder,destFolder);
            }catch(IOException e){
                e.printStackTrace();
                //System.exit(0);
            
            }
        }
             System.out.println("Done!");  
    }
    public static void copyFolder(File src , File dest)
            throws IOException{
            
            if(src.isDirectory()){
                //if directory not exists Create it
                if(!dest.exists()){
                    dest.mkdir();
                    System.out.println("Directory copied from:" + src + " to " + dest);
                    
                }
            //list directory contents
            String files[] = src.list();
            
            for (String file : files){
                File srcFile = new File(src,file);
                File destFile = new File(dest,file);
                
                copyFolder(srcFile,destFile);
            }
            
            }else{
                //if file copy it 
                InputStream in = new FileInputStream(src);
                OutputStream out = new FileOutputStream(dest);
                
                byte[] buffer = new byte[1024];
                
                int length;
                while ((length = in.read(buffer)) > 0 ){
                    out.write(buffer,0,length);
                }
                in.close();
                out.close();
                System.out.println("File copied from:" + src + " to: " + dest);
                
            }
            
    }
    
}
