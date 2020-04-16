package it.polito.tdp.nobel.model;

import java.util.List;
import java.util.Set;

import it.polito.tdp.nobel.db.EsameDAO;

public class Model {
	private EsameDAO dao = new EsameDAO();
	RicercaMedia rm = new RicercaMedia();

	public List<Esame> calcolaSottoinsiemeEsami(int numeroCrediti) {
		List<Esame> allEsami = dao.getTuttiEsami();
		List<Esame> esami = rm.ricercaMedia(allEsami, numeroCrediti);

		return esami;
	}
}
