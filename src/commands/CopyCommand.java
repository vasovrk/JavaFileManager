/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import controllers.ActionEnum;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import static org.eclipse.persistence.tools.file.FileUtil.delete;

/**
 *
 * @author vasovourka
 */
public class CopyCommand implements ICommand {

    private String source, dest, name, path;
    private ActionEnum type;

    public CopyCommand(ActionEnum type, String path, String name) {
        this.source = path + name;
        this.name = name;
        //command(path,name);
    }

    public void setDest(String dest) {
        /*        this.dest = dest + File.pathSeparator + name;*/
        this.dest = dest + name;
        System.out.println("to dest einai:"+this.dest);
        
    }
    /*@Override
     public String getName() {
     return source;*/
      //  throw new UnsupportedOperationException("Not supported yet."); 
//To change body of generated methods, choose Tools | Templates.

    @Override
    public String getSource() {
        return source;
//  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ActionEnum getType() {
        return ActionEnum.COPY;
    }

    @Override
    public void undo() {
        File file = new File(dest);
        delete(file);
    }

    @Override
    public void redo() {
        perform();
    }

    @Override
    public void perform() {
        copy1();
    }

    private void copy1() {
        File srcFolder = new File(source);
        File destFolder = new File(dest);

        //elenxos an iparxei to arxeio
        if (!srcFolder.exists()) {
            System.out.println("to directory einaivvvv :" + source);
            System.out.println("Directory does not exists!");
        //System.exit(0);

        } else {
            try {
                copyFolder(srcFolder, destFolder);
            } catch (IOException e) {
                e.printStackTrace();
                //System.exit(0);

            }
        }
        System.out.println("Done!");
    }

    private static void copyFolder(File src, File dest)
            throws IOException {

        if (src.isDirectory()) {
            //if directory not exists Create it
            if (!dest.exists()) {
                dest.mkdir();
                System.out.println("Directory copied from:" + src + " to " + dest);

            }
            //list directory contents
            String files[] = src.list();

            for (String file : files) {
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);

                copyFolder(srcFile, destFile);
            }

        } else {
            //if file copy it 
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];

            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.close();
            System.out.println("File copied from:" + src + " to: " + dest);

        }

    }

    @Override
    public String getName() {
        return name;
    }
}
