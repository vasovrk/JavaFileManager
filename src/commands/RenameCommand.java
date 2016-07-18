/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import controllers.ActionEnum;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author vasovourka
 */
public class RenameCommand implements ICommand {
    String path;
   private File oldName,newName;
    public RenameCommand(ActionEnum type,String path) {
        this.path=path;
       
        
    }
    public void setNewOldName(File newName,File oldName){
     this.oldName=oldName;   
    this.newName=newName;
    }
    @Override
    public String getName() {
        return File.pathSeparator+oldName.getName();
        }

    @Override
    public String getSource() {
          return  oldName.getPath().toString();
    }

    @Override
    public ActionEnum getType() {
            return ActionEnum.RENAME;
        }

    @Override
    public void undo() {
        
   newName.renameTo(oldName);
    }

    @Override
    public void redo() {
perform();    }

    @Override
    public void perform() {
        oldName.renameTo(newName);
       System.out.println("to palio name einai :"+oldName.toString());
       System.out.println("to kainoyrgio name einai:"+newName.toString());
       
    }
     
    
}
