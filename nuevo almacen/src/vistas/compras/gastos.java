package vistas.compras;

import Conexion.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class gastos extends javax.swing.JInternalFrame {

    int control = 0;
    public static String id;
    
    void cargarcombo(){
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps=con.prepareStatement("SELECT nombre FROM provedores");
            rs=ps.executeQuery();
            
            while(rs.next()){
                proveedor.addItem(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(gastos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    void inhabilitar() {
        agregar.setEnabled(true);
        guardar.setEnabled(false);
        modificar.setEnabled(true);
        fecha.setEnabled(false);
        tipofactura.setEnabled(false);
        sucursal.setEnabled(false);
        numerofact.setEnabled(false);
        estado.setEnabled(false);
        proveedor.setEnabled(false);
        monto.setEnabled(false);
    }

    void habilitar() {
        fecha.setEnabled(true);
        tipofactura.setEnabled(true);
        sucursal.setEnabled(true);
        numerofact.setEnabled(true);
        estado.setEnabled(true);
        proveedor.setEnabled(true);
        monto.setEnabled(true);
    }

    public gastos() {
        initComponents();
        cargarcombo();
        inhabilitar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        agregar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        estado = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tipofactura = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        proveedor = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        sucursal = new javax.swing.JTextField();
        numerofact = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        monto = new javax.swing.JTextField();

        setTitle("Gastos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        jPanel1.add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 90, -1));

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel1.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        jPanel1.add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 69, 90, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 190));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Gastos");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 460, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 640, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Fecha:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 230, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Estado:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, -1, -1));

        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Pagado", "Pendiente" }));
        getContentPane().add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 260, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Tipo de Factura:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));
        getContentPane().add(tipofactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 170, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Proveedor:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, -1));

        proveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        getContentPane().add(proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 240, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Número de Sucursal:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, -1, -1));
        getContentPane().add(sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 150, -1));
        getContentPane().add(numerofact, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 150, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Número de Factura:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Montó:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, -1));
        getContentPane().add(monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 260, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        control = 1;
        agregar.setEnabled(false);
        guardar.setEnabled(true);
        modificar.setEnabled(false);
        habilitar();

    }//GEN-LAST:event_agregarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        control = 0;
        agregar.setEnabled(false);
        guardar.setEnabled(true);
        modificar.setEnabled(false);
        habilitar();
    }//GEN-LAST:event_modificarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        if (estado.getSelectedItem() != "Seleccionar" && proveedor.getSelectedItem() != "Seleccionar") {
            if (control == 0) {
                try {
                    ps = con.prepareStatement("UPDATE com_gasto SET fecha=?, tipo=?, num_sucursal=?, numero=?, monto=?, estado=?, proveedor=? WHERE id_gasto=?");
                    ps.setString(1, fecha.getText());
                    ps.setString(2, tipofactura.getText());
                    ps.setString(3, sucursal.getText());
                    ps.setString(4, numerofact.getText());
                    ps.setString(5, monto.getText());
                    ps.setString(6, String.valueOf(estado.getSelectedItem()));
                    ps.setString(7, String.valueOf(proveedor.getSelectedItem()));
                    ps.setString(8, String.valueOf(id));
                    int res = ps.executeUpdate();
                    if (res > 0) {
                        JOptionPane.showMessageDialog(null, "Se modifico la factura");
                    }
                    inhabilitar();
                } catch (SQLException ex) {
                    Logger.getLogger(gastos.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                try {
                    ps = con.prepareStatement("INSERT INTO com_gasto(fecha, tipo, num_sucursal, numero, monto, estado, proveedor) VALUES(?,?,?,?,?,?,?)");
                    ps.setString(1, fecha.getText());
                    ps.setString(2, tipofactura.getText());
                    ps.setString(3, sucursal.getText());
                    ps.setString(4, numerofact.getText());
                    ps.setString(5, monto.getText());
                    ps.setString(6, String.valueOf(estado.getSelectedItem()));
                    ps.setString(7, String.valueOf(proveedor.getSelectedItem()));
                    int res = ps.executeUpdate();
                    if (res > 0) {
                        JOptionPane.showMessageDialog(null, "Se se guardo la factura");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(gastos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            inhabilitar();
        } else {
            JOptionPane.showMessageDialog(null, "Debe Elegir un Estado y un Proveedor");
        }

    }//GEN-LAST:event_guardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JComboBox<String> estado;
    public static javax.swing.JTextField fecha;
    private javax.swing.JButton guardar;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton modificar;
    public static javax.swing.JTextField monto;
    public static javax.swing.JTextField numerofact;
    private javax.swing.JComboBox<String> proveedor;
    private javax.swing.JButton salir;
    public static javax.swing.JTextField sucursal;
    public static javax.swing.JTextField tipofactura;
    // End of variables declaration//GEN-END:variables
}
