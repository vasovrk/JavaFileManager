/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewFiles;

import controllers.ViewFilesController;
import java.io.File;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;

/**
 *
 * @author vasovourka
 */
public class TableFacade {

    public static void selectedNode(JTable filesTable, JTree filesTree, JTextField pathText) {
        Object node = filesTree.getLastSelectedPathComponent();
        String name;
        name = (node == null) ? "NONE" : node.toString();
        System.out.println("selected node:" + node.toString());
        pathText.setText(node.toString());
        File file = new File(node.toString());
        if (!(file.isFile())) {
            filesTable = DefaultJtable.defaultJtable(filesTable);
            ViewFilesController controller = new ViewFilesController();
            controller.listFilesFolder(file, filesTable, filesTree);
        } else {
            System.out.println("is file cant be viewed");
        }
     
    }
    

}
