package it.polito.tdp.nobel.model;

import java.util.List;
import java.util.Set;

import it.polito.tdp.nobel.db.EsameDAO;

public class Model {
	private EsameDAO dao = new EsameDAO();

	public List<Esame> calcolaSottoinsiemeEsami(int numeroCrediti) {
		List<Esame> allEsami = dao.getTuttiEsami();
		RicercaMedia rm = new RicercaMedia(allEsami, numeroCrediti);
		List<Esame> esami = rm.ricercaMedia(allEsami);

		return esami;
	}
}
