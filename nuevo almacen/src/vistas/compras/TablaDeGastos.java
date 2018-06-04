package vistas.compras;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import vistas.Principal;
import static vistas.Principal.panel;
import vistas.Ventas.Buscador_de_Productos;

public class TablaDeGastos extends javax.swing.JInternalFrame {

    DefaultTableModel model = new DefaultTableModel();

    void codigo_busqueda_fecha(String texto) {
        String[] colum = {"id", "fecha", "número factura", "monto", "Estado", "proveedor"};
        String filtro = "" + texto + "_%";
        String sql = "SELECT id_gasto, fecha, numero, monto, estado, proveedor FROM com_gasto WHERE fecha LIKE " + '"' + filtro + '"';

        model = new DefaultTableModel(null, colum);

        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            Object[] fila = new Object[6];
            while (rs.next()) {
                fila[0] = rs.getObject("id_gasto");
                fila[1] = rs.getObject("fecha");
                fila[2] = rs.getObject("numero");
                fila[3] = rs.getObject("monto");
                fila[4] = rs.getObject("estado");
                fila[5] = rs.getObject("proveedor");

                model.addRow(fila);
            }
            Tablagastos.setModel(model);
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Buscador_de_Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void codigo_busqueda_estado(String texto) {
        String[] colum = {"id", "fecha", "número factura", "monto", "Estado", "proveedor"};
        String filtro = "" + texto + "_%";
        String sql = "SELECT id_gasto, fecha, numero, monto, estado, proveedor FROM com_gasto WHERE estado LIKE " + '"' + filtro + '"';

        model = new DefaultTableModel(null, colum);

        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            Object[] fila = new Object[6];
            while (rs.next()) {
                fila[0] = rs.getObject("id_gasto");
                fila[1] = rs.getObject("fecha");
                fila[2] = rs.getObject("numero");
                fila[3] = rs.getObject("monto");
                fila[4] = rs.getObject("estado");
                fila[5] = rs.getObject("proveedor");

                model.addRow(fila);
            }
            Tablagastos.setModel(model);
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Buscador_de_Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void codigo_busqueda_proveedor(String texto) {
        String[] colum = {"id", "fecha", "número factura", "monto", "Estado", "proveedor"};
        String filtro = "" + texto + "_%";
        String sql = "SELECT id_gasto, fecha, numero, monto, estado, proveedor FROM com_gasto WHERE proveedor LIKE " + '"' + filtro + '"';

        model = new DefaultTableModel(null, colum);

        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            Object[] fila = new Object[6];
            while (rs.next()) {
                fila[0] = rs.getObject("id_gasto");
                fila[1] = rs.getObject("fecha");
                fila[2] = rs.getObject("numero");
                fila[3] = rs.getObject("monto");
                fila[4] = rs.getObject("estado");
                fila[5] = rs.getObject("proveedor");

                model.addRow(fila);
            }
            Tablagastos.setModel(model);
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Buscador_de_Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void codigo_busqueda_numeroFactura(String texto) {
        String[] colum = {"id", "fecha", "número factura", "monto", "Estado", "proveedor"};
        String filtro = "" + texto + "_%";
        String sql = "SELECT id_gasto, fecha, numero, monto, estado, proveedor FROM com_gasto WHERE numero LIKE " + '"' + filtro + '"';

        model = new DefaultTableModel(null, colum);

        Connection con = null;
        Conexion conn = new Conexion();
        con = conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            Object[] fila = new Object[6];
            while (rs.next()) {
                fila[0] = rs.getObject("id_gasto");
                fila[1] = rs.getObject("fecha");
                fila[2] = rs.getObject("numero");
                fila[3] = rs.getObject("monto");
                fila[4] = rs.getObject("estado");
                fila[5] = rs.getObject("proveedor");

                model.addRow(fila);
            }
            Tablagastos.setModel(model);
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(Buscador_de_Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void cargar_tabla(){
        DefaultTableModel model1=new DefaultTableModel();
        Tablagastos.setModel(model1);
        
        Connection con=null;
        Conexion conn=new Conexion();
        con=conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps=con.prepareStatement("SELECT id_gasto, fecha, numero, monto, estado, proveedor FROM com_gasto");
            rs=ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            int cantidad=rsmd.getColumnCount();
            model1.addColumn("id");
            model1.addColumn("fecha");
            model1.addColumn("Número de Factura");
            model1.addColumn("Montó");
            model1.addColumn("Estado");
            model1.addColumn("Proveedor");
            
            while(rs.next()){
                Object[] filas=new Object[cantidad];
                for(int i=0;i<cantidad;i++){
                    filas[i]=rs.getObject(i+1);
                }
                model1.addRow(filas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TablaDeGastos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public TablaDeGastos() {
        initComponents();
        cargar_tabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotones = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_buscador = new javax.swing.JTextField();
        modificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablagastos = new javax.swing.JTable();
        fecha = new javax.swing.JRadioButton();
        estado = new javax.swing.JRadioButton();
        proveedor = new javax.swing.JRadioButton();
        numerodefactura = new javax.swing.JRadioButton();
        eliminar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setTitle("Tabla de Gastos");
        setMaximumSize(new java.awt.Dimension(616, 603));
        setMinimumSize(new java.awt.Dimension(616, 603));
        setPreferredSize(new java.awt.Dimension(610, 603));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tabla de Gastos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Buscar por:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        txt_buscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscadorKeyReleased(evt);
            }
        });
        getContentPane().add(txt_buscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 100, -1));

        modificar.setText("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        getContentPane().add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 90, -1));

        Tablagastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Fecha", "Numero de Factura", "Proveedor", "Estado", "Montó"
            }
        ));
        jScrollPane1.setViewportView(Tablagastos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 127, 600, 400));

        grupoBotones.add(fecha);
        fecha.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fecha.setText("Fecha");
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        grupoBotones.add(estado);
        estado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        estado.setText("Estado");
        getContentPane().add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));

        grupoBotones.add(proveedor);
        proveedor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        proveedor.setText("Proveedor");
        getContentPane().add(proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        grupoBotones.add(numerodefactura);
        numerodefactura.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        numerodefactura.setText("Numero de factura");
        getContentPane().add(numerodefactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, -1, -1));

        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 90, -1));

        jButton3.setText("Salir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        gastos ga=new gastos();
        panel.add(ga);
        ga.setVisible(true);
        
        int indice=Tablagastos.getSelectedRow();
        String id=String.valueOf(Tablagastos.getValueAt(indice, 0));
        gastos.id=id;
        
        Connection con=null;
        Conexion conn=new Conexion();
        con=conn.getConexion();
        PreparedStatement ps;
        ResultSet rs;
        
        try {
            ps=con.prepareStatement("SELECT * FROM com_gasto WHERE id_gasto=?");
            ps.setString(1, id);
            rs=ps.executeQuery();
            if(rs.next()){
                gastos.fecha.setText(rs.getString("fecha"));
                gastos.tipofactura.setText("tipo");
                gastos.sucursal.setText("num_sucursal");
                gastos.numerofact.setText("numero");
                gastos.monto.setText("monto");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(TablaDeGastos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_modificarActionPerformed

    private void txt_buscadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscadorKeyReleased
        if (fecha.isSelected()) {
            String fech = txt_buscador.getText();
            codigo_busqueda_fecha(fech);
        }
        if(estado.isSelected()){
            String est=txt_buscador.getText();
            codigo_busqueda_estado(est);
        }
        if(proveedor.isSelected()){
            String prov=txt_buscador.getText();
            codigo_busqueda_proveedor(prov);
        }
        if(numerodefactura.isSelected()){
            String numfac=txt_buscador.getText();
            codigo_busqueda_numeroFactura(numfac);
        }
    }//GEN-LAST:event_txt_buscadorKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable Tablagastos;
    private javax.swing.JButton eliminar;
    private javax.swing.JRadioButton estado;
    private javax.swing.JRadioButton fecha;
    private javax.swing.ButtonGroup grupoBotones;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificar;
    private javax.swing.JRadioButton numerodefactura;
    private javax.swing.JRadioButton proveedor;
    private javax.swing.JTextField txt_buscador;
    // End of variables declaration//GEN-END:variables
}
