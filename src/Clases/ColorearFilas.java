package Clases;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class ColorearFilas extends DefaultTableCellRenderer {

    private final int columna_patron;

    public ColorearFilas(int Colpatron) {
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
                setBackground(Color.GREEN);
                setForeground(Color.BLACK);
                setFont(font);
                break;
            case "DEVUELTO":
                setBackground(Color.CYAN);
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
