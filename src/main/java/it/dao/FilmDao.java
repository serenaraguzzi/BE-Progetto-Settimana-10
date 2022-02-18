package it.dao;

import java.util.List;
import it.entity.Film;

public interface FilmDao {

	public void aggiungiFilm (Film f);
	public void aggiornaFilm (Film f) throws Exception;
	public void cancellaFilm (int id);
	public List<Film> trovaTutti();
	public List<Film> trovaByRegista(String regista);
	//public Film trova (int id);
}