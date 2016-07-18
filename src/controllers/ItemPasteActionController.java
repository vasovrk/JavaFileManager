/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import commands.CopyCommand;
import commands.CutCommand;
import commands.ICommand;
import java.awt.event.ActionEvent;
import java.util.Stack;

/**
 *
 * @author vasovourka
 */
public class ItemPasteActionController {

    public static boolean action(ICommand command, String destPath) {
        String dest;
        boolean res;
        /*CutCommand c2 = (CutCommand) command;
        c2.setDest(destPath);*/
        switch (command.getType()) {
            case COPY:
                CopyCommand c = (CopyCommand) command;
                c.setDest(destPath);
                break;
            case CUT:
                CutCommand c2=(CutCommand) command;
                c2.setDest(destPath);
                break;
        }

        System.out.println("paste pressed");
        // name2 = viewFiles.selectedCell.selected(filesTable);
        System.out.println("to name einaiiiiiii=" + command.getName());
        dest = destPath + command.getName();
        // pasteItem(destPath);
        System.out.println("to action einaiiiiiii:" + command.getType());
        System.out.println("to name einahsdfhskj:" + command.getName());
        System.out.println("to dest path einaiiiii:" + dest);
        System.out.println("to source path einaiiii" + command.getSource());
        res=ActionController.action(command, dest);
        return res;
    }

}
