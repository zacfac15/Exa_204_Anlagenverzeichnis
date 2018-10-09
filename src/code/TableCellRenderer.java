package code;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;

public class TableCellRenderer implements javax.swing.table.TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Anlage a = (Anlage) value;
        JLabel label = new JLabel();
        label.setOpaque(true);

        switch (column) {
            case 0:
                label.setText(a.getBezeichnug());
                break;
            case 1:
                label.setText(a.getAk() + "");
                break;
            case 2:
                label.setText(a.getInbetriebnahme() + "");
                break;
            case 3:
                label.setText(a.getNd() + "");
                break;
        }

        return label;
    }

}
