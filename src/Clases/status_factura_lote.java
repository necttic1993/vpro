package Clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.*;

public class status_factura_lote extends DefaultTableCellRenderer {

    private final int columna_patron;

    public status_factura_lote(int Colpatron) {
        this.columna_patron = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col) {

        Font font = new Font("Courier", Font.BOLD, 16);

        switch (table.getValueAt(row, columna_patron).toString()) {

            case "1":
                setBackground(Color.white);
                setForeground(Color.blue);
                setFont(font);
                break;
            case "2":
                setBackground(Color.YELLOW);
                setForeground(Color.black);
                setFont(font);
                break;
            case "3":
                setBackground(Color.blue);
                setForeground(Color.white);
                setFont(font);
                break;
            case "4":
                setBackground(Color.blue);
                setForeground(Color.white);
                setFont(font);
                break;
            case "5":
                setBackground(Color.blue);
                setForeground(Color.white);
                setFont(font);
                break;
            default:
                break;
        }
        super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);
        return this;

    }

}
