import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // Oberklasse und Unterklassen haben eigene Tabellen und werden über Schlüssel gejoined.
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id; //technische ID für die Datenbank
	
	// Eigenschaften von Personen
	private String vorname;
	private String nachname;
	private String telefonnummer;
	
	// Leerer Public Konstruktor
	public Person() {
	}

	// Konstruktor mit Parametern, aktuell genutzt von BergendePerson
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}