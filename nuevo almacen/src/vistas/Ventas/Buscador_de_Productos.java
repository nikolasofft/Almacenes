package vistas.Ventas;

import Conexion.Conexion;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import vistas.Archivos.Productos;
import vistas.Principal;

public class Buscador_de_Productos extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    DefaultTableModel model1 = new DefaultTableModel();
    float preciofinal;
    float preciototal;

    void cargarcombo() {
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT nombre FROM clientes");
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente.addItem(rs.getString("nombre"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void cargar_tabla() {

        model = new DefaultTableModel();
        tabla1.setModel(model);
        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement("SELECT codigo, detalle FROM productos");
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidad = rsmd.getColumnCount();

            model.addColumn("codigo");
            model.addColumn("detalle");
            while (rs.next()) {
                Object[] fila = new Object[cantidad];
                for (int i = 0; i < cantidad; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Buscador_de_Productos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    void codigo_busqueda_desc(String texto){
        String[] colum = {"codigo", "detalle"};
        String filtro = "" + texto + "_%";
        String sql = "SELECT * FROM productos WHERE detalle LIKE " + '"' + filtro + '"';

        model = new DefaultTableModel(null, colum);

        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            Object[] fila = new Object[2];
            while (rs.next()) {
                fila[0] = rs.getObject("codigo");
                fila[1] = rs.getObject("detalle");
                model.addRow(fila);
            }
            tabla1.setModel(model);
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Buscador_de_Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void codigo_busqueda(String texto) {
        String[] colum = {"codigo", "detalle"};
        String filtro = "" + texto + "_%";
        String sql = "SELECT * FROM productos WHERE codigo LIKE " + '"' + filtro + '"';

        model = new DefaultTableModel(null, colum);

        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            Object[] fila = new Object[2];
            while (rs.next()) {
                fila[0] = rs.getObject("codigo");
                fila[1] = rs.getObject("detalle");
                model.addRow(fila);
            }
            tabla1.setModel(model);
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Buscador_de_Productos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Buscador_de_Productos() {
        initComponents();
        cargar_tabla();
        cargarcombo();
        unidad.setEnabled(false);

        model1.addColumn("código");
        model1.addColumn("detalle");
        model1.addColumn("cantidad");
        model1.addColumn("precio uni");
        model1.addColumn("cliente");
        model1.addColumn("precio");
        tabla2.setModel(model1);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        codigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        detalle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        unidad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        precio_unidad = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        precio_final = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cliente = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        precio_total = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        boton_generar_factura = new javax.swing.JButton();
        boton_ventas_del_dia = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        cargar_tabla2 = new javax.swing.JButton();
        boton_salir = new javax.swing.JButton();
        Limpiar_campos = new javax.swing.JButton();
        nueva_venta = new javax.swing.JButton();
        borra_de_la_tabla = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        setTitle("Buscador de Productos");
        setMaximumSize(new java.awt.Dimension(979, 500));
        setMinimumSize(new java.awt.Dimension(979, 500));
        setPreferredSize(new java.awt.Dimension(979, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoActionPerformed(evt);
            }
        });
        codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigoKeyReleased(evt);
            }
        });
        jPanel1.add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 69, -1));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Código:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        detalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                detalleKeyReleased(evt);
            }
        });
        jPanel1.add(detalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 210, -1));

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Detalle:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        cantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cantidadActionPerformed(evt);
            }
        });
        jPanel1.add(cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 82, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));
        jPanel1.add(unidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 90, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Unidad:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, -1, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cliente:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, -1, -1));
        jPanel1.add(precio_unidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 90, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Precio:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));

        precio_final.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                precio_finalMouseClicked(evt);
            }
        });
        jPanel1.add(precio_final, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 80, -1));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, -1));

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Precio final:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 10, -1, -1));

        cliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        jPanel1.add(cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 100, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 70));

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Fecha:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, -1, -1));

        fecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaMouseClicked(evt);
            }
        });
        jPanel1.add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 80, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 530, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 70));

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
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
                "Código", "Descripción", "Cantidad", "Unidad", "Cliente", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 970, 210));
        getContentPane().add(precio_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 420, 150, 30));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel8.setText("Precio total:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 420, -1, -1));

        boton_generar_factura.setText("Generar factura");
        boton_generar_factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_generar_facturaActionPerformed(evt);
            }
        });
        getContentPane().add(boton_generar_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, -1, -1));

        boton_ventas_del_dia.setText("Ventas del día");
        boton_ventas_del_dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_ventas_del_diaActionPerformed(evt);
            }
        });
        getContentPane().add(boton_ventas_del_dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Descripcion"
            }
        ));
        tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 310, 110));

        cargar_tabla2.setText("Cargar");
        cargar_tabla2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargar_tabla2ActionPerformed(evt);
            }
        });
        getContentPane().add(cargar_tabla2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, 80, -1));

        boton_salir.setText("Salir");
        boton_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_salirActionPerformed(evt);
            }
        });
        getContentPane().add(boton_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, -1, -1));

        Limpiar_campos.setText("Limpiar Campos");
        Limpiar_campos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Limpiar_camposActionPerformed(evt);
            }
        });
        getContentPane().add(Limpiar_campos, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, -1, -1));

        nueva_venta.setText("Nueva Venta");
        nueva_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nueva_ventaActionPerformed(evt);
            }
        });
        getContentPane().add(nueva_venta, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, -1, -1));

        borra_de_la_tabla.setText("Borrar de la tabla");
        borra_de_la_tabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borra_de_la_tablaActionPerformed(evt);
            }
        });
        getContentPane().add(borra_de_la_tabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadActionPerformed

    private void codigoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyReleased
        String buscar = codigo.getText();
        codigo_busqueda(buscar);
    }//GEN-LAST:event_codigoKeyReleased

    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked
        try {
            int fila = tabla1.getSelectedRow();
            String codi = String.valueOf(tabla1.getValueAt(fila, 0));

            Connection con = null;
            Conexion conn = new Conexion();
            con = conn.getConexion();
            PreparedStatement ps;
            ResultSet rs;

            ps = con.prepareStatement("SELECT * FROM productos WHERE codigo=?");

            ps.setInt(1, Integer.parseInt(codi));

            rs = ps.executeQuery();

            if (rs.next()) {
                codigo.setText(rs.getString("codigo"));
                detalle.setText(rs.getString("detalle"));
                unidad.setText(rs.getString("unidad"));
                precio_unidad.setText(rs.getString("precio_vta"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Buscador_de_Productos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_tabla1MouseClicked

    private void boton_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_salirActionPerformed
        dispose();
    }//GEN-LAST:event_boton_salirActionPerformed

    private void Limpiar_camposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Limpiar_camposActionPerformed
        codigo.setText("");
        detalle.setText("");
        cantidad.setText("");
        unidad.setText("");
        precio_unidad.setText("");
        precio_final.setText("");
    }//GEN-LAST:event_Limpiar_camposActionPerformed

    private void precio_finalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_precio_finalMouseClicked
        preciofinal = (Float.parseFloat(cantidad.getText()) * Float.parseFloat((precio_unidad.getText())));
        precio_final.setText(String.valueOf(preciofinal));

    }//GEN-LAST:event_precio_finalMouseClicked

    private void cargar_tabla2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargar_tabla2ActionPerformed
        String[] datos = new String[6];
        datos[0] = codigo.getText();
        datos[1] = detalle.getText();
        datos[2] = cantidad.getText();
        datos[3] = precio_unidad.getText();
        datos[4] = String.valueOf(cliente.getSelectedItem());
        String nada = "";
        String pre = precio_final.getText();
        if (pre.equals(nada)) {
            JOptionPane.showMessageDialog(null, "Debe calcular el Precio Final antes de Cargar en la tabla");
        } else {
            datos[5] = precio_final.getText();

            preciototal = preciototal + preciofinal;
            precio_total.setText(String.valueOf(preciototal));
            model1.addRow(datos);
        }


    }//GEN-LAST:event_cargar_tabla2ActionPerformed

    private void nueva_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nueva_ventaActionPerformed
        this.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_nueva_ventaActionPerformed

    private void borra_de_la_tablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borra_de_la_tablaActionPerformed
        DefaultTableModel mo = (DefaultTableModel) tabla2.getModel();
        int indice = tabla2.getSelectedRow();

        String des = String.valueOf(tabla2.getValueAt(indice, 5));

        float descuento = Math.abs(Float.parseFloat(des) - Float.parseFloat(precio_total.getText()));
        preciototal = preciototal - Float.parseFloat(des);
        precio_total.setText(String.valueOf(descuento));
        mo.removeRow(indice);
    }//GEN-LAST:event_borra_de_la_tablaActionPerformed

    private void boton_ventas_del_diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_ventas_del_diaActionPerformed
        int indice = tabla2.getSelectedRowCount();
        int fila = 0;
        
        for(int i=0;i<indice;i++) {
            Connection con = null;
                Conexion conn = new Conexion();
                con = conn.getConexion();
                PreparedStatement ps;
                ResultSet rs;
            try {
                
                
                ps=con.prepareStatement("INSERT INTO ventas_dia(codigo, detalle, cantidad, PrecioUnidad, cliente, precio, fecha) VALUES(?,?,?,?,?,?,?)");
                ps.setString(1, String.valueOf(tabla2.getValueAt(fila, 0)));
                ps.setString(2, String.valueOf(tabla2.getValueAt(fila, 1)));
                ps.setString(3, String.valueOf(tabla2.getValueAt(fila, 2)));
                ps.setString(4, String.valueOf(tabla2.getValueAt(fila, 3)));
                ps.setString(5, String.valueOf(tabla2.getValueAt(fila, 4)));
                ps.setString(6, String.valueOf(tabla2.getValueAt(fila, 5)));
                ps.setString(7, fecha.getText());
                
                int res=ps.executeUpdate();
                if(res>0){
                    System.out.println("se almacenaron los valores de la fila n°="+fila);
                }
                
                int cantidad_descontar=Integer.parseInt(String.valueOf(tabla2.getValueAt(fila, 2)));
                
                ps=con.prepareStatement("SELECT codigo, detalle, stock FROM productos WHERE codigo=?");
                ps.setString(1,String.valueOf(tabla2.getValueAt(fila, 0)));
                
                rs=ps.executeQuery();
                if(rs.next()){
                    int cantidadBD=Integer.parseInt(rs.getString("stock"));
                    int resultado=Math.abs(cantidadBD-cantidad_descontar);
                    
                    
                    ps=con.prepareStatement("UPDATE productos SET stock=? WHERE codigo=?");
                    ps.setString(1, String.valueOf(resultado));
                    ps.setString(2, String.valueOf(tabla2.getValueAt(fila, 0)));
                    
                    int re=ps.executeUpdate();
                    if(rs.next()){
                        
                    }
                    
                }
                
                
                fila++;
                
            } catch (SQLException ex) {
                Logger.getLogger(Buscador_de_Productos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
           
            
        }


    }//GEN-LAST:event_boton_ventas_del_diaActionPerformed

    private void fechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaMouseClicked
        DateFormat formato = new SimpleDateFormat("dd/MM/YYYY");

        fecha.setText(String.valueOf(formato.format(new java.util.Date())));
    }//GEN-LAST:event_fechaMouseClicked

    private void codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoActionPerformed

    private void detalleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_detalleKeyReleased
        String detalle= this.detalle.getText();
        codigo_busqueda_desc(detalle);
    }//GEN-LAST:event_detalleKeyReleased

    private void boton_generar_facturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_generar_facturaActionPerformed
        Generador_de_facturas ge=new Generador_de_facturas();
        Principal.panel.add(ge);
        ge.setVisible(true);
        int filas_selecionadas= tabla2.getSelectedRowCount();
        int fila=0;
        
         for(int i=0;i<filas_selecionadas;i++) {
             String[] datos=new String[5];
             DefaultTableModel model= (DefaultTableModel) Generador_de_facturas.tabla_factura.getModel();
             datos[0]=String.valueOf(tabla2.getValueAt(fila, 0));
             datos[1]=String.valueOf(tabla2.getValueAt(fila, 1));
             datos[2]=String.valueOf(tabla2.getValueAt(fila, 2));
             datos[3]=String.valueOf(tabla2.getValueAt(fila, 3));
             datos[4]=String.valueOf(tabla2.getValueAt(fila, 5));
             model.addRow(datos);
             Generador_de_facturas.tabla_factura.setModel(model);
             fila++;
         }
         
    }//GEN-LAST:event_boton_generar_facturaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Limpiar_campos;
    private javax.swing.JButton borra_de_la_tabla;
    private javax.swing.JButton boton_generar_factura;
    private javax.swing.JButton boton_salir;
    private javax.swing.JButton boton_ventas_del_dia;
    private javax.swing.JTextField cantidad;
    private javax.swing.JButton cargar_tabla2;
    private javax.swing.JComboBox<String> cliente;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField detalle;
    private javax.swing.JTextField fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton nueva_venta;
    private javax.swing.JTextField precio_final;
    private javax.swing.JTextField precio_total;
    private javax.swing.JTextField precio_unidad;
    private javax.swing.JTable tabla1;
    private javax.swing.JTable tabla2;
    private javax.swing.JTextField unidad;
    // End of variables declaration//GEN-END:variables
}
