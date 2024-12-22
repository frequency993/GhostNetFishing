import java.io.Serializable;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
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
		Geisternetz tempNetz = new Geisternetz(tempLfdNr, breitengrad, laengengrad, groesse, Status.GEMELDET, tempMelder);
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
	
	// Eigener Laengengrad-Validator
	public void validateLaengengrad(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		// Regex-Prüfung: Dezimalzahl mit mindestens 3 Nachkommastellen
		// Wert in einen String umwandeln für RegEx-Überprüfung
	    String eingabeWert = value.toString();

	    if (!eingabeWert.matches("^-?\\d*\\.\\d{3,}$")) {
	        throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
	            "Längengrad muss eine Dezimalzahl mit mindestens 3 Nachkommastellen sein.", null));
	    }
	    
	    // Value in double casten
	    double doubleWert = (double) value;
	    // Bereichsprüfung: Wert zwischen -180 und 180
	    if (doubleWert < -180 || doubleWert > 180) {
	        throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
	            "Der Wert muss zwischen -180 und 180 liegen.", null));
	    }
	}
	
	// Eigener Breitengrad-Validator
	public void validateBreitengrad(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		// Regex-Prüfung: Dezimalzahl mit mindestens 3 Nachkommastellen
		// Wert in einen String umwandeln für RegEx-Überprüfung
	    String eingabeWert = value.toString();

	    if (!eingabeWert.matches("^-?\\d*\\.\\d{3,}$")) {
	        throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
	            "Längengrad muss eine Dezimalzahl mit mindestens 3 Nachkommastellen sein.", null));
	    }
	    
	    // Value in double casten
	    double doubleWert = (double) value;
	    // Bereichsprüfung: Wert zwischen -90 und 90
	    if (doubleWert < -90 || doubleWert > 90) {
	        throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, 
	            "Der Wert muss zwischen -90 und 90 liegen.", null));
	    }
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