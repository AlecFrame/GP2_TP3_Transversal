
package Vista;

import Modelo.Materia;
import Modelo.Alumno;
import Modelo.Inscripcion;
import Persistencia.Conexion;
import Persistencia.InscriptionData;
import Persistencia.MateriaData;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class vActualizacionNotas extends javax.swing.JInternalFrame {
    public ArrayList<Inscripcion> lista = new ArrayList<>();
    private InscriptionData dataI = new InscriptionData();
    public Connection con = Conexion.cargaConexion();
    private int editado = -1;
    private int seleccionado = -1;
    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int col) { //Bloquea las todas las celdas.
            return col == 2;
        }
    };
    
    public vActualizacionNotas() throws SQLException {
        initComponents();
        
        jbGuardar.setEnabled(false);
        cargarCabecera();
        cargarCombo();
        cargarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcbAlumno = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jbGuardar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel2.setText("situacion del alumno:");

        jcbAlumno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbAlumnoItemStateChanged(evt);
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
                "Codigo", "Nombre", "Nota"
            }
        ));
        jTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMouseClicked(evt);
            }
        });
        jTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jbGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(85, 85, 85))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbSalir))
                .addGap(45, 45, 45))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Carga de Notas:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jcbAlumnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbAlumnoItemStateChanged
        try {
            cargarTabla();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de consulta");
        }
    }//GEN-LAST:event_jcbAlumnoItemStateChanged

    private void jTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableKeyReleased
        int keyCode = evt.getKeyCode();
        try {
            int id = Integer.parseInt(jTable.getValueAt(jTable.getSelectedRow(), 0).toString());
            Inscripcion i = null;
            for (Inscripcion ii: lista) {
                if (ii.getIdInscripcion()==id) {
                    i = ii;
                    editado = i.getIdInscripcion();
                }
            }
            
            if (keyCode == KeyEvent.VK_ENTER&&i!=null) {
                double nota = Double.parseDouble(jTable.getValueAt(jTable.getSelectedRow(), 2).toString());
                if (nota!=i.getNota()) {
                    jbGuardar.setEnabled(true);
                    seleccionado = jTable.getSelectedRow();
                }else
                    jbGuardar.setEnabled(false);
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(this, "Problemas con los tipos de datos");
        }
    }//GEN-LAST:event_jTableKeyReleased

    private void jTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMouseClicked
        if (jbGuardar.isEnabled()) {
            int id = editado;
            Inscripcion i = null;
            for (Inscripcion ii: lista) {
                if (ii.getIdInscripcion()==id) {
                    i = ii;
                }
            }
            if (i!=null) {
                jTable.setValueAt(i.getNota(), seleccionado, 2);
            }
            jbGuardar.setEnabled(false);
        }
    }//GEN-LAST:event_jTableMouseClicked

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        double nota = Double.parseDouble(jTable.getValueAt(seleccionado, 2).toString());
        try {
            dataI.ActualizarNota(nota, editado);
            jbGuardar.setEnabled(false);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "La Consulta sufrio un error");
        }
    }//GEN-LAST:event_jbGuardarActionPerformed
    
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
        modelo.addColumn("Nota");
        jTable.setModel(modelo);
    }
    
    private void cargarTabla() throws SQLException {
        modelo.setRowCount(0);
        lista = dataI.InscripcionesDeAlumno(jcbAlumno.getItemAt(jcbAlumno.getSelectedIndex()));
        
        for (Inscripcion i: lista) {
            agregarFila(i);
        }
    }
    
    private void agregarFila(Inscripcion i) {
        MateriaData data = new MateriaData(con);
        Materia m = data.buscarMateria(i.getIdMateria().getIdMateria());
        
        modelo.addRow(new Object[] {
            i.getIdInscripcion(),
            m.getNombre(),
            i.getNota()
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<Alumno> jcbAlumno;
    // End of variables declaration//GEN-END:variables
}
