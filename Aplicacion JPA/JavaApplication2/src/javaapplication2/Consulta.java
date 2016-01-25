package javaapplication2;

import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Yery
 */
public class Consulta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication2PU"); 
        EntityManager em = emf.createEntityManager(); 
        EntityTransaction tx = em.getTransaction();
        // Creamos la query (consulta).
        Query query = em.createQuery("SELECT c FROM Articulo c ");
        
    	// 10 resultados como mucho.
        query.setMaxResults(10);
        
        // Obtenemos el vector de resultados de la BD.
    	Vector<String> list =  (Vector<String>) query.getResultList();
    	
    	// Imprimimos vector de resultados.
    	System.out.println(list);
        
        // Cerramos EntityManager y EntityManagerFactory para no consumir recursos.
        em.close(); 
        emf.close(); 
    }
    
}
