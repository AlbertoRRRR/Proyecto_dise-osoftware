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
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Admin
 */
public class modificarProducto extends javax.swing.JDialog {

    int variableCambios=0;
    boolean estado = false;
    String[] valores = new String[10];
    
    public modificarProducto(javax.swing.JFrame parent, boolean modal,Integer codigoProducto) throws SQLException {
        super(parent, modal);
        initComponents();
        LlenarComboBox();
        initStyles();
        setLocationRelativeTo(null);//Código para centrar ventana
        CProducto CProducto = new CProducto();
        Map<String, String> productoData = CProducto.asignarProductos(codigoProducto);

        if (productoData != null && !productoData.isEmpty()) {
            String IdElemento = productoData.get("IDElemento");
            String nombreElemento = productoData.get("nombreElemento");
            String precioElemento = productoData.get("precioElemento");
            String costoElemento = productoData.get("costoUnitarioElemento");
            String stockElemento = productoData.get("stockElemento");
            String descripcionElemento = productoData.get("descripcionElemento");
            String categoriaElemento = productoData.get("FKCategoria");
            String proovedorElemento = productoData.get("FKProovedor");
           
            paramCodigo.setText(IdElemento);
            paramNombreProducto.setText(nombreElemento);
            paramPrecio.setText(precioElemento);
            paramCosto.setText(costoElemento);
            paramStock.setText(stockElemento);
            paramDescripcion.setText(descripcionElemento);
            paramCategoria.setText(categoriaElemento);
            paramCodigo.setEditable(false);
            paramNombreProducto.setEditable(false);
            paramPrecio.setEditable(false);
            paramCosto.setEditable(false);
            paramStock.setEditable(false);
            paramDescripcion.setEditable(false);
            paramCategoria.setEditable(false);
            btnGuardar.setEnabled(false);
        }
    }

    private void initStyles(){
        lblTitulo.putClientProperty("FlatLaf.styleClass", "h1" );
        lblTitulo.setBackground(new Color(5, 89, 253));
        lblTitulo.setOpaque(true);
        
        lblCodigo.putClientProperty("FlatLaf.styleClass", "h3" );
        lblCodigo.setForeground(Color.GRAY);
        lblNombre.putClientProperty("FlatLaf.styleClass", "h3" );
        lblNombre.setForeground(Color.GRAY);
        lblDescripcion.putClientProperty("FlatLaf.styleClass", "h3" );
        lblDescripcion.setForeground(Color.GRAY);
        lblPrecio.putClientProperty("FlatLaf.styleClass", "h3" );
        lblPrecio.setForeground(Color.GRAY);
        lblCosto.putClientProperty("FlatLaf.styleClass", "h3" );
        lblCosto.setForeground(Color.GRAY);
        lblStock.putClientProperty("FlatLaf.styleClass", "h3" );
        lblStock.setForeground(Color.GRAY);
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
        
        btnEditar.putClientProperty("FlatLaf.styleClass", "h3" );
        btnEditar.setForeground(new Color(5, 89, 253));
        btnEditar.setBackground(Color.WHITE);
        btnEditar.setBorder(new LineBorder(new Color(5, 89, 253), 1));
        btnEditar.setOpaque(true);
        
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
        
        paramCosto.getDocument().addDocumentListener(new DocumentListener() {
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
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        paramNombreProducto = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        paramPrecio = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblCosto = new javax.swing.JLabel();
        paramCosto = new javax.swing.JTextField();
        lblStock = new javax.swing.JLabel();
        paramStock = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblProovedor = new javax.swing.JLabel();
        paramCategoria = new javax.swing.JTextField();
        paramCodigo = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        comboProovedor = new javax.swing.JComboBox<>();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paramDescripcion = new javax.swing.JTextArea();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paramNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramNombreProductoActionPerformed(evt);
            }
        });
        jPanel1.add(paramNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 520, 30));

        lblPrecio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblPrecio.setText("Precio producto");
        jPanel1.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 131, 22));

        lblNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 111, -1));
        jPanel1.add(paramPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 520, 30));

        btnGuardar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 750, 138, 40));

        btnVolver.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 750, 138, 40));

        lblCosto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCosto.setText("Costo Producto");
        jPanel1.add(lblCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 98, -1));

        paramCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramCostoActionPerformed(evt);
            }
        });
        jPanel1.add(paramCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 520, 30));

        lblStock.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblStock.setText("Stock producto");
        jPanel1.add(lblStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 110, -1));
        jPanel1.add(paramStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 520, 30));

        lblDescripcion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblDescripcion.setText("Descripción");
        jPanel1.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 98, -1));

        lblCategoria.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCategoria.setText("Categoría");
        jPanel1.add(lblCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 590, 98, -1));

        lblProovedor.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblProovedor.setText("Proovedor");
        jPanel1.add(lblProovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 98, -1));
        jPanel1.add(paramCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, 520, 30));

        paramCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramCodigoActionPerformed(evt);
            }
        });
        jPanel1.add(paramCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 520, 30));

        lblCodigo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCodigo.setText("Código");
        jPanel1.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 111, 23));
        jPanel1.add(comboProovedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 690, 520, 30));

        lblTitulo.setBackground(new java.awt.Color(5, 89, 253));
        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Detalle Producto");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 60));

        paramDescripcion.setColumns(20);
        paramDescripcion.setRows(5);
        jScrollPane1.setViewportView(paramDescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 520, 120));

        btnEditar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 750, 138, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paramNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramNombreProductoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        valores[0] = paramCodigo.getText();
        valores[1] = paramNombreProducto.getText();
        valores[2] = paramPrecio.getText();
        valores[3] = paramCosto.getText();
        valores[4] = paramStock.getText();
        valores[5] = paramDescripcion.getText();
        valores[6] = paramCategoria.getText();
        valores[7] = (comboProovedor.getSelectedItem()).toString();

        if(variableCambios==1){
            //Panel de confirmación
            String titulo = "Confirmación";
            String tipo = "producto";
            String mensaje = "<html>¿Está seguro de que quiere guardar la información editada?</html>";

            new panelConfirmacionGuardar(this,true, titulo, mensaje, tipo, valores).setVisible(true);
        } else{
            this.dispose();
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        if (estado){
            if(variableCambios==1){
                String titulo = "Confirmación";
                String mensaje = "<html>¿Está seguro de que quiere volver a la ventana principal?<br/>La información modificada se perderá.</html>";
                new panelConfirmacion(this, true, titulo, mensaje, null, 0,null).setVisible(true);
            } else{
                this.dispose();
            }

        } else {
            this.dispose();
        }
    }//GEN-LAST:event_btnVolverActionPerformed

    private void paramCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramCostoActionPerformed

    private void paramCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramCodigoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        estado = true;

        btnGuardar.setEnabled(true);
        paramCodigo.setEditable(false);
        paramNombreProducto.setEditable(true);
        paramPrecio.setEditable(true);
        paramCosto.setEditable(true);
        paramStock.setEditable(true);
        paramDescripcion.setEditable(true);
        paramCategoria.setEditable(true);
        btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnEditarActionPerformed
    public void LlenarComboBox(){
        RellenarCombos p = new RellenarCombos();
        comboProovedor.setModel(p.Llenar());
    }
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
        //</editor-fold

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                manejoProductos manejoProductos = new manejoProductos();
                Integer parametroCodigo = manejoProductos.devolverCodigo();
                try {
                    modificarProducto dialog = new modificarProducto(new javax.swing.JFrame(), true,parametroCodigo);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(modificarProducto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> comboProovedor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCosto;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblProovedor;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField paramCategoria;
    private javax.swing.JTextField paramCodigo;
    private javax.swing.JTextField paramCosto;
    private javax.swing.JTextArea paramDescripcion;
    private javax.swing.JTextField paramNombreProducto;
    private javax.swing.JTextField paramPrecio;
    private javax.swing.JTextField paramStock;
    // End of variables declaration//GEN-END:variables
}
