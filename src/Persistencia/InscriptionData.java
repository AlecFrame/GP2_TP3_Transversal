
package Persistencia;

import Modelo.Alumno;
import Modelo.Inscripcion;
import Modelo.Materia;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class InscriptionData {
    private Connection con = Conexion.cargaConexion();
    
    public ArrayList<Materia> obtenerMateriasCursadas(int id) throws SQLException {
        ArrayList<Materia> lista = new ArrayList<>();
        String sql = "SELECT materia.idMateria,materia.nombre,materia.anio,materia.estado FROM materia JOIN inscripcion ON inscripcion.idMateria=materia.idMateria WHERE inscripcion.idAlumno=?  ORDER BY materia.idMateria";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        
        ResultSet r = ps.executeQuery();
        
        while (r.next()) {
            lista.add(new Materia(r.getInt("idMateria"),r.getString("nombre"),r.getInt("anio"),r.getBoolean("estado")));
        }
        
        return lista;
    }
    
    public ArrayList<Materia> obtenerMateriasNoCursadas(int id) throws SQLException {
        ArrayList<Materia> lista = new ArrayList<>();
        String sql = "SELECT m.idMateria, m.nombre, m.anio, m.estado FROM materia m LEFT JOIN inscripcion i ON m.idMateria = i.idMateria AND i.idAlumno = ? WHERE i.idAlumno IS NULL";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        
        ResultSet r = ps.executeQuery();
        
        while (r.next()) {
            lista.add(new Materia(r.getInt("idMateria"),r.getString("nombre"),r.getInt("anio"),r.getBoolean("estado")));
        }
        
        return lista;
    }
    
    public void InscribirAlumno(int idAlumno, int idMateria) throws SQLException {
        boolean esta = false;
        ArrayList<Inscripcion> lista = listaInscripciones();
        
        for (Inscripcion i: lista) {
            if (i.getIdAlumno().getIdAlumno()==idAlumno&&i.getIdMateria().getIdMateria()==idMateria) {
                esta = true;
            }
        }
        
        if (!esta) {
            try {
                String sql = "INSERT INTO inscripcion (idInscripcion, nota, idAlumno, idMateria) VALUES (NULL, 0, ?, ?)";

                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, idAlumno);
                ps.setInt(2, idMateria);

                int filas = ps.executeUpdate();
                if (filas>0) {
                    JOptionPane.showMessageDialog(null, "Alumno inscripto con exito");
                }
            }catch(SQLException e) {
                JOptionPane.showMessageDialog(null, "Hubo un error con la consulta");
            }
        }else
            JOptionPane.showMessageDialog(null, "Ese Alumno ya está inscripto en esa materia");
    }
    
    public void EliminarAlumno(int idAlumno, int idMateria) throws SQLException {
        try {
            String sql = "delete from inscripcion where idAlumno=? and idMateria=?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);

            int filas = ps.executeUpdate();
            if (filas>0) {
                JOptionPane.showMessageDialog(null, "Inscripcion eliminada con exito");
            }
        }catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error con la consulta");
        }
    }
    
    public ArrayList<Inscripcion> listaInscripciones() throws SQLException {
        ArrayList<Inscripcion> lista = new ArrayList<>();
        
        AlumnoData dataA = new AlumnoData(con);
        MateriaData dataM = new MateriaData(con);
        
        String sql = "SELECT * From inscripcion";
        Statement ps = con.createStatement();
        
        ResultSet r = ps.executeQuery(sql);
        
        while (r.next()) {
            Alumno a = dataA.buscarAlumnoID(r.getInt("idAlumno"));
            Materia m = dataM.buscarMateria(r.getInt("idMateria"));
            lista.add(new Inscripcion(r.getInt("idInscripcion"),r.getInt("nota"),a,m));
        }
        
        return lista;
    }
    
    public ArrayList<Materia> listarMaterias() throws SQLException {
        ArrayList<Materia> lista = new ArrayList<>();
        String sql = "SELECT materia.idMateria,materia.nombre,materia.anio,materia.estado FROM materia ORDER BY materia.idMateria";
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ResultSet r = ps.executeQuery();
        
        while (r.next()) {
            lista.add(new Materia(r.getInt("idMateria"),r.getString("nombre"),r.getInt("anio"),r.getBoolean("estado")));
        }
        
        return lista;
    }
    
    public ArrayList<Inscripcion> InscripcionesDeAlumno(Alumno a) throws SQLException {
        ArrayList<Inscripcion> lista = new ArrayList<>();
        
        MateriaData dataM = new MateriaData(con);
        
        String sql = "SELECT * From inscripcion Where idAlumno=?";
        
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, a.getIdAlumno());
        
        ResultSet r = ps.executeQuery();
        
        while (r.next()) {
            Materia m = dataM.buscarMateria(r.getInt("idMateria"));
            lista.add(new Inscripcion(r.getInt("idInscripcion"),r.getInt("nota"),a,m));
        }
        
        return lista;
    }
    
    public void ActualizarNota(double nota, int id) throws SQLException {
        int filas = 0;
        String sql = "update inscripcion set nota=? where idInscripcion=?";

        PreparedStatement st = con.prepareStatement(sql);
        st.setDouble(1, nota);
        st.setInt(2, id);

        filas = st.executeUpdate();
        if (filas>0) {
                JOptionPane.showMessageDialog(null, "Nota actualizada con exito");
            }else
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la nota");
    }
    
    public ArrayList<Alumno> AlumnoInscripto (String materia) throws SQLException {
        String sql = "SELECT a.idAlumno, a.dni, a.nombre, a.apellido FROM alumno a JOIN inscripcion i ON a.idAlumno = i.idAlumno JOIN materia m ON m.idMateria = i.idMateria WHERE m.nombre= ? ;";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, materia);
        ResultSet r = st.executeQuery();
        ArrayList<Alumno> listaA = new ArrayList<>();
    while (r.next()) {
        listaA.add(new Alumno(r.getInt("dni"),r.getInt("idAlumno"),r.getString("nombre"),r.getString("apellido")));
        }
    
    return listaA;
    }
    

    }