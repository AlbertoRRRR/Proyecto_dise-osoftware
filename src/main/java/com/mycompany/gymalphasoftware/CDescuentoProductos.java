/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymalphasoftware;


import java.awt.Color;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CDescuentoProductos {
    public void mostrarDescuentosProductos(JTable paramTablaDescuentosProductos){
        CConexion objetoConexion = new CConexion();
        Object[] columnNames = {"Codigo","Nombre", "Cantidad a descontar", "Fecha de Creación","Moneda","",""};
        paramTablaDescuentosProductos.setDefaultRenderer(Object.class,new Render());
        DefaultTableModel modelo = new DefaultTableModel (columnNames, 0){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String sql="";
        JButton botonEditar = new JButton("Editar");
        botonEditar.setName("m");
        JButton botonEliminar = new JButton("Eliminar");
        botonEliminar.setName("e");   
        botonEliminar.setBackground(Color.RED);
        botonEditar.setBackground(Color.GREEN);
        
        sql="SELECT\n" +
            "	IDDescuento,\n" +
            "	nombreDescuento,\n" +
            "	cantidadDescuento,\n" +
            "	fechaCreacionDescuento,\n" +
            "	unidadMedidaDescuento\n" +
            "FROM Descuento";
        
        String [] datos = new String[5];
        
        Statement st;
        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);             
                
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), botonEditar, botonEliminar});
            }
            
            paramTablaDescuentosProductos.setModel(modelo);
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
    }
    public void InsertarDescuentoProducto(JTextField nombreDescuento, JTextField cantidadDescuento, JTextField fechaCreacionDescuento,JTextField unidadMedidaDescuento){
        CConexion objetoConexion = new CConexion();
        
        String consulta = "INSERT INTO Descuento VALUES(?,?,CONVERT(DATE, ?, 103),?)";
        try{ 
            String fechaCreacionDescuentos = fechaCreacionDescuento.getText();
            
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaCreacionDescuentoDate = inputDateFormat.parse(fechaCreacionDescuentos);

                // Convertir java.util.Date a java.sql.Date
            java.sql.Date fechaCreacionDescuentoJava = new java.sql.Date(fechaCreacionDescuentoDate.getTime());
           
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1,nombreDescuento.getText());
            cs.setFloat(2,Float.parseFloat(cantidadDescuento.getText()));
            cs.setDate(3,fechaCreacionDescuentoJava);
            cs.setString(4,unidadMedidaDescuento.getText());
            cs.execute();
            JOptionPane.showMessageDialog(null,"Se inserto correctamente");
            
        }catch (Exception e){
            System.out.println("Error en ejecucion"+e.toString());
        }
    }
    public void ModificarDescuentoProducto(JTextField codigoDescuento ,JTextField nombreDescuento, JTextField cantidadDescuento, JTextField fechaCreacionDescuento,JTextField unidadMedidaDescuento){
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE Descuento \n" +
                            "SET \n" +
                            "    Descuento.nombreDescuento = ?,\n" +
                            "    Descuento.cantidadDescuento = ?,\n" +
                            "    Descuento.fechaCreacionDescuento = ?,\n" +
                            "    Descuento.unidadMedidaDescuento = ?\n" +
                            "WHERE Descuento.IDDescuento = ? ";
        try{  
            String fechaCreacionDescuentos = fechaCreacionDescuento.getText();
            
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaCreacionDescuentoDate = inputDateFormat.parse(fechaCreacionDescuentos);

                // Convertir java.util.Date a java.sql.Date
            java.sql.Date fechaCreacionDescuentoJava = new java.sql.Date(fechaCreacionDescuentoDate.getTime());
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta); 
            cs.setString(1,nombreDescuento.getText());
            cs.setFloat(2,Float.parseFloat(cantidadDescuento.getText()));
            cs.setDate(3,fechaCreacionDescuentoJava);
            cs.setString(4,unidadMedidaDescuento.getText());
            cs.setInt(5,Integer.parseInt(codigoDescuento.getText()));          
            cs.execute();
            JOptionPane.showMessageDialog(null,"Se actualizo correctamente");
            
        }catch (Exception e){
            System.out.println("Error en ejecucion"+e.toString());
        }
    }
    public void EliminarDescuentoProducto(Integer paramCodigo){
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM Descuento WHERE Descuento.IDDescuento = ?";
        
        try{            
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta); 
            cs.setInt(1,paramCodigo);  
            cs.execute();
            JOptionPane.showMessageDialog(null,"Se elimino correctamente");
        } catch (Exception e){
            System.out.println("Error en eliminacion"+e.toString());
        }
    }
    public Map<String, String> asignarDescuentoProducto(Integer parametroCodigoDescuento) throws SQLException {
    CConexion objetoConexion = new CConexion();
    Map<String, String> descuentoProductoData = new HashMap<>();

    // OBTENCION DE DATOS
    String consulta = "SELECT\n" +
            "	IDDescuento,\n" +
            "	nombreDescuento,\n" +
            "	cantidadDescuento,\n" +
            "	fechaCreacionDescuento,\n" +
            "	unidadMedidaDescuento\n" +
            "FROM Descuento\n"+
            "WHERE Descuento.IDDescuento = ?";
    CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
    cs.setInt(1, parametroCodigoDescuento);
    cs.execute();
    ResultSet resultSet = cs.executeQuery();

    if (resultSet.next()) {
        descuentoProductoData.put("IDDescuento", resultSet.getString("IDDescuento"));
        descuentoProductoData.put("nombreDescuento", resultSet.getString("nombreDescuento"));
        descuentoProductoData.put("cantidadDescuento", resultSet.getString("cantidadDescuento"));
        descuentoProductoData.put("fechaCreacionDescuento", resultSet.getString("fechaCreacionDescuento"));
        descuentoProductoData.put("unidadMedidaDescuento", resultSet.getString("unidadMedidaDescuento"));
    }

    return descuentoProductoData;
    }
    public void mostrarDescuentoProductosSimple(JTable paramTablaDescuentosProductos){
        CConexion objetoConexion = new CConexion();
        Object[] columnNames = {"Codigo","Nombre", "Cantidad a descontar", "Fecha de Creación","Moneda","",""};
        paramTablaDescuentosProductos.setDefaultRenderer(Object.class,new Render());
        DefaultTableModel modelo = new DefaultTableModel (columnNames, 0){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String sql=""; 
        
        sql="SELECT\n" +
            "	IDDescuento,\n" +
            "	nombreDescuento,\n" +
            "	cantidadDescuento,\n" +
            "	fechaCreacionDescuento,\n" +
            "	unidadMedidaDescuento\n" +
            "FROM Descuento";
        
        String [] datos = new String[5];
        
        Statement st;
        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);             
                
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)});
            }
            
            paramTablaDescuentosProductos.setModel(modelo);
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
    }
}
