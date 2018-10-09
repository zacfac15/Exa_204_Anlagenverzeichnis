package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AnlageModel extends AbstractTableModel
{

  private List<Anlage> anlagen = new LinkedList<>();
  private int year;

  @Override
  public int getRowCount()
  {
    return anlagen.size();
  }

  @Override
  public int getColumnCount()
  {
    return 9;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex)
  {
     Anlage a = anlagen.get(rowIndex);
     
     switch(columnIndex)
     {
       case 0: return 0;
       default : return 0;
     }
  }

  public void addAnlage(Anlage a)
  {
    anlagen.add(a);
  }

  public void saveFile() throws Exception
  {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("anlagenverzeichnis.csv")))
    {
      bw.write("");
      for (Anlage a : anlagen)
      {
        bw.append(a.toCSV());
      }
    }
    catch (IOException e)
    {
      throw new Exception("Reading file failed: " + e.getMessage());
    }
  }

  public void loadFile() throws Exception
  {
    try (BufferedReader bw = new BufferedReader(new FileReader("anlagenverzeichnis.csv")))
    {
      String line;

      while ((line = bw.readLine()) != null)
      {
        addAnlage(new Anlage(line));
      }
    }
    catch (IOException e)
    {
      throw new Exception("Loading file failed: " + e.getMessage());
    }
  }

  public void updateTable(int year)
  {

  }
}
