/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Yery
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplication2PU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //Creamos el objeto
        Articulo art =new Articulo();
        //Actualizamos los datos
        art.setIDarticulo(6);
        art.setDescripcion("Pantalon Verde");
        art.setPeso(15);
        art.setExistencia(4);
        // Iniciamos la transacción.
        tx.begin();

        try {
        	// Se mapea el objeto a la tabla (se crea la tupla si no existia)
        	// Los cambios en Java afectarán al MySQL y viceversa.
            em.persist(art);
            // Commiteamos los cambios, de la misma forma que se haria en SQL puro.
            tx.commit();
        } catch(Exception e) {
        	// Al encontrar un error, deshacemos los cambios de la transacción.
            tx.rollback();
        }

        // Cerramos EntityManager y EntityManagerFactory para no consumir recursos.
        em.close();
        emf.close();
    }

}
