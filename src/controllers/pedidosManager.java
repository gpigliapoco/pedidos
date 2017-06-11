/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import datos.dPedido;
import java.util.List;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author leo
 */
public class pedidosManager {
    
      private SessionFactory factory;

    public pedidosManager(SessionFactory factory) {
        if (factory == null) {
            throw new RuntimeException("factory is mandatory");
        }
        this.factory = factory;
    }
    
    public List<dPedido> listadoPENDIENTES(){
      Session s = factory.openSession();
         try {
             return  s.createCriteria(dPedido.class).add(Restrictions.like("estado", "PENDIENTE")).
                     setFetchMode("operadores", FetchMode.JOIN).
                     
                     list();
         } finally{
          s.close();
             
         }
      
      
      
      }
    public List<dPedido> listadoeNTREGADOS(){
      Session s = factory.openSession();
         try {
             return  s.createCriteria(dPedido.class).add(Restrictions.like("estado", "ENTREGADO")).
                     setFetchMode("operadores", FetchMode.JOIN).
                     
                     list();
         } finally{
          s.close();
             
         }
      
      
      
      }
    public List<dPedido> listadoTODOS(){
      Session s = factory.openSession();
         try {
             return  s.createCriteria(dPedido.class).
                     setFetchMode("operadores", FetchMode.JOIN).
                     
                     list();
         } finally{
          s.close();
             
         }
      
      
      
      }
    
     public dPedido getPedidoById(Long id){
     
         Session s = factory.openSession();
         try {
             return (dPedido) s.createQuery("From dPedido as p join fetch p.operadores  where p.idPedidos= :id").setParameter("id", id).uniqueResult();
         } finally{
          s.close();
             
         }
     
     
     }
}
