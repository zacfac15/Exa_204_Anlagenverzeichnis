package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class AnlageModel extends AbstractTableModel {

    private ArrayList<Anlage> anlagen = new ArrayList<>();
    private int year;

    private static final String[] colNames = {"Bezeichnung", "AK", "Inbetriebnahme", "ND", "bish. ND", "AfA bisher", "Wert vor Afs", "AfA d. J.", "BW 31.12"};

    public void addAnlage(Anlage a) {
        anlagen.add(a);
    }

    public void saveFile() throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("anlagenverzeichnis.csv"))) {
            bw.write("");
            for (Anlage a : anlagen) {
                bw.append(a.toCSV());
            }
        } catch (IOException e) {
            throw new Exception("Reading file failed: " + e.getMessage());
        }
    }

    public void loadFile() throws Exception {
        try (BufferedReader bw = new BufferedReader(new FileReader("anlagenverzeichnis.csv"))) {
            String line;

            while ((line = bw.readLine()) != null) {
                addAnlage(new Anlage(line));
            }
        } catch (IOException e) {
            throw new Exception("Loading file failed: " + e.getMessage());
        }
    }

    public void updateTable(int year) {
        
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
        Anlage a = anlagen.get(rowIndex);
        return a;
    }
}
