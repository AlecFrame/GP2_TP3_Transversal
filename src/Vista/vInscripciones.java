
package Vista;

import java.sql.*;
import Modelo.Alumno;
import Modelo.Materia;
import Persistencia.Conexion;
import Persistencia.InscriptionData;
import Persistencia.MateriaData;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class vInscripciones extends javax.swing.JInternalFrame {
    public ArrayList<Materia> lista = new ArrayList<>();
    public Connection con = Conexion.cargaConexion();
    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int col) { //Bloquea las todas las celdas.
            return false;
        }
    };
    
    public vInscripciones() throws SQLException {
        initComponents();
        
        Deshabilitar();
        cargarCabecera();
        cargarCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jpanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jrbIns = new javax.swing.JRadioButton();
        jbInscribir = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jrbNoIns = new javax.swing.JRadioButton();
        jcbAlumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Formulario de Inscripciones");

        jpanel.setBackground(new java.awt.Color(71, 216, 229));

        jLabel2.setText("Seleccione un alumno:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Listado de Materias");

        jrbIns.setText("Materias Inscriptas");
        jrbIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbInsActionPerformed(evt);
            }
        });

        jbInscribir.setText("Inscribir");
        jbInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbInscribirActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jrbNoIns.setText("Materias no inscriptas");
        jrbNoIns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbNoInsActionPerformed(evt);
            }
        });

        jcbAlumno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbAlumnoItemStateChanged(evt);
            }
        });
        jcbAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbAlumnoActionPerformed(evt);
            }
        });

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Año"
            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

        javax.swing.GroupLayout jpanelLayout = new javax.swing.GroupLayout(jpanel);
        jpanel.setLayout(jpanelLayout);
        jpanelLayout.setHorizontalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLayout.createSequentialGroup()
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(71, 71, 71)
                                .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpanelLayout.createSequentialGroup()
                                .addComponent(jrbIns)
                                .addGap(261, 261, 261)
                                .addComponent(jrbNoIns))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpanelLayout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(jLabel5))
                    .addGroup(jpanelLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jbInscribir)
                        .addGap(112, 112, 112)
                        .addComponent(jbEliminar)
                        .addGap(95, 95, 95)
                        .addComponent(jbSalir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpanelLayout.setVerticalGroup(
            jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbNoIns)
                    .addComponent(jrbIns))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbInscribir)
                    .addComponent(jbEliminar)
                    .addComponent(jbSalir))
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel1)
                .addContainerGap(320, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void jrbInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbInsActionPerformed
        try {
            InscriptionData data = new InscriptionData();
            Alumno a = jcbAlumno.getItemAt(jcbAlumno.getSelectedIndex());
            
            if (jrbIns.isSelected()) {
                jrbNoIns.setSelected(false);
                lista = data.obtenerMateriasCursadas(a.getIdAlumno());
            }else
                lista = data.listarMaterias();
            
            cargarTabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Consulta mal ejecutada: "+ex,"Atencion",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jrbInsActionPerformed
   
    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jcbAlumnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbAlumnoItemStateChanged
        try {
            InscriptionData data = new InscriptionData();
            Alumno a = jcbAlumno.getItemAt(jcbAlumno.getSelectedIndex());
            
            if (jrbIns.isSelected()) {
                lista = data.obtenerMateriasCursadas(a.getIdAlumno());
            }else
            if (jrbNoIns.isSelected()) {
                lista = data.obtenerMateriasNoCursadas(a.getIdAlumno());
            }else
            lista = data.listarMaterias();
            
            cargarTabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Consulta mal ejecutada: "+ex,"Atencion",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jcbAlumnoItemStateChanged

    private void jrbNoInsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbNoInsActionPerformed
        try {
            InscriptionData data = new InscriptionData();
            Alumno a = jcbAlumno.getItemAt(jcbAlumno.getSelectedIndex());
            
            if (jrbNoIns.isSelected()) {
                jrbIns.setSelected(false);
                lista = data.obtenerMateriasNoCursadas(a.getIdAlumno());
            }else
                lista = data.listarMaterias();
            
            cargarTabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Consulta mal ejecutada: "+ex,"Atencion",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jrbNoInsActionPerformed

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        Alumno a = jcbAlumno.getItemAt(jcbAlumno.getSelectedIndex());
        
        try {
            int idMateria = Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 0).toString());
            MateriaData dataM = new MateriaData(con);
            InscriptionData dataI = new InscriptionData();
            Materia m = dataM.buscarMateria(idMateria);
            
            lista = dataI.obtenerMateriasCursadas(a.getIdAlumno());
            
            if (lista.contains(m)) {
                jbInscribir.setEnabled(false);
                jbEliminar.setEnabled(true);
            }else{
                jbInscribir.setEnabled(true);
                jbEliminar.setEnabled(false);
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Húbo algún problema con los tipos de datos","Atencion",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jTableMouseClicked
        
    private void jbInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbInscribirActionPerformed
        Alumno a = jcbAlumno.getItemAt(jcbAlumno.getSelectedIndex());
        
        try {
            int idMateria = Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 0).toString());
            InscriptionData data = new InscriptionData();
            
            data.InscribirAlumno(a.getIdAlumno(), idMateria);
            
            if (jrbIns.isSelected()) {
                lista = data.obtenerMateriasCursadas(a.getIdAlumno());
            }else
            if (jrbNoIns.isSelected()) {
                lista = data.obtenerMateriasNoCursadas(a.getIdAlumno());
            }else
            lista = data.listarMaterias();
            
            jbInscribir.setEnabled(false);
            cargarTabla();
        }catch(NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Húbo algún problema con los tipos de datos: "+e,"Atencion",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbInscribirActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        Alumno a = jcbAlumno.getItemAt(jcbAlumno.getSelectedIndex());
        
        try {
            int idMateria = Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 0).toString());
            InscriptionData data = new InscriptionData();
            
            data.EliminarAlumno(a.getIdAlumno(), idMateria);
            
            if (jrbIns.isSelected()) {
                lista = data.obtenerMateriasCursadas(a.getIdAlumno());
            }else
            if (jrbNoIns.isSelected()) {
                lista = data.obtenerMateriasNoCursadas(a.getIdAlumno());
            }else
            lista = data.listarMaterias();
            
            jbEliminar.setEnabled(false);
            cargarTabla();
        }catch(NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Húbo algún problema con los tipos de datos: "+e,"Atencion",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jcbAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbAlumnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbAlumnoActionPerformed
    
    public void cargarCombo() throws SQLException {
        Statement s = con.createStatement();
        ResultSet r = s.executeQuery("Select idAlumno,dni,nombre,apellido,fechaNacimiento,estado From alumno");
        lista.clear();
        jcbAlumno.removeAllItems();
        
        while (r.next()) {
            Alumno a = new Alumno(r.getInt("dni"),
                    r.getInt("idAlumno"),
                    r.getString("nombre"),
                    r.getString("apellido"),
                    r.getDate("fechaNacimiento").toLocalDate(),
                    r.getBoolean("estado"));
            jcbAlumno.addItem(a);
        }
        cargarTabla();
    }
    
    public void cargarCabecera() {
        modelo.addColumn("Código");
        modelo.addColumn("Nombre");
        modelo.addColumn("Año");
        jTable.setModel(modelo);
    }
    
    private void cargarTabla() {
        modelo.setRowCount(0);
        for (Materia m: lista) {
            agregarFila(m);
        }
    }
    
    private void agregarFila(Materia m) {
        modelo.addRow(new Object[] {
            m.getIdMateria(),
            m.getNombre(),
            m.getAnio()
        });
    }
    
    private void Deshabilitar() {
        jbEliminar.setEnabled(false);
        jbInscribir.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbInscribir;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcbAlumno;
    private javax.swing.JPanel jpanel;
    private javax.swing.JRadioButton jrbIns;
    private javax.swing.JRadioButton jrbNoIns;
    // End of variables declaration//GEN-END:variables
}
