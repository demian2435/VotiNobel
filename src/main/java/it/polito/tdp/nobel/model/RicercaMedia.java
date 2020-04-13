package it.polito.tdp.nobel.model;

import java.util.ArrayList;
import java.util.List;

public class RicercaMedia {
	private List<Esame> allEsami;
	private int crediti;
	private int bestMedia = 0;
	private List<Esame> result;
	private List<Esame> bestEsami;

	public RicercaMedia(List<Esame> allEsami, int crediti) {
		this.allEsami = allEsami;
		this.crediti = crediti;
	}

	public List<Esame> ricercaMedia(List<Esame> allEsami) {
		result = new ArrayList<Esame>();
		ricorsiva(allEsami, result);
		return bestEsami;
	}

	private void ricorsiva(List<Esame> disponibili, List<Esame> parziale) {
		// Se la media della lista parziale è più alta della BestMedia
		// e il TotaleCrediti della lista parziale corrispondono ai crediti richiesti
		// inserisci parziale come risposta vincente e aggiorna la BestMedia
		if (calcolaMedia(parziale) > bestMedia && calcolaCrediti(parziale) == crediti) {
			bestMedia = calcolaMedia(parziale);
			bestEsami = new ArrayList<Esame>(parziale);
		} else {
			for (Esame e : disponibili) {
				// Se la lista parziale non supera i crediti richiesti aggiungiamo
				// un nuovo esame alla lista e calcoliamo se è la migliore
				if (calcolaCrediti(parziale) < crediti) {
					// Aggiungo un esame alla lista parziale
					List<Esame> tentativo = new ArrayList<Esame>(parziale);
					tentativo.add(e);
					// Tolgo un esame dalla lista degli esami disponibili
					List<Esame> rimanenti = new ArrayList<Esame>(disponibili);
					rimanenti.remove(e);
					// Vado a controllore se la lista supera i criteri necessari ad essere
					// la migliore, o se dovra essere scartata o continuare nella ricorsione
					ricorsiva(rimanenti, tentativo);
				}
			}
		}
	}

	private int calcolaCrediti(List<Esame> result) {
		if (result.size() == 0) {
			return -1;
		}
		int somma = 0;
		for (Esame e : result) {
			somma += e.getCrediti();
		}
		return somma;
	}

	private int calcolaMedia(List<Esame> result) {
		if (result.size() == 0) {
			return -1;
		}
		int somma = 0;
		for (Esame e : result) {
			somma += e.getVoto();
		}
		return somma / result.size();
	}

}
