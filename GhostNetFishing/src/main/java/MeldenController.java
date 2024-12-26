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
	private Geisternetz geisternetz = new Geisternetz();
	private MeldendePerson meldendePerson = new MeldendePerson();
	
	@Inject
	GeisternetzGesamtListe geisternetzGesamtListe;
	
	// Leerer Konstruktor
	public MeldenController() {
	}
	
	public void hinzufuegen() {
	    if (meldendePerson.getTelefonnummer() == null) {
		        meldendePerson.setIstAnonym(true);
		} else {
			meldendePerson.setIstAnonym(false);
		}
		
		int tempLfdNr = geisternetzGesamtListe.naechsteLfdNr();
		geisternetz.setLfdNr(tempLfdNr);
		geisternetz.setStatus(Status.GEMELDET);
		geisternetz.setMeldendePerson(meldendePerson);

		geisternetzGesamtListe.netzHinzufuegen(geisternetz);
		
		//Objekte zurücksetzen und dadurch auch Felder leeren.
		geisternetz = new Geisternetz();
		meldendePerson = new MeldendePerson();
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
	            "Breitengrad muss eine Dezimalzahl mit mindestens 3 Nachkommastellen sein.", null));
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
	public Geisternetz getGeisternetz() {
		return geisternetz;
	}

	public void setGeisternetz(Geisternetz geisternetz) {
		this.geisternetz = geisternetz;
	}

	public MeldendePerson getMeldendePerson() {
		return meldendePerson;
	}

	public void setMeldendePerson(MeldendePerson meldendePerson) {
		this.meldendePerson = meldendePerson;
	}

	public GeisternetzGesamtListe getGeisternetzGesamtListe() {
		return geisternetzGesamtListe;
	}

	public void setGeisternetzGesamtListe(GeisternetzGesamtListe geisternetzGesamtListe) {
		this.geisternetzGesamtListe = geisternetzGesamtListe;
	}
	
}