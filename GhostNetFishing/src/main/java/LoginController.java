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
	private List<BergendePerson> bergendenListe;
    
	@Inject
    private BergendePerson bergendePerson; // Injektion der zentralen Bean
	
	// Leerer Konstruktor
	public LoginController() {
		this.bergendenListe = new ArrayList<BergendePerson>();
		this.bergendenListe.add(new BergendePerson("Dennis", "Schmalenberger", "+4915124052488", "tester", "tester"));
	}	

	
	public void postValidateName(ComponentSystemEvent ev) throws AbortProcessingException {
		UIInput temp = (UIInput)ev.getComponent();
		this.benutzername = (String)temp.getValue();
	}
	
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