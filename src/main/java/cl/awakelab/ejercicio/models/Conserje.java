package cl.awakelab.ejercicio.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Conserje {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "CONSERJE_SEQ"
    )
    private Long id;

    @Column(name = "NOMBRE_PRIMERO", length = 30)
    private String firstName;
    private String lastName;
    private int age;

    // ******************** ONE TO MANY ***********************

    @OneToMany(mappedBy = "conserje", cascade = CascadeType.ALL)
    private Set<Curso> listaCursos = new HashSet<>();

    public Set<Curso> getCurso() {
        return listaCursos;
    }

    public void setCurso(Set<Curso> curso) {
        this.listaCursos = curso;
    }

    public void addCurso(Curso curso) {
        listaCursos.add(curso);
        curso.setConserje(this);
    }

    public void deleteCurso(Curso curso) {
        listaCursos.remove(curso);
        curso.setConserje(null);
    }

    // *******************************************

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
