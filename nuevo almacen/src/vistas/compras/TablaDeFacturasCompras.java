
package vistas.compras;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static vistas.Principal.panel;


public class TablaDeFacturasCompras extends javax.swing.JInternalFrame {
    
    void cargar_tabla(){
        DefaultTableModel model=new DefaultTableModel();
        tablaFacCompras.setModel(model);
        
        Connection con=null;
        Conexion conn=new Conexion();
        con=conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps=con.prepareStatement("SELECT id_facCompra, fecha, numero, monto, estado, Proveedor FROM fac_compras");
            rs=ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int cantidadcolum=rsmd.getColumnCount();
            model.addColumn("id");
            model.addColumn("Fecha");
            model.addColumn("Número de Factura");
            model.addColumn("Montó");
            model.addColumn("Estado");
            model.addColumn("Proveedor");
            
            while(rs.next()){
                Object[] filas=new Object[cantidadcolum];
                for(int i=0;i<cantidadcolum;i++){
                    filas[i]=rs.getObject(i+1);
                }
                model.addRow(filas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TablaDeFacturasCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public TablaDeFacturasCompras() {
        initComponents();
        cargar_tabla();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFacCompras = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        fecha = new javax.swing.JRadioButton();
        estado = new javax.swing.JRadioButton();
        proveedor = new javax.swing.JRadioButton();
        numero_factura = new javax.swing.JRadioButton();
        boton_modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setTitle("Tabla de Facturas de Compras");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tabla de Facturas de Compras");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 48));

        tablaFacCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Fecha", "Número de Factura", "Montó", "Estado", "Proveedor"
            }
        ));
        jScrollPane1.setViewportView(tablaFacCompras);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 600, 390));

        jLabel3.setText("Buscar por:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 130, -1));

        buttonGroup1.add(fecha);
        fecha.setText("Fecha");
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, -1, -1));

        buttonGroup1.add(estado);
        estado.setText("Estado");
        getContentPane().add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, -1, -1));

        buttonGroup1.add(proveedor);
        proveedor.setText("Proveedor");
        getContentPane().add(proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, -1, -1));

        buttonGroup1.add(numero_factura);
        numero_factura.setText("Número de factura");
        getContentPane().add(numero_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        boton_modificar.setText("Modificar");
        boton_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_modificarActionPerformed(evt);
            }
        });
        getContentPane().add(boton_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 90, -1));

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 90, -1));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 530, 70, -1));

        jButton2.setText("Actualizar Tabla");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        Connection con=null;
        Conexion conn=new Conexion();
        con=conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        int fila=tablaFacCompras.getSelectedRow();
        try {
            ps=con.prepareStatement("DELETE FROM fac_compras WHERE id_facCompra=?");
            ps.setString(1, String.valueOf( tablaFacCompras.getValueAt(fila, 0)));
            int res=ps.executeUpdate();
            if(res>0){
                JOptionPane.showMessageDialog(null, "se elimino la factura de compras");
            }
        } catch (SQLException ex) {
            Logger.getLogger(TablaDeFacturasCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_eliminarActionPerformed

    private void boton_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_modificarActionPerformed
        Factura_Compras fa=new Factura_Compras();
        panel.add(fa);
        fa.setVisible(true);
        
        int fila=tablaFacCompras.getSelectedRow();
        String id_comp=String.valueOf(tablaFacCompras.getValueAt(fila, 0));
        Factura_Compras.id=String.valueOf(tablaFacCompras.getValueAt(fila, 0));
        
        Connection con=null;
        Conexion conn=new Conexion();
        con=conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps=con.prepareStatement("SELECT * FROM fac_compras WHERE id_facCompra=?");
            ps.setString(1, id_comp);
            rs=ps.executeQuery();
            if(rs.next()){
                Factura_Compras.campo_fecha.setText(rs.getString("fecha"));
               Factura_Compras.campor_tipo_factura.setText(rs.getString("tipo"));
               Factura_Compras.campo_sucursa.setText(rs.getString("num_suc"));
               Factura_Compras.campo_factura.setText(rs.getString("numero"));
               Factura_Compras.campo_monto.setText(rs.getString("monto"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TablaDeFacturasCompras.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_boton_modificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cargar_tabla();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_modificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton eliminar;
    private javax.swing.JRadioButton estado;
    private javax.swing.JRadioButton fecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JRadioButton numero_factura;
    private javax.swing.JRadioButton proveedor;
    private javax.swing.JTable tablaFacCompras;
    // End of variables declaration//GEN-END:variables
}
