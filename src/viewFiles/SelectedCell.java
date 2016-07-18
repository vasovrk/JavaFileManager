/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewFiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author vasovourka
 */
public class SelectedCell {

    //static JMenuItem item1 = new JMenuItem("paste");
    public static String selected(JTable table) {
        int rows = table.getRowCount();
        //System.out.println("rows=" + rows);
        int row = 0;
        int col = 0;
        String str = null ;

        while (row < rows) {

            if (table.isCellSelected(row, col)) {
                TableModel tabModel = table.getModel();
                System.out.println(tabModel.getValueAt(row, col));
                /*  item1.addActionListener(new ActionListener() {
                 public void actionPerformed(java.awt.event.ActionEvent evt) {
                 JFileChooser chooser = new JFileChooser();
                 chooser.showOpenDialog(null);
                 System.out.println("paste clicked!!!");
                 System.out.println(evt.getActionCommand());
                 }
                 }
                 );*/
                 str = "/"+tabModel.getValueAt(row, col).toString();
                
                //   controllers.MoveFileController.move(tabModel.getValueAt(row, col).toString());
                 
            }

            row++;
        }
        return str;
    }
}
