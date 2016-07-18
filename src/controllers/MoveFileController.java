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
public class MoveFileController {
    
    public static void move(String str,String str2)
    {
      InputStream inStream = null;
      OutputStream outStream = null;
      
      try{
          File srcfile = new File(str);
          File newfile = new File(str2);
          
          inStream = new FileInputStream(srcfile);
          outStream = new FileOutputStream(newfile);
          
          byte[] buffer = new byte[1024];
          
          int length;
          
          while((length = inStream.read(buffer)) > 0){
              outStream.write(buffer , 0 ,length);
          }
          
          inStream.close();
          outStream.close();
          //delete the source file
          srcfile.delete();
          
          System.out.println("File has been moved!");
      }catch(IOException e){
        System.out.println("file is folder and can't move");
      }       
    }

}
