
package Modelo;

import java.util.Objects;


public class Inscripcion {
    private int idInscripcion;
    private double nota;
    private Alumno idAlumno;
    private Materia idMateria;

    public Inscripcion(int idinscripcion, double nota, Alumno alumno, Materia materia) {
        this.idInscripcion = idinscripcion;
        this.nota = nota;
        this.idAlumno = alumno;
        this.idMateria = materia;
    }

    public Inscripcion(Alumno alumno, double nota, Materia materia) {
        this.nota = nota;
        this.idAlumno = alumno;
        this.idMateria = materia;
    }

    public Inscripcion() {
    }

    public Inscripcion(double nota) {
        this.nota = nota;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Materia getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Materia idMateria) {
        this.idMateria = idMateria;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripcion=" + idInscripcion + ", nota=" + nota + ", idAlumno=" + idAlumno + ", idMateria=" + idMateria + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.idInscripcion;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.nota) ^ (Double.doubleToLongBits(this.nota) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.idAlumno);
        hash = 53 * hash + Objects.hashCode(this.idMateria);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscripcion other = (Inscripcion) obj;
        if (this.idInscripcion != other.idInscripcion) {
            return false;
        }
        if (Double.doubleToLongBits(this.nota) != Double.doubleToLongBits(other.nota)) {
            return false;
        }
        if (!Objects.equals(this.idAlumno, other.idAlumno)) {
            return false;
        }
        return Objects.equals(this.idMateria, other.idMateria);
    }
    
    
}
