package Entità;


public class Utente {
private String nome;
private String cognome;
private String username;
private String password;


    public Utente(String first, String last, String user, String string) {
    	nome=first;
    	cognome=last;
    	username=user;
    	password=string;
    	}
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setNickname(String nickname) {
		this.username = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	


}
