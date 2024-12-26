import jakarta.persistence.*;

public class BergendePersonDAO {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ghostnetPersistenceUnit");
	
	//	Leerer Public Konstruktor
	public BergendePersonDAO() {	
	}
	
	public void speichern(BergendePerson bergendePerson) {
    	EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(bergendePerson);
        System.out.println("BergendePersonDAO: Person gespeichert mit ID: " + bergendePerson.getId() + " gespeichert");
        t.commit();
	}
}