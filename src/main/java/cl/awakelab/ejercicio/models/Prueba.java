package cl.awakelab.ejercicio.models;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Prueba {

    @Id
    @GeneratedValue(generator = "PRUEBA_SEQ")
    private Long id;

    @Column(length = 2)
    private int numeroDePregunta;

    @Column(length = 50)
    private String pregunta;

    @ManyToMany(mappedBy = "pruebas", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Set<Curso> cursos = new HashSet<>();

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    public int getNumeroDePregunta() {
        return numeroDePregunta;
    }

    public void setNumeroDePregunta(int numeroDePregunta) {
        this.numeroDePregunta = numeroDePregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Prueba{" +
                "id=" + id+
                ", numeroDePregunta=" + numeroDePregunta +
                ", pregunta='" + pregunta + '\'' +
                '}';
    }
}
