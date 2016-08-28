/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import commands.Command;
import commands.CopyCommand;
import commands.ICommand;
import static controllers.ActionEnum.COPY;
import static controllers.ActionEnum.CUT;
import java.util.Stack;

/**
 *
 * @author vasovourka
 */
public class ActionController {

    static Stack<ICommand> commandsPerformed = new Stack<>();
    static Stack<ICommand> commandsUndone = new Stack<>();

    public static ICommand popUndo() {
        ICommand command = commandsPerformed.pop();
        commandsUndone.push(command);
        return command;
    }

    public static ICommand popRedo() {
        ICommand command = commandsUndone.pop();
        commandsPerformed.push(command);
        return command;
    }

    public static boolean action(ICommand command, String dest) {
        boolean res = true;

        command.perform();
        commandsPerformed.push(command);
        if (commandsPerformed.isEmpty()) {
            res = false;

        }
        return res;
    }
}
