import java.io.Serializable;

public class GPS implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// Eigenschaften von Geisternetzen
	private Double breitengrad;
	private Double laengengrad;

	//	Leerer Public Konstruktor
	public GPS() {
	}
	
	// Konstruktor mit breitengrad und laengengrad
	public GPS(Double breitengrad, Double laengengrad) {
		this.breitengrad = breitengrad;
		this.laengengrad = laengengrad;
	}

	// Getter und Setter
	public double getBreitengrad() {
		return breitengrad;
	}

	public void setBreitengrad(double breitengrad) {
		this.breitengrad = breitengrad;
	}

	public double getLaengengrad() {
		return laengengrad;
	}

	public void setLaengengrad(double laengengrad) {
		this.laengengrad = laengengrad;
	}

	
}