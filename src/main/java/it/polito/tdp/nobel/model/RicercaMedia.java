package it.polito.tdp.nobel.model;

import java.util.ArrayList;
import java.util.List;

public class RicercaMedia {
	private int crediti;
	private float bestMedia;
	private List<Esame> result;
	private List<Esame> bestEsami;
	private List<Esame> allEsami;

	public List<Esame> ricercaMedia(List<Esame> allEsami, int crediti) {
		this.crediti = crediti;
		this.bestMedia = 0;
		this.allEsami = allEsami;
		result = new ArrayList<Esame>();
		bestEsami = new ArrayList<Esame>();
		// ricorsiva(allEsami, result);
		ricorsivaNew(result, 0);
		return bestEsami;
	}

	// OLD VERSION
//	private void ricorsiva(List<Esame> disponibili, List<Esame> parziale) {
//		// Se la media della lista parziale è più alta della BestMedia
//		// e il TotaleCrediti della lista parziale corrispondono ai crediti richiesti
//		// inserisci parziale come risposta vincente e aggiorna la BestMedia
//		if (calcolaMedia(parziale) > bestMedia && calcolaCrediti(parziale) == crediti) {
//			bestMedia = calcolaMedia(parziale);
//			bestEsami = new ArrayList<Esame>(parziale);
//		}
//		// Se la lista parziale non supera i crediti richiesti aggiungiamo
//		// un nuovo esame alla lista e calcoliamo se è la migliore
//		if (calcolaCrediti(parziale) < crediti) {
//
//			for (Esame e : disponibili) {
//				// Aggiungo un esame alla lista parziale
//				List<Esame> tentativo = new ArrayList<Esame>(parziale);
//				tentativo.add(e);
//				// Tolgo un esame dalla lista degli esami disponibili
//				List<Esame> rimanenti = new ArrayList<Esame>(disponibili);
//				rimanenti.remove(e);
//				// Vado a controllore se la lista supera i criteri necessari ad essere
//				// la migliore, o se dovra essere scartata o continuare nella ricorsione
//				ricorsiva(rimanenti, tentativo);
//			}
//		}
//	}

	// NEW VERSION
	private void ricorsivaNew(List<Esame> parziale, int index) {
		if (calcolaCrediti(parziale) == crediti && calcolaMedia(parziale) > bestMedia) {
			bestMedia = calcolaMedia(parziale);
			bestEsami = new ArrayList<Esame>(parziale);
		}
		if (index == allEsami.size()) {
			return;
		}
		if (calcolaCrediti(parziale) < crediti) {
			parziale.add(allEsami.get(index));
			ricorsivaNew(parziale, index + 1);
			parziale.remove(parziale.size() - 1);
			ricorsivaNew(parziale, index + 1);
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

	private float calcolaMedia(List<Esame> result) {
		if (result.size() == 0) {
			return -1;
		}

		float somma = 0;
		int crediti = 0;
		for (Esame e : result) {
			crediti += e.getCrediti();
			somma += e.getVoto() * e.getCrediti();
		}
		return somma / crediti;
	}

}
