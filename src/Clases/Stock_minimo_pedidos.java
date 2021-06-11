package Clases;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.*;

public class Stock_minimo_pedidos extends DefaultTableCellRenderer {

    int columna_minimo;

    public Stock_minimo_pedidos(int mini) {

        this.columna_minimo = mini;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col) {
        Font font = new Font("Courier", Font.BOLD, 16);
        String minimo = (table.getValueAt(row, columna_minimo).toString());
        int existe = Integer.parseInt(minimo);
        int cont = 0;

        if (existe > cont) {
            setBackground(Color.green);
            setForeground(Color.black);
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
