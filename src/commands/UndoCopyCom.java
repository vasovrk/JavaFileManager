/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import controllers.ActionEnum;
import java.io.File;
import java.util.Stack;
import static org.eclipse.persistence.tools.file.FileUtil.delete;

/**
 *
 * @author vasovourka
 */
public class UndoCopyCom implements ICommand {
        private Stack<ICommand> stUndo,stRedo;
        public UndoCopyCom (Stack<ICommand> stUndo,Stack<ICommand> stRedo){
            this.stUndo=stUndo;
            this.stRedo=stRedo;
        }
    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSource() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ActionEnum getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void undo() {
        undoCopy(stUndo,stRedo);
    }

    @Override
    public void redo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void perform() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public static void undoCopy(Stack<ICommand> stUndo, Stack<ICommand> stRedo) {
        ICommand newComPaste = stUndo.pop();
        System.out.println("sourcepath:" + newComPaste.getSource());
        ICommand newComCopy = stUndo.pop();
        System.out.println("destpath:" + newComCopy.getSource());
        //File file = new File(newComPaste.getSource());
        controllers.MoveFileController.move(newComPaste.getSource(), newComCopy.getSource());
        //delete(file);
        stRedo.push(newComPaste);
        stRedo.push(newComCopy);
    }
}
