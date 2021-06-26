package Clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.*;

public class staus_factura extends DefaultTableCellRenderer {

    private final int columna_patron;

    public staus_factura(int Colpatron) {
        this.columna_patron = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col) {

        Font font = new Font("Courier", Font.BOLD, 16);

        switch (table.getValueAt(row, columna_patron).toString()) {

            
            case "CANCELADA":
                setBackground(Color.GREEN);
                setForeground(Color.BLACK);
                setFont(font);
                break;
            case "ANULADA":
                setBackground(Color.RED);
                setForeground(Color.white);
                setFont(font);
                break;
            case "PENDIENTE":
                setBackground(Color.ORANGE);
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
