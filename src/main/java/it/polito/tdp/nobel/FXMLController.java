package it.polito.tdp.nobel;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.nobel.model.Esame;
import it.polito.tdp.nobel.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	Model model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtInput;

	@FXML
	private TextArea txtResult;

	@FXML
	private Button btnReset;

	@FXML
	void doCalcolaCombinazione(ActionEvent event) {
		txtResult.clear();
		
		try {
			int numeroCrediti = Integer.parseInt(txtInput.getText());
			List<Esame> esami = model.calcolaSottoinsiemeEsami(numeroCrediti);

			for (Esame e : esami) {
				txtResult.appendText(e.getNomeCorso() + "\n");
			}

		} catch (NumberFormatException e) {
			txtResult.setText("Inserire un numero di crediti > 0");
		} catch (NullPointerException e) {
			txtResult.setText("Non esistono configurazioni con questo valore di crediti");
		}
	}

	@FXML
	void doReset(ActionEvent event) {
		// reset the UI
		txtInput.clear();
		txtResult.clear();
	}

	@FXML
	void initialize() {
		assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'VotiNobel.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'VotiNobel.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'VotiNobel.fxml'.";
	}

	public void setModel(Model model) {

		this.model = model;
	}
}
