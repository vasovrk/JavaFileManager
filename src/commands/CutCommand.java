/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import controllers.ActionEnum;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author vasovourka
 */
public class CutCommand implements ICommand {

    private String source;
    private String dest;
    private String name;
    private String path;
    private ActionEnum type;

    public CutCommand(ActionEnum type, String path, String name) {
        this.source = path + name;
        this.name = name;
    }

    @Override
    public void undo() {
//        File sourceFile = new File(source);
//        File destFile = new File(dest);
//        if (destFile.isDirectory()) {
//            try {
//                FileUtils.moveDirectory(destFile, sourceFile);
//            } catch (IOException ex) {
//                Logger.getLogger(CutCommand.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else if (destFile.isFile()) {
//            try {
//                FileUtils.moveFile(destFile, sourceFile);
//            } catch (IOException ex) {
//                Logger.getLogger(CutCommand.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }

    @Override
    public void perform() {
        File sourceFile = new File(source);
        File destFile = new File(dest);
        if (sourceFile.isDirectory()) {
            try {
                FileUtils.moveDirectory(sourceFile, destFile);
            } catch (IOException ex) {
                Logger.getLogger(CutCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (sourceFile.isFile()) {
            try {
                FileUtils.moveFile(sourceFile, destFile);
            } catch (IOException ex) {
                Logger.getLogger(CutCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void redo() {
        perform();
    }

    public void setDest(String dest) {
        this.dest = dest + name;
        System.out.println("to dest einai:" + this.dest);
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
        return ActionEnum.CUT;
    }

}
