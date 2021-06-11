package Clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.*;

public class Stock_minimo extends DefaultTableCellRenderer {

    int columna_patron;

    public Stock_minimo(int tipo) {
        this.columna_patron = tipo;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col) {
        Font font = new Font("Courier", Font.BOLD, 16);
        String valor = (table.getValueAt(row, columna_patron).toString());
        if (valor.equals("0")) {
            setBackground(Color.white);
            setForeground(Color.red);
            setFont(font);
        } else {
            setBackground(Color.white);
            setForeground(Color.BLACK);
            setFont(font);
        }

        super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);
        return this;

    }

}
