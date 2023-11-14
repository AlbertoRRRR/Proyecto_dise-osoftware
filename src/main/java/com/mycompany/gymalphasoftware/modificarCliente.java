/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.gymalphasoftware;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatMonokaiProIJTheme;
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
 * @author labf403
 */
public class modificarCliente extends javax.swing.JDialog {

     int variableCambios=0;
    boolean estado = false;
    String[] valores = new String[10];
    
    public modificarCliente(javax.swing.JFrame parent, boolean modal,Integer codigoMembresias) throws SQLException {
        super(parent, modal);
        initComponents();
        initStyles();
        setLocationRelativeTo(null);//Código para centrar ventana
        CClientes objetoClientes = new CClientes();
        Map<String, String> clienteData = objetoClientes.asignarCliente(codigoMembresias);

        if (clienteData != null && !clienteData.isEmpty()) {
            String IDCliente = clienteData.get("DNICliente");
            String nombreCliente = clienteData.get("nombreCliente");
            String apellidoPaternoCliente = clienteData.get("apellidoPaternoCliente");
            String apellidoMaternoCliente = clienteData.get("apellidoMaternoCliente");
            String generoCliente = clienteData.get("generoCliente");
            String telefonoCliente = clienteData.get("telefonoCliente");
            String correoElectronicoCliente = clienteData.get("correoElectronicoCliente");
            String fechaIngresoCliente = clienteData.get("fechaIngresoCliente");
            try {
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            String strFechaConvertida = outputDateFormat.format(inputDateFormat.parse(fechaIngresoCliente));
            paramFechaAfiliacion.setText(strFechaConvertida);
            } catch (ParseException e) {
                System.out.println("Error al convertir la fecha: " + e.getMessage());
            }
            paramDNI.setText(IDCliente);
            paramNombre.setText(nombreCliente);
            paramApellidoPaterno.setText(apellidoPaternoCliente);
            paramApellidoMaterno.setText(apellidoMaternoCliente);
            paramTelefono.setText(telefonoCliente);
            paramGenero.setText(generoCliente);
            paramCorreoElectronico.setText(correoElectronicoCliente);
            paramDNI.setEditable(false);
            paramNombre.setText(nombreCliente);
            paramApellidoPaterno.setText(apellidoPaternoCliente);
            paramApellidoMaterno.setText(apellidoMaternoCliente);
            paramTelefono.setText(telefonoCliente);
            paramGenero.setText(generoCliente);
            paramCorreoElectronico.setText(correoElectronicoCliente);
            paramDNI.setEditable(false);
            paramNombre.setEditable(false);
            paramApellidoPaterno.setEditable(false);
            paramApellidoMaterno.setEditable(false);
            paramTelefono.setEditable(false);
            paramGenero.setEditable(false);
            paramCorreoElectronico.setEditable(false);
            paramFechaAfiliacion.setEditable(false);
        }
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
        lblApellidoPaterno.putClientProperty("FlatLaf.styleClass", "h3" );
        lblApellidoPaterno.setForeground(Color.GRAY);
        lblApellidoMaterno.putClientProperty("FlatLaf.styleClass", "h3" );
        lblApellidoMaterno.setForeground(Color.GRAY);
        lblTelefono.putClientProperty("FlatLaf.styleClass", "h3" );
        lblTelefono.setForeground(Color.GRAY);
        lblGenero.putClientProperty("FlatLaf.styleClass", "h3" );
        lblGenero.setForeground(Color.GRAY);
        lblCorreoElectronico.putClientProperty("FlatLaf.styleClass", "h3" );
        lblCorreoElectronico.setForeground(Color.GRAY);
        lblFechaContrata.putClientProperty("FlatLaf.styleClass", "h3" );
        lblFechaContrata.setForeground(Color.GRAY);
        
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
        
        paramApellidoPaterno.getDocument().addDocumentListener(new DocumentListener() {
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
        
        paramApellidoMaterno.getDocument().addDocumentListener(new DocumentListener() {
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
        
        paramTelefono.getDocument().addDocumentListener(new DocumentListener() {
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
        
        paramGenero.getDocument().addDocumentListener(new DocumentListener() {
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
        
        paramCorreoElectronico.getDocument().addDocumentListener(new DocumentListener() {
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
        
        paramFechaAfiliacion.getDocument().addDocumentListener(new DocumentListener() {
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblApellidoMaterno = new javax.swing.JLabel();
        paramCorreoElectronico = new javax.swing.JTextField();
        lblTelefono = new javax.swing.JLabel();
        paramFechaAfiliacion = new javax.swing.JTextField();
        lblCorreoElectronico = new javax.swing.JLabel();
        lblFechaContrata = new javax.swing.JLabel();
        paramDNI = new javax.swing.JTextField();
        paramNombre = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        paramApellidoPaterno = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblApellidoPaterno = new javax.swing.JLabel();
        paramTelefono = new javax.swing.JTextField();
        paramApellidoMaterno = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        lblGenero = new javax.swing.JLabel();
        paramGenero = new javax.swing.JTextField();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setBackground(new java.awt.Color(5, 89, 253));
        lblTitulo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Detalle Cliente");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 60));

        lblApellidoMaterno.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblApellidoMaterno.setText("Apellido Materno: ");
        jPanel1.add(lblApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 288, 165, -1));
        jPanel1.add(paramCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 456, 520, 30));

        lblTelefono.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblTelefono.setText("Teléfono:");
        jPanel1.add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 358, 118, -1));
        jPanel1.add(paramFechaAfiliacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 526, 520, 30));

        lblCorreoElectronico.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCorreoElectronico.setText("Correo Electrónico:");
        jPanel1.add(lblCorreoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 428, 214, -1));

        lblFechaContrata.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblFechaContrata.setText("Fecha de afiliación:");
        jPanel1.add(lblFechaContrata, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 498, 214, -1));

        paramDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramDNIActionPerformed(evt);
            }
        });
        jPanel1.add(paramDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 106, 520, 30));

        paramNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramNombreActionPerformed(evt);
            }
        });
        jPanel1.add(paramNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 176, 520, 30));

        lblCodigo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblCodigo.setText("Dni: ");
        jPanel1.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 66, 36, 34));
        jPanel1.add(paramApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 246, 520, 30));

        lblNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblNombre.setText("Nombre:");
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 148, 62, -1));

        lblApellidoPaterno.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblApellidoPaterno.setText("Apellido Paterno: ");
        jPanel1.add(lblApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 218, 161, -1));
        jPanel1.add(paramTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 386, 240, 30));

        paramApellidoMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramApellidoMaternoActionPerformed(evt);
            }
        });
        jPanel1.add(paramApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 316, 520, 30));

        btnGuardar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(414, 587, 138, 40));

        btnVolver.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 587, 138, 40));

        lblGenero.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        lblGenero.setText("Genero:");
        jPanel1.add(lblGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 358, 114, -1));

        paramGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paramGeneroActionPerformed(evt);
            }
        });
        jPanel1.add(paramGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(312, 386, 240, 30));

        btnEditar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 587, 138, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 647));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void paramDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramDNIActionPerformed

    private void paramNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramNombreActionPerformed

    private void paramApellidoMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramApellidoMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramApellidoMaternoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        valores[0] = paramDNI.getText();
        valores[1] = paramNombre.getText();
        valores[2] = paramApellidoPaterno.getText();
        valores[3] = paramApellidoMaterno.getText();
        valores[4] = paramTelefono.getText();
        valores[5] = paramGenero.getText();
        valores[6] = paramCorreoElectronico.getText();
        valores[7] = paramFechaAfiliacion.getText();

        if(variableCambios==1){
            //Panel de confirmación
            String titulo = "Confirmación";
            String tipo = "cliente";
            String mensaje = "<html>¿Está seguro de que quiere guardar la información editada?</html>";

            new panelConfirmacionGuardar(this, true, titulo, mensaje, tipo, valores).setVisible(true);
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

    private void paramGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paramGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paramGeneroActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        estado = true;
        paramNombre.setEditable(true);
        paramApellidoPaterno.setEditable(true);
        paramApellidoMaterno.setEditable(true);
        paramTelefono.setEditable(true);
        paramGenero.setEditable(true);
        paramCorreoElectronico.setEditable(true);
        paramFechaAfiliacion.setEditable(true);
    }//GEN-LAST:event_btnEditarActionPerformed

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
        //</editor-fol

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                manejoClientes manejoClientes = new manejoClientes();
                Integer idcliente = manejoClientes.devolverCodigo();
                try {
                    modificarCliente dialog = new modificarCliente(new javax.swing.JFrame(), true,idcliente);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(modificarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblApellidoMaterno;
    private javax.swing.JLabel lblApellidoPaterno;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCorreoElectronico;
    private javax.swing.JLabel lblFechaContrata;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField paramApellidoMaterno;
    private javax.swing.JTextField paramApellidoPaterno;
    private javax.swing.JTextField paramCorreoElectronico;
    private javax.swing.JTextField paramDNI;
    private javax.swing.JTextField paramFechaAfiliacion;
    private javax.swing.JTextField paramGenero;
    private javax.swing.JTextField paramNombre;
    private javax.swing.JTextField paramTelefono;
    // End of variables declaration//GEN-END:variables
}
