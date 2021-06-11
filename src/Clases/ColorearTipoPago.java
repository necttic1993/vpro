package Clases;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class ColorearTipoPago extends DefaultTableCellRenderer {

    private final int columna_patron;

    public ColorearTipoPago(int Colpatron) {
        this.columna_patron = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col) {
        Font font = new Font("Courier", Font.BOLD, 16);
        switch (table.getValueAt(row, columna_patron).toString()) {

            case "CONTADO":
                setBackground(Color.white);
                setForeground(Color.black);
                setFont(font);
                break;
            case "CRÉDITO":
                setBackground(Color.blue);
                setForeground(Color.white);
                setFont(font);
                break;
            case "E-COMMERCE":
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
