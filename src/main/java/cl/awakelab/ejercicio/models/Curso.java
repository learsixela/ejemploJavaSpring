package cl.awakelab.ejercicio.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotBlank(message = "DEBES INGRESAR ALGO")
	private String nombre;
	private String detalle;

	@Column(updatable=false)
	private Date createAt;

	private Date updateAt;
	
	/*
		ONE TO ONE
	 */

	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="alumno_id")
	private Alumno alumno;

	/*
		MANY TO ONE
	 */

	@ManyToOne
	@JoinColumn(name = "profesor_id")
	private Profesor profesor;

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	@ManyToOne
	@JoinColumn
	private Conserje conserje;

	public Conserje getConserje() {
		return conserje;
	}

	public void setConserje(Conserje conserje) {
		this.conserje = conserje;
	}

	/*
		MANY TO MANY
	 */

	@ManyToMany
	@JoinTable(
			name = "CURSO_PRUEBA",
			joinColumns = @JoinColumn(name = "PRUEBA_ID"),
			inverseJoinColumns = @JoinColumn(name = "CURSO_ID")
	)
	private Set<Prueba> pruebas = new HashSet<>();

	public Set<Prueba> getPruebas() {
		return pruebas;
	}

	public void setPruebas(Set<Prueba> pruebas) {
		this.pruebas = pruebas;
	}

	public void addPrueba(Prueba prueba) {
		pruebas.add(prueba);
		prueba.getCursos().add(this);
	}

	public void deletePrueba(Prueba prueba) {
		pruebas.remove(prueba);
		prueba.getCursos().remove(this);
	}

	@PrePersist
	protected void onCreate() {
		setCreateAt(new Date());
	}
	
	@PreUpdate
	protected void onUpdate() {
		setUpdateAt(new Date());
	}
	
	public Curso() {
		
	}

	public Curso(Long id, String nombre, Date createAt, Date updateAt) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	
	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	@Override
	public String toString() {
		String toString = "Curso{" +
				"id=" + id +
				", nombre='" + nombre + '\'' +
				", detalle='" + detalle + '\'' +
				", createAt=" + createAt +
				", updateAt=" + updateAt +
				", pruebas=" + pruebas +
				", profesor_id=";

		if (profesor != null) toString += profesor.getId();
		else toString += "null";

		toString += '}';

		return toString;
	}
}
