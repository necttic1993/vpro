package Clases;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class ColorearStatusPresupuesto extends DefaultTableCellRenderer {

    private final int columna_patron;

    public ColorearStatusPresupuesto(int Colpatron) {
        this.columna_patron = Colpatron;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean Selected, boolean hasFocus, int row, int col) {

        Font font = new Font("Courier", Font.BOLD, 16);

        switch (table.getValueAt(row, columna_patron).toString()) {

            case "EMITIDO":
                setBackground(Color.BLUE);
                setForeground(Color.WHITE);
                setFont(font);
                break;
            case "CONFIRMADO":
                setBackground(Color.GREEN);
                setForeground(Color.BLACK);
                setFont(font);
                break;
            case "CANCELADO":
                setBackground(Color.RED);
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
