/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gymalphasoftware;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatMonokaiProIJTheme;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Admin
 */
public class nuevoProducto extends javax.swing.JDialog {

    int variableCambios=0;
    int varPosition;
    int codigoMembresiasLocal;
    boolean estado = false;
    int i;
    String[] valores = new String[10];
    
    Boolean resultado = true;
    public nuevoProducto(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initStyles();
        setLocationRelativeTo(null);//Código para centrar ventana
        LlenarComboBox();
    }
    private void initStyles(){
        lblTitulo.putClientProperty("FlatLaf.styleClass", "h1" );
        lblTitulo.setBackground(new Color(5, 89, 253));
        lblTitulo.setOpaque(true);
        
        lblNombre.putClientProperty("FlatLaf.styleClass", "h3" );
        lblNombre.setForeground(Color.GRAY);
        lblPrecioProducto.putClientProperty("FlatLaf.styleClass", "h3" );
        lblPrecioProducto.setForeground(Color.GRAY);
        lblCostoProducto.putClientProperty("FlatLaf.styleClass", "h3" );
        lblCostoProducto.setForeground(Color.GRAY);
        lblStockProducto.putClientProperty("FlatLaf.styleClass", "h3" );
        lblStockProducto.setForeground(Color.GRAY);
        lblDescripcion.putClientProperty("FlatLaf.styleClass", "h3" );
        lblDescripcion.setForeground(Color.GRAY);
        lblCategoria.putClientProperty("FlatLaf.styleClass", "h3" );
        lblCategoria.setForeground(Color.GRAY);
        lblProovedor.putClientProperty("FlatLaf.styleClass", "h3" );
        lblProovedor.setForeground(Color.GRAY);
        
        
        btnGuardar.putClientProperty("FlatLaf.styleClass", "h3" );
        btnGuardar.setForeground(new Color(5, 89, 253));
        btnGuardar.setBackground(Color.WHITE);
        btnGuardar.setBorder(new LineBorder(new Color(5, 89, 253), 1));
        btnGuardar.setOpaque(true);
        
        btnVolver.putClientProperty("FlatLaf.styleClass", "h3" );
        btnVolver.setForeground(Color.GRAY);
        btnVolver.setBackground(Color.WHITE);
        btnVolver.setBorder(new LineBorder(Color.GRAY, 1));
        btnVolver.setOpaque(true);
        
        paramNombreProducto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Este método se llama cuando se inserta texto en el JTextField
                variableCambios=1;
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                // Este método se llama cuando se elimina texto del JTextField
                variableCambios=1;
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método se llama cuando se cambia algún atributo del texto (raro en JTextField)
                
            }
        });
        
        paramPrecio.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Este método se llama cuando se inserta texto en el JTextField
                variableCambios=1;
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                // Este método se llama cuando se elimina texto del JTextField
                variableCambios=1;
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método se llama cuando se cambia algún atributo del texto (raro en JTextField)
                
            }
        });
        
        ParamCosto.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Este método se llama cuando se inserta texto en el JTextField
                variableCambios=1;
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                // Este método se llama cuando se elimina texto del JTextField
                variableCambios=1;
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método se llama cuando se cambia algún atributo del texto (raro en JTextField)
                
            }
        });
        
        paramStock.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Este método se llama cuando se inserta texto en el JTextField
                variableCambios=1;
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                // Este método se llama cuando se elimina texto del JTextField
                variableCambios=1;
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método se llama cuando se cambia algún atributo del texto (raro en JTextField)
                
            }
        });
        
        paramDescripcion.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Este método se llama cuando se inserta texto en el JTextField
                variableCambios=1;
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                // Este método se llama cuando se elimina texto del JTextField
                variableCambios=1;
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método se llama cuando se cambia algún atributo del texto (raro en JTextField)
                
            }
        });
        
        paramCategoria.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Este método se llama cuando se inserta texto en el JTextField
                variableCambios=1;
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                // Este método se llama cuando se elimina texto del JTextField
                variableCambios=1;
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método se llama cuando se cambia algún atributo del texto (raro en JTextField)
                
            }
        });
        
        comboProovedor.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                // Este código se ejecutará cuando se seleccione un elemento en el JComboBox.
                variableCambios = 1;
            }
                }
        });
    }
    public void LlenarComboBox(){
        RellenarCombos p = new RellenarCombos();
        comboProovedor.setModel(p.Llenar());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        paramNombreProducto = new javax.swing.JTextField();
        lblPrecioProducto = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        paramPrecio = new javax.swing.JTextField();
        lblCostoProducto = new javax.swing.JLabel();
        ParamCosto = new javax.swing.JTextField();
        lblStockProducto = new javax.swing.JLabel();
        paramStock = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        paramDescripcion = new javax.swing.JTextField();
        lblProovedor = new javax.swing.JLabel();
        paramCategoria = new javax.swing.JTextField();
        comboProovedor = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paramNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramNombreProductoActionPerformed(evt);
            }
        });
        jPanel1.add(paramNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 340, 30));

        lblPrecioProducto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblPrecioProducto.setText("Precio producto");
        jPanel1.add(lblPrecioProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 131, -1));

        lblNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 111, -1));

        paramPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramPrecioActionPerformed(evt);
            }
        });
        jPanel1.add(paramPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 340, 30));

        lblCostoProducto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCostoProducto.setText("Costo Producto");
        jPanel1.add(lblCostoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 98, -1));
        jPanel1.add(ParamCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 340, 30));

        lblStockProducto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblStockProducto.setText("Stock producto");
        jPanel1.add(lblStockProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 98, -1));
        jPanel1.add(paramStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 340, 30));

        lblDescripcion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblDescripcion.setText("Descripción");
        jPanel1.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 98, -1));

        lblCategoria.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCategoria.setText("Categoría");
        jPanel1.add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 98, -1));
        jPanel1.add(paramDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 340, 30));

        lblProovedor.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblProovedor.setText("Proovedor");
        jPanel1.add(lblProovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, 98, -1));
        jPanel1.add(paramCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 340, 30));
        jPanel1.add(comboProovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 530, 340, 30));

        btnGuardar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 580, 138, 40));

        btnVolver.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 580, 138, 40));

        lblTitulo.setBackground(new java.awt.Color(5, 89, 253));
        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Crear Nuevo Producto");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paramNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramNombreProductoActionPerformed

    private void paramPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramPrecioActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        valores[0] = paramNombreProducto.getText();
        valores[1] = paramPrecio.getText();
        valores[2] = ParamCosto.getText();
        valores[3] = paramStock.getText();
        valores[4] = paramDescripcion.getText();
        valores[5] = paramCategoria.getText();
        valores[6] = (comboProovedor.getSelectedItem()).toString();

        if(variableCambios==1){
            //Panel de confirmación
            String titulo = "Confirmación";
            String tipo = "crearProducto";
            String mensaje = "<html>¿Está seguro de que quiere insertar el registro?</html>";

            new panelConfirmacion(this, true, titulo, mensaje, tipo, 0, valores).setVisible(true);
        } else{
            this.dispose();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        if (estado==false){
            if(variableCambios==1){
                String titulo = "Confirmación";
                String mensaje = "<html>¿Está seguro de que quiere volver a la ventana principal?<br/>La información modificada se perderá.</html>";
                new panelConfirmacion(this, true, titulo, mensaje, null, 0, null).setVisible(true);
            } else{
                this.dispose();
            }

        } else {
            this.dispose();
        }
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            com.formdev.flatlaf.themes.FlatMacLightLaf.setup();
         } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevoProducto(new javax.swing.JFrame(), true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ParamCosto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> comboProovedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCostoProducto;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecioProducto;
    private javax.swing.JLabel lblProovedor;
    private javax.swing.JLabel lblStockProducto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField paramCategoria;
    private javax.swing.JTextField paramDescripcion;
    private javax.swing.JTextField paramNombreProducto;
    private javax.swing.JTextField paramPrecio;
    private javax.swing.JTextField paramStock;
    // End of variables declaration//GEN-END:variables
}
