/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gymalphasoftware;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *
 * @author Admin
 */
public class ClientesPanel extends javax.swing.JPanel {

    CClientes objetoClientes = new CClientes();
     Integer codigoClientes;
     Integer idCliente;
     JFrame dashboard;
    public ClientesPanel(JFrame Dashboard) {
        dashboard=Dashboard;
        initComponents();
        initStyles();
        paintImages();
        initConfiguration();
        tableStyles();
    }
    private void initStyles(){
        lblManejoClientes.putClientProperty("FlatLaf.styleClass", "h1");
        lblBusquedaCliente.putClientProperty("FlatLaf.styleClass", "h3");
        
        JTableHeader header = tblReporteClientes.getTableHeader();

        // Propiedades encabezado
        header.putClientProperty("FlatLaf.styleClass", "h2");
        header.setReorderingAllowed(false);
        header.setOpaque(false);
        
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.put("TableHeader.cellBorder", new BorderUIResource(BorderFactory.createMatteBorder(10, 20, 10, 0, new Color(5, 89, 253))));
        
        header.setPreferredSize(new Dimension(header.getWidth(), 50));
        header.setBackground(new Color(5, 89, 253));
        header.setForeground(new Color(255, 255, 255));
        // Alineación a la izquierda 
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) header.getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        tblReporteClientes.getTableHeader().setDefaultRenderer(headerRenderer);
        
        
        tblReporteClientes.setRowHeight(35);
        tblReporteClientes.putClientProperty("FlatLaf.styleClass", "h3" );
        
        //Scroll pane
        
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Esta línea desactiva la barra horizontal
        jScrollPane3.getVerticalScrollBar().setUnitIncrement(15); // Ajustar velocidad de desplazamiento
        jScrollPane3.setBorder(null);
        
        
        
        //Quitar bordes
        tblReporteClientes.setBorder(BorderFactory.createEmptyBorder());
        jPanel1.setBorder(new EmptyBorder(0, 0, 0, 0));
        jScrollPane3.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        //Boton actualizar
        btnActualizar.putClientProperty("FlatLaf.styleClass", "h3" );
        //btnActualizar.setForeground(new Color(5, 89, 253));
        btnActualizar.setForeground(Color.WHITE);
        //btnActualizar.setBackground(Color.WHITE);
        btnActualizar.setBackground(new Color(5, 89, 253));
        btnActualizar.setBorder(new LineBorder(new Color(5, 89, 253), 1));
        btnActualizar.setOpaque(true);
        
    }
    private void tableStyles(){
        //Ancho de columnas
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Obtener el ancho de la tabla después de que esté visible
                int totalWidth = tblReporteClientes.getWidth();
                int[] columnWidths = {11, 16, 10, 10, 11, 22,12,4,4};// Porcentajes relativos al ancho total

                for (int i = 0; i < tblReporteClientes.getColumnCount(); i++) {
                    TableColumn column = tblReporteClientes.getColumnModel().getColumn(i);
                    int preferredWidth = (int) (totalWidth * (columnWidths[i] / 100.0));
                    column.setPreferredWidth(preferredWidth);
                }
            }
        });
        //Pading de celdas
        tblReporteClientes.setDefaultRenderer(Object.class, new PaddedCellRenderer(20, 10, tblReporteClientes.getColumnCount()-2)); // Agregar el renderizador con padding
        System.out.println(tblReporteClientes.getColumnCount()-2);
        
    }
    private void initConfiguration(){
        objetoClientes.mostrarCliente(tblReporteClientes);
        
        
        
        //Listener de mouse
        GlobalMouseListener  globalMouseListener = new GlobalMouseListener(lblBusquedaCliente);
        panelVariable2.addMouseListener(globalMouseListener);
        //Listener de JtextField
        lblBusquedaCliente.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Este método se ejecutará cuando se inserte texto
                checkTextFieldAndExecuteCode();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Este método se ejecutará cuando se elimine texto
                checkTextFieldAndExecuteCode();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Este método se ejecutará cuando se cambie el estilo del texto (raramente usado en JTextField)
            }

            private void checkTextFieldAndExecuteCode() {
                // Coloca el código que deseas ejecutar aquí
                if(lblBusquedaCliente.getText().equals("") || lblBusquedaCliente.getText().equals("Ingresa cliente")){
                    objetoClientes.mostrarCliente(tblReporteClientes);
                } else{
                    CClientes objetoClientes = new CClientes();
                    try {
                        objetoClientes.BuscarCliente(lblBusquedaCliente, tblReporteClientes);
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(Dashboards.class.getName()).log(Level.SEVERE, null, ex);
                    }     
                }
            }
        });
        }
    
    private void paintImages(){
         scaleImageSizeAutomatic(btnBusqueda2, "src/main/resources/images/BuscarGris.png",20,20);
         scaleImageSizeAutomatic(btnEliminar, "src/main/resources/images/CirculoEliminar.png",20,20);
         scaleImageSizeAutomatic(btnAñadir, "src/main/resources/images/Añadir.png",60,60);
    }
    
    public void scaleImage(JButton labelName, String route){
        //Escalando imagen para Jlabel
        ImageIcon image = new ImageIcon(route);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        labelName.setIcon(icon);
        this.repaint();
    }
    public void scaleImageSizeAutomatic(JButton labelName, String route, Integer Ancho, Integer Alto){
        //Escalando imagen para Jlabel
        ImageIcon image = new ImageIcon(route);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(Ancho, Alto, Image.SCALE_SMOOTH));
        labelName.setIcon(icon);            
        this.repaint();
    }
    public void scaleImageLabel(JLabel labelName, String route ,Integer Ancho, Integer Alto){
        //Escalando imagen para Jlabel
        ImageIcon image = new ImageIcon(route);
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(Ancho, Alto, Image.SCALE_SMOOTH));
        labelName.setIcon(icon);
        this.repaint();
    }
    
    public void actualizarTabla() {
        CProducto objetoProducto = new CProducto();
        try {
            objetoProducto.BuscarProducto(lblBusquedaCliente,tblReporteClientes);
        } catch (SQLException ex) {
            Logger.getLogger(Dashboards.class.getName()).log(Level.SEVERE, null, ex);
        }
         
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
        panelVariable2 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblReporteClientes = new javax.swing.JTable();
        lblManejoClientes = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblBusquedaCliente = new javax.swing.JTextField();
        btnBusqueda2 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAñadir = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelVariable2.setBackground(new java.awt.Color(255, 255, 255));
        panelVariable2.setForeground(new java.awt.Color(16, 80, 200));
        panelVariable2.setMinimumSize(new java.awt.Dimension(1020, 640));

        tblReporteClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblReporteClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReporteClientesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblReporteClientes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1480, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1480, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
        );

        lblManejoClientes.setText("Manejo de Clientes");

        btnActualizar.setText("Actualizar");
        btnActualizar.setMinimumSize(new java.awt.Dimension(75, 33));
        btnActualizar.setPreferredSize(new java.awt.Dimension(75, 33));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        lblBusquedaCliente.setBackground(new java.awt.Color(242, 242, 242));
        lblBusquedaCliente.setForeground(new java.awt.Color(153, 153, 153));
        lblBusquedaCliente.setText("Ingresa cliente");
        lblBusquedaCliente.setBorder(null);
        lblBusquedaCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblBusquedaClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lblBusquedaClienteFocusLost(evt);
            }
        });
        lblBusquedaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblBusquedaClientelblBusquedaProductoActionPerformed(evt);
            }
        });

        btnBusqueda2.setBackground(new java.awt.Color(242, 242, 242));
        btnBusqueda2.setBorder(null);
        btnBusqueda2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBusqueda2MouseEntered(evt);
            }
        });
        btnBusqueda2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusqueda2btnBusquedaActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(242, 242, 242));
        btnEliminar.setBorder(null);
        btnEliminar.setBorderPainted(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setFocusable(false);
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnBusqueda2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 1238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lblBusquedaCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBusqueda2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelVariable2Layout = new javax.swing.GroupLayout(panelVariable2);
        panelVariable2.setLayout(panelVariable2Layout);
        panelVariable2Layout.setHorizontalGroup(
            panelVariable2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVariable2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelVariable2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelVariable2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblManejoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        panelVariable2Layout.setVerticalGroup(
            panelVariable2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVariable2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblManejoClientes)
                .addGap(35, 35, 35)
                .addGroup(panelVariable2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Añadir.png"))); // NOI18N
        btnAñadir.setBorder(null);
        btnAñadir.setContentAreaFilled(false);
        btnAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAñadirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVariable2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelVariable2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1560, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1034, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblReporteClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReporteClientesMouseClicked

        int column = tblReporteClientes.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblReporteClientes.getRowHeight();

        if(row < tblReporteClientes.getRowCount() && row >= 0 && column < tblReporteClientes.getColumnCount() && column >= 0){
            Object value = tblReporteClientes.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;

                if(boton.getName().equals("m")){
                    System.out.println("Hola m");
                    int fila = tblReporteClientes.getSelectedRow();
                    idCliente = Integer.parseInt(tblReporteClientes.getValueAt(fila,0).toString());

                    try {
                        new modificarCliente(dashboard, true, idCliente).setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(manejoMembresias.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                if(boton.getName().equals("e")){
                    
                    int selectedRow = tblReporteClientes.getSelectedRow();                  
                    Object cellValue = tblReporteClientes.getValueAt(selectedRow, 0);
                    Integer cellValueText = Integer.parseInt(cellValue.toString());   
                    
                    String titulo = "Confirmación";
                    String mensaje = "<html>¿Está seguro de que quiere eliminar el registro?<br/>No sé podrá recuperar una vez eliminado.</html>";
                    new panelConfirmacionJFrame(dashboard, true, titulo, mensaje, "eliminarCliente",cellValueText, null).setVisible(true);                }

            }
        }
    }//GEN-LAST:event_tblReporteClientesMouseClicked

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        new nuevoCliente(dashboard,true).setVisible(true);
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        CClientes objetoClientes = new CClientes();
        objetoClientes.mostrarCliente(tblReporteClientes);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void lblBusquedaClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblBusquedaClienteFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_lblBusquedaClienteFocusGained

    private void lblBusquedaClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblBusquedaClienteFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lblBusquedaClienteFocusLost

    private void lblBusquedaClientelblBusquedaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblBusquedaClientelblBusquedaProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblBusquedaClientelblBusquedaProductoActionPerformed

    private void btnBusqueda2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusqueda2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusqueda2MouseEntered

    private void btnBusqueda2btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusqueda2btnBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusqueda2btnBusquedaActionPerformed

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnBusqueda2;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField lblBusquedaCliente;
    private javax.swing.JLabel lblManejoClientes;
    private javax.swing.JPanel panelVariable2;
    private javax.swing.JTable tblReporteClientes;
    // End of variables declaration//GEN-END:variables
}
