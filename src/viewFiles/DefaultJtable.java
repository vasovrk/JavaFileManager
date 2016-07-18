/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewFiles;

import javax.swing.JTable;

/**
 *
 * @author vasovourka
 */
public class DefaultJtable {

    public static JTable defaultJtable(JTable table) {

        int rows = table.getRowCount();
        //System.out.println("rows=" + rows);
        int row = 0;
        while (row < rows) {
            for (int col = 0; col <= 2; col++) {
                table.setValueAt("", row, col);
            }
            row++;
        }
        table.clearSelection();
        return table;
    }

}
