package PaisesXML2;

public class Kontinenteak {

	String izenaString;
	double superficie;
	int Pais_Kop;
	long Poblazioa;

	public Kontinenteak(String Izena, double superficie, int PaisKop, long poblazioa) {
		this.izenaString = Izena;
		this.superficie = superficie;
		this.Pais_Kop = PaisKop;
		this.Poblazioa = poblazioa;

	}

	public String getIzenaString() {
		return izenaString;
	}

	public void setIzenaString(String izenaString) {
		this.izenaString = izenaString;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public int getPais_Kop() {
		return Pais_Kop;
	}

	public void setPais_Kop(int pais_Kop) {
		Pais_Kop = pais_Kop;
	}

	public long getPoblazioa() {
		return Poblazioa;
	}

	public void setPoblazioa(long poblazioa) {
		Poblazioa = poblazioa;
	}

	@Override
	public String toString() {
		return "Kontinentea: " + izenaString + ", Superfiziea: " + superficie + " km², Herria: " + Pais_Kop
				+ ", Poblazioa: " + Poblazioa + " pertsona.";
	}

}
