/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import datos.dZona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static vistas.tablaPedidos.cn;
/**
 *
 * @author leo
 */
public class zonaManager {
     private SessionFactory factory;
     public String zona="";

    public zonaManager(SessionFactory factory) {
        if (factory == null) {
            throw new RuntimeException("factory is mandatory");
        }
        this.factory = factory;
    }
    public dZona getByIdop (int id){
        Session s = factory.openSession();
         try{
         
          return (dZona) s.createQuery("from dZona  where operadores= :id").setParameter("id", id).uniqueResult();
                 
          
         }finally{
          s.close();
        }
    }  
    
    
    public void zona(String id) {

       String sSQL = "select zona from zonas  where fk_idOperadores='" + id + "'";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                zona = rs.getString("zona");

            }
          

        } catch (SQLException ex) {
            Logger.getLogger(dZona.class.getName()).log(Level.SEVERE, null, ex);
        }finally{ 
            
            
        }

    }
    
}
