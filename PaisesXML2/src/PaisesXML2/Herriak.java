package PaisesXML2;

import java.time.LocalDate;

public class Herriak {
	String kodeaString;
	String izenaString;
	int BiziEsperantza;
	LocalDate dataSortuDate;
	double poblazioa;
	String kapitala;
	Kontinenteak kontinentea;

	public Herriak(String kodeString, String Izena, int Biziesperantza, LocalDate Sortudata, double poblazioa,
			String kapitalaString, Kontinenteak kontinenteaKontinenteak) {

		this.kodeaString = kodeString;
		this.izenaString = Izena;
		this.BiziEsperantza = Biziesperantza;
		this.dataSortuDate = Sortudata;
		this.poblazioa = poblazioa;
		this.kapitala = kapitalaString;
		this.kontinentea = kontinenteaKontinenteak;

	}

	/**
	 * @return the kodeaString
	 */
	public String getKodeaString() {
		return kodeaString;
	}

	/**
	 * @param kodeaString the kodeaString to set
	 */
	public void setKodeaString(String kodeaString) {
		this.kodeaString = kodeaString;
	}

	/**
	 * @return the izenaString
	 */
	public String getIzenaString() {
		return izenaString;
	}

	/**
	 * @param izenaString the izenaString to set
	 */
	public void setIzenaString(String izenaString) {
		this.izenaString = izenaString;
	}

	/**
	 * @return the biziEsperantza
	 */
	public int getBiziEsperantza() {
		return BiziEsperantza;
	}

	/**
	 * @param biziEsperantza the biziEsperantza to set
	 */
	public void setBiziEsperantza(int biziEsperantza) {
		BiziEsperantza = biziEsperantza;
	}

	/**
	 * @return the dataSortuDate
	 */
	public LocalDate getDataSortuDate() {
		return dataSortuDate;
	}

	/**
	 * @param dataSortuDate the dataSortuDate to set
	 */
	public void setDataSortuDate(LocalDate dataSortuDate) {
		this.dataSortuDate = dataSortuDate;
	}

	/**
	 * @return the poblazioa
	 */
	public double getPoblazioa() {
		return poblazioa;
	}

	/**
	 * @param poblazioa the poblazioa to set
	 */
	public void setPoblazioa(double poblazioa) {
		this.poblazioa = poblazioa;
	}

	/**
	 * @return the kapitala
	 */
	public String getKapitala() {
		return kapitala;
	}

	/**
	 * @param kapitala the kapitala to set
	 */
	public void setKapitala(String kapitala) {
		this.kapitala = kapitala;
	}

	/**
	 * @return the kontinentea
	 */
	public Kontinenteak getKontinentea() {
		return kontinentea;
	}

	/**
	 * @param kontinentea the kontinentea to set
	 */
	public void setKontinentea(Kontinenteak kontinentea) {
		this.kontinentea = kontinentea;
	}

	@Override
	public String toString() {
		return "Herria: " + izenaString + " (" + kodeaString + "), Kapitala: " + kapitala + ", Bizi Esperantza: "
				+ BiziEsperantza + ", Sortze Data: " + dataSortuDate + ", Poblazioa: " + poblazioa + ", Kontinentea: "
				+ kontinentea.getIzenaString();
	}

}
