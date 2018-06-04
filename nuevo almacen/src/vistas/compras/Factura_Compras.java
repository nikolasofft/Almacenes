
package vistas.compras;

import Conexion.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vistas.Archivos.Proveedor;

public class Factura_Compras extends javax.swing.JInternalFrame {
    String control="0";
    public static String id;
    
    void cargar_comboProveedor(){
        Connection con=null;
        Conexion conn=new Conexion();
        con=conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps=con.prepareStatement("SELECT nombre FROM provedores");
            rs=ps.executeQuery();
            while(rs.next()){
                combo_proveedor.addItem(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Factura_Compras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   void inhabilitar(){
        botonagregar.setEnabled(true);
        botonguardar.setEnabled(false);
        botonmodificar.setEnabled(true);
        campo_fecha.setEnabled(false);
        campor_tipo_factura.setEnabled(false);
        campo_factura.setEnabled(false);
        combo_estado.setEnabled(false);
        combo_proveedor.setEnabled(false);
        campo_monto.setEnabled(false);
    }
   void habilitar(){
       campo_fecha.setEnabled(true);
        campor_tipo_factura.setEnabled(true);
        campo_factura.setEnabled(true);
        combo_estado.setEnabled(true);
        combo_proveedor.setEnabled(true);
        campo_monto.setEnabled(true);
   }
   void botones(){
       botonagregar.setEnabled(false);
        botonguardar.setEnabled(true);
        botonmodificar.setEnabled(false);
   }

    
    public Factura_Compras() {
        initComponents();
        cargar_comboProveedor();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botonguardar = new javax.swing.JButton();
        botonsalir = new javax.swing.JButton();
        botonmodificar = new javax.swing.JButton();
        botonagregar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        campo_fecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campor_tipo_factura = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campo_sucursa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campo_factura = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        combo_estado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        combo_proveedor = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        campo_monto = new javax.swing.JTextField();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonguardar.setText("Guardar");
        botonguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonguardarActionPerformed(evt);
            }
        });
        jPanel1.add(botonguardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        botonsalir.setText("Salir");
        botonsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonsalirActionPerformed(evt);
            }
        });
        jPanel1.add(botonsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 83, -1));

        botonmodificar.setText("Modificar");
        botonmodificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonmodificarActionPerformed(evt);
            }
        });
        jPanel1.add(botonmodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, -1));

        botonagregar.setText("Agregar");
        botonagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonagregarActionPerformed(evt);
            }
        });
        jPanel1.add(botonagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 200));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Facturas de Compras");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 590, 60));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 630, 60));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("fecha:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));
        getContentPane().add(campo_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 230, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Tipo de Factura:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));
        getContentPane().add(campor_tipo_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 170, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Número de Sucursal:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 120, 20));
        getContentPane().add(campo_sucursa, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 150, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Número de Factura:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));
        getContentPane().add(campo_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 170, 150, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Estado:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, -1));

        combo_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Pagado", "Pendiente" }));
        getContentPane().add(combo_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 220, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Proveedor:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, -1));

        combo_proveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        getContentPane().add(combo_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 200, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Montó:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));
        getContentPane().add(campo_monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 220, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonsalirActionPerformed
        dispose();
    }//GEN-LAST:event_botonsalirActionPerformed

    private void botonagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonagregarActionPerformed
        control="1";
        botones();
        habilitar();
    }//GEN-LAST:event_botonagregarActionPerformed

    private void botonmodificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonmodificarActionPerformed
        control="0";
        botones();
        habilitar();
    }//GEN-LAST:event_botonmodificarActionPerformed

    private void botonguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonguardarActionPerformed
        Connection con=null;
        Conexion conn=new Conexion();
        con=conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        if(combo_estado.getSelectedItem()!="Seleccionar" && combo_proveedor.getSelectedItem()!="Seleccionar"){
            
       
        if(control.equals("0")){
            try {
                ps=con.prepareStatement("UPDATE fac_compras SET fecha=?, tipo=?, num_suc=?, numero=?, monto=?, estado=?, Proveedor=? WHERE id_facCompra=?");
                ps.setString(1, (campo_fecha.getText()));
                ps.setString(2, campor_tipo_factura.getText());
                ps.setString(3, campo_sucursa.getText());
                ps.setString(4, campo_factura.getText());
                ps.setString(5, campo_monto.getText());
                ps.setString(6, String.valueOf(combo_estado.getSelectedItem()));
                ps.setString(7, String.valueOf(combo_proveedor.getSelectedItem()));
                ps.setString(8,String.valueOf(id));
                
                int res=ps.executeUpdate();
                if(res>0){
                    JOptionPane.showMessageDialog(null, "Se modifico la factura de compra");
                }
                inhabilitar();
            } catch (SQLException ex) {
                Logger.getLogger(Factura_Compras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                ps=con.prepareStatement("INSERT INTO fac_compras(fecha, tipo, num_suc, numero, monto, estado, Proveedor) VALUES(?,?,?,?,?,?,?)");
                ps.setString(1, (campo_fecha.getText()));
                ps.setString(2, campor_tipo_factura.getText());
                ps.setString(3, campo_sucursa.getText());
                ps.setString(4, campo_factura.getText());
                ps.setString(5, campo_monto.getText());
                ps.setString(6, String.valueOf(combo_estado.getSelectedItem()));
                ps.setString(7, String.valueOf(combo_proveedor.getSelectedItem()));
                
                int res=ps.executeUpdate();
                if(res>0){
                    JOptionPane.showMessageDialog(null, "Se guardo la Factura de Compras");
                }
                inhabilitar();
                        } catch (SQLException ex) {
                Logger.getLogger(Factura_Compras.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         }else{
            JOptionPane.showMessageDialog(null, "Debe elegir un Estado y un Proveedor");
        }
            
    }//GEN-LAST:event_botonguardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonagregar;
    private javax.swing.JButton botonguardar;
    private javax.swing.JButton botonmodificar;
    private javax.swing.JButton botonsalir;
    public static javax.swing.JTextField campo_factura;
    public static javax.swing.JTextField campo_fecha;
    public static javax.swing.JTextField campo_monto;
    public static javax.swing.JTextField campo_sucursa;
    public static javax.swing.JTextField campor_tipo_factura;
    private javax.swing.JComboBox<String> combo_estado;
    private javax.swing.JComboBox<String> combo_proveedor;
    private javax.swing.JLabel jLabel1;
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
    // End of variables declaration//GEN-END:variables
}
