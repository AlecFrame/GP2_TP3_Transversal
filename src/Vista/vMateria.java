
package Vista;

import Modelo.Materia;
import Persistencia.Conexion;
import Persistencia.InscriptionData;
import Persistencia.MateriaData;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class vMateria extends javax.swing.JInternalFrame {
    public ArrayList<Materia> lista = new ArrayList<>();
    public Connection con = Conexion.cargaConexion();

    public vMateria() {
        initComponents();
        
        Deshabilitar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfCodigo = new javax.swing.JTextField();
        jtfNombre = new javax.swing.JTextField();
        jrbEstado = new javax.swing.JRadioButton();
        jbBuscar = new javax.swing.JButton();
        jbNuevo = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jtfAnio = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Materia");

        jpanel.setBackground(new java.awt.Color(71, 216, 229));

        jLabel2.setText("Código:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Estado:");

        jLabel6.setText("Año:");

        jtfCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfCodigoActionPerformed(evt);
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
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(118, 118, 118)
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtfAnio, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jtfNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addComponent(jrbEstado)
                            .addGroup(jpanelLayout.createSequentialGroup()
                                .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jpanelLayout.setVerticalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtfAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jrbEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
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

    private void jtfCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfCodigoActionPerformed

    private void jrbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbEstadoActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        if (!jtfCodigo.getText().equalsIgnoreCase("")) {
            try {
                int codigo = Integer.parseInt(jtfCodigo.getText());
                MateriaData data = new MateriaData(con);
                InscriptionData dataI = new InscriptionData();
                
                ArrayList<Materia> list = dataI.listarMaterias();
                boolean encontrado = false;
                
                for (Materia mm: list) {
                    if (mm.getIdMateria()==codigo) {
                        encontrado = true;
                    }
                }
                
                if (encontrado) {
                    Materia m = data.buscarMateria(codigo);

                    Limpiar();
                    Habilitar();
                    jtfCodigo.setText(String.valueOf(m.getIdMateria()));
                    jtfNombre.setText(m.getNombre());
                    jtfAnio.setText(String.valueOf(m.getAnio()));
                    jrbEstado.setSelected(m.isEstado());
                }else
                    JOptionPane.showMessageDialog(this, "Codigo de materia no encontrada","Atencion",JOptionPane.WARNING_MESSAGE);
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this, "El Código y año permiten solo numeros","Atencion",JOptionPane.WARNING_MESSAGE);
            }
        }else
            JOptionPane.showMessageDialog(this, "El campo de Código está vacio","Atencion",JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        Habilitar();
        Limpiar();
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        if (!jtfCodigo.getText().equalsIgnoreCase("")) {
            try {
                int codigo = Integer.parseInt(jtfCodigo.getText());
                MateriaData data = new MateriaData(con);
                
                data.cambiarEstado(codigo);
                cargarLista();
                Limpiar();
            } catch(Exception e) {
                JOptionPane.showMessageDialog(this, "El Código tiene que ser un número","Atencion",JOptionPane.WARNING_MESSAGE);
            }
        }else
            JOptionPane.showMessageDialog(this, "El campo del Código está vacio","Atencion",JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        String codigo = jtfCodigo.getText();
        String nombre = jtfNombre.getText();
        String anio = jtfAnio.getText();
        boolean estado = jrbEstado.isSelected();
        MateriaData data = new MateriaData(con);
        
        if (!(nombre.isEmpty()|anio.isEmpty())) {
            if (codigo.isEmpty()) {
                try {
                    int anioi = Integer.parseInt(anio);
                    if (anioi>0) {
                        Materia m = new Materia(nombre,anioi,estado);

                        data.guardarMateria(m);
                        cargarLista();
                        Limpiar();
                    }else
                        JOptionPane.showMessageDialog(this, "El Año de la materia no puede ser inferior a 1","Atencion",JOptionPane.WARNING_MESSAGE);
                }catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "El año solo permite numeros","Atencion",JOptionPane.WARNING_MESSAGE);
                }
            }else{
                try {
                    int codigoi = Integer.parseInt(codigo);
                    if (codigoi>0) {
                        int anioi = Integer.parseInt(anio);
                        if (anioi>0) {
                            Materia m = new Materia(codigoi,nombre,anioi,estado);

                            InscriptionData dataI = new InscriptionData();
                            ArrayList<Materia> list = dataI.listarMaterias();
                            boolean encontrado = false;

                            for (Materia mm: list) {
                                if (mm.getIdMateria()==codigoi) {
                                    encontrado = true;
                                }
                            }

                            if (!encontrado) {
                                data.guardarMateria(m);
                                cargarLista();
                                Limpiar();
                            }else{
                                data.actualizarMateria(m, "nombre,anio,estado");
                                JOptionPane.showMessageDialog(this, "La materia con el codigo: "+codigo+" fue actualizada");
                            }
                        }else
                            JOptionPane.showMessageDialog(this, "El Año de la materia no puede ser inferior a 1","Atencion",JOptionPane.WARNING_MESSAGE);
                    }else
                        JOptionPane.showMessageDialog(this, "El Código no puede ser inferior a 1","Atencion",JOptionPane.WARNING_MESSAGE);
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(this, "El Codigo y año solo permite números","Atencion",JOptionPane.WARNING_MESSAGE);
                }
            }
        }else
            JOptionPane.showMessageDialog(this, "Algunos campos están vacios","Atencion",JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    public void Deshabilitar() {
        jtfNombre.setEnabled(false);
        jtfAnio.setEnabled(false);
        jrbEstado.setEnabled(false);
        jbGuardar.setEnabled(false);
    }
    
    public void Habilitar() {
        jtfNombre.setEnabled(true);
        jtfAnio.setEnabled(true);
        jrbEstado.setEnabled(true);
        jbGuardar.setEnabled(true);
    }
    
    public void Limpiar() {
        jtfCodigo.setText("");
        jtfNombre.setText("");
        jtfAnio.setText("");
        jrbEstado.setSelected(false);
    }
    
    public void cargarLista() throws SQLException {
        Statement s = con.createStatement();
        ResultSet r = s.executeQuery("Select idMateria,nombre,anio,estado From materia");
        lista.clear();
        
        while (r.next()) {
            lista.add(new Materia(r.getInt("idMateria"),
                    r.getString("nombre"),
                    r.getInt("anio"),
                    r.getBoolean("estado")));
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JPanel jpanel;
    private javax.swing.JRadioButton jrbEstado;
    private javax.swing.JTextField jtfAnio;
    private javax.swing.JTextField jtfCodigo;
    private javax.swing.JTextField jtfNombre;
    // End of variables declaration//GEN-END:variables
}
