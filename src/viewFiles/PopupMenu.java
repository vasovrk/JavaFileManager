/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package viewFiles;

import javax.swing.JPopupMenu;
import javax.swing.JTable;

/**
 *
 * @author vasovourka
 */
public class PopupMenu {
    public static void popupAction(java.awt.event.MouseEvent evt,JPopupMenu popUp){
    if (evt.isPopupTrigger()) {
            JTable source = (JTable) evt.getSource();
            int row = source.rowAtPoint(evt.getPoint());
            int column = source.columnAtPoint(evt.getPoint());

            if (!source.isRowSelected(row)) {
                source.changeSelection(row, column, false, false);
            }
            popUp.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }
}
