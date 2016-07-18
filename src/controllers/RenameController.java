/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import commands.ICommand;
import commands.RenameCommand;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author vasovourka
 */
public class RenameController {
   public static void  inputName(ICommand command,String path,String oldName) {
   
    
    JFrame frame = new JFrame();
    Object result = JOptionPane.showInputDialog(frame, "Enter new name:");
    String newName="/"+result.toString();
    System.out.println("newName izzzzz:"+newName);
    File oldFileName=new File(path+oldName);
    File newFileName=new File(path+newName);
      RenameCommand com=(RenameCommand) command;
    com.setNewOldName(newFileName,oldFileName);
//    System.out.println("oldfile:"+path+oldName);
//    System.out.println("new file: "+path+newName);
//   boolean res= oldFileName.renameTo(newFileName);
//    if (!res) {
//        System.out.println( "File was not successfully renamed");
//    }
    ActionController.action(command, path);
    System.out.println(result);
   
   // ActionController.action(command, path);
   
  }
    
}
