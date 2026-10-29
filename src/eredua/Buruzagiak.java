package eredua;

public class Buruzagiak {

	private String izena;
	private String abizena;
	private String email;
	private String IdNagusia;
	
	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getAbizena() {
		return abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdNagusia() {
		return IdNagusia;
	}

	public void setIdNagusia(String IdNagusia) {
		this.IdNagusia = IdNagusia;
	}

	public String toString() {
		return izena + " - " + abizena + " - " + email;
	}

}
