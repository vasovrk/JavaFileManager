/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import controllers.ActionEnum;

/**
 *
 * @author vasovourka
 */
public interface ICommand {

    String getName();

    String getSource();

    ActionEnum getType();
    
    void undo();
    
    void redo();
    
    void perform();
    
}
