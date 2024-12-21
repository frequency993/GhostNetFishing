import java.io.Serializable;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class MeldenController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Deklarationen
	private String vorname;
	private String nachname ;
	private String telefonnummer;
	private Double breitengrad;
	private Double laengengrad;
	private Integer groesse;
	
	@Inject
	GeisternetzGesamtListe geisternetzGesamtListe;
	
	// Leerer Konstruktor
	public MeldenController() {
	}
	
	public void hinzufuegen() {
		boolean tmpIstAnonym = false;
	    if (telefonnummer == null) {
	        vorname = "Anonym";
	        nachname = "Anonym";
	        telefonnummer = "Anonym";
	        tmpIstAnonym = true;
	    }
	    
		MeldendePerson tempMelder = new MeldendePerson(vorname, nachname, telefonnummer,tmpIstAnonym);
		
		int tempLfdNr = geisternetzGesamtListe.naechsteLfdNr();
		Geisternetz tempNetz = new Geisternetz(tempLfdNr, breitengrad, laengengrad, groesse, "Gemeldet", tempMelder);
		geisternetzGesamtListe.netzHinzufuegen(tempNetz);
		felderLeeren();
	}
	
	public void felderLeeren() {
		this.vorname = null;
		this.nachname = null;
		this.telefonnummer = null;
		this.breitengrad = null;
		this.laengengrad = null;
		this.groesse = null;
	}

	// Getter und Setter
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

	public Double getBreitengrad() {
		return breitengrad;
	}

	public void setBreitengrad(Double breitengrad) {
		this.breitengrad = breitengrad;
	}

	public Double getLaengengrad() {
		return laengengrad;
	}

	public void setLaengengrad(Double laengengrad) {
		this.laengengrad = laengengrad;
	}

	public Integer getGroesse() {
		return groesse;
	}

	public void setGroesse(Integer groesse) {
		this.groesse = groesse;
	}
	
}