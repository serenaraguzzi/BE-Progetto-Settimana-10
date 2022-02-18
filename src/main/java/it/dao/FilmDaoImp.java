package it.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.security.crypto.bcrypt.BCrypt;
import it.entity.Film;

public class FilmDaoImp implements FilmDao {

	private EntityManager em = null;

	public EntityManager getEm() {
		if(em==null) {
			em = EntityManagerHelper.getEntityManager();
		}
		return em;
	}

	public void aggiungiFilm (Film f) {
		String incassoCriptato = BCrypt.hashpw(f.getIncasso(), BCrypt.gensalt());
		f.setIncasso(incassoCriptato); //criptazione incasso

		getEm().getTransaction().begin();
		getEm().persist(f);
		getEm().getTransaction().commit();
	}

	public void aggiornaFilm (Film f)  throws Exception {
		String incassoCriptato = BCrypt.hashpw(f.getIncasso(), BCrypt.gensalt());
		f.setIncasso(incassoCriptato); //criptazione incasso

		Film flm = getEm().find(Film.class, f.getId());
		if (flm == null) {
			throw new Exception("Film non trovato!");
		}
		getEm().getTransaction().begin();
		getEm().merge(f);
		getEm().getTransaction().commit();
	}

	public void cancellaFilm (int id) {
		try {
			Film f = trova(id);
			getEm().getTransaction().begin();
			getEm().remove(f);
		}
		catch (Exception e ) {
			getEm().getTransaction().rollback();
		}
		finally {
			getEm().getTransaction().commit();
		}
	}

	public Film trova (int id) {
		return getEm().find(Film.class, id);
	}

	/** java doc
	 *  Trova tutti i film presenti in piattaforma di un determinato regista
	 * 
	 *  @author  Serena Raguzzi
	 *  @param  String regista
	 *  @return  Film presenti in piattaforma di un determinato regista
	 */
	@SuppressWarnings ("unchecked")
	public List<Film> trovaByRegista(String regista) {
		Query q= getEm().createNamedQuery("film.trovaByRegista").setParameter(1, regista) ;
		return q.getResultList();
	}

	@SuppressWarnings ("unchecked")
	public List<Film> trovaTutti() {
		return getEm().createNamedQuery("film.trovaTutti").getResultList();
	}

}