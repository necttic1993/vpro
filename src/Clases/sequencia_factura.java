package Clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.*;

public class sequencia_factura extends DefaultTableCellRenderer {

    private final int columna_patron;

    public sequencia_factura(int Colpatron) {
        this.columna_patron = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col) {

        Font font = new Font("Courier", Font.BOLD, 16);

        switch (table.getValueAt(row, columna_patron).toString()) {

            case "001":
                setBackground(Color.CYAN);
                setForeground(Color.black);
                setFont(font);
                break;
            case "002":
                setBackground(Color.green);
                setForeground(Color.black);
                setFont(font);
                break;

            default:
                break;
        }
        super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);
        return this;

    }

}
