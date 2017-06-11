/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import conexion.GenericRepository;
import conexion.SessionFactoryManager;
import conexion.conexcion1;
import controllers.detallePedidoManager;
import controllers.operadoresManager;
import controllers.pedidosManager;
import controllers.zonaManager;
import datos.dDetallePedido;
import datos.dOperadores;
import datos.dPedido;
import datos.dProductos;
import datos.dZona;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.SessionFactory;

/**
 *
 * @author leo
 */
public class tablaPedidos extends javax.swing.JFrame {

      public  static SessionFactory factory;
    public static Connection cn;
    
     dPedido dts=new dPedido();
     dPedido dtsEditar=new dPedido();
    
     java.util.Date datoFecha = null;
      java.util.Date datoEntrega = null;
      
      long cod1;
      
      
      public List<dPedido> pedido;
      
    public tablaPedidos() {
        initComponents();
        conectar();
        connecion();
        inhabilitar();
        mostar();
    }

     public void  conectar(){
       if(factory==null){
            SessionFactoryManager manager = new SessionFactoryManager();
             factory = manager.getSessionFactory();
       }else
       {
           System.out.println("ya esta conectado factory");
           factory.close();
       }

   }
   
   public void connecion(){
       if(cn==null){
   
    conexcion1 mysql = new conexcion1();
    cn = mysql.conectar1();}
       else{
           System.out.println("ya esta conectado cn");
       }
   
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtRazon = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtProvincia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEntrega = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        cboEstado = new javax.swing.JComboBox();
        txtZona = new javax.swing.JTextField();
        cboZona = new javax.swing.JComboBox();
        rZona = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        txtIdPr = new javax.swing.JTextField();
        txtProducto = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProductos = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePedidos = new javax.swing.JTable();
        rPendientes = new javax.swing.JRadioButton();
        rEntregados = new javax.swing.JRadioButton();
        rTodos = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("LISTADO DE PEDIDOS DE CARGA ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 877, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Id");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdKeyPressed(evt);
            }
        });

        txtRazon.setEditable(false);
        txtRazon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRazonActionPerformed(evt);
            }
        });

        jLabel2.setText("Ciudad");

        txtCiudad.setEditable(false);
        txtCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiudadActionPerformed(evt);
            }
        });

        jLabel3.setText("Provincia");

        txtProvincia.setEditable(false);
        txtProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProvinciaActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha");

        try {
            txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        jLabel5.setText("Entrega");

        try {
            txtEntrega.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntregaActionPerformed(evt);
            }
        });

        jLabel6.setText("Estado");

        txtEstado.setEditable(false);
        txtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEstadoActionPerformed(evt);
            }
        });

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PENDIENTE", "ENTREGADO" }));
        cboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboEstadoActionPerformed(evt);
            }
        });

        txtZona.setEditable(false);
        txtZona.setEnabled(false);
        txtZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtZonaActionPerformed(evt);
            }
        });

        cboZona.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NORTE", "SUR", "OESTE", "TRANSPORTE", "VIAJE\t" }));
        cboZona.setEnabled(false);
        cboZona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboZonaActionPerformed(evt);
            }
        });

        rZona.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRazon))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(rZona)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEstado)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addComponent(txtZona, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboZona, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRazon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboZona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rZona))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtIdPr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPrActionPerformed(evt);
            }
        });
        txtIdPr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIdPrKeyPressed(evt);
            }
        });

        txtProducto.setEditable(false);
        txtProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductoActionPerformed(evt);
            }
        });

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });

        jLabel7.setText("Id");

        jLabel8.setText("producto");

        jLabel9.setText("Cantidad");

        jLabel10.setText("Precio");

        btnAgregar.setText("+");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        tableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PRODUCTO", "CANTIDAD", "PRECIO"
            }
        ));
        jScrollPane1.setViewportView(tableProductos);

        btnEliminar.setText("-");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                                    .addComponent(txtIdPr))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtProducto)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCantidad)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPrecio)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdPr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnNuevo)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablePedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePedidosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablePedidos);

        buttonGroup1.add(rPendientes);
        rPendientes.setSelected(true);
        rPendientes.setText("PENDIENTES");
        rPendientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rPendientesActionPerformed(evt);
            }
        });

        buttonGroup1.add(rEntregados);
        rEntregados.setText("ENTREGADOS");
        rEntregados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rEntregadosActionPerformed(evt);
            }
        });

        buttonGroup1.add(rTodos);
        rTodos.setText("TODOS");
        rTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rTodosActionPerformed(evt);
            }
        });

        jButton1.setText("IMPRIMIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(rPendientes)
                .addGap(52, 52, 52)
                .addComponent(rEntregados)
                .addGap(38, 38, 38)
                .addComponent(rTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rPendientes)
                    .addComponent(rEntregados)
                    .addComponent(rTodos)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void habilitar(){
    
        txtId.setText("");
        txtRazon.setText("");
        txtProvincia.setText("");
        txtCiudad.setText("");
        txtFecha.setText("");
        txtEntrega.setText("");
        txtEstado.setText("");
        txtZona.setText("");
        txtIdPr.setText("");
        txtProducto.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        
        txtId.setEnabled(true);
        
        txtFecha.setEnabled(true);
        txtEntrega.setEnabled(true);
        
        
        txtIdPr.setEnabled(true);
        
        txtCantidad.setEnabled(true);
        txtPrecio.setEnabled(true);
        limpiaTabla();
        
    }
    
    public void inhabilitar(){
      txtId.setEnabled(false);
        
        txtFecha.setEnabled(false);
        txtEntrega.setEnabled(false);
        txtEstado.setEnabled(false);
        
        txtIdPr.setEnabled(false);
        
        txtCantidad.setEnabled(false);
        txtPrecio.setEnabled(false);
        rZona.setSelected(false);
        cboZona.setEnabled(false);
    
    }
     public void limpiaTabla() { /// METODO LIMPIAR TABLA (NO FUNCIONA)
        try {
            DefaultTableModel temp = (DefaultTableModel) tableProductos.getModel();
            int a = temp.getRowCount();
            for (int i = 0; i < a; i++) {
                temp.removeRow(0); //aquí estaba el error, antes pasaba la i como parametro.... soy un bacín  XD
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
     
      public void agregarProducto() {

       

        Object[] datos = new Object[]{txtIdPr.getText(), txtProducto.getText(), txtCantidad.getText(), txtPrecio.getText()};

        DefaultTableModel model = (DefaultTableModel) tableProductos.getModel();
        model.addRow(datos);
        tableProductos.setModel(model);

        txtIdPr.setText("");
        txtProducto.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
      

        

    }
      
      public void guardar(){
      
           GenericRepository<dPedido, Long> func = new GenericRepository<dPedido, Long>(factory) {
        };
        
           GenericRepository<dOperadores, Long> funcOP = new GenericRepository<dOperadores, Long>(factory) {
        }; 
      
           dOperadores operador=funcOP.getById(Long.valueOf(txtId.getText()));
           obtenerFecha();
           obtenerEntrega();
           
           
           
           dts.setOperadores(operador);
           dts.setFecha(datoFecha);
           dts.setEntrega(datoEntrega);
           dts.setEstado(txtEstado.getText());
           func.save(dts);
           guardarDetalle();
         
           if(rZona.isSelected()&& txtZona.getText().length()!=0)
           {guardarZona();}
           inhabilitar();
           mostar();
      }
       
      public void guardarDetalle(){
      
              GenericRepository<dDetallePedido, Long> func = new GenericRepository<dDetallePedido, Long>(factory) {
        };
        
           GenericRepository<dProductos, Long> funcPR = new GenericRepository<dProductos, Long>(factory) {
        }; 
          
             GenericRepository<dPedido, Long> funcPEDI = new GenericRepository<dPedido, Long>(factory) {
        };
      
           String datos="";
           
             int fila = tableProductos.getRowCount();
        for (int x = 0; x < fila; x++) {
        
            String cod = String.valueOf(tableProductos.getValueAt(x, 0));
            String nom= String.valueOf(tableProductos.getValueAt(x, 1));
            String cant = String.valueOf(tableProductos.getValueAt(x, 2));
            String pre = String.valueOf(tableProductos.getValueAt(x, 3));
        
            dProductos dtsProductos = funcPR.getById(Long.valueOf(cod));
            dDetallePedido detalle=new dDetallePedido();
            
            detalle.setCantidad(Integer.parseInt(cant));
            detalle.setPrecio(Double.valueOf(pre));
            detalle.setProducto(dtsProductos);
            detalle.setPedido(dts);
            
            
          datos=datos+" "+cant+" "+nom+" $"+pre+" ;";        
            func.save(detalle);
            
                        
        }
          System.out.println(datos);
        dts.setObservacion(datos);
           
        funcPEDI.update(dts);
      }
      
      public void guardarZona(){
      
           GenericRepository<dZona, Long> func = new GenericRepository<dZona, Long>(factory) {
        };
             GenericRepository<dOperadores, Long> funcOP = new GenericRepository<dOperadores, Long>(factory) {
        }; 
      
           dOperadores operador=funcOP.getById(Long.valueOf(txtId.getText()));
           dZona dtsZona=new dZona();
           
           dtsZona.setZona(txtZona.getText());
           dtsZona.setOperadores(operador);
           func.save(dtsZona);
          
      
      }
            
      
        public void obtenerFecha() {

        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");  ////// metodo para convertir string a date y colocarlo en jdatechooser   http://www.forosdelweb.com/f45/mysql-java-netbeans-java-sql-date-860869/
        String fecha = txtFecha.getText();

        try {

            datoFecha = formatoDelTexto.parse(fecha);

        } catch (ParseException ex) {

            ex.printStackTrace();

        }
        
    }
          public void obtenerEntrega() {

        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");  ////// metodo para convertir string a date y colocarlo en jdatechooser   http://www.forosdelweb.com/f45/mysql-java-netbeans-java-sql-date-860869/
        String fecha = txtEntrega.getText();

        try {

            datoEntrega = formatoDelTexto.parse(fecha);

        } catch (ParseException ex) {

            ex.printStackTrace();

        }
        
    }
           public void mostar() {

          
       DefaultTableModel model;
//         GenericRepository<dPedido, Long> func = new GenericRepository<dPedido, Long>(factory) {
//        };
       pedidosManager func=new pedidosManager(factory);
         
       
       if(rEntregados.isSelected()){
           pedido = func.listadoeNTREGADOS();
           
       }
       if(rPendientes.isSelected()){
           pedido = func.listadoPENDIENTES();
           
       }
        if(rTodos.isSelected()){
           pedido = func.listadoTODOS();
           
       }       
         
        List<dPedido> lista =pedido;
        
        String[] titulos = {"ID","FECHA", "RAZON SOCIAL", "LOCALIDAD","ENTREGA","OBSERVACION"};
        model = new DefaultTableModel(null, titulos);
        
        Object data[] = new Object[6];
        for (dPedido lista1 : lista) {
           
            data[0] = lista1.getIdPedidos();
            data[2] = lista1.getOperadores().getRazonSocial();
            data[3] = lista1.getOperadores().getLocalidad();
            
            data[5] = lista1.getObservacion();
            
            SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
      
             String strDate = sm.format(lista1.getFecha());
             String strDate1 = sm.format(lista1.getEntrega());
            try {
                //Converting the String back to java.util.Date
                Date dt = sm.parse(strDate);
                Date dt1 = sm.parse(strDate1);
            } catch (ParseException ex) {
                Logger.getLogger(tablaPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
             data[1] = strDate;
             data[4] = strDate1;
            
            model.addRow(data);
        }
       tablePedidos.setModel(model);
        tablePedidos.getColumnModel().getColumn(0).setMaxWidth(100);
        tablePedidos.getColumnModel().getColumn(1).setMaxWidth(350);
        tablePedidos.getColumnModel().getColumn(2).setMaxWidth(200);
        tablePedidos.getColumnModel().getColumn(3).setMaxWidth(100);
        tablePedidos.getColumnModel().getColumn(4).setMaxWidth(500);
        
    }
    
           public void editar(){
           
                GenericRepository<dPedido, Long> func = new GenericRepository<dPedido, Long>(factory) {
        };
           
           dtsEditar.setEstado(txtEstado.getText());
           func.update(dtsEditar);
           mostar();
           }
           
   public void detalle(){
       
       detallePedidoManager func=new detallePedidoManager(factory);
       DefaultTableModel model;
       
       List<dDetallePedido> lista=func.getDetalle(cod1);
       
       String[] titulos = {"ID","PRODUCTO", "CANTIDAD", "PRECIO"};
       model = new DefaultTableModel(null, titulos);
       
       Object data[] = new Object[4];
       for (dDetallePedido lista1 : lista) {
           
            data[0] = lista1.getProducto().getIdProductos().toString();
            data[1] = lista1.getProducto().getProductos();
            data[2] = lista1.getCantidad();
            data[3] = lista1.getPrecio();
           
            model.addRow(data);
           
       }
      tableProductos.setModel(model);
   
   
   }        
           
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
     agregarProducto();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DefaultTableModel dtm = (DefaultTableModel) tableProductos.getModel(); //TableProducto es el nombre de mi tabla ;) 
        dtm.removeRow(tableProductos.getSelectedRow());
        
      
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
      guardar();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
    
        zonaManager funcZ =new zonaManager(factory);
        operadoresManager funcOPP = new operadoresManager(factory);
        
        dOperadores op = funcOPP.getOperadorById(Long.valueOf(txtId.getText()));
       
         funcZ.zona(txtId.getText());
         String zona=funcZ.zona;
         System.out.println("zona es "+zona );
        
        txtRazon.setText(op.getRazonSocial());
        txtProvincia.setText(op.getProvincia());
        txtCiudad.setText(op.getLocalidad());
        txtZona.setText(zona);
        if(txtZona.getText().equals(""))
           {rZona.setSelected(true);
           cboZona.setEnabled(true);
           }else{
            rZona.setSelected(false);
            cboZona.setEnabled(false);
        }
        txtId.transferFocus();
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
       txtFecha.transferFocus();
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntregaActionPerformed
txtEntrega.transferFocus();
    }//GEN-LAST:event_txtEntregaActionPerformed

    private void txtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEstadoActionPerformed
        txtEstado.transferFocus();
    }//GEN-LAST:event_txtEstadoActionPerformed

    private void txtIdPrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPrActionPerformed
        if (txtIdPr.getText().length() != 0) {
             GenericRepository<dProductos, Long> funcPRO = new GenericRepository<dProductos, Long>(factory) {
      };
            
            dProductos pr = funcPRO.getById(Long.valueOf(txtIdPr.getText()));
            
            if(pr!=null){
            txtProducto.setText(pr.productos);
            txtIdPr.transferFocus();
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "producto no existe");
                return;
            }
        } else {

            return;
        }
    }//GEN-LAST:event_txtIdPrActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
       txtCantidad.transferFocus();
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        txtPrecio.transferFocus();
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
     habilitar();
     btnEditar.setEnabled(false);
     btnGuardar.setEnabled(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
    editar();
//  mostar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void cboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboEstadoActionPerformed
      txtEstado.setText(cboEstado.getSelectedItem().toString());
       
    }//GEN-LAST:event_cboEstadoActionPerformed

    private void txtIdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_F9) {
            vTabla_Operador form = new vTabla_Operador();
            form.ventana = "pedido";
            form.toFront();
            form.setVisible(true);
        }   // TODO add your handling code here:
    }//GEN-LAST:event_txtIdKeyPressed

    private void txtIdPrKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdPrKeyPressed
       if (evt.getKeyCode() == KeyEvent.VK_F9) {
            vTabla_Prod form = new vTabla_Prod();
            form.ventana = "pedido";
            form.toFront();
            form.setVisible(true);
        }   // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPrKeyPressed

    private void tablePedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePedidosMouseClicked
       if (evt.getClickCount() == 1) {
            int fila = tablePedidos.getSelectedRow();
                       
            String cod = tablePedidos.getValueAt(fila, 0).toString();
           pedidosManager func=new pedidosManager(factory);
            
           btnEditar.setEnabled(true);
           btnGuardar.setEnabled(false);
            cod1 = Long.valueOf(cod);
            
            dtsEditar=func.getPedidoById(cod1);
            
            txtId.setText(dtsEditar.getOperadores().getIdoperadores().toString());
            txtRazon.setText(dtsEditar.getOperadores().getRazonSocial());
            txtCiudad.setText(dtsEditar.getOperadores().getLocalidad());
            txtProvincia.setText(dtsEditar.getOperadores().getProvincia());
            txtEstado.setText(dtsEditar.getEstado());
            
            SimpleDateFormat sm = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat sm1 = new SimpleDateFormat("dd-MM-yyyy");
      
             String strDate = sm.format(dtsEditar.getFecha());
             String strDate1 = sm1.format(dtsEditar.getEntrega());
            try {
                //Converting the String back to java.util.Date
                Date dt = sm.parse(strDate);
                Date dt1 = sm.parse(strDate1);
            } catch (ParseException ex) {
                Logger.getLogger(tablaPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            txtFecha.setText(strDate);
            txtEntrega.setText(strDate1);
            
            
       
       
       }
    }//GEN-LAST:event_tablePedidosMouseClicked

    private void rPendientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rPendientesActionPerformed
      rPendientes.isSelected();
      mostar();
    }//GEN-LAST:event_rPendientesActionPerformed

    private void rEntregadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rEntregadosActionPerformed
    rEntregados.isSelected();
    mostar();
    }//GEN-LAST:event_rEntregadosActionPerformed

    private void rTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rTodosActionPerformed
     rTodos.isSelected();
     mostar();
    }//GEN-LAST:event_rTodosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   //  detalle();
     
     String path = "C:\\Users\\leo\\Documents\\NetBeansProjects\\pedidos\\src\\reportes\\pedidos.jasper";
            JasperReport jr = null;
            try {
               
                jr = (JasperReport) JRLoader.loadObjectFromFile(path);
                JasperPrint jp = JasperFillManager.fillReport(jr, null, cn);
                JasperViewer jw = new JasperViewer(jp, false);

                jw.setVisible(true);

            } catch (JRException ex) {
                Logger.getLogger(tablaPedidos.class.getName()).log(Level.SEVERE, null, ex);
            }
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtZonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtZonaActionPerformed

    private void cboZonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboZonaActionPerformed
       txtZona.setText(cboZona.getSelectedItem().toString());
    }//GEN-LAST:event_cboZonaActionPerformed

    private void txtRazonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRazonActionPerformed
      txtRazon.transferFocus();
    }//GEN-LAST:event_txtRazonActionPerformed

    private void txtCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiudadActionPerformed
       txtCiudad.transferFocus();
    }//GEN-LAST:event_txtCiudadActionPerformed

    private void txtProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProvinciaActionPerformed
       txtProvincia.transferFocus();
    }//GEN-LAST:event_txtProvinciaActionPerformed

    private void txtProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoActionPerformed
     txtProducto.transferFocus();
    }//GEN-LAST:event_txtProductoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tablaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tablaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tablaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tablaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tablaPedidos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cboEstado;
    private javax.swing.JComboBox cboZona;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rEntregados;
    private javax.swing.JRadioButton rPendientes;
    private javax.swing.JRadioButton rTodos;
    private javax.swing.JRadioButton rZona;
    private javax.swing.JTable tablePedidos;
    private javax.swing.JTable tableProductos;
    private javax.swing.JTextField txtCantidad;
    protected static javax.swing.JTextField txtCiudad;
    private javax.swing.JFormattedTextField txtEntrega;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JFormattedTextField txtFecha;
    protected static javax.swing.JTextField txtId;
    protected static javax.swing.JTextField txtIdPr;
    private javax.swing.JTextField txtPrecio;
    protected static javax.swing.JTextField txtProducto;
    protected static javax.swing.JTextField txtProvincia;
    protected static javax.swing.JTextField txtRazon;
    private javax.swing.JTextField txtZona;
    // End of variables declaration//GEN-END:variables
}
