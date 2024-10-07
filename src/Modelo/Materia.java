
package Modelo;

import java.util.Objects;


public class Materia {
   private int idMateria;
   private String nombre;
   private int anio;
   private boolean estado;

    public Materia() {
    }

    public Materia(int idMateria, String nombre, int anioMateria, boolean activo) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.anio = anioMateria;
        this.estado = activo;
    }

    public Materia(String nombre, int anioMateria, boolean activo) {
        this.idMateria = -1;
        this.nombre = nombre;
        this.anio = anioMateria;
        this.estado = activo;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre+" "+anio+", estado: "+((estado)? "activo":"inactivo");
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.idMateria;
        hash = 37 * hash + Objects.hashCode(this.nombre);
        hash = 37 * hash + this.anio;
        hash = 37 * hash + (this.estado ? 1 : 0);
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
        final Materia other = (Materia) obj;
        if (this.idMateria != other.idMateria) {
            return false;
        }
        if (this.anio != other.anio) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }
    
    
}
