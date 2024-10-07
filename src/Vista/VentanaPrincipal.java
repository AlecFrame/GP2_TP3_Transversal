
package Vista;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends javax.swing.JFrame {

    public VentanaPrincipal() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmAlumno = new javax.swing.JMenu();
        jmiAlumno = new javax.swing.JMenuItem();
        jmMateria = new javax.swing.JMenu();
        jmiMateria = new javax.swing.JMenuItem();
        jmAdministracion = new javax.swing.JMenu();
        jmiManipulacion = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jmConsultas = new javax.swing.JMenu();
        jmiAlumnosPorMateria = new javax.swing.JMenuItem();
        jmSalir = new javax.swing.JMenu();
        jmiSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 737, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );

        jmAlumno.setText("Alumno");

        jmiAlumno.setText("Formulario de Alumno");
        jmiAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAlumnoActionPerformed(evt);
            }
        });
        jmAlumno.add(jmiAlumno);

        jMenuBar1.add(jmAlumno);

        jmMateria.setText("Materia");

        jmiMateria.setText("Formulario de Materia");
        jmiMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMateriaActionPerformed(evt);
            }
        });
        jmMateria.add(jmiMateria);

        jMenuBar1.add(jmMateria);

        jmAdministracion.setText("Administración");

        jmiManipulacion.setText("Manejo de Inscripciones");
        jmiManipulacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiManipulacionActionPerformed(evt);
            }
        });
        jmAdministracion.add(jmiManipulacion);

        jMenuItem4.setText("Manipulación de notas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jmAdministracion.add(jMenuItem4);

        jMenuBar1.add(jmAdministracion);

        jmConsultas.setText("Consultas");

        jmiAlumnosPorMateria.setText("Alumnos por materia");
        jmiAlumnosPorMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAlumnosPorMateriaActionPerformed(evt);
            }
        });
        jmConsultas.add(jmiAlumnosPorMateria);

        jMenuBar1.add(jmConsultas);

        jmSalir.setText("Salir");

        jmiSalir.setText("Salir");
        jmiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSalirActionPerformed(evt);
            }
        });
        jmSalir.add(jmiSalir);

        jMenuBar1.add(jmSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAlumnoActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        vAlumno v;
        try {
            v = new vAlumno();
            v.setVisible(true);
            escritorio.add(v);
            escritorio.moveToFront(v);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de carga de datos");
        }
    }//GEN-LAST:event_jmiAlumnoActionPerformed

    private void jmiMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMateriaActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        vMateria v = new vMateria();
        v.setVisible(true);
        escritorio.add(v);
        escritorio.moveToFront(v);
    }//GEN-LAST:event_jmiMateriaActionPerformed

    private void jmiManipulacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiManipulacionActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        vInscripciones v;
        try {
            v = new vInscripciones();
            v.setVisible(true);
            escritorio.add(v);
            escritorio.moveToFront(v);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de carga de datos");
        }
    }//GEN-LAST:event_jmiManipulacionActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        vActualizacionNotas v;
        try {
            v = new vActualizacionNotas();
            v.setVisible(true);
            escritorio.add(v);
            escritorio.moveToFront(v);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error de carga de datos");
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jmiAlumnosPorMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAlumnosPorMateriaActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        vConsultaAlumnoPorMateria v = null;
        try {
            v = new vConsultaAlumnoPorMateria();
        } catch (SQLException ex) {
            Logger.getLogger(VentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        v.setVisible(true);
        escritorio.add(v);
        escritorio.moveToFront(v);
    }//GEN-LAST:event_jmiAlumnosPorMateriaActionPerformed

    private void jmiSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jmiSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenu jmAdministracion;
    private javax.swing.JMenu jmAlumno;
    private javax.swing.JMenu jmConsultas;
    private javax.swing.JMenu jmMateria;
    private javax.swing.JMenu jmSalir;
    private javax.swing.JMenuItem jmiAlumno;
    private javax.swing.JMenuItem jmiAlumnosPorMateria;
    private javax.swing.JMenuItem jmiManipulacion;
    private javax.swing.JMenuItem jmiMateria;
    private javax.swing.JMenuItem jmiSalir;
    // End of variables declaration//GEN-END:variables
}
