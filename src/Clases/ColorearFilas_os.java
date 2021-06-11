package Clases;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class ColorearFilas_os extends DefaultTableCellRenderer {

    private final int columna_patron;

    public ColorearFilas_os(int Colpatron) {
        this.columna_patron = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col) {
        Font font = new Font("Courier", Font.BOLD, 16);
        switch (table.getValueAt(row, columna_patron).toString()) {

            case "ANULADO":
                setBackground(Color.RED);
                setForeground(Color.BLACK);
                setFont(font);
                break;
            case "RECEPCION":
                setBackground(Color.WHITE);
                setForeground(Color.BLUE);
                setFont(font);
                break;
            case "PAGADO":
                setBackground(Color.LIGHT_GRAY);
                setForeground(Color.BLUE);
                setFont(font);
                break;
            case "TEST":
                setBackground(Color.CYAN);
                setForeground(Color.BLACK);
                setFont(font);
                break;
            case "LABORATORIO":
                setBackground(Color.BLUE);
                setForeground(Color.white);
                setFont(font);
                break;
            case "REPARADO":
                setBackground(Color.YELLOW);
                setForeground(Color.BLACK);
                setFont(font);
                break;
            case "ENTREGADO":
                setBackground(Color.GREEN);
                setForeground(Color.BLACK);
                setFont(font);
                break;
            case "SIN SOLUCION":
                setBackground(Color.white);
                setForeground(Color.RED);
                setFont(font);
                break;
            default:
                break;
        }
        super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);
        return this;
    }

}
