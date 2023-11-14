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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CMembresiaPorCliente {
    public void mostrarMembresiaCliente(JTable paramTablaMembresiaCliente){
        CConexion objetoConexion = new CConexion();
        Object[] columnNames = {"DNI","Membresia", "Fecha de Inicio","Fecha de fin", "",""};
        paramTablaMembresiaCliente.setDefaultRenderer(Object.class,new Render());
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
            "clientePorMembresia.FKCliente,\n" +
            "Membresia.membresiaNombre,\n" +
            "clientePorMembresia.membresiaFechaInicio,\n" +
            "clientePorMembresia.membresiaFechaFin\n" +
            "FROM clientePorMembresia\n" +
            "INNER JOIN Membresia ON Membresia.IDMembresia = clientePorMembresia.FKMembresia";
        
        String [] datos = new String[4];
        
        Statement st;
        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), botonEditar, botonEliminar});
            }
            
            paramTablaMembresiaCliente.setModel(modelo);
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
    }
    public int obtenerIdPorValor(String valor) {
    CConexion objetoConexion = new CConexion();
    int id = -1; // Valor predeterminado en caso de que no se encuentre ningún registro
    
    String consulta = "SELECT IDMembresia FROM Membresia WHERE membresiaNombre = ?";
    
    try {
        CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
        cs.setString(1, valor);

        ResultSet resultado = cs.executeQuery();
        if (resultado.next()) {
            id = resultado.getInt("IDMembresia");
        }
        resultado.close();
        cs.close();
    } catch (Exception e) {
        System.out.println("Error en ejecución: " + e.toString());
    }

    return id;
    }
    public void InsertarMembresiaCliente(JTextField paramCliente ,JComboBox paramMembresiaNombre, JTextField paramFechaInicio ,JTextField paramFechaFin){
        CConexion objetoConexion = new CConexion();
        
        String consulta = "SET DATEFORMAT YMD INSERT INTO clientePorMembresia (FKCliente, FKMembresia, membresiaFechaInicio, membresiaFechaFin)"+
                            "VALUES (?,?,?,?);";
        try{ 
            String fechaString = paramFechaInicio.getText();
            String fechaString2 = paramFechaFin.getText();
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaContrata = inputDateFormat.parse(fechaString);
            Date fechaContrata2 = inputDateFormat.parse(fechaString2);
            Integer codigoMembresia = obtenerIdPorValor(paramMembresiaNombre.getSelectedItem().toString());
                // Convertir java.util.Date a java.sql.Date
            java.sql.Date fechaInicio = new java.sql.Date(fechaContrata.getTime());
            java.sql.Date fichaFin = new java.sql.Date(fechaContrata2.getTime());
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
            cs.setString(1,paramCliente.getText());
            cs.setInt(2, codigoMembresia);
            cs.setDate(3,fechaInicio);
            cs.setDate(4,fichaFin);
            cs.execute();
            JOptionPane.showMessageDialog(null,"Se inserto correctamente");
            
        }catch (Exception e){
            System.out.println("Error en ejecucion"+e.toString());
        }
    }
    public void ModificarMembresiaCliente(JTextField paramCliente ,JComboBox paramMembresiaNombre, JTextField paramFechaInicio ,JTextField paramFechaFin){
        CConexion objetoConexion = new CConexion();
        
        String consulta = "UPDATE clientePorMembresia \n" +
                            "SET \n" +
                            "    clientePorMembresia.FKCliente = ?,\n" +
                            "    clientePorMembresia.FKMembresia = ?,\n" +
                            "    clientePorMembresia.membresiaFechaInicio = ?,\n" +
                            "    clientePorMembresia.membresiaFechaFin = ?\n" +
                            "WHERE clientePorMembresia.FKCliente = ? AND  clientePorMembresia.membresiaFechaInicio = CONVERT(DATE, ?, 120)";
        try{  
            String fechaString = paramFechaInicio.getText();
            String fechaString2 = paramFechaFin.getText();
            Integer codigoMembresia = obtenerIdPorValor(paramMembresiaNombre.getSelectedItem().toString());
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaContrata = inputDateFormat.parse(fechaString);
            Date fechaContrata2 = inputDateFormat.parse(fechaString2);

                // Convertir java.util.Date a java.sql.Date
            java.sql.Date fechaInicio = new java.sql.Date(fechaContrata.getTime());
            java.sql.Date fichaFin = new java.sql.Date(fechaContrata2.getTime());
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta); 
            cs.setString(1,paramCliente.getText());
            cs.setInt(2, codigoMembresia);
            cs.setDate(3,fechaInicio);
            cs.setDate(4,fichaFin);
            cs.setString(5,paramCliente.getText());
            cs.setDate(6,fechaInicio);
            
            cs.execute();
            JOptionPane.showMessageDialog(null,"Se actualizo correctamente");
            
        }catch (Exception e){
            System.out.println("Error en ejecucion"+e.toString());
        }
    }
    public void EliminarMembresiaCliente(String paramCodigo, String paramFecha){
        CConexion objetoConexion = new CConexion();
        
        String consulta = "DELETE FROM clientePorMembresia WHERE clientePorMembresia.FKCliente = ? AND  clientePorMembresia.membresiaFechaInicio =  CONVERT(DATE, ?, 120)";
        
        try{
            
            SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaAsignacionDescuento = inputDateFormat.parse(paramFecha);

                // Convertir java.util.Date a java.sql.Date
            java.sql.Date fechaDescuentoEmpleadoVivo = new java.sql.Date(fechaAsignacionDescuento.getTime());
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta); 
            cs.setString(1,paramCodigo);
            cs.setDate(2,fechaDescuentoEmpleadoVivo);
            cs.execute();
            JOptionPane.showMessageDialog(null,"Se elimino correctamente");
        } catch (Exception e){
            System.out.println("Error en eliminacion"+e.toString());
        }
    }
    public Map<String, String> asignarMembresiaCliente(String parametroDescuento, String parametroFechaDescuento) throws SQLException {
    CConexion objetoConexion = new CConexion();
    Map<String, String> descuentoEmpleadoData = new HashMap<>();

    // OBTENCION DE DATOS
    String consulta = "SELECT FKCliente, FKMembresia, membresiaFechaInicio,membresiaFechaFin FROM clientePorMembresia WHERE FKCliente = ? AND  membresiaFechaInicio =  CONVERT(DATE, ?, 120)\n";
    CallableStatement cs = objetoConexion.establecerConexion().prepareCall(consulta);
    cs.setString(1, parametroDescuento);
    cs.setString(2, parametroFechaDescuento);
    cs.execute();
    ResultSet resultSet = cs.executeQuery();

    if (resultSet.next()) {
        descuentoEmpleadoData.put("FKCliente", resultSet.getString("FKCliente"));
        descuentoEmpleadoData.put("FKMembresia", resultSet.getString("FKMembresia"));
        descuentoEmpleadoData.put("membresiaFechaInicio", resultSet.getString("membresiaFechaInicio"));
        descuentoEmpleadoData.put("membresiaFechaFin", resultSet.getString("membresiaFechaFin"));
    }

    return descuentoEmpleadoData;
    }
    public void mostrarMembresiaClienteSimple(JTable paramTablaMembresiaCliente){
        CConexion objetoConexion = new CConexion();
        Object[] columnNames = {"DNI","Membresia", "Fecha de Inicio","Fecha de fin"};
        paramTablaMembresiaCliente.setDefaultRenderer(Object.class,new Render());
        DefaultTableModel modelo = new DefaultTableModel (columnNames, 0){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String sql="";
       
        
        sql="SELECT\n" +
            "clientePorMembresia.FKCliente,\n" +
            "Membresia.membresiaNombre,\n" +
            "clientePorMembresia.membresiaFechaInicio,\n" +
            "clientePorMembresia.membresiaFechaFin\n" +
            "FROM clientePorMembresia\n" +
            "INNER JOIN Membresia ON Membresia.IDMembresia = clientePorMembresia.FKMembresia";
        
        String [] datos = new String[4];
        
        Statement st;
        
        try{
            st = objetoConexion.establecerConexion().createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                
               
                modelo.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
            }
            
            paramTablaMembresiaCliente.setModel(modelo);
        } catch(Exception e){
            System.out.println("No se mostraron los registror, error: " + e.toString());
            
        }
    }
}
