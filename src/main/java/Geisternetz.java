import java.io.Serializable;

public class Geisternetz implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Eigenschaften von Geisternetzen
	private double breitengrad;
	private double laengengrad;
	private int groesse;
	private int lfdNr;
	private MeldendePerson meldendePerson;
	private Person verschollenMeldendePerson;
	private Person bergendePerson;
	private Status status;
	
//	Leerer Public Konstruktor
	public Geisternetz() {
	}

	// Konstruktor mit Parametern
	public Geisternetz(int lfdNr, double breitengrad, double laengengrad, int groesse, Status status, MeldendePerson meldendePerson) {
		super();
		this.breitengrad = breitengrad;
		this.laengengrad = laengengrad;
		this.groesse = groesse;
		this.status = status;
		this.meldendePerson = meldendePerson;
		this.lfdNr = lfdNr;
	}

	// Getter und Setter
	
	public double getBreitengrad() {
		return breitengrad;
	}

	public int getLfdNr() {
		return lfdNr;
	}

	public void setLfdNr(int lfdNr) {
		this.lfdNr = lfdNr;
	}

	public void setBreitengrad(double breitengrad) {
		this.breitengrad = breitengrad;
	}

	public double getLaengengrad() {
		return laengengrad;
	}

	public void setLaengengrad(double laengengrad) {
		this.laengengrad = laengengrad;
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

	public Person getBergendePerson() {
		return bergendePerson;
	}

	public void setBergendePerson(Person bergendePerson) {
		this.bergendePerson = bergendePerson;
	}	
}
