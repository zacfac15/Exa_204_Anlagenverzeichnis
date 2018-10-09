package code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AnlageModel
{

  private ArrayList<Anlage> anlagen = new ArrayList<>();
  private int year;

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
