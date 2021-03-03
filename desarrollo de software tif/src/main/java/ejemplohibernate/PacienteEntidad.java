package ejemplohibernate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paciente")
public class PacienteEntidad implements Serializable{

	private int IdPaciente;
	

	private String nom_paciente;
	private String nom_dueño;
	private String n_telefono;
	private String direccion;
	private String mail;
	
	public PacienteEntidad() { }
	
	@Id
	@Column(name="IdPaciente")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdPaciente() {
		return IdPaciente;
	}
	
	public void setIdPaciente(int idPaciente) {
		IdPaciente = idPaciente;
	}

	public String getNom_paciente() {
		return nom_paciente;
	}

	public void setNom_paciente(String nom_paciente) {
		this.nom_paciente = nom_paciente;
	}

	public String getNom_dueño() {
		return nom_dueño;
	}

	public void setNom_dueño(String nom_dueño) {
		this.nom_dueño = nom_dueño;
	}

	public String getN_telefono() {
		return n_telefono;
	}

	public void setN_telefono(String n_telefono) {
		this.n_telefono = n_telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
		
		
}