package test;

public class Prodotto {
	private String name;
	private String cod;
	private float price;
	
	public Prodotto(String n,String c,float p) {
		name=n;
		cod=c;
		price=p;
		
	}
	
	public String getNome() {
		return name;
	}
	public void setNome(String nome) {
		this.name = nome;
	}
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public float getPrezzo() {
		return price;
	}
	public void setPrezzo(float prezzo) {
		this.price = prezzo;
	}

}
