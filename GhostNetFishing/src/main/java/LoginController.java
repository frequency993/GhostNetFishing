import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AbortProcessingException;
import jakarta.faces.event.ComponentSystemEvent;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@ViewScoped
public class LoginController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Deklarationen
	private String benutzername;
	private String passwort;
	private List<BergendePerson> bergendenListe = new ArrayList<BergendePerson>();
	private static final BergendePersonDAO dao = new BergendePersonDAO();
	
	// Injektion der zentralen Bean
	@Inject
    private BergendePerson bergendePerson; 
	
	// Leerer Konstruktor
	public LoginController() {
		bergendenListe = dao.laden();
		// Nur für Testzwecke!!!!
		// Nur für Testzwecke!!!!
		if (bergendenListe.isEmpty()) {
			this.bergendenListe.add(new BergendePerson("Christoph", "Kolumbus", "+3911111111111", "a", "a"));
			this.bergendenListe.add(new BergendePerson("Ferdinand", "Magellan", "+3512222222222", "b", "b"));
			this.bergendenListe.add(new BergendePerson("James", "Cook", "+4433333333333", "c", "c"));
		}
	}	

	// Zwischenmethode, um den Benutzernamen zu speichern
	public void postValidateBenutzerName(ComponentSystemEvent ev) throws AbortProcessingException {
		UIInput temp = (UIInput)ev.getComponent();
		this.benutzername = (String)temp.getValue();
	}
	
	// Validierungsmethode für den Login
	public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		for(BergendePerson bP:bergendenListe) {
			BergendePerson temp=new BergendePerson(this.benutzername, (String)value);
			if(bP.equals(temp)) {
				this.bergendePerson.setId(bP.getId());
				this.bergendePerson.setVorname(bP.getVorname());
				this.bergendePerson.setNachname(bP.getNachname());
				this.bergendePerson.setTelefonnummer(bP.getTelefonnummer());
				this.bergendePerson.setBenutzerName(bP.getBenutzerName());
				this.bergendePerson.setPasswort(bP.getPasswort());
				return;
			}
		}
		throw new ValidatorException(new FacesMessage("Bitte Login-Daten überprüfen!"));
	}

	public String login() {
		return "bergen";
	}
	
	// Getter und Setter
	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public List<BergendePerson> getBergendenListe() {
		return bergendenListe;
	}

	public void setBergendenListe(List<BergendePerson> bergendenListe) {
		this.bergendenListe = bergendenListe;
	}

	public BergendePerson getBergendePerson() {
		return bergendePerson;
	}

	public void setBergendePerson(BergendePerson bergendePerson) {
		this.bergendePerson = bergendePerson;
	}
	
	
}