package vistas.Archivos;

import Conexion.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Tipo_Producto extends javax.swing.JInternalFrame {

    byte variable = 0;

    void inhabilitar() {
        detalle.setEnabled(false);
        estado.setEnabled(false);
        guardar.setEnabled(false);
        agregar.setEnabled(true);
        modificar.setEnabled(true);
        eliminar.setEnabled(true);
    }

    void habilitar() {
        detalle.setEnabled(true);
        estado.setEnabled(true);
    }

    void cargar_tabla() {
        DefaultTableModel model = new DefaultTableModel();
        tabla_tipo_producto.setModel(model);

        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_tipo, detalle, estado FROM tipo_producto");

            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidaddecolum = rsmd.getColumnCount();
            
            model.addColumn("id");
            model.addColumn("detelle");
            model.addColumn("estado");

            while (rs.next()) {
                Object[] fila = new Object[cantidaddecolum];
                for (int i = 0; i < cantidaddecolum; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Tipo_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Tipo_Producto() {
        initComponents();
        cargar_tabla();
        inhabilitar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        guardar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        agregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        detalle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        estado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_tipo_producto = new javax.swing.JTable();

        setTitle("Tipos de Productos");
        setMaximumSize(new java.awt.Dimension(860, 191));
        setMinimumSize(new java.awt.Dimension(860, 191));
        setPreferredSize(new java.awt.Dimension(860, 191));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 127, 90, -1));

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 98, 90, -1));

        agregar.setText("agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        jPanel1.add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 160));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tipos de Productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Detalle:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 50, 20));

        detalle.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(detalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 200, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Estado:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Activo", "Inactivo", " " }));
        getContentPane().add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 200, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 290, 160));

        tabla_tipo_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Detalle", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla_tipo_producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_tipo_productoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_tipo_producto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, 160));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        variable = 1;
        guardar.setEnabled(true);
        agregar.setEnabled(false);
        modificar.setEnabled(false);
        eliminar.setEnabled(false);
        habilitar();
    }//GEN-LAST:event_agregarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        variable = 0;
        guardar.setEnabled(true);
        agregar.setEnabled(false);
        modificar.setEnabled(false);
        eliminar.setEnabled(false);
        habilitar();
    }//GEN-LAST:event_modificarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        if (variable == 0) {

            try {
                ps = con.prepareStatement("SELECT * FROM tipo_producto WHERE detalle=?");
                ps.setString(1, detalle.getText());

                rs = ps.executeQuery();

                if (rs.next()) {
                    String indice = rs.getString("id_tipo");
                    ps = con.prepareStatement("UPDATE tipo_producto SET detalle=?, estado=? WHERE id_tipo=?");
                    ps.setString(1, detalle.getText());
                    ps.setString(2, String.valueOf(estado.getSelectedItem()));
                    ps.setString(3, indice);

                    int res = ps.executeUpdate();
                    if (res > 0) {
                        JOptionPane.showMessageDialog(null, "se modifico con exito el tipo de producto");
                    }
                }
                inhabilitar();
                cargar_tabla();
            } catch (Exception e) {

            }
        } else {
            try {
                ps = con.prepareStatement("INSERT INTO tipo_producto(detalle, estado) VALUES(?,?)");
                ps.setString(1, detalle.getText());
                ps.setString(2, String.valueOf(estado.getSelectedItem()));

                int re = ps.executeUpdate();
                if (re > 0) {
                    JOptionPane.showMessageDialog(null, "se guardo con exito el tipo de producto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Tipo_Producto.class.getName()).log(Level.SEVERE, null, ex);
            }
            inhabilitar();
            cargar_tabla();
            variable = 0;
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        try {
            
                 ps = con.prepareStatement("DELET FROM tipo_producto WHERE id_tipo=?");
                int indice=tabla_tipo_producto.getSelectedRow();
                
                 ps.setString(1, (String) tabla_tipo_producto.getValueAt(indice, 0));

                int ress = ps.executeUpdate();
                if (ress > 0) {
                    JOptionPane.showMessageDialog(null, "Se elimino con exito el tipo de producto");
                }
            

        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_eliminarActionPerformed

    private void tabla_tipo_productoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_tipo_productoMouseClicked
        int fila = tabla_tipo_producto.getSelectedRow();
        detalle.setText(String.valueOf(tabla_tipo_producto.getValueAt(fila, 1)));
        estado.setSelectedItem(tabla_tipo_producto.getValueAt(fila, 2));
    }//GEN-LAST:event_tabla_tipo_productoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JTextField detalle;
    private javax.swing.JButton eliminar;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificar;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla_tipo_producto;
    // End of variables declaration//GEN-END:variables
}
