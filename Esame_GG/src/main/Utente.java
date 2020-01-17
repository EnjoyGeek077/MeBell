package main;


public class Utente {
private String nome;
private String cognome;
private String nickname;
private String password;


    public Utente(String first, String last, String user, String string) {
    	nome=first;
    	cognome=last;
    	nickname=user;
    	password=string;
}//
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	


}
