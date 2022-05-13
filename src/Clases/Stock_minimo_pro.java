package Clases;

import Ventas.Ventas_venta;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.*;

public class Stock_minimo_pro extends DefaultTableCellRenderer {

    int columna_patron;
    int columna_minimo;

    public Stock_minimo_pro(int tipo, int mini) {
        this.columna_patron = tipo;
        this.columna_minimo = mini;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col) {
        Font font = new Font("Courier", Font.BOLD, 16);
        String valor = (table.getValueAt(row, columna_patron).toString());
        String minimo = (table.getValueAt(row, columna_minimo).toString());
        int stock = Integer.parseInt(valor);
        int existe = Integer.parseInt(minimo);
        int cont = 1;

        if (stock < existe && stock >= cont) {
            setBackground(Color.ORANGE);
            setForeground(Color.black);
            setFont(font);
            Ventas_venta.pro_bloq = "1";
        } else if (stock < cont) {
            setBackground(Color.red);
            setForeground(Color.white);
            setFont(font);
            Ventas_venta.pro_bloq = "1";
        } else {
            setBackground(Color.white);
            setForeground(Color.BLACK);
            setFont(font);

        }

        super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);
        return this;

    }

}
