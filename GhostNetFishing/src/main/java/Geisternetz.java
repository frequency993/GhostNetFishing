import java.io.Serializable;

import jakarta.persistence.*;

@Entity
public class Geisternetz implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; //technische ID für die Datenbank
    
	// Eigenschaften von Geisternetzen
    @OneToOne(cascade = CascadeType.PERSIST)
	private GPS gps = new GPS();
    
	private Integer groesse;
	private int lfdNr;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private MeldendePerson meldendePerson;

	@OneToOne(cascade = CascadeType.MERGE)
	private MeldendePerson verschollenMeldendePerson;
	
	@ManyToOne
	private BergendePerson bergendePerson;
	private Status status;
	
//	Leerer Public Konstruktor
	public Geisternetz() {
	}

	// Getter und Setter

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLfdNr() {
		return lfdNr;
	}

	public void setLfdNr(int lfdNr) {
		this.lfdNr = lfdNr;
	}

	public Integer getGroesse() {
		return groesse;
	}

	public void setGroesse(Integer groesse) {
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
		this.verschollenMeldendePerson = (MeldendePerson) verschollenMeldendePerson;
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
