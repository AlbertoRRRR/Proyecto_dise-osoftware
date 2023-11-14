package com.mycompany.gymalphasoftware;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author alber
 */
public class panelConfirmacion extends javax.swing.JDialog {

    /**
     * Creates new form panelConfirmacion1
     */
    public panelConfirmacion(javax.swing.JDialog parent, boolean modal, String titulo, String mensaje, String tipo, int apoyo, String[] valores) {
        super(parent, modal);
        initComponents();
        initStyles();
        setLocationRelativeTo(null);//Código para centrar ventana
        btnSi.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
                if(tipo=="eliminarMembresia"){
                    System.out.println("HOlaaaaaaaaaa");
                    CMembresias objetoMembresias = new CMembresias();
                    objetoMembresias.EliminarMembresia(apoyo);
                }
                if("crearMembresia".equals(tipo)){
                    System.out.println("HOlaaaaaaaaaa");
                    CMembresias objetoMembresias = new CMembresias();
                    objetoMembresias.InsertarMembresias(valores[0],valores[1],valores[2], valores[3],valores[4]);
                }
                if("crearCliente".equals(tipo)){
                    System.out.println("HOlaaaaaaaaaa");
                    CClientes objetoClientes = new CClientes();
                    objetoClientes.InsertarClientes(valores[0],valores[1],valores[2], valores[3],valores[4],valores[5],valores[6],valores[7]);
                }
                if("crearProducto".equals(tipo)){
                    System.out.println("HOlaaaaaaaaaa");
                    CProducto objetoProducto = new CProducto();
                    objetoProducto.InsertarProductos(valores[0],valores[1],valores[2], valores[3],valores[4],valores[5],valores[6],valores[7]);
                }
                parent.dispose();
                dispose();
            }
        });

        btnNo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                parent.setVisible(true);
                dispose();
            }
        });
        //Definición de titulo y mensaje
        lblTitulo.setBackground(new Color(5, 89, 253));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.putClientProperty("FlatLaf.styleClass", "h3" );
        lblTitulo.setText(titulo);
        lblTitulo.setOpaque(true);
        //
        lblMensaje.putClientProperty("FlatLaf.styleClass", "h3" );
        lblMensaje.setText(mensaje);
        lblMensaje.setForeground(Color.gray);
        
    }
    
    private void initStyles(){
        
        btnSi.putClientProperty("FlatLaf.styleClass", "h4" );
        btnSi.setForeground(new Color(5, 89, 253));
        btnSi.setBackground(Color.WHITE);
        btnSi.setBorder(new LineBorder(new Color(5, 89, 253), 1));
        btnSi.setOpaque(true);
        btnSi.setPreferredSize(new Dimension(100, 35));
        
        btnNo.putClientProperty("FlatLaf.styleClass", "h4" );
        btnNo.setForeground(Color.GRAY);
        btnNo.setBackground(Color.WHITE);
        btnNo.setBorder(new LineBorder(Color.GRAY, 1));
        btnNo.setOpaque(true);
        btnNo.setPreferredSize(new Dimension(100, 35));
        
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
        lblMensaje = new javax.swing.JLabel();
        btnSi = new javax.swing.JButton();
        btnNo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 10, 5, new java.awt.Color(5, 89, 253)));
        jPanel1.setMinimumSize(new java.awt.Dimension(440, 160));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(440, 160));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setBackground(new java.awt.Color(0, 0, 0));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("jLabel1");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 29));

        lblMensaje.setBackground(new java.awt.Color(255, 255, 255));
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensaje.setText("Ejemplooooooooooooooooooooooooooooooooooo");
        jPanel1.add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 38, 410, 70));

        btnSi.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnSi.setText("Sí");
        btnSi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiActionPerformed(evt);
            }
        });
        jPanel1.add(btnSi, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 126, 40));

        btnNo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        btnNo.setText("No");
        btnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNoActionPerformed(evt);
            }
        });
        jPanel1.add(btnNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 138, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSiActionPerformed

    private void btnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnNoActionPerformed

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
            java.util.logging.Logger.getLogger(panelConfirmacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panelConfirmacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panelConfirmacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panelConfirmacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                panelConfirmacion dialog = new panelConfirmacion(new javax.swing.JDialog(), true, "Título de la ventana", "Mensaje de confirmación","",1, new String[]{});
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNo;
    private javax.swing.JButton btnSi;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}