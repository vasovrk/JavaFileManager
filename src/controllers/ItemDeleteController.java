/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

import java.awt.event.ActionEvent;

/**
 *
 * @author vasovourka
 */
public class ItemDeleteController {
    public static void action(ActionEvent evt,String path,String name){
         if (evt.getActionCommand().equals("delete")) {
            System.out.println("delete pressed");
            //name = viewFiles.selectedCell.selected(filesTable);

            controllers.DeleteFileController.delete1(path, name);
        }

    }
}
