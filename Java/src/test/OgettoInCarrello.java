package test;

public class OgettoInCarrello {
	private Prodotto prodotto;
	private int quantità;
	
	public OgettoInCarrello(Prodotto p,int q) {
		prodotto = p;
		quantità = q;
	}
	
	public Prodotto getProdotto() {
		return prodotto;
	}
	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}
	public int getQuantità() {
		return quantità;
	}
	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}

}
