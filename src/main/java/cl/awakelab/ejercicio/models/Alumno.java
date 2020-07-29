package cl.awakelab.ejercicio.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="alumnos")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@Column(updatable=false)
	private Date createAt;

	private Date updateAt;

	@OneToOne(mappedBy="alumno", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Curso curso;
	
	
	@PrePersist
	protected void onCreate() {
		setCreateAt(new Date());
	}
	
	@PreUpdate
	protected void onUpdate() {
		setUpdateAt(new Date());
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

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
}
