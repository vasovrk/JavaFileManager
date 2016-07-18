/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

/**
 *
 * @author vasovourka
 */
public class PasteCommand {
    //CopyCommand realCopy = (CopyCommand)comm;
   // realCopy.setDest(pathText.getText());
    private String dest;
    public PasteCommand(String path,String name){
        this.dest=path+name;
    }
//     public void setDest(String dest) {
//        /*        this.dest = dest + File.pathSeparator + name;*/
//        this.dest = dest + name;
//        System.out.println("to dest einai:"+this.dest);
//        
//    }
}
