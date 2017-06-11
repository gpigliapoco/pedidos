/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;



import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



/**
 *
 * @author Marcelo
 */
public class SessionFactoryManager {
    
    
    public SessionFactory getSessionFactory(){
       
        Configuration config = new Configuration();
        config.setProperties(getHibernateProperties());
        config.addAnnotatedClass(datos.dOperadores.class);
       
        config.addAnnotatedClass(datos.dCategoria_op.class);
        config.addAnnotatedClass(datos.dCategoriaPR.class);
        config.addAnnotatedClass(datos.dZona.class);
        config.addAnnotatedClass(datos.dPedido.class);
        config.addAnnotatedClass(datos.dProductos.class);
        config.addAnnotatedClass(datos.dDetallePedido.class);
        config.addAnnotatedClass(datos.dTransporte.class);
        config.addAnnotatedClass(datos.dVendedor.class);
       
        return buildSessionFactory(config);
    }

    private SessionFactory buildSessionFactory(Configuration config) throws HibernateException {
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                applySettings(config.getProperties());
        SessionFactory factory = config.buildSessionFactory(builder.build());
        return factory;
    }


    private Properties getHibernateProperties() {
        Properties props = new Properties();
       // Establece el driver de conexion dependiente del RDBMS
        props.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");

        // Establece la url de conexion dependiente del RDBMS
        props.put("hibernate.connection.url", "jdbc:mysql://192.168.100.103:3306/pedidos");

        // Establece el usuario
        props.put("hibernate.connection.username", "root");

        // Establece la clave
        props.put("hibernate.connection.password", "password");

        // Establece el dialecto a utilizar
        props.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        
        // Establece el uso de logging, deber� existir el archivo log4j.properties
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.hbm2ddl.auto","update");

        // Retorna las propiedades
        return props;
    }
    
 

    
}
