/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viewFiles;

import controllers.TreeController;
import controllers.ViewFilesController;
import java.io.File;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.tools.FileObject;
import org.eclipse.persistence.sessions.Project;
import org.eclipse.persistence.tools.file.FileUtil;

/**
 *
 * @author vasovourka
 */
public class ViewFacade {
    private File file;
    public void initializeTree(JTable filesTable, JTree filesTree,
            JTextField pathText)
    {
        /*          File[] roots = File.listRoots();
        System.out.println("Root directories in your system are:");
        for (File root : roots) {
        System.out.println(root.toString());
        file = new File(root.toString());
        }*/
        //String userHome = System.getProperty( "user.home" );
        String userHome = System.getProperty("user.dir");
        File file = new File(userHome);
       
         ViewFilesController controller = new ViewFilesController();
        controller.listFilesFolder(file, filesTable, filesTree);
         TreeController.treeCreation(filesTree, file);
       // TreeController.treeInit(filesTree, file);
        pathText.setText(file.toString());
        
    }
  
    
}
