import java.util.List;

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
        em.close();
	}
	
	public List<BergendePerson> laden() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<BergendePerson> q = em.createQuery("select b from BergendePerson b", BergendePerson.class);
		List<BergendePerson> alleBergendePersonen = q.getResultList();
		em.close();
		return alleBergendePersonen;
	}
	
}