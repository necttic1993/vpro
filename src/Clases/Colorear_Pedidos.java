package Clases;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class Colorear_Pedidos extends DefaultTableCellRenderer {

    private final int columna_patron;

    public Colorear_Pedidos(int Colpatron) {
        this.columna_patron = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col) {

        Font font = new Font("Courier", Font.BOLD, 16);

        switch (table.getValueAt(row, columna_patron).toString()) {

            case "En Espera":
                setBackground(Color.white);
                setForeground(Color.red);
                setFont(font);
                break;
            case "Confirmado":
                setBackground(Color.GREEN);
                setForeground(Color.BLACK);
                setFont(font);
                break;
            case "En Proceso":
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
