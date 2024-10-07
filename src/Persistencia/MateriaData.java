
package Persistencia;

import Modelo.Materia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MateriaData {
    private Connection con;
    
    public MateriaData(Connection con) {
        this.con = con;
    }
    
    public void guardarMateria(Materia m) {
        try {
            String sql = "insert into materia(idMateria, nombre, anio, estado)"
                    + " values (?, ?, ?, ?);";

            PreparedStatement ps = con.prepareStatement(sql);
            if (m.getIdMateria()==-1) ps.setNull(1, java.sql.Types.INTEGER); else ps.setInt(1, m.getIdMateria());
            ps.setString(2, m.getNombre());
            ps.setInt(3, m.getAnio());
            ps.setBoolean(4, m.isEstado());
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println("Materia Registrada con exito");
                JOptionPane.showMessageDialog(null, "Materia Registrada con exito");
            }
        }catch(SQLException e) {
            System.err.println("Datos de materia son incompatibles");
            JOptionPane.showMessageDialog(null, "Datos de amteria son incompatibles","Atencion",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public Materia buscarMateria(int codigo) {
        Materia materia = null;
        try{
            String sql = "select idMateria,nombre,anio,estado from materia where idMateria = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            ResultSet resultado = ps.executeQuery();
            while(resultado.next()) {
                materia = new Materia(resultado.getInt("idMateria"),resultado.getString("nombre"),
                    resultado.getInt("anio"),resultado.getBoolean("estado"));
            }
        }catch(SQLException e) {
            System.err.println("Materia no encontrada "+e);
            JOptionPane.showMessageDialog(null, "Código de materia no encontrada","Atencion",JOptionPane.WARNING_MESSAGE);
        }
        return materia;
    }
    
    public void eliminarMateria(int codigo) {
        try{
            String sql = "delete from materia where idMateria = ?";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            
            int filas = ps.executeUpdate();
            if (filas>0) {
                System.out.println("Se ha eliminado la materia correctamente");
                JOptionPane.showMessageDialog(null, "Se ha eliminado a la materia correctamente");
            }else
                JOptionPane.showMessageDialog(null, "No se ha encontrado a la materia","Atencion",JOptionPane.WARNING_MESSAGE);
        }catch(SQLException e) {
            System.err.println("Materia no encontrada "+e);
            JOptionPane.showMessageDialog(null, "Materia no encontrada","Atencion",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void actualizarMateria(Materia m,String cambiar) {
        try {
            int filas=0;
            if (cambiar.contains("nombre")) {
                if (m.getNombre()!=null) {
                    String sql = "update materia set nombre=? where idMateria=?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setString(1, m.getNombre());
                    st.setInt(2, m.getIdMateria());

                    filas = st.executeUpdate();
                }else
                    JOptionPane.showMessageDialog(null, "Nombre de materia nulo","Atencion",JOptionPane.WARNING_MESSAGE);
            }
            if (cambiar.contains("anio")) {
                if (m.getAnio()>0) {
                    String sql = "update materia set anio=? where idMateria=?";

                    PreparedStatement st = con.prepareStatement(sql);
                    st.setInt(1, m.getAnio());
                    st.setInt(2, m.getIdMateria());

                    filas = st.executeUpdate();
                }else
                    JOptionPane.showMessageDialog(null, "Año de materia inferior a 1 es invalido","Atencion",JOptionPane.WARNING_MESSAGE);
            }
            if (cambiar.contains("estado")) {
                String sql = "update materia set estado=? where idMateria=?";
                
                PreparedStatement st = con.prepareStatement(sql);
                st.setBoolean(1, m.isEstado());
                st.setInt(2, m.getIdMateria());
                
                filas = st.executeUpdate();
            }
            if (filas>0) {
                System.out.println("Materia ("+m.getIdMateria()+") actualizado con exito");
            }else
                JOptionPane.showMessageDialog(null, "No se encuentra el código de la materia","Atencion",JOptionPane.WARNING_MESSAGE);
        }catch(SQLException e) {
            System.err.println("Datos de materia incompatibles: "+e);
            JOptionPane.showMessageDialog(null, "Datos de materia incompatibles","Atencion",JOptionPane.WARNING_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Estado de la materia actualizada con exito");
        }else
            JOptionPane.showMessageDialog(null, "No se encuentra el código de la materia","Atencion",JOptionPane.WARNING_MESSAGE);
    }
    
    public void motrarTablaMateria() throws SQLException {
        Statement statement = con.createStatement();
        ResultSet resultado = statement.executeQuery("SELECT * FROM materia");
        
        while(resultado.next()) {
            String estado = (resultado.getBoolean("estado"))? "activo":"inactivo";
            System.out.println(resultado.getString("idMateria")+", "+resultado.getString("nombre")+", "+resultado.getInt("anio")+", "+estado);
        }
    }
    
    public ArrayList<Materia> mostrarMaterias() throws SQLException {
        
        ArrayList<Materia> lista = new ArrayList<>();
        String sql = "SELECT * FROM materia ORDER BY idMateria";
        
        PreparedStatement ps = con.prepareStatement(sql);
        
        ResultSet r = ps.executeQuery();
        
        while (r.next()) {
            lista.add(new Materia(r.getInt("idMateria"),r.getString("nombre"),r.getInt("anio"),r.getBoolean("estado")));
        }
        
        return lista;
    }
}
