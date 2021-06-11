package Clases;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class ColorearFilas_Servicios extends DefaultTableCellRenderer {

    private final int columna_patron;

    public ColorearFilas_Servicios(int Colpatron) {
        this.columna_patron = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col) {
        Font font = new Font("Courier", Font.BOLD, 16);
        switch (table.getValueAt(row, columna_patron).toString()) {

            case "EN ESPERA":
                setBackground(Color.RED);
                setForeground(Color.BLACK);
                setFont(font);
                break;
            case "EN PROCESO":
                setBackground(Color.BLUE);
                setForeground(Color.WHITE);
                setFont(font);
                break;
            case "FINALIZADO":
                setBackground(Color.GREEN);
                setForeground(Color.WHITE);
                setFont(font);
                break;
            
            default:
                break;
        }
        super.getTableCellRendererComponent(table, value, Selected, hasFocus, row, col);
        return this;
    }

}
