import java.io.Serializable;

import jakarta.persistence.*;


@Entity
public class GPS implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id; //technische ID für die Datenbank
    
	// Eigenschaften von Geisternetzen
	private Double breitengrad;
	private Double laengengrad;

	//	Leerer Public Konstruktor
	public GPS() {
	}	

	// Getter und Setter
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}