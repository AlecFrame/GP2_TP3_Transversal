
package Vista;

import java.sql.*;
import Modelo.Alumno;
import Persistencia.AlumnoData;
import Persistencia.Conexion;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class vAlumno extends javax.swing.JInternalFrame {
    public ArrayList<Alumno> lista = new ArrayList<>();
    public Connection con = Conexion.cargaConexion();
    
    public vAlumno() throws SQLException {
        initComponents();
        
        cargarLista();
        Deshabilitar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfDNI = new javax.swing.JTextField();
        jtfApellido = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jrbEstado = new javax.swing.JRadioButton();
        jbBuscar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jdFecha = new com.toedter.calendar.JDateChooser();

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Alumno");

        jpanel.setBackground(new java.awt.Color(71, 216, 229));

        jLabel2.setText("Documento:");

        jLabel3.setText("Apellido:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Estado:");

        jLabel6.setText("Fecha de Nacimiento:");

        jtfDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDNIActionPerformed(evt);
            }
        });

        jrbEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbEstadoActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpanelLayout = new javax.swing.GroupLayout(jpanel);
        jpanel.setLayout(jpanelLayout);
        jpanelLayout.setHorizontalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpanelLayout.createSequentialGroup()
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(47, 47, 47)
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jrbEstado)
                            .addGroup(jpanelLayout.createSequentialGroup()
                                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfDNI)
                                    .addComponent(jtfApellido)
                                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbBuscar))))
                    .addGroup(jpanelLayout.createSequentialGroup()
                        .addComponent(jbNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbEliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbSalir)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jpanelLayout.setVerticalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jrbEstado))
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6))
                    .addGroup(jpanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jdFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo)
                    .addComponent(jbEliminar)
                    .addComponent(jbGuardar)
                    .addComponent(jbSalir))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jpanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDNIActionPerformed

    }//GEN-LAST:event_jtfDNIActionPerformed

    private void jrbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEstadoActionPerformed

    }//GEN-LAST:event_jrbEstadoActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        if (!jtfDNI.getText().equalsIgnoreCase("")) {
            try {
                int dnii = Integer.parseInt(jtfDNI.getText());
                
                AlumnoData data = new AlumnoData(con);
                ArrayList<Alumno> list = data.listarAlumnos();
                boolean encontrado = false;
                
                for (Alumno a: list) {
                    if (a.getDni()==dnii) {
                        encontrado = true;
                    }
                }
                
                if (encontrado) {
                    Alumno a = data.buscarAlumno(dnii);

                    Limpiar();
                    Habilitar();
                    jtfDNI.setText(String.valueOf(a.getDni()));
                    jtfNombre.setText(a.getNombre());
                    jtfApellido.setText(a.getApellido());
                    jdFecha.setDate(java.sql.Date.valueOf(a.getFechaNacimiento()));
                    jrbEstado.setSelected(a.isEstado());
                }else
                    JOptionPane.showMessageDialog(this, "DNI de Alumno no encontrado","Atencion",JOptionPane.WARNING_MESSAGE);
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this, "El número de documento solo permite números","Atencion",JOptionPane.WARNING_MESSAGE);
            }
        }else
            JOptionPane.showMessageDialog(this, "El campo Documento está vacio","Atencion",JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        Habilitar();
        Limpiar();
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        String dni = jtfDNI.getText();
        String nombre = jtfNombre.getText();
        String apellido = jtfApellido.getText();
        boolean estado = jrbEstado.isSelected();
        
        if (!(dni==""|nombre==""|apellido==""|jdFecha.getDate()==null)) {
            java.util.Date utilDate = jdFecha.getDate();
            Date sqlDate = new Date(utilDate.getTime());
            LocalDate fecha = sqlDate.toLocalDate();
            try {
                int dnii = Integer.parseInt(dni);
                AlumnoData data = new AlumnoData(con);
                Alumno a = new Alumno(dnii,apellido,nombre,fecha,estado);
                
                ArrayList<Alumno> list = data.listarAlumnos();
                boolean encontrado = false;
                
                for (Alumno aa: list) {
                    if (aa.getDni()==dnii) {
                        encontrado = true;
                    }
                }
                
                if (!encontrado) {
                    data.guardarAlumno(a);
                    cargarLista();
                    Limpiar();
                }else {
                    data.actualizarAlumno(a, "dni,nombre,apellido,fecha,estado");
                    JOptionPane.showMessageDialog(this, "El Alumno con el dni: "+dni+" fue actualizado");
                }
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this, "El número de documento tiene que ser un número","Atencion",JOptionPane.WARNING_MESSAGE);
            }
        }else
            JOptionPane.showMessageDialog(this, "Algunos campos están vacios","Atencion",JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        if (!jtfDNI.getText().equalsIgnoreCase("")) {
            try {
                int dnii = Integer.parseInt(jtfDNI.getText());
                AlumnoData data = new AlumnoData(con);
                
                data.cambiarEstado(dnii);
                cargarLista();
                Limpiar();
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this, "El número de documento tiene que ser un número","Atencion",JOptionPane.WARNING_MESSAGE);
            }
        }else
            JOptionPane.showMessageDialog(this, "El campo Documento está vacio","Atencion",JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    public void Deshabilitar() {
        jtfApellido.setEnabled(false);
        jtfNombre.setEnabled(false);
        jdFecha.setEnabled(false);
        jrbEstado.setEnabled(false);
        jbGuardar.setEnabled(false);
    }
    
    public void Habilitar() {
        jtfApellido.setEnabled(true);
        jtfNombre.setEnabled(true);
        jdFecha.setEnabled(true);
        jrbEstado.setEnabled(true);
        jbGuardar.setEnabled(true);
    }
    
    public void Limpiar() {
        jtfDNI.setText("");
        jtfNombre.setText("");
        jtfApellido.setText("");
        jdFecha.setDate(null);
        jrbEstado.setSelected(false);
    }
    
    public void cargarLista() throws SQLException {
        Statement s = con.createStatement();
        ResultSet r = s.executeQuery("Select dni,nombre,apellido,fechaNacimiento,estado From alumno");
        lista.clear();
        
        while (r.next()) {
            lista.add(new Alumno(r.getInt("dni"),
                    r.getString("nombre"),
                    r.getString("apellido"),
                    r.getDate("fechaNacimiento").toLocalDate(),
                    r.getBoolean("estado")));
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private com.toedter.calendar.JDateChooser jdFecha;
    private javax.swing.JPanel jpanel;
    private javax.swing.JRadioButton jrbEstado;
    private javax.swing.JTextField jtfApellido;
    private javax.swing.JTextField jtfDNI;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
