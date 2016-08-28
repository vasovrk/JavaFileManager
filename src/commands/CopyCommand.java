/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import controllers.ActionEnum;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import static org.eclipse.persistence.tools.file.FileUtil.delete;

/**
 *
 * @author vasovourka
 */
public class CopyCommand implements ICommand {

    private String source;
    private String dest;
    private String name;
    private String path;
    private ActionEnum type;

    public CopyCommand(ActionEnum type, String path, String name) {
        this.source = path + name;
        this.name = name;
    }

  
    @Override
    public void perform() {
        File sourceFile = new File(source);
        File destFile = new File(dest);
    
        if(sourceFile.isDirectory()){
            try {
                FileUtils.copyDirectory(sourceFile, destFile);
            } catch (IOException ex) {
                Logger.getLogger(CopyCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(sourceFile.isFile()){
            try {
                FileUtils.copyFile(sourceFile, destFile);
            } catch (IOException ex) {
                Logger.getLogger(CopyCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    
    }

   
    @Override
    public String getName() {
        return name;
    }
    
     @Override
    public String getSource() {
        return source;
    }

    @Override
    public ActionEnum getType() {
        return ActionEnum.COPY;
    }

    @Override
    public void undo() {
        File file = new File(dest);
        delete(file);
    }

    @Override
    public void redo() {
        perform();
    }
    
    
    public void setDest(String dest) {
        this.dest = dest + name;
        System.out.println("to dest einai:"+this.dest);
        
    }

}
