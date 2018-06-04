
package vistas.Ventas;



import Conexion.Conexion;
import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import vistas.Principal;


public class Ventas extends javax.swing.JInternalFrame {
 String fecha="";
 double total=0;
 
 void cargar(){
     DefaultTableModel model=new DefaultTableModel();
        tablaventas.setModel(model);
        Connection con = null;
                Conexion conn = new Conexion();
                con = conn.getConexion();
                PreparedStatement ps;
                ResultSet rs;
     try {
         ps=con.prepareStatement("SELECT codigo, detalle, cantidad, PrecioUnidad, cliente, precio FROM ventas_dia");
         
         rs=ps.executeQuery();
         ResultSetMetaData rsmd=rs.getMetaData();
         int cantidad=rsmd.getColumnCount();
         model.addColumn("código");
         model.addColumn("detalle");
         model.addColumn("cantidad");
         model.addColumn("PrecioUnidad");
         model.addColumn("cliente");
         model.addColumn("precio");
         while(rs.next()){
             Object[] fila=new Object[cantidad];
             for(int i=0;i<cantidad;i++){
                 
                 fila[i]=rs.getObject(i+1);
             }
             model.addRow(fila);
         }
         
     } catch (SQLException ex) {
         Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
     }
 }
    
    public Ventas() {
        initComponents();
        DateFormat formato=new SimpleDateFormat("dd/MM/YYYY");
        
        fecha_venta.setText(String.valueOf(formato.format(new Date())));
        
        cargar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fecha_venta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaventas = new javax.swing.JTable();
        ActualizarTabla = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setTitle("Ventas del Día");
        setMaximumSize(new java.awt.Dimension(928, 564));
        setMinimumSize(new java.awt.Dimension(928, 564));
        setPreferredSize(new java.awt.Dimension(928, 564));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ventas del Día");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 23, -1, -1));

        fecha_venta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fecha_ventaMouseClicked(evt);
            }
        });
        fecha_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecha_ventaActionPerformed(evt);
            }
        });
        jPanel1.add(fecha_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(812, 29, 90, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fecha:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(769, 32, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 70));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 450, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 912, -1));

        tablaventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Descripción", "Cantidad", "Unidad", "Cliente", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tablaventas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 73, 912, 390));

        ActualizarTabla.setText("Actualizar Tabla");
        ActualizarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarTablaActionPerformed(evt);
            }
        });
        getContentPane().add(ActualizarTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, 30));

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fecha_ventaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fecha_ventaMouseClicked
        
       
        
    }//GEN-LAST:event_fecha_ventaMouseClicked

    private void ActualizarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarTablaActionPerformed
        cargar();
    }//GEN-LAST:event_ActualizarTablaActionPerformed

    private void fecha_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecha_ventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fecha_ventaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActualizarTabla;
    private javax.swing.JTextField fecha_venta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaventas;
    // End of variables declaration//GEN-END:variables
}
