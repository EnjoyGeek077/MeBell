package Entità;


public class Utente {
private String username;
private String nome;
private String cognome;
private String password;


    public Utente(String user, String first, String last, String passw) {
	username=user;
    	nome=first;
    	cognome=last;
    	password=passw;
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
