/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pomodorogui;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.*;

/**
 *
 * @author jose26398
 */
public class PomodoroGUI extends javax.swing.JFrame {
    
    static PomodoroDB pomDB;

    /**
     * Creates new form PomodoroGUI
     */
    public PomodoroGUI() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        botonAniadirEmpleado = new javax.swing.JButton();
        botonEliminarEmpleado1 = new javax.swing.JButton();
        botonAniadirTarea = new javax.swing.JButton();
        botonAsignarTarea = new javax.swing.JButton();
        botonEliminarTarea = new javax.swing.JButton();
        botonDesasignarEmpleado = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        botonEliminarPlato = new javax.swing.JButton();
        botonAniadirPlato = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        botonIncluirProveedor = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        botonMostrarBD = new javax.swing.JButton();
        titulo = new javax.swing.JLabel();
        botonInsertar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        botonAniadirEmpleado.setText("Añadir Empleado");
        botonAniadirEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAniadirEmpleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonAniadirEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAniadirEmpleadoActionPerformed(evt);
            }
        });

        botonEliminarEmpleado1.setText("Eliminar Empleado");
        botonEliminarEmpleado1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminarEmpleado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarEmpleado1ActionPerformed(evt);
            }
        });

        botonAniadirTarea.setText("Añadir Tarea");
        botonAniadirTarea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAniadirTarea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonAniadirTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAniadirTareaActionPerformed(evt);
            }
        });

        botonAsignarTarea.setText("Asignar Empleado a una Tarea");
        botonAsignarTarea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAsignarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAsignarTareaActionPerformed(evt);
            }
        });

        botonEliminarTarea.setText("Eliminar Tarea");
        botonEliminarTarea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarTareaActionPerformed(evt);
            }
        });

        botonDesasignarEmpleado.setText("Desasignar Empleado a una Tarea");
        botonDesasignarEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonDesasignarEmpleado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonDesasignarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDesasignarEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonEliminarEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAniadirEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonEliminarTarea, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                    .addComponent(botonDesasignarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonAsignarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAniadirTarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(139, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonAniadirTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botonAniadirEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonEliminarEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botonEliminarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonAsignarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botonDesasignarEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gestión de Empleados", jPanel1);

        botonEliminarPlato.setText("Eliminar Plato (RF 2.2)");
        botonEliminarPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarPlatoActionPerformed(evt);
            }
        });

        botonAniadirPlato.setText("Añadir Plato");
        botonAniadirPlato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAniadirPlatoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonAniadirPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonEliminarPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(497, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(botonAniadirPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonEliminarPlato, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );

        jTabbedPane1.addTab("Gestión de Menus", jPanel2);

        botonIncluirProveedor.setText("Incluir Proveedor (RF 3.1)");
        botonIncluirProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIncluirProveedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 784, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(164, 164, 164)
                    .addComponent(botonIncluirProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(426, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 343, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(149, 149, 149)
                    .addComponent(botonIncluirProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(137, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Gestión de Proveedores", jPanel3);

        botonSalir.setBackground(new java.awt.Color(210, 62, 52));
        botonSalir.setText("Salir");
        botonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        botonMostrarBD.setText("Mostrar Base de Datos");
        botonMostrarBD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonMostrarBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonMostrarBDActionPerformed(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("BASE DE DATOS DEL RESTAURANTE POMODORO");
        titulo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        botonInsertar.setText("Insertar en la Base de Datos");
        botonInsertar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInsertarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonMostrarBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(botonInsertar, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonMostrarBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(botonInsertar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonEliminarPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarPlatoActionPerformed
        String salida = "";
        try {
            salida = pomDB.eliminarTabla("Plato");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar el plato");
        }
        JOptionPane.showMessageDialog(this, salida);  
    }//GEN-LAST:event_botonEliminarPlatoActionPerformed

    private void botonIncluirProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonIncluirProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonIncluirProveedorActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        JOptionPane.showMessageDialog(this, "Hasta pronto!");
        try {
            pomDB.cerrarConexion();
        } catch (SQLException ex) {
            Logger.getLogger(PomodoroGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonAniadirEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAniadirEmpleadoActionPerformed
        String db = "";
        try {
            db = pomDB.insertarTabla("Empleado");
            JOptionPane.showMessageDialog(this, db);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al añadir un empleado");
        }
    }//GEN-LAST:event_botonAniadirEmpleadoActionPerformed

    private void botonMostrarBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonMostrarBDActionPerformed
        String db = "", tabla = "";
        String[] options = {"Empleado", "Tarea", "Menu", "Plato", "Proveedor", "Ingrediente",
                          "menu_contiene_plato", "plato_contiene_ing", "provee", "asignacion"};
        tabla = (String) JOptionPane.showInputDialog(null,"Selecciona una tabla", "Tablas...",
                                            JOptionPane.QUESTION_MESSAGE,null,options, options[0]);
        try {
            pomDB.mostrarTabla(tabla);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "La tabla que has introducido no existe");
        }
    }//GEN-LAST:event_botonMostrarBDActionPerformed

    private void botonInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInsertarActionPerformed
        String db = "", tabla = "";
        String[] options = {"Empleado", "Tarea", "Menu", "Plato", "Proveedor", "Ingrediente",
                          "menu_contiene_plato", "plato_contiene_ing", "provee", "asignacion"};
        tabla = (String) JOptionPane.showInputDialog(null,"Selecciona una tabla", "Tablas...",
                                            JOptionPane.QUESTION_MESSAGE,null,options, options[0]);
        try {
            db = pomDB.insertarTabla(tabla);
            JOptionPane.showMessageDialog(this, db);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "La tabla que has introducido no existe");
        }
    }//GEN-LAST:event_botonInsertarActionPerformed

    private void botonEliminarEmpleado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarEmpleado1ActionPerformed
        String salida = "";
        try {
            salida = pomDB.eliminarTabla("Empleado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar el empleado");
        }
        JOptionPane.showMessageDialog(this, salida);  
    }//GEN-LAST:event_botonEliminarEmpleado1ActionPerformed

    private void botonAsignarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAsignarTareaActionPerformed
        String db = "";
        try {
            db = pomDB.insertarTabla("asignacion");
            JOptionPane.showMessageDialog(this, db);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al asignar tarea");
        }
    }//GEN-LAST:event_botonAsignarTareaActionPerformed

    private void botonAniadirTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAniadirTareaActionPerformed
        String db = "";
        try {
            db = pomDB.insertarTabla("Tarea");
            JOptionPane.showMessageDialog(this, db);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al insertar una tarea nueva");
        }
    }//GEN-LAST:event_botonAniadirTareaActionPerformed

    private void botonEliminarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarTareaActionPerformed
        String salida = "";
        try {
            salida = pomDB.eliminarTabla("Tarea");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al eliminar la tarea");
        }
        JOptionPane.showMessageDialog(this, salida); 
    }//GEN-LAST:event_botonEliminarTareaActionPerformed

    private void botonDesasignarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDesasignarEmpleadoActionPerformed
        String salida = "";
        try {
            salida = pomDB.eliminarTabla("asignacion");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al desasignar empleado");
        }
        JOptionPane.showMessageDialog(this, salida); 
    }//GEN-LAST:event_botonDesasignarEmpleadoActionPerformed

    private void botonAniadirPlatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAniadirPlatoActionPerformed
        String db = "";
        try {
            db = pomDB.insertarTabla("Plato");
            JOptionPane.showMessageDialog(this, db);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al insertar un plato");
        }
    }//GEN-LAST:event_botonAniadirPlatoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PomodoroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PomodoroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PomodoroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PomodoroGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PomodoroGUI().setVisible(true);
                pomDB = new PomodoroDB();
                pomDB.crearConexion();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAniadirEmpleado;
    private javax.swing.JButton botonAniadirPlato;
    private javax.swing.JButton botonAniadirTarea;
    private javax.swing.JButton botonAsignarTarea;
    private javax.swing.JButton botonDesasignarEmpleado;
    private javax.swing.JButton botonEliminarEmpleado1;
    private javax.swing.JButton botonEliminarPlato;
    private javax.swing.JButton botonEliminarTarea;
    private javax.swing.JButton botonIncluirProveedor;
    private javax.swing.JButton botonInsertar;
    private javax.swing.JButton botonMostrarBD;
    private javax.swing.JButton botonSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
