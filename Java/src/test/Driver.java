package test;

import java.util.ArrayList;

import com.sun.org.apache.xpath.internal.operations.Equals;

public class Driver {
	 
	private ArrayList<Prodotto> magazzino;
	private ArrayList<OgettoInCarrello> carrello;
	Carrello addCarrello = new Carrello(this);
	
	public static void main(String[] args) {
		Driver controller = new Driver();
		AggiungiInMagazzino addMag = new AggiungiInMagazzino(controller);
		
		addMag.setVisible(true);
	}
	
	public Driver() {
		magazzino = new ArrayList<Prodotto>();
		setCarrello(new ArrayList<OgettoInCarrello>());
		
	}


public void addOnMagazzino(String n, String c, float p) {
		Prodotto pr = new Prodotto(n, c, p);
		magazzino.add(pr);
		System.out.println(n+c+p);
	}

public void TerminaInserimentoArticoli() {
	try {
		
		addCarrello.setVisible(true);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

public void apriInserimentoInCarrello() {
	try {
		AggiungiInCarrello frame = new AggiungiInCarrello(this);
		frame.updateCombobox();
		frame.setComboboxNumeri();
		frame.setVisible(true);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
public void aggiungiOInCarrello(Object nome, Object quantità) {
	for(Prodotto a: magazzino) {
		if(nome==a.getNome()) {
			addCarrello.aggiungiArticoloInCarrello(nome.toString(), quantità.toString(),a.getPrezzo());
		}
	}
}

public ArrayList<OgettoInCarrello> getCarrello() {
	return carrello;
}

public void setCarrello(ArrayList<OgettoInCarrello> carrello) {
	this.carrello = carrello;
}

public ArrayList<Prodotto> getMagazzino() {
	return magazzino;
}

public void setMagazzino(ArrayList<Prodotto> magazzino) {
	this.magazzino = magazzino;
}
}
