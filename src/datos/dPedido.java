/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "pedidos")
public class dPedido implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPedidos")
    public Long idPedidos;
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    public Date fecha;
    @Temporal(TemporalType.DATE)
    @Column(name = "entrega")
    public Date entrega;
    @Column(name = "estado")
    public String estado;
    @Column(name = "observacion")
    public String observacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_idOperadores")
    public dOperadores operadores;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "pedido")
    public List<dDetallePedido> detallePedido;

    public dPedido() {
    }

    public dPedido(Date fecha, Date entrega, String estado, String observacion, dOperadores operadores, List<dDetallePedido> detallePedido) {
        this.fecha = fecha;
        this.entrega = entrega;
        this.estado = estado;
        this.observacion = observacion;
        this.operadores = operadores;
        this.detallePedido = detallePedido;
    }

   

    
    
    public Long getIdPedidos() {
        return idPedidos;
    }

    public void setIdPedidos(Long idPedidos) {
        this.idPedidos = idPedidos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getEntrega() {
        return entrega;
    }

    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public dOperadores getOperadores() {
        return operadores;
    }

    public void setOperadores(dOperadores operadores) {
        this.operadores = operadores;
    }

    public List<dDetallePedido> getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(List<dDetallePedido> detallePedido) {
        this.detallePedido = detallePedido;
    }

   
  
    
    
}
