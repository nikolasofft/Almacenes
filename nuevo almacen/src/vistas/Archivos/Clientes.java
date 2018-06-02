package vistas.Archivos;

import Conexion.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Clientes extends javax.swing.JInternalFrame {

    byte per = 0;

    void inhabilitar() {
        nombre.setEnabled(false);
        domicilio.setEnabled(false);
        correo.setEnabled(false);
        cuit.setEnabled(false);
        nuevocliente.setEnabled(true);
        Guardar.setEnabled(false);
        modificar.setEnabled(true);
        eliminar.setEnabled(true);
    }

    void cargar_tabla() {
        DefaultTableModel model = new DefaultTableModel();
        tabla_clientes.setModel(model);

        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_cliente, nombre, domicilio, correo, cuit FROM clientes");

            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidadcolumnas = rsmd.getColumnCount();

            model.addColumn("id");
            model.addColumn("nombre");
            model.addColumn("domicilio");
            model.addColumn("correo");
            model.addColumn("cuit");

            while (rs.next()) {
                Object[] filas = new Object[cantidadcolumnas];
                for (int i = 0; i < cantidadcolumnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                int[] anchos = {17, 80, 90, 90, 75};
                for (int i = 0; i < 5; i++) {
                    tabla_clientes.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                }
                model.addRow(filas);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Clientes() {
        initComponents();
        inhabilitar();
        cargar_tabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        nuevocliente = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        domicilio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_clientes = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        cuit = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setTitle("Mantenimiento de Clientes");
        setMaximumSize(new java.awt.Dimension(1038, 252));
        setMinimumSize(new java.awt.Dimension(1038, 252));
        setPreferredSize(new java.awt.Dimension(1038, 252));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nuevocliente.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        nuevocliente.setText("Nuevo Cliente");
        nuevocliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoclienteActionPerformed(evt);
            }
        });
        jPanel1.add(nuevocliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 100, -1));

        Guardar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        jPanel1.add(Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 100, -1));

        modificar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        jPanel1.add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 74, 100, -1));

        salir.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 186, 100, -1));

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 100, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 220));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mantenimiento del Cliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        nombre.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 280, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Domicilio:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        domicilio.setBackground(new java.awt.Color(204, 204, 204));
        domicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                domicilioActionPerformed(evt);
            }
        });
        getContentPane().add(domicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 280, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Correo:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, -1, -1));

        correo.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 280, -1));

        tabla_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "Domicilio", "Correo", "Cuit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_clientesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabla_clientes);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 540, 220));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cuit:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, -1));

        cuit.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(cuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 280, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 370, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void domicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_domicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_domicilioActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void nuevoclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoclienteActionPerformed
        nuevocliente.setEnabled(false);
        modificar.setEnabled(false);
        eliminar.setEnabled(false);
        Guardar.setEnabled(true);
        nombre.setEnabled(true);
        domicilio.setEnabled(true);
        correo.setEnabled(true);
        cuit.setEnabled(true);
        per = 1;
    }//GEN-LAST:event_nuevoclienteActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        if (per == 0) {
            try {

                ps = con.prepareStatement("UPDATE clientes SET nombre=?, domicilio=?, correo=?, cuit=? WHERE id_cliente=?");
                int rr = tabla_clientes.getSelectedRow();
                ps.setString(1, nombre.getText());
                ps.setString(2, domicilio.getText());
                ps.setString(3, correo.getText());
                ps.setString(4, cuit.getText());
                ps.setString(5, (String) tabla_clientes.getValueAt(rr, 0));

                int re = ps.executeUpdate();
                if (re > 0) {
                    JOptionPane.showMessageDialog(null, "se modifico el cliente");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
            cargar_tabla();
            inhabilitar();
        } else if (per == 1) {
            try {
                ps = con.prepareStatement("INSERT INTO clientes(nombre, domicilio, correo, cuit) VALUES(?,?,?,?)");
                ps.setString(1, nombre.getText());
                ps.setString(2, domicilio.getText());
                ps.setString(3, correo.getText());
                ps.setString(4, cuit.getText());

                int res = ps.executeUpdate();
                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "Se Guardo el Cliente");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
            inhabilitar();
            cargar_tabla();
        }

    }//GEN-LAST:event_GuardarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        nuevocliente.setEnabled(false);
        eliminar.setEnabled(false);
        Guardar.setEnabled(true);
        modificar.setEnabled(false);

        nombre.setEnabled(true);
        domicilio.setEnabled(true);
        correo.setEnabled(true);
        cuit.setEnabled(true);
    }//GEN-LAST:event_modificarActionPerformed

    private void tabla_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_clientesMouseClicked
        int fila = tabla_clientes.getSelectedRow();

        nombre.setText(String.valueOf(tabla_clientes.getValueAt(fila, 1)));
        domicilio.setText(String.valueOf(tabla_clientes.getValueAt(fila, 2)));
        correo.setText(String.valueOf(tabla_clientes.getValueAt(fila, 3)));
        cuit.setText(String.valueOf(tabla_clientes.getValueAt(fila, 4)));
    }//GEN-LAST:event_tabla_clientesMouseClicked

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("DELETE FROM clientes WHERE id_cliente=?");
            int rr = tabla_clientes.getSelectedRow();
            int ar = (int) tabla_clientes.getValueAt(rr, 0);
            ps.setInt(1, ar);

            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Se elimino el cliente con exito");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
        }
        cargar_tabla();

    }//GEN-LAST:event_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Guardar;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField cuit;
    private javax.swing.JTextField domicilio;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton nuevocliente;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla_clientes;
    // End of variables declaration//GEN-END:variables
}
