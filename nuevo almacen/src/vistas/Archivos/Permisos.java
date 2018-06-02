package vistas.Archivos;

import Conexion.Conexion;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Permisos extends javax.swing.JInternalFrame {

    byte per = 0;

    void limpiar() {
        descripcion.setText("");
        detalle.setText("");
    }

    void inhabilitar() {
        descripcion.setEnabled(false);
        estados.setEnabled(false);
        detalle.setEnabled(false);
        Guardar.setEnabled(false);
        Agregar.setEnabled(true);
        Modificar.setEnabled(true);
    }
    
    void cargar_tabla(){
            DefaultTableModel model=new DefaultTableModel();
            tablaPermisos.setModel(model);
            
            Connection con=null;
            Conexion conn=new Conexion();
            con=conn.getConexion();
            PreparedStatement ps;
            ResultSet rs;
            
        try {
            ps=con.prepareStatement("SELECT id_permiso, nombre, estado, detalle FROM permisos");
            
            rs=ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int cantidadcolumnas=rsmd.getColumnCount();
            
            model.addColumn("id");
            model.addColumn("nombre");
            model.addColumn("estado");
            model.addColumn("detalle");
            
            while(rs.next()){
                Object[] filas=new Object[cantidadcolumnas];
                for(int i=0;i<cantidadcolumnas;i++){
                    filas[i]=rs.getObject(i+1);
                }
                int[] anchos = {17, 30, 30, 150};
                for (int i = 0; i < 4; i++) {
                    tablaPermisos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                }
                model.addRow(filas);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Permisos() {
        initComponents();
        inhabilitar();
        cargar_tabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBotones = new javax.swing.JPanel();
        Agregar = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        detalle = new javax.swing.JTextArea();
        lblTitulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        estados = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPermisos = new javax.swing.JTable();

        setTitle("Permisos de Usuario");
        setMaximumSize(new java.awt.Dimension(908, 249));
        setMinimumSize(new java.awt.Dimension(908, 249));
        setPreferredSize(new java.awt.Dimension(908, 249));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelBotones.setBackground(new java.awt.Color(102, 102, 255));
        PanelBotones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });
        PanelBotones.add(Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 110, -1));

        Guardar.setText("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        PanelBotones.add(Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 110, -1));

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        PanelBotones.add(Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 110, -1));

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        PanelBotones.add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 110, -1));

        btnCerrar.setText("Salir");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        PanelBotones.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 190, 100, -1));

        getContentPane().add(PanelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 220));

        detalle.setBackground(new java.awt.Color(204, 204, 204));
        detalle.setColumns(20);
        detalle.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        detalle.setRows(5);
        jScrollPane1.setViewportView(detalle);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 200, 100));

        lblTitulo.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("PERMISOS DE USUARIOS");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 270, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Descripción : ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 80, 20));

        descripcion.setBackground(new java.awt.Color(204, 204, 204));
        descripcion.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        getContentPane().add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 200, -1));

        lblEstado.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblEstado.setForeground(new java.awt.Color(255, 255, 255));
        lblEstado.setText("Estado :");
        getContentPane().add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 80, 20));

        estados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activado", "Desactivado", " " }));
        estados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadosActionPerformed(evt);
            }
        });
        getContentPane().add(estados, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 200, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Detalles :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 310, 220));

        tablaPermisos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "id", "Descripcion", "Estado", "Detalles"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaPermisos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPermisosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaPermisos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 460, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        descripcion.setEnabled(true);
        estados.setEnabled(true);
        detalle.setEnabled(true);
        Guardar.setEnabled(true);
        Agregar.setEnabled(false);
        Modificar.setEnabled(false);
        eliminar.setEnabled(false);
        per = 1;
    }//GEN-LAST:event_AgregarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        if (per == 0) {
            try {

                ps = con.prepareStatement("UPDATE permisos SET nombre=?, estado=?, detalle=? WHERE id_permiso=?");
                int rr=tablaPermisos.getSelectedRow();
                ps.setString(1, descripcion.getText());
                ps.setString(2, String.valueOf(estados.getSelectedItem()));
                ps.setString(3, detalle.getText());
                ps.setString(4,String.valueOf(tablaPermisos.getValueAt(rr, 0)));

                int re = ps.executeUpdate();
                if (re > 0) {
                    JOptionPane.showMessageDialog(null, "se modifico el estado");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
            cargar_tabla();
            inhabilitar();
        } else if (per == 1) {
            try {
                ps = con.prepareStatement("INSERT INTO permisos(nombre, estado, detalle) VALUES(?,?,?)");
                ps.setString(1, descripcion.getText());
                ps.setString(2, (String) estados.getSelectedItem());
                ps.setString(3, detalle.getText());

                int res = ps.executeUpdate();
                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "Se Guardo el Permiso");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
            inhabilitar();
            cargar_tabla();
        }
        limpiar();
    }//GEN-LAST:event_GuardarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
        Agregar.setEnabled(false);
        Guardar.setEnabled(false);
        eliminar.setEnabled(false);
        Modificar.setEnabled(false);
        descripcion.setEnabled(true);
        estados.setEnabled(true);
        detalle.setEnabled(true);
        Guardar.setEnabled(true);
    }//GEN-LAST:event_ModificarActionPerformed

    private void tablaPermisosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPermisosMouseClicked
        int fila = tablaPermisos.getSelectedRow();
        descripcion.setText((String) tablaPermisos.getValueAt(fila, 1));
        estados.setSelectedItem(tablaPermisos.getValueAt(fila, 2));
        detalle.setText((String)tablaPermisos.getValueAt(fila, 3));
    }//GEN-LAST:event_tablaPermisosMouseClicked

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        Connection con=null;
        Conexion conn=new Conexion();
        con=conn.getConexion();
        PreparedStatement ps;
        
        try {
            ps=con.prepareStatement("DELETE FROM permisos WHERE id_permiso=?");
            int rr=tablaPermisos.getSelectedRow();
            int ar= (int) tablaPermisos.getValueAt(rr, 0);
            ps.setInt(1,ar);
            
            int res=ps.executeUpdate();
            if(res>0){
                JOptionPane.showMessageDialog(null, "Se elimino el Permiso con exito");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
        }
        cargar_tabla();
        
    }//GEN-LAST:event_eliminarActionPerformed

    private void estadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Modificar;
    private javax.swing.JPanel PanelBotones;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JTextField descripcion;
    private javax.swing.JTextArea detalle;
    private javax.swing.JButton eliminar;
    private javax.swing.JComboBox<String> estados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tablaPermisos;
    // End of variables declaration//GEN-END:variables
}
