/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import datos.dDetallePedido;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author leo
 */
public class detallePedidoManager {
    
      private SessionFactory factory;

    public detallePedidoManager(SessionFactory factory) {
        if (factory == null) {
            throw new RuntimeException("factory is mandatory");
        }
        this.factory = factory;
    }
    
     public List<dDetallePedido> getDetalle(Long id){
     
         Session s = factory.openSession();
         try {
             return s.createQuery("From dDetallePedido as d join fecth d.producto as p join fetch d.pedido as i where d.pedido= :id").setParameter("id", id).list();
         } finally{
          s.close();
             
         }
     
     
     }
    
}
