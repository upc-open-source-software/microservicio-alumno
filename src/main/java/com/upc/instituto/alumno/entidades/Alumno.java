package com.upc.instituto.alumno.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_ALUMNO")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;

	@NotEmpty(message = "no puede estar vacío")
	@Column(name = "nombres", nullable = false)
	private String nombres;

	@NotEmpty(message = "no puede estar vacío")
	@Column(name = "apellidos", nullable = false)
	private String apellidos;

	@NotNull(message = "no puede estar vacío")
	@Column(name = "fechaNacimiento", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	@NotEmpty(message = "no puede estar vacío")
	@Column(name = "direccion")
	private String direccion;

	@NotEmpty(message = "no puede estar vacío")
	@Column(name = "celular")
	private String celular;

	@NotEmpty(message = "no puede estar vacío")
	@Email(message = "no es una dirección de correo electrónico válido")
	@Column(name = "correo")
	private String correo;

	@NotNull
	@Column(name = "departamentoId")
	private Long idDepartamento;

	@NotNull
	@Column(name = "provinciaId")
	private Long idProvincia;

	@NotNull
	@Column(name = "distritoId")
	private Long idDistrito;

	@Column(name = "fechaRegistro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRegistro;
	
	public Alumno() {
		super();
	}

	public Alumno(Long codigo, @NotEmpty(message = "no puede estar vacío") String nombres,
			@NotEmpty(message = "no puede estar vacío") String apellidos,
			@NotNull(message = "no puede estar vacío") Date fechaNacimiento,
			@NotEmpty(message = "no puede estar vacío") String direccion,
			@NotEmpty(message = "no puede estar vacío") String celular,
			@NotEmpty(message = "no puede estar vacío") @Email(message = "no es una dirección de correo electrónico válido") String correo,
			@NotNull Long idDepartamento, @NotNull Long idProvincia, @NotNull Long idDistrito, Date fechaRegistro) {
		super();
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.celular = celular;
		this.correo = correo;
		this.idDepartamento = idDepartamento;
		this.idProvincia = idProvincia;
		this.idDistrito = idDistrito;
		this.fechaRegistro = fechaRegistro;
	}

	@PrePersist
	public void prePersist() {
		this.fechaRegistro = new Date();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Long getIdDepartamento() {
		return idDepartamento;
	}

	public void setIdDepartamento(Long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public Long getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}

	public Long getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(Long idDistrito) {
		this.idDistrito = idDistrito;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

}
