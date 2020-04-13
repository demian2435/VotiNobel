package it.polito.tdp.nobel.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		Model model = new Model();
		List<Esame> test = model.calcolaSottoinsiemeEsami(20);
		
		for (Esame e : test) {
			System.out.println(e.getNomeCorso());
		}
		
	}

}
