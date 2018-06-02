package vistas.Archivos;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Registro extends javax.swing.JInternalFrame {

    void inhabilitar(){
        nombre.setEnabled(false);
        apellido.setEnabled(false);
        usuario.setEnabled(false);
        contraseña1.setEnabled(false);
        contraseña2.setEnabled(false);
        Permisos.setEnabled(false);
        correo.setEnabled(false);
        Registrar.setEnabled(false);
        modificar.setEnabled(true);
        nuevo_usuario.setEnabled(true);
    }
    
    public void cargar_combobox() {
        Connection con = null;
        Conexion CONN = new Conexion();
        con = CONN.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        try {
            ps = con.prepareStatement("SELECT * FROM permisos");
            rs = ps.executeQuery();

            while (rs.next()) {
                Permisos.addItem(rs.getString("nombre"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public Registro() {
        initComponents();
        limpiaFrm();
        cargar_combobox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        modificar = new javax.swing.JButton();
        nuevo_usuario = new javax.swing.JButton();
        Registrar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        apellido = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        contraseña1 = new javax.swing.JPasswordField();
        contraseña2 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        Permisos = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();

        setTitle("Registrarse");
        setMaximumSize(new java.awt.Dimension(519, 308));
        setMinimumSize(new java.awt.Dimension(519, 308));
        setPreferredSize(new java.awt.Dimension(519, 308));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/equipo.png"))); // NOI18N

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        nuevo_usuario.setText("Nuevo Usuario");
        nuevo_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_usuarioActionPerformed(evt);
            }
        });

        Registrar.setText("Registrar");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nuevo_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Registrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(modificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nuevo_usuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Registrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 280));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registro de Usuario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 11, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 52, -1, -1));

        nombre.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 49, 260, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Apellido:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 83, -1, -1));

        apellido.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 80, 260, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Usuario:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 114, -1, -1));

        usuario.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 111, 260, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Contraseña:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 145, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("<html>Repetir Contraseña:</html>");
        jLabel7.setToolTipText("");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 168, 82, -1));

        contraseña1.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(contraseña1, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 142, 260, -1));

        contraseña2.setBackground(new java.awt.Color(204, 204, 204));
        contraseña2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseña2ActionPerformed(evt);
            }
        });
        getContentPane().add(contraseña2, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 176, 260, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Permiso:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 210, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Correo:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 239, -1, -1));

        correo.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 236, 260, -1));

        Permisos.setBackground(new java.awt.Color(204, 204, 204));
        Permisos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Nivel1", "Nivel2" }));
        getContentPane().add(Permisos, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 207, 260, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 360, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void contraseña2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contraseña2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contraseña2ActionPerformed

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        Connection con = null;
        con = new Conexion().getConexion();
        PreparedStatement ps;
        ResultSet rs;
        String con1 = String.valueOf(contraseña1.getPassword());
        String con2 = String.valueOf(contraseña2.getPassword());
        try {
            if (con1.equals(con2)) {
                ps = con.prepareStatement("INSERT INTO usuarios(nombre, apellido, usuario, contraseña, contraseña2, correo, permisos_id_permiso) VALUES(?,?,?,?,?,?,?)");
                ps.setString(1, nombre.getText());
                ps.setString(2, apellido.getText());
                ps.setString(3, usuario.getText());
                ps.setString(4, String.valueOf(contraseña1.getPassword()));
                ps.setString(5, String.valueOf(contraseña2.getPassword()));
                ps.setString(6, correo.getText());
                ps.setInt(7, Permisos.getSelectedIndex());

                int ret = ps.executeUpdate();
                if (ret > 0) {
                    JOptionPane.showMessageDialog(null, "Se guardo el Usuario");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo guardar el Usuario 'INTENTELO NUEVAMENTE'");
                }
            } else {
                JOptionPane.showMessageDialog(null, "las contraseña y la cofirmacion de contraseña no son iguales");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        limpiaFrm();
    }//GEN-LAST:event_RegistrarActionPerformed

    private void nuevo_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_usuarioActionPerformed
        habilitarFrm();
    }//GEN-LAST:event_nuevo_usuarioActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed

    }//GEN-LAST:event_modificarActionPerformed
    public void limpiaFrm() {
        this.nombre.setText("");
        this.nombre.setEnabled(false);
        this.apellido.setText("");
        this.apellido.setEnabled(false);
        this.usuario.setText("");
        this.usuario.setEnabled(false);
        this.contraseña1.setText("");
        this.contraseña1.setEnabled(false);
        this.contraseña2.setText("");
        this.contraseña2.setEnabled(false);
        this.correo.setText("");
        this.correo.setEnabled(false);
        this.Permisos.setEnabled(false);
    }

    public void habilitarFrm() {
        this.nombre.setEnabled(true);
        this.apellido.setEnabled(true);
        this.usuario.setEnabled(true);
        this.contraseña1.setEnabled(true);
        this.contraseña2.setEnabled(true);
        this.correo.setEnabled(true);
        this.Permisos.setEnabled(true);
        this.nombre.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Permisos;
    private javax.swing.JButton Registrar;
    private javax.swing.JTextField apellido;
    private javax.swing.JPasswordField contraseña1;
    private javax.swing.JPasswordField contraseña2;
    private javax.swing.JTextField correo;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton nuevo_usuario;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
