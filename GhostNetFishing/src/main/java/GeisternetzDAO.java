import java.util.List;

import jakarta.persistence.*;

public class GeisternetzDAO {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ghostnetPersistenceUnit");
	
	//	Leerer Public Konstruktor
	public GeisternetzDAO() {	
	}
	
	public void speichern(Geisternetz geisternetz) {
    	EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        em.persist(geisternetz);
        t.commit();
        em.close();
	}
	
	public void updateBergendePerson(Geisternetz geisternetz, BergendePerson bergendePerson) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		geisternetz.setBergendePerson(bergendePerson);
		t.begin();
		//BergendePerson managedBergendePerson = em.find(BergendePerson.class, bergendePerson.getId());
		//geisternetz.setBergendePerson(managedBergendePerson);
		em.merge(geisternetz);
		t.commit();
		em.close();
	}
	
	public void update(Geisternetz geisternetz) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.merge(geisternetz);
		t.commit();
		em.close();
		//System.out.println("GeisternetzDAO - Update: Geisternetz mit meldender Person: " + geisternetz.getVerschollenMeldendePerson().getVorname());
	}
	
	public List<Geisternetz> getAlleGeisternetze() {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Geisternetz> q = em.createQuery("select g from Geisternetz g", Geisternetz.class);
		List<Geisternetz> alleGeisternetze = q.getResultList();
		em.close();
		return alleGeisternetze;
	}
}