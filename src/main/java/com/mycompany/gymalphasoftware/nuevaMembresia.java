/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.gymalphasoftware;

import java.awt.Color;
import java.time.LocalDate;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author alber
 */
public class nuevaMembresia extends javax.swing.JDialog {
    int variableCambios=0;
    JTable tabla;
    JFrame Dashboard;
    String[] valores = new String[5];
    
    public nuevaMembresia(JFrame parent, boolean modal) {
        super(parent, modal);
        Dashboard=parent;
        initComponents();
        initStyles();
        setLocationRelativeTo(null);//Código para centrar ventana
        
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
        lblTitulo.putClientProperty("FlatLaf.styleClass", "h1" );
        lblTitulo.setBackground(new Color(5, 89, 253));
        lblTitulo.setOpaque(true);
        
        lblNombre.putClientProperty("FlatLaf.styleClass", "h3" );
        lblNombre.setForeground(Color.GRAY);
        lblDescripcion.putClientProperty("FlatLaf.styleClass", "h3" );
        lblDescripcion.setForeground(Color.GRAY);
        lblPrecio.putClientProperty("FlatLaf.styleClass", "h3" );
        lblPrecio.setForeground(Color.GRAY);
        lblFCreacion.putClientProperty("FlatLaf.styleClass", "h3" );
        lblFCreacion.setForeground(Color.GRAY);
        lblDuracion.putClientProperty("FlatLaf.styleClass", "h3" );
        lblDuracion.setForeground(Color.GRAY);
        
        
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
        
        paramNombre.putClientProperty("FlatLaf.styleClass", "h3" );
        paramNombre.setForeground(Color.BLACK);
        paramDescripcion.putClientProperty("FlatLaf.styleClass", "h3" );
        paramDescripcion.setForeground(Color.BLACK);
        paramPrecio.putClientProperty("FlatLaf.styleClass", "h3" );
        paramPrecio.setForeground(Color.BLACK);
        paramDuracion.putClientProperty("FlatLaf.styleClass", "h3" );
        paramDuracion.setForeground(Color.BLACK);
                
        
        
        //Fecha
        paramFechaCreacion.putClientProperty("FlatLaf.styleClass", "h3" );
        paramFechaCreacion.setForeground(Color.BLACK);
        LocalDate now = LocalDate.now();
        int year = now.getYear();
        int day = now.getDayOfMonth();
        int month = now.getMonthValue();
        paramFechaCreacion.setText(day+"/"+month+"/"+year);
        paramFechaCreacion.setEditable(false);
        paramFechaCreacion.setFocusable(false);
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
        paramNombre = new javax.swing.JTextField();
        lblDescripcion = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        paramDescripcion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        paramPrecio = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        paramFechaCreacion = new javax.swing.JTextField();
        lblFCreacion = new javax.swing.JLabel();
        paramDuracion = new javax.swing.JTextField();
        lblDuracion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paramNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramNombreActionPerformed(evt);
            }
        });
        jPanel1.add(paramNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 340, 30));

        lblDescripcion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblDescripcion.setText("Descripción");
        jPanel1.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 141, -1));

        lblTitulo.setBackground(new java.awt.Color(5, 89, 253));
        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Crear Nueva Membresía");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 60));

        lblNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblNombre.setText("Nombre");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 86, -1));
        jPanel1.add(paramDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 340, 30));

        btnGuardar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, 138, 40));

        btnVolver.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 126, 40));
        jPanel1.add(paramPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 340, 30));

        lblPrecio.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblPrecio.setText("Precio");
        jPanel1.add(lblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 141, -1));
        jPanel1.add(paramFechaCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 340, 30));

        lblFCreacion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblFCreacion.setText("Fecha Creación");
        jPanel1.add(lblFCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 141, -1));

        paramDuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramDuracionActionPerformed(evt);
            }
        });
        jPanel1.add(paramDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 340, 30));

        lblDuracion.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblDuracion.setText("Duración (Meses)");
        jPanel1.add(lblDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 141, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paramNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramNombreActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        valores[0] = paramNombre.getText();
        valores[1] = paramDescripcion.getText();
        valores[2] = paramPrecio.getText();
        valores[3] = paramFechaCreacion.getText();
        valores[4] = paramDuracion.getText();

        if(variableCambios==1){
            //Panel de confirmación
            String titulo = "Confirmación";
            String mensaje = "<html>¿Está seguro de que quiere crear la membresía?</html>";
            String tipo = "crearMembresia";
            new panelConfirmacion(this, true, titulo, mensaje, tipo, 0, valores).setVisible(true);
        } else{
            this.dispose();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        if(variableCambios==1){
            String titulo = "Confirmación";
            String mensaje = "<html>¿Está seguro de que quiere volver a la ventana principal?<br/>La información ingresada se perderá</html>";
            new panelConfirmacion(this, true, titulo, mensaje, null, 0, null).setVisible(true);
            //new PruebaJdialog(this,true).setVisible(true);
        } else{
            this.dispose();
        }
    }//GEN-LAST:event_btnVolverActionPerformed

    private void paramDuracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramDuracionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramDuracionActionPerformed

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
            java.util.logging.Logger.getLogger(nuevaMembresia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(nuevaMembresia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(nuevaMembresia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(nuevaMembresia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                nuevaMembresia dialog = new nuevaMembresia(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
        
        try {
            com.formdev.flatlaf.themes.FlatMacLightLaf.setup();
         } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JLabel lblFCreacion;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField paramDescripcion;
    private javax.swing.JTextField paramDuracion;
    private javax.swing.JTextField paramFechaCreacion;
    private javax.swing.JTextField paramNombre;
    private javax.swing.JTextField paramPrecio;
    // End of variables declaration//GEN-END:variables
}
