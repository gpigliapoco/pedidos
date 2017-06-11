/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author leo
 */
@Entity
@Table(name = "detallePedido")
public class dDetallePedido implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idDetalle")
    public Long idDetalle;
    @Column(name = "cantidad")
    public int cantidad;
    @Column(name = "precio")
    public double precio;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_idProductos")
    public dProductos producto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_idPedidos")
    public dPedido pedido;

    public dDetallePedido() {
    }

    public dDetallePedido(int cantidad, double precio, dProductos producto, dPedido pedido) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.producto = producto;
        this.pedido = pedido;
    }

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public dProductos getProducto() {
        return producto;
    }

    public void setProducto(dProductos producto) {
        this.producto = producto;
    }

    public dPedido getPedido() {
        return pedido;
    }

    public void setPedido(dPedido pedido) {
        this.pedido = pedido;
    }
    
    
}
