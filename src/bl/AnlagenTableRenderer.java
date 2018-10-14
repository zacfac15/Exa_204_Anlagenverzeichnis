package bl;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class AnlagenTableRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Anlage a = (Anlage) value;
        JLabel label = new JLabel();
        label.setOpaque(false);

        switch (column) {
            case 0:
                label.setText(a.getBezeichnug());
                break;
            case 1:
                label.setText(String.format("%,d", a.getAk()));
                break;
            case 2:
                label.setText(a.getInbetriebnahme() + "");
                break;
            case 3:
                label.setText(a.getNd() + "");
                break;
            case 4:
                double bishNd = a.getBishND(AnlageModel.jahr);

                if (bishNd == 0) {
                    label.setForeground(Color.RED);
                }
                label.setText(String.format("%,.2f", bishNd));
                break;
            case 5:
                double afaBish = a.getAfaBish(AnlageModel.jahr);

                if (afaBish == 0) {
                    label.setForeground(Color.RED);
                }
                label.setText(String.format("%,.2f", afaBish));
                break;
            case 6:
                double bwStart = a.getBWStartOfYear(AnlageModel.jahr);

                if (bwStart == 0) {
                    label.setForeground(Color.RED);
                }

                label.setText(String.format("%,.2f", bwStart));
                break;
            case 7:
                double afaThisYear = a.getAfaThisYear(AnlageModel.jahr);

                if (afaThisYear == 0) {
                    label.setForeground(Color.RED);
                }

                label.setText(String.format("%,.2f", afaThisYear));
                break;
            case 8:
                double bwEndYear = a.getBWEndOfYear(AnlageModel.jahr);

                if (bwEndYear == 0) {
                    label.setForeground(Color.RED);
                }

                label.setText(String.format("%,.2f", bwEndYear));
                break;
        }

        return label;
    }

}
