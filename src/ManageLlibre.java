import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

/**
 * Created by 46406163y on 23/01/17.
 */
public class ManageLlibre {

    private static SessionFactory factory;
    public static void main(String[] args) {
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        ManageLlibre ME = new ManageLlibre();

        Integer  empID1 = ME.addLlibre(8569, "La sombra del viento", 5, "Planeta", 501, 2001);
        Integer  empID2 = ME.addLlibre(8567, "El sabueso de los Baskerville", 3, "Strand Magazine", 368, 1902);
        Integer  empID3 = ME.addLlibre(8563, "El hobbit", 6, "Planeta", 370, 1937);
        Integer  empID4 = ME.addLlibre(8569, "Maus", 1, "Apex Novelties", 198, 1980);
        Integer  empID5 = ME.addLlibre(8570, "Persepolis", 2, "Norma", 152, 2007);
        Integer  empID6 = ME.addLlibre(8551, "100 años de soledad", 5, "Harper", 623, 1967);


        ME.listLlibre();

        //ME.updateLlibre(empID1, 5000);

        //ME.deleteLlibre(empID2);

        ME.listLlibre();
    }

    public Integer addLlibre(int llibre_id, String titol, int nombre_exemplars, String editorial, int nombre_pagines, int any_edicio){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try{
            tx = session.beginTransaction();
            Llibre llibre = new Llibre(llibre_id, titol, nombre_exemplars, editorial, nombre_pagines, any_edicio);

            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return employeeID;
    }

    public void listLlibre( ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List llibre = session.createQuery("FROM Llibre").list();
            for (Iterator iterator =
                 llibre.iterator(); iterator.hasNext();){
                Llibre libro = (Llibre) iterator.next();
                System.out.print("Id: " + libro.getLlibre_id());
                System.out.print("Titol: " + libro.getTítol());
                System.out.print("Editorial: " + libro.getEditorial());
                System.out.println("Any d'edició: " + libro.getAny_edicio());
                System.out.println(" numero de pagines: " + libro.getNombre_pagines());
                System.out.println(" numero d'exemplars: " + libro.getNombre_exemplars());
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void updateLlibre(Integer llibreID, int nombre_exemplars ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Llibre llibre =
                    (Llibre)session.get(Llibre.class, llibreID);
            llibre.getNombre_exemplars();
            session.update(llibre);
            tx.commit();
        }catch (HibernateException e) {if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    public void deleteLlibre(Integer llibre_id){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Llibre llibre = (Llibre)session.get(Llibre.class, llibre_id);
            session.delete(llibre);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}
