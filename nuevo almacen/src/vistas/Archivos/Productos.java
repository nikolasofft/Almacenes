package vistas.Archivos;

import vistas.AdministradorDeUsuarios.Permisos;
import Conexion.Conexion;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Productos extends javax.swing.JInternalFrame {

    byte control = 0;

    void cargarcombo() {
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT detalle FROM tipo_producto");
            rs = ps.executeQuery();
            while (rs.next()) {
                tipo_producto.addItem(rs.getString("detalle"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void Inhabilitar() {
        agregar.setEnabled(true);
        guardar.setEnabled(false);
        modificar.setEnabled(true);
        eliminar.setEnabled(true);

        codigo.setEnabled(false);
        tipo_producto.setEnabled(false);
        detalle.setEnabled(false);
        unidad.setEnabled(false);
        stock_actual.setEnabled(false);
        stock_minimo.setEnabled(false);
        precio_venta.setEnabled(false);
    }

    void habilitar() {
        codigo.setEnabled(true);
        tipo_producto.setEnabled(true);
        detalle.setEnabled(true);
        unidad.setEnabled(true);
        stock_actual.setEnabled(true);
        stock_minimo.setEnabled(true);
        precio_venta.setEnabled(true);
    }

    void cargar_tabla() {
        DefaultTableModel model = new DefaultTableModel();
        tabla_productos.setModel(model);

        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT id_productos, codigo, tipo_producto, detalle, stock, precio_vta FROM productos");
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidad = rsmd.getColumnCount();
            model.addColumn("id");
            model.addColumn("codigo");
            model.addColumn("tipo de producto");
            model.addColumn("detalle");
            model.addColumn("Stock");
            model.addColumn("precio");

            while (rs.next()) {
                Object[] fila = new Object[cantidad];
                for (int i = 0; i < cantidad; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                int[] anchos = {20, 25, 10, 180, 40, 40};
                for (int i = 0; i < 6; i++) {
                    tabla_productos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
                }
                model.addRow(fila);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Productos() {
        initComponents();
        cargar_tabla();
        Inhabilitar();
        cargarcombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBotones = new javax.swing.JPanel();
        lblIcono = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        agregar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        codigo = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        lblTipos = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        tipo_producto = new javax.swing.JComboBox<>();
        detalle = new javax.swing.JTextField();
        lblDetalle = new javax.swing.JLabel();
        lblUnidad = new javax.swing.JLabel();
        unidad = new javax.swing.JTextField();
        lblStockAct = new javax.swing.JLabel();
        stock_actual = new javax.swing.JTextField();
        stock_minimo = new javax.swing.JTextField();
        lblStockMin = new javax.swing.JLabel();
        lblPrecVta = new javax.swing.JLabel();
        precio_venta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_productos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setTitle("Mantenimiento de Productos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelBotones.setBackground(new java.awt.Color(102, 102, 255));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/productos.png"))); // NOI18N

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconos de botones/salir 32.png"))); // NOI18N
        btnCerrar.setText(" Salir");
        btnCerrar.setBorder(null);
        btnCerrar.setBorderPainted(false);
        btnCerrar.setContentAreaFilled(false);
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBotonesLayout = new javax.swing.GroupLayout(PanelBotones);
        PanelBotones.setLayout(PanelBotonesLayout);
        PanelBotonesLayout.setHorizontalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcono, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelBotonesLayout.setVerticalGroup(
            PanelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(agregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(PanelBotones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 400));
        getContentPane().add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 130, -1));

        lblCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCodigo.setForeground(new java.awt.Color(255, 255, 255));
        lblCodigo.setText("Código: ");
        getContentPane().add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, 20));

        lblTipos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTipos.setForeground(new java.awt.Color(255, 255, 255));
        lblTipos.setText("Tipo de Producto: ");
        getContentPane().add(lblTipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, -1, 20));

        lblTitulo.setBackground(new java.awt.Color(255, 255, 255));
        lblTitulo.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("MANTENIMIENTO DE PRODUCTOS");
        getContentPane().add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 400, -1));

        tipo_producto.setMaximumRowCount(4);
        tipo_producto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        getContentPane().add(tipo_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 240, -1));
        getContentPane().add(detalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 510, -1));

        lblDetalle.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblDetalle.setForeground(new java.awt.Color(255, 255, 255));
        lblDetalle.setText("Detalle: ");
        getContentPane().add(lblDetalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 50, 20));

        lblUnidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblUnidad.setForeground(new java.awt.Color(255, 255, 255));
        lblUnidad.setText("Unidad: ");
        getContentPane().add(lblUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, -1, 20));
        getContentPane().add(unidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 130, -1));

        lblStockAct.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStockAct.setForeground(new java.awt.Color(255, 255, 255));
        lblStockAct.setText("Stock actual: ");
        getContentPane().add(lblStockAct, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, -1, 20));
        getContentPane().add(stock_actual, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 270, -1));
        getContentPane().add(stock_minimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 90, -1));

        lblStockMin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblStockMin.setForeground(new java.awt.Color(255, 255, 255));
        lblStockMin.setText("Stock mínimo: ");
        getContentPane().add(lblStockMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, -1, 20));

        lblPrecVta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblPrecVta.setForeground(new java.awt.Color(255, 255, 255));
        lblPrecVta.setText("Precio de venta: ");
        getContentPane().add(lblPrecVta, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, -1, 20));
        getContentPane().add(precio_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 250, -1));

        tabla_productos.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null}
            },
            new String [] {
                "id", "código", "tipo de producto", "detalle", "stock actual", "precio de venta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabla_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_productos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 600, 230));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 600, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        control = 1;
        habilitar();
        stock_actual.setEnabled(false);
        agregar.setEnabled(false);
        guardar.setEnabled(true);
        modificar.setEnabled(false);
        agregar.setEnabled(false);
        eliminar.setEnabled(false);
    }//GEN-LAST:event_agregarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        control = 0;
        habilitar();
        stock_actual.setEnabled(false);
        agregar.setEnabled(false);
        guardar.setEnabled(true);
        modificar.setEnabled(false);
        agregar.setEnabled(false);
        eliminar.setEnabled(false);
    }//GEN-LAST:event_modificarActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        if (control == 0) {
            try {
                tipo_producto.setEnabled(true);
                stock_actual.setEnabled(false);
                

                ps = con.prepareStatement("UPDATE productos SET codigo=?, tipo_producto=?, detalle=?, unidad=?, stock_minimo=?, precio_vta=? WHERE id_productos=?");
                int indice = tabla_productos.getSelectedRow();
                String rr=String.valueOf(tabla_productos.getValueAt(indice, 0));
                
                ps.setString(1, codigo.getText());
                ps.setString(2, String.valueOf(tipo_producto.getSelectedItem()));
                ps.setString(3, detalle.getText());
                ps.setString(4, unidad.getText());
                ps.setString(5, stock_minimo.getText());
                ps.setString(6, precio_venta.getText());
                ps.setString(7, rr);

                int res = ps.executeUpdate();
                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "se modificco con exito el producto");
                }
                cargar_tabla();
                Inhabilitar();
            } catch (SQLException ex) {
                Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                ps = con.prepareStatement("INSERT INTO productos(codigo, tipo_producto, detalle, unidad, stock_minimo, precio_vta) VALUES(?,?,?,?,?,?)");
                ps.setString(1, codigo.getText());
                ps.setString(2, String.valueOf(tipo_producto.getSelectedItem()));
                ps.setString(3, detalle.getText());
                ps.setString(4, unidad.getText());
                ps.setString(5, stock_minimo.getText());
                ps.setString(6, precio_venta.getText());

                int re = ps.executeUpdate();
                if (re > 0) {
                    JOptionPane.showMessageDialog(null, "se guardo con exito el producto");
                }
                cargar_tabla();
                Inhabilitar();
                control=0;
            } catch (SQLException ex) {
                Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_guardarActionPerformed

    private void tabla_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_productosMouseClicked
       int indice=tabla_productos.getSelectedRow();
       int id=(int) tabla_productos.getValueAt(indice, 0);
       
       Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;
       
        try {
            ps=con.prepareStatement("SELECT codigo, detalle, unidad, stock_minimo, precio_vta FROM productos WHERE id_productos=?");
            ps.setInt(1, id);
            
            rs=ps.executeQuery();
            if(rs.next()){
                codigo.setText(rs.getString("codigo"));
               detalle.setText(rs.getString("detalle"));
               unidad.setText(rs.getString("unidad"));
               stock_minimo.setText(rs.getString("stock_minimo"));
               precio_venta.setText(rs.getString("precio_vta"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_tabla_productosMouseClicked

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        Connection con=null;
        Conexion conn=new Conexion();
        con=conn.getConexion();
        PreparedStatement ps;
        
       try {
            ps=con.prepareStatement("DELETE FROM productos WHERE id_productos=?");
            int rr=tabla_productos.getSelectedRow();
            int ar= (int) tabla_productos.getValueAt(rr, 0);
            ps.setInt(1,ar);
            
            int res=ps.executeUpdate();
            if(res>0){
                JOptionPane.showMessageDialog(null, "Se elimino el producto con exito");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Permisos.class.getName()).log(Level.SEVERE, null, ex);
        }
       Inhabilitar();
       cargar_tabla();
    }//GEN-LAST:event_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelBotones;
    private javax.swing.JButton agregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField detalle;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDetalle;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblPrecVta;
    private javax.swing.JLabel lblStockAct;
    private javax.swing.JLabel lblStockMin;
    private javax.swing.JLabel lblTipos;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUnidad;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField precio_venta;
    private javax.swing.JTextField stock_actual;
    private javax.swing.JTextField stock_minimo;
    private javax.swing.JTable tabla_productos;
    private javax.swing.JComboBox<String> tipo_producto;
    private javax.swing.JTextField unidad;
    // End of variables declaration//GEN-END:variables
}
