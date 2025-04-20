package co.edu.unbosque.proyectoFinal.dto;

public class LogInDTO {

	private Integer id;
	private String usuario;
	private String contrasenia;
	private String correo;

	public LogInDTO() {
		// TODO Auto-generated constructor stub
	}

	public LogInDTO(String usuario, String contrasenia, String correo) {
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
		return "LogInDTO [id=" + id + ", usuario=" + usuario + ", contrasenia=" + contrasenia + ", correo=" + correo
				+ "]";
	}

}
