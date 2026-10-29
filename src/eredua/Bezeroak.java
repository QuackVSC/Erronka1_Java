package eredua;

public class Bezeroak {
	private String ID;
	private String izena;
	private String abizena;
	private String email;
	private String telefonoa;
	
	public String getID() {
		return ID;
	}
	
	public void setID(String ID) {
		this.ID=ID;
	}
	
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
	public String getTelefonoa() {
		return telefonoa;
	}
	public void setTelefonoa(String telefonoa) {
		this.telefonoa = telefonoa;
	}

	public String toString(){
		return izena +" - "+ abizena +" - "+ email + " - " + telefonoa;
	}
	
}
