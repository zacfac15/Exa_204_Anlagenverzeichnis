package bl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class AnlageModel extends AbstractTableModel {

    private final ArrayList<Anlage> anlagen = new ArrayList<>();
    private final String filename = "./anlagenverzeichnis.csv";
    public static int jahr;

    private static final String[] colNames = {"Bezeichnung", "AK", "Inbetriebnahme", "ND", "bish. ND", "AfA bisher", "Wert vor Afs", "AfA d. J.", "BW 31.12"};

    public void addAnlage(Anlage a) {
        anlagen.add(a);
    }

    @Override
    public String getColumnName(int i) {
        return colNames[i];
    }

    @Override
    public int getRowCount() {
        return anlagen.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return anlagen.get(rowIndex);
    }

    public void updateTable(int jahr) {
        AnlageModel.jahr = jahr;
        fireTableRowsUpdated(0, anlagen.size() - 1);
    }

    public void loadFile() throws Exception {
        try (BufferedReader bw = new BufferedReader(new FileReader(filename))) {
            String line;

            bw.readLine();
            while ((line = bw.readLine()) != null) {
                addAnlage(new Anlage(line));
            }
        } catch (IOException e) {
            throw new Exception(String.format("%s: %s", "Reading file failed", e.getMessage()));
        }
    }

}
