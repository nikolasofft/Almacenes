
package vistas.Stock;

public class Ingresos extends javax.swing.JInternalFrame {

  
    public Ingresos() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cantidad_ingreso = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Precio_compra = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        porcentaje_a_agregar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_producto = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_facturas_compras = new javax.swing.JTable();
        campo_detalle_producto = new javax.swing.JTextField();
        campo_factura_proveedor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        campo_factura_fecha = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Guardar");
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        jButton2.setText("Salir");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 90, -1));

        jButton3.setText("Agregar");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        jButton4.setText("Modificar");
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 230));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingreso de Stock");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 11, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.jpg"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 440, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 620, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Cantidad a Ingresar:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, -1, -1));
        getContentPane().add(cantidad_ingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 180, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Precio de Compra:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, -1, -1));
        getContentPane().add(Precio_compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, 190, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("<html>% a Agregar al Precio para la venta:</html>");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 100, -1));
        getContentPane().add(porcentaje_a_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 180, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Producto:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, -1, -1));

        tabla_producto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "id", "detalle"
            }
        ));
        jScrollPane1.setViewportView(tabla_producto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 280, 60));

        jLabel8.setText("Factura:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, -1, -1));

        tabla_facturas_compras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Proveedor", "Fecha"
            }
        ));
        jScrollPane3.setViewportView(tabla_facturas_compras);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 290, 60));
        getContentPane().add(campo_detalle_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 220, -1));
        getContentPane().add(campo_factura_proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 60, 90, -1));

        jLabel9.setText("Fecha:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 60, -1, -1));
        getContentPane().add(campo_factura_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 60, 100, -1));

        jRadioButton1.setText("Calcular precio de Venta");
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Precio_compra;
    private javax.swing.JTextField campo_detalle_producto;
    private javax.swing.JTextField campo_factura_fecha;
    private javax.swing.JTextField campo_factura_proveedor;
    private javax.swing.JTextField cantidad_ingreso;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
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
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField porcentaje_a_agregar;
    private javax.swing.JTable tabla_facturas_compras;
    private javax.swing.JTable tabla_producto;
    // End of variables declaration//GEN-END:variables
}
