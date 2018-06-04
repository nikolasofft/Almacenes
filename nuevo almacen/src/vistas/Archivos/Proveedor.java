package vistas.Archivos;

import vistas.AdministradorDeUsuarios.Permisos;
import Conexion.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Proveedor extends javax.swing.JInternalFrame {

    byte var = 0;

    void inhabilitart() {
        nuevo.setEnabled(true);
        modificar.setEnabled(true);
        eliminar.setEnabled(true);
        nombre.setEnabled(false);
        domicilio.setEnabled(false);
        correo.setEnabled(false);
        cuit.setEnabled(false);
        telefono.setEnabled(false);
        guardar.setEnabled(false);
    }

    void habilitar() {
        nombre.setEnabled(true);
        telefono.setEnabled(true);
        correo.setEnabled(true);
        cuit.setEnabled(true);
        domicilio.setEnabled(true);
    }

    void cargar_tabla() {
        DefaultTableModel model = new DefaultTableModel();
        tabla_proveedores.setModel(model);
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_provedor,nombre, domicilio, cuit, telefono, correo FROM provedores");

            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidad = rsmd.getColumnCount();
            
            model.addColumn("id");
            model.addColumn("nombre");
            model.addColumn("domicilio");
            model.addColumn("cuit");
            model.addColumn("telefono");
            model.addColumn("correo");

            while (rs.next()) {
                Object[] fila = new Object[cantidad];
                for (int i = 0; i < cantidad; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                int[] anchos = {15, 80, 80, 80, 70};
                for (int i = 0; i < 5; i++) {
                    tabla_proveedores.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                }
                model.addRow(fila);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Proveedor() {
        initComponents();
        inhabilitart();
        cargar_tabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cuit = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        domicilio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_proveedores = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        nuevo = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

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

        setTitle("Proveedores");
        setMaximumSize(new java.awt.Dimension(588, 445));
        setMinimumSize(new java.awt.Dimension(588, 445));
        setPreferredSize(new java.awt.Dimension(588, 445));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mantenimiento de Proveedores");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 350, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cuit:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));
        getContentPane().add(cuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 350, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Domicilio:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, -1, -1));

        domicilio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                domicilioActionPerformed(evt);
            }
        });
        getContentPane().add(domicilio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 350, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Telefono:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));
        getContentPane().add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 350, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Correo:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, -1, -1));
        getContentPane().add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 350, -1));

        tabla_proveedores.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "Nombre", "Domicilio", "Cuit", "Correo", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla_proveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_proveedoresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla_proveedores);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 580, 220));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 440, 220));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nuevo.setText("Nuevo Proveedor");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jPanel2.add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 120, -1));

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        jPanel2.add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 41, 120, -1));

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        jPanel2.add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, -1));

        eliminar.setText("eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 99, 120, -1));

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel2.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 120, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void domicilioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_domicilioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_domicilioActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        dispose();
    }//GEN-LAST:event_salirActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        var = 1;
        guardar.setEnabled(true);
        modificar.setEnabled(false);
        eliminar.setEnabled(false);
        nuevo.setEnabled(false);
        habilitar();


    }//GEN-LAST:event_nuevoActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        guardar.setEnabled(true);
        modificar.setEnabled(false);
        nuevo.setEnabled(false);
        eliminar.setEnabled(false);
        habilitar();
    }//GEN-LAST:event_modificarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed

        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        if (var == 0) {
            try {
                ps = con.prepareStatement("SELECT * FROM provedores WHERE nombre=?");
                ps.setString(1, nombre.getText());
                rs = ps.executeQuery();
                if (rs.next()) {
                    String indice = rs.getString("id_provedor");
                    ps = con.prepareStatement("UPDATE provedores SET nombre=?, domicilio=?, cuit=?, telefono=?, correo=? WHERE id_provedor=?");
                    ps.setString(1, nombre.getText());
                    ps.setString(2, domicilio.getText());
                    ps.setString(3, cuit.getText());
                    ps.setString(4, telefono.getText());
                    ps.setString(5, correo.getText());
                    ps.setString(6, indice);

                    int res = ps.executeUpdate();
                    if (res > 0) {
                        JOptionPane.showMessageDialog(null, "se modifico con exito el proveedor");
                    }
                }
                inhabilitart();
                cargar_tabla();
            } catch (SQLException ex) {
                Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                ps = con.prepareStatement("INSERT INTO provedores(nombre, domicilio, cuit, telefono, correo) VALUES(?,?,?,?,?)");
                ps.setString(1, nombre.getText());
                ps.setString(2, domicilio.getText());
                ps.setString(3, cuit.getText());
                ps.setString(4, telefono.getText());
                ps.setString(5, correo.getText());
                
                int ree=ps.executeUpdate();
                if(ree>0){
                    JOptionPane.showMessageDialog(null, "se guardo con exito el proveedor");
                }
                inhabilitart();
                cargar_tabla();
            } catch (SQLException ex) {
                Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_guardarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        Connection con=null;
        Conexion conn=new Conexion();
        con=conn.getConexion();
        PreparedStatement ps;
        
       try {
            ps=con.prepareStatement("DELETE FROM provedores WHERE id_provedor=?");
            int rr=tabla_proveedores.getSelectedRow();
            int ar= (int) tabla_proveedores.getValueAt(rr, 0);
            ps.setInt(1,ar);
            
            int res=ps.executeUpdate();
            if(res>0){
                JOptionPane.showMessageDialog(null, "Se elimino el Provedor con exito");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
        }
        inhabilitart();
        cargar_tabla();
        var=0;
    }//GEN-LAST:event_eliminarActionPerformed

    private void tabla_proveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_proveedoresMouseClicked
        int fila=tabla_proveedores.getSelectedRow();
        nombre.setText(String.valueOf( tabla_proveedores.getValueAt(fila, 1)));
        domicilio.setText(String.valueOf( tabla_proveedores.getValueAt(fila, 2)));
        cuit.setText(String.valueOf(tabla_proveedores.getValueAt(fila, 3)));
        telefono.setText(String.valueOf(tabla_proveedores.getValueAt(fila, 4)));
        correo.setText(String.valueOf(tabla_proveedores.getValueAt(fila, 5)));
    }//GEN-LAST:event_tabla_proveedoresMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField correo;
    private javax.swing.JTextField cuit;
    private javax.swing.JTextField domicilio;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField nombre;
    private javax.swing.JButton nuevo;
    private javax.swing.JButton salir;
    private javax.swing.JTable tabla_proveedores;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
