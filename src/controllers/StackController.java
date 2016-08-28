/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import commands.Command;
import java.io.File;
import java.util.Stack;
import static org.eclipse.persistence.tools.file.FileUtil.delete;

/**
 *
 * @author vasovourka
 */
public class StackController {

    public static Stack undoCut(Stack<Command> stUndo, Stack<Command> stRedo) {
        Command newCom;
        Command newComPaste = stUndo.pop();
        System.out.println(stUndo);
        System.out.println("sourcepath:" + newComPaste.getSource());
        Command newComCut = (Command) stUndo.pop();
        System.out.println("destpath:" + newComCut.getSource());
//        controllers.MoveFileController.move(newComPaste.getSource(), newComCut.getSource());
        //System.out.println(stUndo);
        stRedo.push(newComPaste);
        stRedo.push(newComCut);
        return stUndo;
    }

    public static Stack redoCut(Stack<Command> stUndo, Stack<Command> stRedo) {
        Command newComCut = stRedo.pop();
        Command newComPaste = stRedo.pop();
//        controllers.MoveFileController.move(newComCut.getSource(), newComPaste.getSource());
        stUndo.push(newComCut);
        stUndo.push(newComPaste);
        return stRedo;
    }

    public static void undoCopy(Stack<Command> stUndo, Stack<Command> stRedo) {
        Command newComPaste = stUndo.pop();
        System.out.println("sourcepath:" + newComPaste.getSource());
        Command newComCopy = stUndo.pop();
        System.out.println("destpath:" + newComCopy.getSource());
        File file = new File(newComPaste.getSource());
//        controllers.MoveFileController.move(newComPaste.getSource(), newComCopy.getSource());
        //delete(file);
        stRedo.push(newComPaste);
        stRedo.push(newComCopy);
    }
}
