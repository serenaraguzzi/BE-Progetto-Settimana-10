package it.rest;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import it.dao.FilmDao;
import it.dao.FilmDaoImp;
import it.entity.Film;

@RestController
@RequestMapping("/film")
@Api(value="PiattaformaFilm", tags="Gestione piattaforma di film")
public class FilmRest {

	Logger logger = LoggerFactory.getLogger(getClass());
	FilmDao fd = new FilmDaoImp();

	//http://localhost:8080/ProgettoSettimana10-0.0.1-SNAPSHOT/swagger-ui.html

	@PostMapping
	@ApiOperation(value="inserimento film", notes="Qui è possibile inserire un film in piattaforma")
	public ResponseEntity<String> aggiungiFilm(@RequestBody Film f) {
		try{fd.aggiungiFilm(f);
		return new ResponseEntity<String>("Film inserito correttamente!", HttpStatus.OK);
		}
		catch(Exception e) {
			logger.error("Il film non è stato inserito");
			return new ResponseEntity<String>("Film non inserito!", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping ("/{id}")
	@ApiOperation(value="aggiornamento film", notes="Qui è possibile aggiornare un film in piattaforma")
	public ResponseEntity<String> aggiornaFilm(@RequestBody Film f, @PathVariable int id) {
		f.setId(id);
		try {fd.aggiornaFilm(f);
		return new ResponseEntity<String>("Film aggiornato!", HttpStatus.OK);
		} 
		catch (Exception e) {
			logger.error("Il film non è stato aggiornato");
			return new ResponseEntity<String>("Film non aggiornato!", HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping ("/{id}")
	@ApiOperation(value="eliminazione film", notes = "Qui è possibile cancellare un film dalla piattaforma")
	public ResponseEntity<String> cancellaFilm (@PathVariable int id) {
		try { fd.cancellaFilm(id);
		return new ResponseEntity<String>("Film cancellato!", HttpStatus.OK);
		} 
		catch (Exception e) {
			logger.error("Il film non è stato cancellato");
			return new ResponseEntity<String>("Film non cancellato!", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping ("/lista")
	@ApiOperation(value="lista film", notes= "Qui è possibile visualizzare tutti i film presenti in piattaforma")
	public ResponseEntity<List<Film>> getAll() {
		try {
			return new ResponseEntity<List<Film>>(fd.trovaTutti(), HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<List<Film>>((List<Film>)null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping ("/{regista}")
	@ApiOperation(value="trova film per regista", notes= "Qui è possibile visualizzare tutti i film presenti in piattaforma di un determinato regista")
	public ResponseEntity<List<Film>> trovaByRegista(@PathVariable String regista) {
		List <Film> filmTrovati = fd.trovaByRegista(regista);
		if (filmTrovati.isEmpty()) {
			logger.error("Il regista non esiste");
			return new ResponseEntity<List<Film>>(filmTrovati, HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<List<Film>>(filmTrovati, HttpStatus.OK);
		}
	}
	
}