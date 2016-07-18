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
public class Command implements ICommand {
    
    private ActionEnum type;
    private String source;
    private String filename;
    public Command(ActionEnum type, String path, String name) {
        this.type = type;
        this.source = path + name;
        this.filename = name;
        
    }

    @Override
    public String getName() {
        return filename; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSource() {
        return source;
    }

    @Override
    public ActionEnum getType() {
        return type;
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void redo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void perform() {
        System.out.println("to perform den iparxei");
    }

  
    
}
