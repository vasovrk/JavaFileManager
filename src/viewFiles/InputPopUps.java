/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viewFiles;

import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author vasovourka
 */
public class InputPopUps {
    public static boolean inputName(String path,String oldName) {
    JFrame frame = new JFrame();
    Object result = JOptionPane.showInputDialog(frame, "Enter new name:");
    String newName=File.pathSeparator+result.toString();
    File oldFileName=new File(path+oldName);
    File newFileName=new File(path+newName);
    System.out.println("oldfile:"+path+oldName);
    System.out.println("new file: "+path+newName);
   boolean res= oldFileName.renameTo(newFileName);
    if (!res) {
        System.out.println( "File was not successfully renamed");
    }
    
    System.out.println(result);
    return res;
  }
}
