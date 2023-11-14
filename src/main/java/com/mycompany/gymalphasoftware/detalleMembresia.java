/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.gymalphasoftware;

import java.awt.Color;
import java.awt.Font;
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
 * @author alber
 */
public class detalleMembresia extends javax.swing.JDialog {
    int variableCambios=0;
    int codigoMembresiasLocal;
    String[] valores = new String[6];
    boolean estado = false;
    
    public detalleMembresia(javax.swing.JFrame parent, boolean modal, Integer codigoMembresias) throws SQLException {
        super(parent, modal);
        initComponents();
        initStyles();
        codigoMembresiasLocal=codigoMembresias;
        setLocationRelativeTo(null);//Código para centrar ventana
        CMembresias objetoMembresias = new CMembresias();
        Map<String, String> membresiaData = objetoMembresias.asignarMembresia(codigoMembresias);
        
        if (membresiaData != null && !membresiaData.isEmpty()) {
            String IDMembresia = membresiaData.get("IDMembresia");
            String membresiaNombre = membresiaData.get("membresiaNombre");
            String membresiaDescripcion = membresiaData.get("membresiaDescripcion");
            String membresiaPrecio = membresiaData.get("membresiaPrecio");
            String membresiaFechaCreacion = membresiaData.get("membresiaFechaCreacion");
            String membresiaDuracion = membresiaData.get("membresiaDuracion");
            try {
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String strFechaConvertida = outputDateFormat.format(inputDateFormat.parse(membresiaFechaCreacion));
            paramFechaCreacion.setText(strFechaConvertida);
            } catch (ParseException e) {
                System.out.println("Error al convertir la fecha: " + e.getMessage());
            }
            paramCodigo.setText(IDMembresia);
            paramNombre.setText(membresiaNombre);
            paramDescripcion.setText(membresiaDescripcion);
            paramPrecio.setText(membresiaPrecio);
            paramDuracion.setText(membresiaDuracion);
            paramCodigo.setEditable(false);
        }
        
        //Listeners para el cambio de información
        
        paramNombre.getDocument().addDocumentListener(new DocumentListener() {
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
        paramFechaCreacion.getDocument().addDocumentListener(new DocumentListener() {
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
        paramDuracion.getDocument().addDocumentListener(new DocumentListener() {
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
        
    }

    private void initStyles(){
        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 15));
        lblTitulo.putClientProperty("FlatLaf.styleClass", "h1" );
        lblTitulo.setBackground(new Color(5, 89, 253));
        lblTitulo.setOpaque(true);
        
        lblCodigo.putClientProperty("FlatLaf.styleClass", "h3" );
        lblCodigo.setForeground(Color.GRAY);
        
        lblNombre.putClientProperty("FlatLaf.styleClass", "h3" );
        lblNombre.setForeground(Color.GRAY);
        lblPrecio.putClientProperty("FlatLaf.styleClass", "h3" );
        lblPrecio.setForeground(Color.GRAY);
        lblDescripcion.putClientProperty("FlatLaf.styleClass", "h3" );
        lblDescripcion.setForeground(Color.GRAY);
        lblFCreacion.putClientProperty("FlatLaf.styleClass", "h3" );
        lblFCreacion.setForeground(Color.GRAY);
        lblDuracion.putClientProperty("FlatLaf.styleClass", "h3" );
        lblDuracion.setForeground(Color.GRAY);
        
        //jtextfields
        
        paramCodigo.putClientProperty("FlatLaf.styleClass", "h3" );
        paramNombre.putClientProperty("FlatLaf.styleClass", "h3" );
        
        paramDescripcion.putClientProperty("FlatLaf.styleClass", "h3" );
        paramPrecio.putClientProperty("FlatLaf.styleClass", "h3" );
        paramFechaCreacion.putClientProperty("FlatLaf.styleClass", "h3" );
        paramDuracion.putClientProperty("FlatLaf.styleClass", "h3" );
        paramCodigo.setForeground(Color.BLACK);
        paramNombre.setForeground(Color.BLACK);
        paramDescripcion.setForeground(Color.BLACK);
        paramPrecio.setForeground(Color.BLACK);
        paramFechaCreacion.setForeground(Color.BLACK);
        paramDuracion.setForeground(Color.BLACK);
        
        //No editable
        
        paramCodigo.setEditable(false);
        paramNombre.setEditable(false);
        paramDescripcion.setEditable(false);
        paramPrecio.setEditable(false);
        paramFechaCreacion.setEditable(false);
        paramDuracion.setEditable(false);
        
        paramCodigo.setFocusable(false);
        paramNombre.setFocusable(false);
        paramDescripcion.setFocusable(false);
        paramPrecio.setFocusable(false);
        paramFechaCreacion.setFocusable(false);
        paramDuracion.setFocusable(false);
        //
        
        btnGuardar.putClientProperty("FlatLaf.styleClass", "h3" );
        btnGuardar.setForeground(Color.GRAY);
        btnGuardar.setBackground(Color.WHITE);
        btnGuardar.setBorder(new LineBorder(Color.GRAY, 1));
        btnGuardar.setOpaque(true);
        btnGuardar.setFocusable(false);
        btnGuardar.setContentAreaFilled(false);
        
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
    }
    
    public void consulta(){
        CMembresias objetoMembresias = new CMembresias();
        System.out.println(paramNombre.getText());
        System.out.println("xdxddx");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        paramCodigo = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        paramNombre = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paramDescripcion = new javax.swing.JTextArea();
        lblPrecio = new javax.swing.JLabel();
        paramPrecio = new javax.swing.JTextField();
        lblFCreacion = new javax.swing.JLabel();
        paramFechaCreacion = new javax.swing.JTextField();
        lblDuracion = new javax.swing.JLabel();
        paramDuracion = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setAlignmentX(0.0F);
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setMinimumSize(new java.awt.Dimension(580, 640));
        jPanel1.setPreferredSize(new java.awt.Dimension(580, 640));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setBackground(new java.awt.Color(5, 89, 253));
        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Detalle Membresía");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 60));

        lblCodigo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCodigo.setText("Código");
        jPanel1.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 86, -1));
        jPanel1.add(paramCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 520, 30));

        lblNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 141, -1));

        paramNombre.setCaretPosition(paramNombre.getText().length());
        jPanel1.add(paramNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 520, 30));

        lblDescripcion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblDescripcion.setText("Descripción");
        jPanel1.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 141, -1));

        paramDescripcion.setColumns(20);
        paramDescripcion.setRows(5);
        jScrollPane1.setViewportView(paramDescripcion);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 520, 110));

        lblPrecio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblPrecio.setText("Precio");
        jPanel1.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 141, -1));
        jPanel1.add(paramPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 520, 30));

        lblFCreacion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblFCreacion.setText("Fecha Creación");
        jPanel1.add(lblFCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 141, -1));
        jPanel1.add(paramFechaCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 520, 30));

        lblDuracion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblDuracion.setText("Duración");
        jPanel1.add(lblDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 141, -1));
        jPanel1.add(paramDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 520, 30));

        btnVolver.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 600, 126, 40));

        btnEditar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 600, 138, 40));

        btnGuardar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 600, 138, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed

        if (estado){
            if(variableCambios==1){
                String titulo = "Confirmación";
                String mensaje = "<html>¿Está seguro de que quiere volver a la ventana principal?<br/>La información modificada se perderá.</html>";
                new panelConfirmacion(this, true, titulo, mensaje, null, 0,null).setVisible(true);
                //new PruebaJdialog(this,true).setVisible(true);
            } else{
                this.dispose();
            }

        } else {
            this.dispose();
        }

    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        estado = true;

        //jtextfields

        paramCodigo.putClientProperty("FlatLaf.styleClass", "h3" );
        paramNombre.putClientProperty("FlatLaf.styleClass", "h3" );

        paramDescripcion.putClientProperty("FlatLaf.styleClass", "h3" );
        paramPrecio.putClientProperty("FlatLaf.styleClass", "h3" );
        paramFechaCreacion.putClientProperty("FlatLaf.styleClass", "h3" );
        paramDuracion.putClientProperty("FlatLaf.styleClass", "h3" );
        paramCodigo.setForeground(Color.BLACK);
        paramNombre.setForeground(Color.BLACK);
        paramDescripcion.setForeground(Color.BLACK);
        paramPrecio.setForeground(Color.BLACK);
        paramFechaCreacion.setForeground(Color.BLACK);
        paramDuracion.setForeground(Color.BLACK);

        //Editable

        paramNombre.setEditable(true);
        paramDescripcion.setEditable(true);
        paramPrecio.setEditable(true);
        paramFechaCreacion.setEditable(true);
        paramDuracion.setEditable(true);

        paramNombre.setFocusable(true);
        paramDescripcion.setFocusable(true);
        paramPrecio.setFocusable(true);
        paramFechaCreacion.setFocusable(true);
        paramDuracion.setFocusable(true);

        paramNombre.setBackground(Color.WHITE);
        paramDescripcion.setBackground(Color.WHITE);
        paramPrecio.setBackground(Color.WHITE);
        paramFechaCreacion.setBackground(Color.WHITE);
        paramDuracion.setBackground(Color.WHITE);

        paramNombre.requestFocus();

        btnGuardar.putClientProperty("FlatLaf.styleClass", "h3" );
        btnGuardar.setForeground(new Color(5, 89, 253));
        btnGuardar.setBackground(Color.WHITE);
        btnGuardar.setBorder(new LineBorder(new Color(5, 89, 253), 1));
        btnGuardar.setOpaque(true);
        btnGuardar.setFocusable(true);

        btnVolver.putClientProperty("FlatLaf.styleClass", "h3" );
        btnVolver.setForeground(Color.GRAY);
        btnVolver.setBackground(Color.WHITE);
        btnVolver.setBorder(new LineBorder(Color.GRAY, 1));
        btnVolver.setOpaque(true);

        btnEditar.putClientProperty("FlatLaf.styleClass", "h3" );
        btnEditar.setForeground(Color.GRAY);
        btnEditar.setBackground(Color.WHITE);
        btnEditar.setBorder(new LineBorder(Color.GRAY, 1));
        btnEditar.setOpaque(true);
        btnEditar.setFocusable(false);
        btnEditar.setContentAreaFilled(false);

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        valores[0] = paramCodigo.getText();
        valores[1] = paramNombre.getText();
        valores[2] = paramDescripcion.getText();
        valores[3] = paramPrecio.getText();
        valores[4] = paramDuracion.getText();
        valores[5] = paramFechaCreacion.getText();

        if(variableCambios==1){
            //Panel de confirmación
            String titulo = "Confirmación";
            String tipo = "membresia";
            String mensaje = "<html>¿Está seguro de que quiere guardar la información editada?</html>";
            int codigo = codigoMembresiasLocal;
            new panelConfirmacionGuardar(this, true, titulo, mensaje, tipo, valores).setVisible(true);
        } else{
            this.dispose();
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(detalleMembresia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detalleMembresia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detalleMembresia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detalleMembresia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    detalleMembresia dialog = new detalleMembresia(new javax.swing.JFrame(), true,2);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(detalleMembresia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblFCreacion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField paramCodigo;
    private javax.swing.JTextArea paramDescripcion;
    private javax.swing.JTextField paramDuracion;
    private javax.swing.JTextField paramFechaCreacion;
    private javax.swing.JTextField paramNombre;
    private javax.swing.JTextField paramPrecio;
    // End of variables declaration//GEN-END:variables
}
