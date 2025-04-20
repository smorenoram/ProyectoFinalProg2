package co.edu.unbosque.proyectoFinal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
public class LogIn {

	private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
	@Column(name = "usuario", unique = true)
	private String usuario;
	@Column(name = "contrasenia", unique = true)
	private String contrasenia;
	@Column(name = "correo", unique = true)
	private String correo;

	public LogIn() {
		// TODO Auto-generated constructor stub
	}

	public LogIn(String usuario, String contrasenia, String correo) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
		this.correo = correo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	@Override
	public String toString() {
		return "LogIn [id=" + id + ", usuario=" + usuario + ", contrasenia=" + contrasenia + ", correo=" + correo + "]";
	}

}
