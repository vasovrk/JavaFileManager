/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import commands.ICommand;

/**
 *
 * @author vasovourka
 */
public class UndoController {
    public static void undo(ICommand com){
        ICommand command = ActionController.popUndo();
        command.undo();
    }
}
