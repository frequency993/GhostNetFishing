import java.io.Serializable;

public class Geisternetz implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Eigenschaften von Geisternetzen
	private GPS gps;
	private int groesse;
	private int lfdNr;
	private MeldendePerson meldendePerson;
	private Person verschollenMeldendePerson;
	private BergendePerson bergendePerson;
	private Status status;
	
//	Leerer Public Konstruktor
	public Geisternetz() {
	}

	// Konstruktor mit Parametern
	public Geisternetz(int lfdNr, Double breitengrad, Double laengengrad, int groesse, Status status, MeldendePerson meldendePerson) {
		this.gps = new GPS(breitengrad, laengengrad);
		this.groesse = groesse;
		this.status = status;
		this.meldendePerson = meldendePerson;
		this.lfdNr = lfdNr;
	}

	// Getter und Setter

	public int getLfdNr() {
		return lfdNr;
	}

	public void setLfdNr(int lfdNr) {
		this.lfdNr = lfdNr;
	}


	public int getGroesse() {
		return groesse;
	}

	public void setGroesse(int groesse) {
		this.groesse = groesse;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public MeldendePerson getMeldendePerson() {
		return meldendePerson;
	}

	public void setMeldendePerson(MeldendePerson meldendePerson) {
		this.meldendePerson = meldendePerson;
	}

	public Person getVerschollenMeldendePerson() {
		return verschollenMeldendePerson;
	}

	public void setVerschollenMeldendePerson(Person verschollenMeldendePerson) {
		this.verschollenMeldendePerson = verschollenMeldendePerson;
	}

	public BergendePerson getBergendePerson() {
		return bergendePerson;
	}

	public void setBergendePerson(BergendePerson bergendePerson) {
		this.bergendePerson = bergendePerson;
	}

	public GPS getGps() {
		return gps;
	}

	public void setGps(GPS gps) {
		this.gps = gps;
	}	
}
