import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Eigenschaften von Personen
	private String vorname;
	private String nachname;
	private String telefonnummer;
	
	// Leerer Public Konstruktor
	public Person() {
	}
	
	// Konstruktor mit Attributen
	public Person(String vorname, String nachname, String telefonnummer) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.telefonnummer = telefonnummer;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}	
}