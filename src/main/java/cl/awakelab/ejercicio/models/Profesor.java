package cl.awakelab.ejercicio.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Profesor {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String nombrecito;
    private int age;

    @OneToMany(mappedBy = "profesor",
            cascade = {CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH})
    private List<Curso> cursosLista = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrecito() {
        return nombrecito;
    }

    public void setNombrecito(String name) {
        this.nombrecito = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // ***************************************************

    /*
        Es importante (sólo por facilidad de código) crear métodos extras
        para generar el nexo entre, en este caso, cursos y profesores.

        Estos métodos extra son .addCurso(Curso curso) y .deleteCurso(Curso curso),
        para este caso.

        Esto se utiliza para relaciones @ManyToOne (o viceversa) y @ManyToMany.
     */

    public List<Curso> getCursosLista() {
        return cursosLista;
    }

    public void setCursosLista(List<Curso> cursos) {
        this.cursosLista = cursos;
    }

    public void addCurso(Curso curso) {
        cursosLista.add(curso);
        curso.setProfesor(this);
    }

    public void deleteCurso(Curso curso) {
        cursosLista.remove(curso);
        curso.setProfesor(null);
    }

    // ***************************************************


    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nombrecito='" + nombrecito + '\'' +
                ", edad='" + age + '\'' +
                ", cursosLista=" + cursosLista +
                '}';
    }
}
