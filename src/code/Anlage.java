package code;

public class Anlage
{

  private String bezeichnug;
  private int ak;
  private int inbetriebnahme;
  private int nd;

  public Anlage(String line)
  {
    String[] parts = line.split(",");
    bezeichnug = parts[0];
    ak = Integer.parseInt(parts[1]);
    inbetriebnahme = Integer.parseInt(parts[2]);
    nd = Integer.parseInt(parts[3]);
  }

  public String getBezeichnug()
  {
    return bezeichnug;
  }

  public int getAk()
  {
    return ak;
  }

  public int getInbetriebnahme()
  {
    return inbetriebnahme;
  }

  public int getNd()
  {
    return nd;
  }

  public String toCSV()
  {
    return String.format("%s,%d,%d,%d", bezeichnug, ak, inbetriebnahme, nd);
  }

}
