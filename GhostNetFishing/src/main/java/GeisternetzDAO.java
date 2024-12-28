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
        
		// Prüfung, ob die MeldendePerson im Geisternetz vorhanden ist und die ID null ist.
		// Aktuell sollte dies beim Aufruf von speichern() immer der Fall sein
		MeldendePerson meldendePerson = geisternetz.getMeldendePerson();
		if (meldendePerson != null && meldendePerson.getId() == 0) {
		
            // Prüfung, ob eine MeldendePerson mit den Attributen bereits in der Datenbank vorhanden ist
			// abfrage ist komplexer, da Telefonnummer NULL sein kann
            String abfrage = "SELECT p FROM Person p WHERE p.vorname = :vorname AND p.nachname = :nachname " +
            				 "AND ((:telefonnummer IS NULL AND p.telefonnummer IS NULL) OR p.telefonnummer = :telefonnummer)";
            TypedQuery<MeldendePerson> query = em.createQuery(abfrage, MeldendePerson.class);
            query.setParameter("vorname", meldendePerson.getVorname());
            query.setParameter("nachname", meldendePerson.getNachname());
            query.setParameter("telefonnummer", meldendePerson.getTelefonnummer());
            List<MeldendePerson> ergebnis = query.getResultList();
            
            if (!ergebnis.isEmpty()) {
                // Wenn die MeldendePerson bereits existiert, wird diese Person verwendet
                meldendePerson = ergebnis.get(0);
                geisternetz.setMeldendePerson(meldendePerson);
            }
		}
        
        t.begin();
        em.persist(geisternetz);
        t.commit();
        em.close();
	}
	
	public void updateBergendePerson(Geisternetz geisternetz, BergendePerson bergendePerson) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		BergendePerson managedBergendePerson = em.find(BergendePerson.class, bergendePerson.getId());
		geisternetz.setBergendePerson(managedBergendePerson);
		em.merge(geisternetz);
		t.commit();
		em.close();
	}
	
	public void update(Geisternetz geisternetz) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		// Prüfung, ob die VerschollenMeldendePerson im Geisternetz vorhanden ist und die ID null ist.
		// Aktuell sollte dies beim Aufruf von update() immer der Fall sein
		Person meldendePerson = geisternetz.getVerschollenMeldendePerson();
		if (meldendePerson != null && meldendePerson.getId() == 0) {
		
            // Prüfung, ob eine VerschollenMeldendePerson mit den Attributen bereits in der Datenbank vorhanden ist
            String abfrage = "SELECT p FROM Person p WHERE p.vorname = :vorname AND p.nachname = :nachname AND p.telefonnummer = :telefonnummer";
            TypedQuery<Person> query = em.createQuery(abfrage, Person.class);
            query.setParameter("vorname", meldendePerson.getVorname());
            query.setParameter("nachname", meldendePerson.getNachname());
            query.setParameter("telefonnummer", meldendePerson.getTelefonnummer());
            List<Person> ergebnis = query.getResultList();
            
            if (!ergebnis.isEmpty()) {
                // Wenn die VerschollenMeldendePerson bereits existiert, wird diese Person verwendet
                meldendePerson = ergebnis.get(0);
                geisternetz.setVerschollenMeldendePerson(meldendePerson);
            }
		}
		
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