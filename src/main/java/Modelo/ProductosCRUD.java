/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import Modelo.Productos;

/**
 *
 * @author DAW-B
 */
public class ProductosCRUD {
    public static List<Productos> getProductos(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_productosCRUD_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT p FROM Productos p";
        Query q = manager.createQuery(sql,Productos.class);
        List<Productos> productosBD =  q.getResultList();
        return productosBD;
    }
    
    public static Productos getProducto(int id){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_productosCRUD_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "SELECT p FROM Productos p WHERE p.id="+id;
        Query q = manager.createQuery(sql,Productos.class);
        Productos productosBD = (Productos) q.getSingleResult();
        return productosBD; 
    }
    
    public static void insertaProducto(Productos p){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("com.mycompany_productosCRUD_war_1.0-SNAPSHOTPU");
        EntityManager manager = factory.createEntityManager();
        String sql = "INSERT INTO productos (id, nombre, imagen, categoria, precio) VALUES (NULL, 'Tortas de Alcazar Especial', '', 'complementos', '6.00');";
        manager.getTransaction().begin();
        Query q = manager.createNativeQuery(sql,Productos.class);
        manager.getTransaction().commit();
        int lineasRefrescadas=q.executeUpdate();
    }
}
