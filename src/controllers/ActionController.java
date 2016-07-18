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
        /*System.out.println("to source path einaiiiii:\n" + command.getSource());
         System.out.println("to command einai : " + command.getType());*/
        command.perform();
        commandsPerformed.push(command);
//        return true;
////        System.out.println("to  commandsUndone einaiiii:" + commandsUndone.toString());
////
////        
////        boolean res = false;
//       switch (command.getType()) {
//           case CUT:
////                System.out.println("katalogos move" + dest);
////                controllers.MoveFileController.move(command.getSource(), dest);
////                res = true;
//                break;
//            case COPY:
//
//                System.out.println("katalogos copy" + dest);
//               // controllers.CopyFileController.copy1(command.getSource() , dest);
//                /*  ICommand copy=new CopyCommand(command.getSource(),dest);
//                 copy.perform();*/
//                break;
//        }
        if (commandsPerformed.isEmpty()) {
            res = false;

        }
        return res;
    }
}
