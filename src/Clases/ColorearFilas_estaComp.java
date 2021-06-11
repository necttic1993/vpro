package Clases;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class ColorearFilas_estaComp extends DefaultTableCellRenderer {

    private final int columna_patron;

    public ColorearFilas_estaComp(int Colpatron) {
        this.columna_patron = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col) {
        Font font = new Font("Courier", Font.BOLD, 16);
        switch (table.getValueAt(row, columna_patron).toString()) {

            case "FINALIZADA":
                setBackground(Color.white);
                setForeground(Color.red);
                setFont(font);
                break;
            case "CONFIRMADA":
                setBackground(Color.green);
                setForeground(Color.BLACK);
                setFont(font);
                break;
         
            default:
                break;
        }
        super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);
        return this;
    }

}
