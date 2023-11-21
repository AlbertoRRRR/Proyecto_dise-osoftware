/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.gymalphasoftware;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
public class ProductosPanel extends javax.swing.JPanel {
    JFrame dashboard;
    Integer codigoProducto;
    CProducto objetoProducto = new CProducto();
    public ProductosPanel(JFrame Dashboard) {
        dashboard=Dashboard;
        initComponents();
        initStyles();
        paintImages();
        initConfiguration();
        tableStyles();
    }
    private void initStyles(){
        lblManejoProductos.putClientProperty("FlatLaf.styleClass", "h1");
        lblBusquedaProducto.putClientProperty("FlatLaf.styleClass", "h3");
        //tabla

        JTableHeader header = tblReporteProductos.getTableHeader();

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
        tblReporteProductos.getTableHeader().setDefaultRenderer(headerRenderer);
        
        
        tblReporteProductos.setRowHeight(35);
        tblReporteProductos.putClientProperty("FlatLaf.styleClass", "h3" );
        
        //Scroll pane
        
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER); // Esta línea desactiva la barra horizontal
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(15); // Ajustar velocidad de desplazamiento
        jScrollPane1.setBorder(null);
        
        
        
        //Quitar bordes
        tblReporteProductos.setBorder(BorderFactory.createEmptyBorder());
        jPanel1.setBorder(new EmptyBorder(0, 0, 0, 0));
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
                int totalWidth = tblReporteProductos.getWidth();
                int[] columnWidths = {6, 20, 8, 8, 6, 28,8,8,4,4};// Porcentajes relativos al ancho total

                for (int i = 0; i < tblReporteProductos.getColumnCount(); i++) {
                    TableColumn column = tblReporteProductos.getColumnModel().getColumn(i);
                    int preferredWidth = (int) (totalWidth * (columnWidths[i] / 100.0));
                    column.setPreferredWidth(preferredWidth);
                }
            }
        });
        //Pading de celdas
        tblReporteProductos.setDefaultRenderer(Object.class, new PaddedCellRenderer(20, 10, tblReporteProductos.getColumnCount()-2)); // Agregar el renderizador con padding
        System.out.println(tblReporteProductos.getColumnCount()-2);
        
    }
    
    private void initConfiguration(){
        objetoProducto.mostrarProducto(tblReporteProductos);
        
        //Listener de mouse
        GlobalMouseListener  globalMouseListener = new GlobalMouseListener(lblBusquedaProducto);
        panelVariable.addMouseListener(globalMouseListener);
        //Listener de JtextField
        lblBusquedaProducto.getDocument().addDocumentListener(new DocumentListener() {
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
                if(lblBusquedaProducto.getText().equals("") || lblBusquedaProducto.getText().equals("Ingresa producto")){
                    objetoProducto.mostrarProducto(tblReporteProductos);
                } else{
                    CProducto objetoProducto  = new CProducto ();
                    try {
                        objetoProducto.BuscarProducto(lblBusquedaProducto, tblReporteProductos);
                        
                    } catch (SQLException ex) {
                        Logger.getLogger(Dashboards.class.getName()).log(Level.SEVERE, null, ex);
                    }     
                }
            }
        });}
    
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
    
    public void actualizarTabla() {
        CProducto objetoProducto = new CProducto();
        try {
            objetoProducto.BuscarProducto(lblBusquedaProducto,tblReporteProductos);
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
        panelVariable = new javax.swing.JPanel();
        lblManejoProductos = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblBusquedaProducto = new javax.swing.JTextField();
        btnBusqueda = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporteProductos = new javax.swing.JTable();
        btnAñadir = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelVariable.setBackground(new java.awt.Color(255, 255, 255));
        panelVariable.setForeground(new java.awt.Color(16, 80, 200));
        panelVariable.setMinimumSize(new java.awt.Dimension(1020, 640));
        panelVariable.setPreferredSize(new java.awt.Dimension(1040, 740));

        lblManejoProductos.setText("Manejo de Productos");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btnActualizar.setText("Actualizar");
        btnActualizar.setMinimumSize(new java.awt.Dimension(75, 33));
        btnActualizar.setPreferredSize(new java.awt.Dimension(75, 33));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        lblBusquedaProducto.setBackground(new java.awt.Color(242, 242, 242));
        lblBusquedaProducto.setForeground(new java.awt.Color(153, 153, 153));
        lblBusquedaProducto.setText("Ingresa producto");
        lblBusquedaProducto.setBorder(null);
        lblBusquedaProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblBusquedaProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                lblBusquedaProductoFocusLost(evt);
            }
        });
        lblBusquedaProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblBusquedaProductoActionPerformed(evt);
            }
        });

        btnBusqueda.setBackground(new java.awt.Color(242, 242, 242));
        btnBusqueda.setBorder(null);
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
                .addGap(18, 18, 18)
                .addComponent(lblBusquedaProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBusquedaProducto)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(btnBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tblReporteProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblReporteProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReporteProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblReporteProductos);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1288, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelVariableLayout = new javax.swing.GroupLayout(panelVariable);
        panelVariable.setLayout(panelVariableLayout);
        panelVariableLayout.setHorizontalGroup(
            panelVariableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVariableLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblManejoProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1078, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelVariableLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelVariableLayout.setVerticalGroup(
            panelVariableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVariableLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblManejoProductos)
                .addGap(17, 17, 17)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(258, 258, 258))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(1285, Short.MAX_VALUE)
                .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelVariable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1360, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(722, Short.MAX_VALUE)
                .addComponent(btnAñadir, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(panelVariable, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1360, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 814, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAñadirActionPerformed
        new nuevoProducto(dashboard,true).setVisible(true);
    }//GEN-LAST:event_btnAñadirActionPerformed

    private void tblReporteProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReporteProductosMouseClicked
        int column = tblReporteProductos.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/tblReporteProductos.getRowHeight();

        if(row < tblReporteProductos.getRowCount() && row >= 0 && column < tblReporteProductos.getColumnCount() && column >= 0){
            Object value = tblReporteProductos.getValueAt(row, column);
            if(value instanceof JButton){
                ((JButton)value).doClick();
                JButton boton = (JButton) value;

                if(boton.getName().equals("m")){
                    System.out.println("Hola m");
                    int fila = tblReporteProductos.getSelectedRow();
                    codigoProducto = Integer.parseInt(tblReporteProductos.getValueAt(fila,0).toString());

                    try {
                        new modificarProducto(dashboard, true,codigoProducto).setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(manejoProductos.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                if(boton.getName().equals("e")){

                    int selectedRow = tblReporteProductos.getSelectedRow();

                    Object cellValue = tblReporteProductos.getValueAt(selectedRow, 0);
                    Integer cellValueText = Integer.parseInt(cellValue.toString());

                    String titulo = "Confirmación";
                    String mensaje = "<html>¿Está seguro de que quiere eliminar el registro?<br/>No sé podrá recuperar una vez eliminado.</html>";
                    new panelConfirmacionJFrame(dashboard, true, titulo, mensaje, "eliminarProducto",cellValueText, null).setVisible(true);

                }

            }
        }
    }//GEN-LAST:event_tblReporteProductosMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        CProducto objetoProducto = new CProducto();
        objetoProducto.mostrarProducto(tblReporteProductos);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void lblBusquedaProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblBusquedaProductoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_lblBusquedaProductoFocusGained

    private void lblBusquedaProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblBusquedaProductoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_lblBusquedaProductoFocusLost

    private void lblBusquedaProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblBusquedaProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblBusquedaProductoActionPerformed

    private void btnBusquedaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusquedaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusquedaMouseEntered

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAñadir;
    private javax.swing.JButton btnBusqueda;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lblBusquedaProducto;
    private javax.swing.JLabel lblManejoProductos;
    private javax.swing.JPanel panelVariable;
    private javax.swing.JTable tblReporteProductos;
    // End of variables declaration//GEN-END:variables
}
