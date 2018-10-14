package bl;

public class Anlage {

    private final String bezeichnug;
    private final int ak;
    private final double inbetriebnahme;
    private final double nd;

    public Anlage(String line) {
        String[] parts = line.split(";");
        bezeichnug = parts[0];
        ak = Integer.parseInt(parts[1].replace(".", ""));
        inbetriebnahme = Double.parseDouble(parts[2].replace(",", "."));
        nd = Double.parseDouble(parts[3].replace(",", "."));
    }

    public String getBezeichnug() {
        return bezeichnug;
    }

    public int getAk() {
        return ak;
    }

    public double getInbetriebnahme() {
        return inbetriebnahme;
    }

    public double getNd() {
        return nd;
    }

    public double getBishND(double jahr) {
        if (jahr < inbetriebnahme) {
            return 0;
        }
        return jahr - inbetriebnahme;
    }

    public double getAfaBish(double jahr) {
        if (getBishND(jahr) < 0) {
            return 0;
        }

        if (getBishND(jahr) > nd) {
            return ak;
        }

        return getBishND(jahr) * (ak / nd);
    }

    public double getAfaThisYear(double jahr) {
        if (getBishND(jahr) <= 0) {
            return 0;
        }

        if (getBishND(jahr) > nd) {
            return 0;
        }

        if (getBishND(jahr) < 0.6 || getBishND(jahr) > (nd - 0.6)) {
            return (ak / nd) / 2;
        }
        return ak / nd;
    }

    public double getBWStartOfYear(double jahr) {
        if (getBishND(jahr) < 0) {
            return 0;
        }
        if (getBishND(jahr) > nd) {
            return 0;
        }
        return ak - getAfaBish(jahr);
    }

    public double getBWEndOfYear(double jahr) {
        return getBWStartOfYear(jahr) - getAfaThisYear(jahr);
    }
}
