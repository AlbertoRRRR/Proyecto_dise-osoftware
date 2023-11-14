/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gymalphasoftware;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Admin
 */
public class MembresiasPanel extends javax.swing.JPanel {
    CMembresias objetoMembresias = new CMembresias();
    Integer codigoMembresias;
    JFrame dashboard;
    
    public MembresiasPanel(JFrame Dashboard) {
        dashboard=Dashboard;
        initComponents();
        paintImages();
        initConfiguration();
        initStyles();
        tableStyles();
    }
    
    private void initStyles(){
        tableStyles();
        lblManejoMembresias.putClientProperty("FlatLaf.styleClass", "h1");
        tfBusquedaProducto.putClientProperty("FlatLaf.styleClass", "h3");
        
        
        //tabla

        JTableHeader header = tblReporteMembresias.getTableHeader();

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
        tblReporteMembresias.getTableHeader().setDefaultRenderer(headerRenderer);
        
        
        tblReporteMembresias.setRowHeight(35);
        tblReporteMembresias.putClientProperty("FlatLaf.styleClass", "h3" );
        tblReporteMembresias.setShowHorizontalLines(true);
        
        //Scroll pane
        
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Esta línea desactiva la barra horizontal
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(15); // Ajustar velocidad de desplazamiento
        jScrollPane1.setBorder(null);
        
        
        
        //Quitar bordes
        tblReporteMembresias.setBorder(BorderFactory.createEmptyBorder());
        jPanel2.setBorder(new EmptyBorder(0, 0, 0, 0));
        jScrollPane1.setBorder(new EmptyBorder(0, 0, 0, 0));
        
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
                int totalWidth = tblReporteMembresias.getWidth();
                int[] columnWidths = {8, 17, 32, 8, 14, 12,3,3};// Porcentajes relativos al ancho total

                for (int i = 0; i < tblReporteMembresias.getColumnCount(); i++) {
                    TableColumn column = tblReporteMembresias.getColumnModel().getColumn(i);
                    int preferredWidth = (int) (totalWidth * (columnWidths[i] / 100.0));
                    column.setPreferredWidth(preferredWidth);
                }
            }
        });
        //Pading de celdas
        tblReporteMembresias.setDefaultRenderer(Object.class, new PaddedCellRenderer(20, 10, tblReporteMembresias.getColumnCount()-2)); // Agregar el renderizador con padding
        System.out.println(tblReporteMembresias.getColumnCount()-2);
        
    }
    
    private void initConfiguration(){
        objetoMembresias.mostrarMembresias(tblReporteMembresias);
        
        
        
        //Listener de mouse
        GlobalMouseListener globalMouseListener = new GlobalMouseListener(tfBusquedaProducto);
        panelVariable.addMouseListener(globalMouseListener);
        //Listener de JtextField
        tfBusquedaProducto.getDocument().addDocumentListener(new DocumentListener() {
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
                if(tfBusquedaProducto.getText().equals("") || tfBusquedaProducto.getText().equals("Ingresa Membresía")){
                    objetoMembresias.mostrarMembresias(tblReporteMembresias);
                } else{
                    CMembresias objetoMembresias = new CMembresias();
                    try {
                        objetoMembresias.BuscarMembresias(tfBusquedaProducto, tblReporteMembresias);
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(Dashboards.class.getName()).log(Level.SEVERE, null, ex);
                    }     
                }
            }
        });
        
    }
    
    private void paintImages(){
        scaleImageSizeAutomatic(btnBusqueda, "src/main/resources/images/BuscarGris.png",20,20);
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
    public Integer devolverCodigo() {
        return codigoMembresias;
    }
    public void recargarTabla() throws SQLException{
        CMembresias objetoMembresias = new CMembresias();
        objetoMembresias.BuscarMembresias(tfBusquedaProducto, tblReporteMembresias);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelVariable = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblManejoMembresias = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporteMembresias = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        tfBusquedaProducto = new javax.swing.JTextField();
        btnBusqueda = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAñadir = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1570, 940));
        setPreferredSize(new java.awt.Dimension(1570, 940));

        panelVariable.setBackground(new java.awt.Color(255, 255, 255));
        panelVariable.setForeground(new java.awt.Color(16, 80, 200));
        panelVariable.setMinimumSize(new java.awt.Dimension(1570, 940));
        panelVariable.setPreferredSize(new java.awt.Dimension(1570, 940));
        panelVariable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblManejoMembresias.setText("Manejo de Membresias");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBorder(null);

        tblReporteMembresias.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        tblReporteMembresias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblReporteMembresias.setToolTipText("");
        tblReporteMembresias.setGridColor(new java.awt.Color(255, 255, 255));
        tblReporteMembresias.setOpaque(false);
        tblReporteMembresias.setRowHeight(35);
        tblReporteMembresias.setSelectionBackground(new java.awt.Color(180, 205, 255));
        tblReporteMembresias.getTableHeader().setResizingAllowed(false);
        tblReporteMembresias.getTableHeader().setReorderingAllowed(false);
        tblReporteMembresias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReporteMembresiasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblReporteMembresias);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1490, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnActualizar.setText("Actualizar");
        btnActualizar.setMinimumSize(new java.awt.Dimension(75, 33));
        btnActualizar.setPreferredSize(new java.awt.Dimension(75, 33));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        tfBusquedaProducto.setBackground(new java.awt.Color(242, 242, 242));
        tfBusquedaProducto.setForeground(new java.awt.Color(153, 153, 153));
        tfBusquedaProducto.setText("Ingresa Membresía");
        tfBusquedaProducto.setBorder(null);
        tfBusquedaProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfBusquedaProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfBusquedaProductoFocusLost(evt);
            }
        });

        btnBusqueda.setBackground(new java.awt.Color(242, 242, 242));
        btnBusqueda.setBorder(null);
        btnBusqueda.setBorderPainted(false);
        btnBusqueda.setContentAreaFilled(false);
        btnBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBusqueda.setFocusPainted(false);
        btnBusqueda.setFocusable(false);
        btnBusqueda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBusquedaMouseEntered(evt);
            }
        });
        btnBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaActionPerformed(evt);
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
                .addComponent(btnBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(tfBusquedaProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tfBusquedaProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(40, 40, 40))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(80, 80, 80))
        );

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
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(lblManejoMembresias, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lblManejoMembresias, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145)
                .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        panelVariable.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1570, 940));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1570, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelVariable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelVariable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        new nuevaMembresia(dashboard, true).setVisible(true);
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void tblReporteMembresiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReporteMembresiasMouseClicked
        
        int column = tblReporteMembresias.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblReporteMembresias.getRowHeight();

        if(row < tblReporteMembresias.getRowCount() && row >= 0 && column < tblReporteMembresias.getColumnCount() && column >= 0){
            Object value = tblReporteMembresias.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;
                boton.putClientProperty("FlatLaf.styleClass", "h3");
                if(boton.getName().equals("m")){
                    int fila = tblReporteMembresias.getSelectedRow();
                    codigoMembresias = Integer.parseInt(tblReporteMembresias.getValueAt(fila,0).toString());
                    try {
                        new detalleMembresia(dashboard, true, codigoMembresias).setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(manejoMembresias.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(boton.getName().equals("e")){
                    int selectedRow = tblReporteMembresias.getSelectedRow();
                    Object cellValue = tblReporteMembresias.getValueAt(selectedRow, 0);
                    Integer cellValueText = Integer.parseInt(cellValue.toString());
                    
                    String titulo = "Confirmación";
                    String mensaje = "<html>¿Está seguro de que quiere eliminar el registro?<br/>No sé podrá recuperar una vez eliminado.</html>";
                    new panelConfirmacionJFrame(dashboard, true, titulo, mensaje, "eliminarMembresia",cellValueText, null).setVisible(true);
                    
                }

            }
        }
        
    }//GEN-LAST:event_tblReporteMembresiasMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        CMembresias objetoMembresias = new CMembresias();
        objetoMembresias.mostrarMembresias(tblReporteMembresias);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tfBusquedaProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBusquedaProductoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBusquedaProductoFocusGained

    private void tfBusquedaProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfBusquedaProductoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tfBusquedaProductoFocusLost

    private void btnBusquedaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusquedaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusquedaMouseEntered

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusquedaActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblManejoMembresias;
    private javax.swing.JPanel panelVariable;
    private javax.swing.JTable tblReporteMembresias;
    private javax.swing.JTextField tfBusquedaProducto;
    // End of variables declaration//GEN-END:variables

    private void addWindowFocusListener(WindowFocusListener windowFocusListener) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
