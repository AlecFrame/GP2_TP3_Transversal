
package Persistencia;

import Modelo.Alumno;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AlumnoData {
    private Connection con;
    private DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public AlumnoData(Connection con) {
        this.con = con;
    }
    
    public void guardarAlumno(Alumno a) {
        
        try {
            String sql = "insert into alumno(dni, nombre, apellido, fechaNacimiento, estado)"
                    + " values (?, ?, ?, ?, ?);";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, a.getDni());
            ps.setString(2, a.getNombre());
            ps.setString(3, a.getApellido());
            ps.setDate(4, java.sql.Date.valueOf(a.getFechaNacimiento()));
            ps.setBoolean(5, a.isEstado());
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println("Alumno Registrado con exito");
                JOptionPane.showMessageDialog(null, "Alumno Registrado con exito");
            }
        }catch(SQLException e) {
            System.err.println("Datos de alumno incompatibles");
            JOptionPane.showMessageDialog(null, "Datos de alumno incompatibles","Atencion",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public Alumno buscarAlumno(int dni) {
        Alumno alumno = null;
        try{
            String sql = "select dni,nombre,apellido,fechaNacimiento,estado from alumno where dni = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()) {
                alumno = new Alumno(resultado.getInt("dni"),resultado.getString("apellido"),
                    resultado.getString("nombre"),resultado.getDate("fechaNacimiento").toLocalDate(),
                    resultado.getBoolean("estado"));
            }
        }catch(SQLException e) {
            System.err.println("Alumno no encontrado "+e);
            JOptionPane.showMessageDialog(null, "Alumno no encontrado","Atencion",JOptionPane.WARNING_MESSAGE);
        }
        return alumno;
    }
    
    public Alumno buscarAlumnoID(int id) {
        Alumno alumno = null;
        try{
            String sql = "select * from alumno where idAlumno = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()) {
                alumno = new Alumno(resultado.getInt("dni"),resultado.getInt("idAlumno"),resultado.getString("apellido"),
                    resultado.getString("nombre"),resultado.getDate("fechaNacimiento").toLocalDate(),
                    resultado.getBoolean("estado"));
            }
        }catch(SQLException e) {
            System.err.println("Alumno no encontrado "+e);
            JOptionPane.showMessageDialog(null, "Alumno no encontrado","Atencion",JOptionPane.WARNING_MESSAGE);
        }
        return alumno;
    }
    
    public void eliminarAlumno(int id) {
        try{
            String sql = "delete from alumno where idAlumno = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println("Se ha eliminado al alumno correctamente");
                JOptionPane.showMessageDialog(null, "Se ha eliminado al alumno correctamente");
            }else {
                System.err.println("No se ha encontrado al alumno");
                JOptionPane.showMessageDialog(null, "Alumno no encontrado","Atencion",JOptionPane.WARNING_MESSAGE);
            }
        }catch(SQLException e) {
            System.err.println("Alumno no encontrado "+e);
            JOptionPane.showMessageDialog(null, "Alumno no encontrado","Atencion",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void actualizarAlumno(Alumno a,String cambiar) {
        try {
            int filas=0;
            if (cambiar.contains("nombre")) {
                if (a.getNombre()!=null) {
                    String sql = "update alumno set nombre=? where dni=?";
                    
                    PreparedStatement st = con.prepareStatement(sql);
                    st.setString(1, a.getNombre());
                    st.setInt(2, a.getDni());

                    filas = st.executeUpdate();
                }else
                    JOptionPane.showMessageDialog(null, "Nombre de alumno nulo","Atencion",JOptionPane.WARNING_MESSAGE);
            }
            if (cambiar.contains("apellido")) {
                if (a.getApellido()!=null) {
                    String sql = "update alumno set apellido=? where dni=?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setString(1, a.getApellido());
                    st.setInt(2, a.getDni());

                    filas = st.executeUpdate();
                }else
                    JOptionPane.showMessageDialog(null, "Apellido de alumno nulo","Atencion",JOptionPane.WARNING_MESSAGE);
            }
            if (cambiar.contains("dni")) {
                if (a.getDni()!=0) {
                    String sql = "update alumno set dni=? where idAlumno=?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setInt(1, a.getDni());
                    st.setInt(2, a.getIdAlumno());

                    filas = st.executeUpdate();
                }else
                    JOptionPane.showMessageDialog(null, "DNI de alumno 0","Atencion",JOptionPane.WARNING_MESSAGE);
            }
            if (cambiar.contains("fechaNacimiento")) {
                if (a.getFechaNacimiento()!=null) {
                    String sql = "update alumno set fechaNacimiento=? where dni=?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setDate(1, java.sql.Date.valueOf(a.getFechaNacimiento()));
                    st.setInt(2, a.getDni());

                    filas = st.executeUpdate();
                }else
                    JOptionPane.showMessageDialog(null, "FechaNacimiento de alumno nulo","Atencion",JOptionPane.WARNING_MESSAGE);
            }
            if (cambiar.contains("estado")) {
                String sql = "update alumno set estado=? where dni=?";
                
                PreparedStatement st = con.prepareStatement(sql);
                st.setBoolean(1, a.isEstado());
                    st.setInt(2, a.getDni());
                
                filas = st.executeUpdate();
            }
            
            if (filas>0) {
                System.out.println("Alumno ("+a.getDni()+") actualizado con exito");
            }else
                JOptionPane.showMessageDialog(null, "No se encuentra la ID del alumno","Atencion",JOptionPane.WARNING_MESSAGE);
        }catch(SQLException e) {
            System.err.println("Datos de alumno incompatibles: "+e);
            JOptionPane.showMessageDialog(null, "Datos de alumno incompatibles","Atencion",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void cambiarEstado(int dni) throws SQLException {
        int filas=0;
        String sql = "update alumno set estado=? where dni=?";
                
        PreparedStatement st = con.prepareStatement(sql);
        st.setBoolean(1, false);
        st.setInt(2, dni);
                
        filas = st.executeUpdate();
        if (filas>0) {
            System.out.println("Estado de Alumno actualizado con exito");
            JOptionPane.showMessageDialog(null, "Estado de Alumno actualizado con exito");
        }else
            JOptionPane.showMessageDialog(null, "No se encuentra el DNI del alumno","Atencion",JOptionPane.WARNING_MESSAGE);
    }
    
    public void actualizarAlumno2(Alumno a,String cambiar, int ID) {
        try {
            int filas=0;
            if (cambiar.contains("nombre")) {
                if (a.getNombre()!=null) {
                    String sql = "update alumno set nombre=? where idAlumno=?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setString(1, a.getNombre());
                    st.setInt(2, a.getIdAlumno());

                    filas = st.executeUpdate();
                }else
                    JOptionPane.showMessageDialog(null, "nombre de alumno nulo","Atencion",JOptionPane.WARNING_MESSAGE);
            }
            if (cambiar.contains("apellido")) {
                if (a.getApellido()!=null) {
                    String sql = "update alumno set apellido=? where idAlumno=?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setString(1, a.getApellido());
                    st.setInt(2, a.getIdAlumno());

                    filas = st.executeUpdate();
                }else
                    JOptionPane.showMessageDialog(null, "Apellido de alumno nulo","Atencion",JOptionPane.WARNING_MESSAGE);
            }
            if (cambiar.contains("dni")) {
                if (a.getDni()!=0) {
                    String sql = "update alumno set dni=? where idAlumno=?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setInt(1, a.getDni());
                    st.setInt(2, a.getIdAlumno());

                    filas = st.executeUpdate();
                }else
                    JOptionPane.showMessageDialog(null, "No se actualizo al alumno porque su DNI es 0","Atencion",JOptionPane.WARNING_MESSAGE);
            }
            if (cambiar.contains("fechaNacimiento")) {
                if (a.getFechaNacimiento()!=null) {
                    String sql = "update alumno set fechaNacimiento=? where idAlumno=?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setDate(1, java.sql.Date.valueOf(a.getFechaNacimiento()));
                    st.setInt(2, a.getIdAlumno());

                    filas = st.executeUpdate();
                }else
                    JOptionPane.showMessageDialog(null, "Fecha de nacimiento nula","Atencion",JOptionPane.WARNING_MESSAGE);
            }
            if (cambiar.contains("estado")) {
                String sql = "update alumno set estado=? where idAlumno=?";
                
                PreparedStatement st = con.prepareStatement(sql);
                st.setBoolean(1, a.isEstado());
                st.setInt(2, a.getIdAlumno());
                
                filas = st.executeUpdate();
            }
            if (cambiar.contains("idAlumno")) {
                if (ID>0&buscarAlumno(ID)==null) {
                    String sql = "update alumno set idAlumno=? where idAlumno=?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setInt(1, ID);
                    st.setInt(2, a.getIdAlumno());

                    filas = st.executeUpdate();
                }else
                    JOptionPane.showMessageDialog(null, "No se actualizo el ID del alumno porque es incompatible o ya existe","Atencion",JOptionPane.WARNING_MESSAGE);
            }
            if (filas>0) {
                System.out.println("Alumno ("+a.getIdAlumno()+") actualizado con exito");
                JOptionPane.showMessageDialog(null, "Alumno actualizado con exito");
            }else
                JOptionPane.showMessageDialog(null, "No se encuentra el ID del alumno","Atencion",JOptionPane.WARNING_MESSAGE);
        }catch(SQLException e) {
            System.err.println("Datos de alumno incompatibles: "+e);
            JOptionPane.showMessageDialog(null, "Datos de alumno incompatibles","Atencion",JOptionPane.WARNING_MESSAGE);
        }
        
    }
    
    public void motrarTablaAlumnos() throws SQLException {
        Statement statement = con.createStatement();
        ResultSet resultado = statement.executeQuery("SELECT * FROM alumno");
        
        while(resultado.next()) {
            LocalDate fecha = resultado.getDate("fechaNacimiento").toLocalDate();
            String estado = (resultado.getBoolean("estado"))? "activo":"inactivo";
            System.out.println(resultado.getString("idAlumno")+", "+resultado.getString("dni")+", "+resultado.getString("nombre")+", "+resultado.getString("apellido")+", "+fecha.format(formato)+", "+estado);
        }
    }
    
    public ArrayList<Alumno> listarAlumnos() throws SQLException {
        ArrayList<Alumno> lista = new ArrayList<>();
        String sql = "SELECT idAlumno,dni,nombre,apellido,fechaNacimiento,estado FROM alumno ORDER BY idAlumno";
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ResultSet r = ps.executeQuery();
        
        while (r.next()) {
            LocalDate fecha = r.getDate("fechaNacimiento").toLocalDate();
            lista.add(new Alumno(r.getInt("dni"),r.getInt("idAlumno"),r.getString("apellido"),r.getString("nombre"),fecha,r.getBoolean("estado")));
        }
        
        return lista;
    }
}
