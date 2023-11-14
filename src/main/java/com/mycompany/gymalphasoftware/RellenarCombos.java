/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gymalphasoftware;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author Admin
 */
public class RellenarCombos {
    public DefaultComboBoxModel Llenar(){
        CConexion objetoConexion = new CConexion();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Seleccione");
        try{
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall("{CALL SP_COMBO_PROVEEDORES}");
            ResultSet rs = cs.executeQuery();
            while(rs.next())//Realizamos un recorrido
            {
                modelo.addElement(rs.getString(1));
            }
            System.out.println("Todo bien");
        }catch(Exception e){
            System.out.println("Hubo un problema" +e.toString());
        }
        
        return modelo;  
    }
    public DefaultComboBoxModel LlenarDescuentoEmpleado(){
        CConexion objetoConexion = new CConexion();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Seleccione");
        try{
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall("{CALL SP_DESCUENTO_TIPO_EMPLEADOS}");
            ResultSet rs = cs.executeQuery();
            while(rs.next())//Realizamos un recorrido
            {
                modelo.addElement(rs.getString(1));
            }
            System.out.println("Todo bien");
        }catch(Exception e){
            System.out.println("Hubo un problema" +e.toString());
        }
        
        return modelo;  
    }
    public DefaultComboBoxModel LlenarMembresia(){
        CConexion objetoConexion = new CConexion();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Seleccione");
        try{
            CallableStatement cs = objetoConexion.establecerConexion().prepareCall("{CALL SP_COMBO_MEMBRESIAS}");
            ResultSet rs = cs.executeQuery();
            while(rs.next())//Realizamos un recorrido
            {
                modelo.addElement(rs.getString(1));
            }
            System.out.println("Todo bien");
        }catch(Exception e){
            System.out.println("Hubo un problema" +e.toString());
        }
        
        return modelo;  
    }
}
