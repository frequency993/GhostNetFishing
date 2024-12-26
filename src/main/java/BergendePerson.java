import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.persistence.Entity;

import org.mindrot.jbcrypt.BCrypt;

@Entity
@Named
@SessionScoped
public class BergendePerson extends Person implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Eigenschaften von Personen
	private String benutzerName;
	private String passwort;
	private static final BergendePersonDAO dao = new BergendePersonDAO();


	// Leerer Public Konstruktor
	public BergendePerson() {
	}
	
	// Passwörter werden mittels BCrypt gehashed und gesaltet!
	public BergendePerson(String vorname, String nachname, String telefonnummer, String benutzerName, String passwort) {
		super(vorname, nachname, telefonnummer);
		this.benutzerName = benutzerName;
		this.passwort = BCrypt.hashpw(passwort, BCrypt.gensalt());
		dao.speichern(this);
		System.out.println("BergendePerson: Person gespeichert mit Id: " + this.getId());
	}
	
	// Constructor für das temporäre Objekt "Bergende Person" für die Validierung
	public BergendePerson(String benutzerName, String passwort) {
		this.benutzerName = benutzerName;
		this.passwort = passwort;
	}
	
	// Angepasste equals-Methode mit Verwendung von BCrypt
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BergendePerson) {
			BergendePerson b = (BergendePerson)obj;
			// Vergleich der Benutzernamen
			 if (b.getBenutzerName().equals(this.benutzerName)) {
	                // Nutzt BCrypt um das gespeicherte mit dem angegebenen Passwort zu vergleichen und gibt den boolean zurück.
	                return BCrypt.checkpw(b.getPasswort(), this.passwort);
	            }
	        }
	        return false;
	    }

	// Getter und Setter
	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getBenutzerName() {
		return benutzerName;
	}

	public void setBenutzerName(String benutzerName) {
		this.benutzerName = benutzerName;
	}	
	
}