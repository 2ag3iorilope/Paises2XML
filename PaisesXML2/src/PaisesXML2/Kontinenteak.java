package PaisesXML2;

/**
 * The Class Kontinenteak.
 */
public class Kontinenteak {

	/** Kontinentearen izena. */
	String izenaString;

	/** Kontinentearen superfiziea. */
	double superficie;

	/** Kontinentearen Herri Kopurua. */
	int Pais_Kop;

	/** Kontinenteko Poblazioa. */
	long Poblazioa;

	/**
	 * Instantiates a new kontinenteak.
	 *
	 * @param Izena       , kontinentearen izena
	 * @param superficie, kontinenetaren superfiziea
	 * @param PaisKop     , kontinentearen herri kopurua
	 * @param poblazioa   , kontinenteko poblazioa
	 */
	public Kontinenteak(String Izena, double superficie, int PaisKop, long poblazioa) {
		this.izenaString = Izena;
		this.superficie = superficie;
		this.Pais_Kop = PaisKop;
		this.Poblazioa = poblazioa;

	}

	/**
	 * Kontinentearen izena lortzen du.
	 *
	 * @return kontinentearen izena
	 */
	public String getIzenaString() {
		return izenaString;
	}

	/**
	 * Kontinentearen izena ezartzen du.
	 *
	 * @param izenaString , kontinentearen izena
	 */
	public void setIzenaString(String izenaString) {
		this.izenaString = izenaString;
	}

	/**
	 * kontinentearen superfiziea lortzen du.
	 *
	 * @return kontinentearen superfiziea
	 */
	public double getSuperficie() {
		return superficie;
	}

	/**
	 * Kontinentearen superfiziea ezartzen du
	 *
	 * @param superficie, kontinentearen superfiziea
	 */
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	/**
	 * Kontinentearen herri kopurua lortzen du
	 *
	 * @return kontinentearen herri kopurua
	 */
	public int getPais_Kop() {
		return Pais_Kop;
	}

	/**
	 * Kontinentearen herri kopurua ezartzen du
	 *
	 * @param pais_Kop , kontinentearen herri kopurua
	 */
	public void setPais_Kop(int pais_Kop) {
		Pais_Kop = pais_Kop;
	}

	/**
	 * Kontinentearen poblazioa lortzen du
	 *
	 * @return kontinentearen poblazioa
	 */
	public long getPoblazioa() {
		return Poblazioa;
	}

	/**
	 * Kontinentearen poblazioa ezartzen du
	 *
	 * @param poblazioa , kontinentearen poblazioa
	 */
	public void setPoblazioa(long poblazioa) {
		Poblazioa = poblazioa;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Kontinentea: " + izenaString + ", Superfiziea: " + superficie + " km², Herria: " + Pais_Kop
				+ ", Poblazioa: " + Poblazioa + " pertsona.";
	}

}
