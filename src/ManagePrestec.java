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
public class ManagePrestec {

    private static SessionFactory factory;
    public static void main(String[] args) {
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        ManagePrestec ME = new ManagePrestec();/* Add



few employee records in database */
        Integer  empID1 = ME.addPrestec( 8569, 9521, "La sombra del viento", "Crisitan", "21/2/2016", "26/2/2016");
        Integer  empID2 = ME.addPrestec(8569, 5521,"La sombra del viento", "Fabian", "9/6/2016", "30/6/2016");
        Integer  empID3 = ME.addPrestec(8569, 7410,"Maus", "Marcos", "1/11/2016", "2/12/2016");
        /* List down all the employees */
        ME.listPrestec();
/* Update employee's records */
       // ME.updatePrestec(empID1, 5000);
/* Delete an employee from the database */
       // ME.deletePrestec(empID2);
/* List down new list of the employees */
        ME.listPrestec();
    }
    /* Method to CREATE an employee in the database */
    public Integer addPrestec(int llibre_id, int soci_id, String llibre, String soci, String data_inici, String data_final){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try{
            tx = session.beginTransaction();
            Prestec prestec = new Prestec(llibre_id, soci_id, llibre, soci, data_inici, data_final);
            employeeID = (Integer) session.save(prestec);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return employeeID;
    }
    /* Method to READ all the employees */
    public void listPrestec( ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Prestec").list();
            for (Iterator iterator =
                 employees.iterator(); iterator.hasNext();){
                Prestec prestec = (Prestec) iterator.next();
                System.out.print("Llibre id: " + prestec.getLlibre_id());
                System.out.print(" soci id: " + prestec.getSoci_id());
                System.out.println(" llibre: " + prestec.getLlibre());
                System.out.print(" soci: " + prestec.getSoci());
                System.out.print(" data de inici: " + prestec.getData_inici());
                System.out.println(" data de fi: " + prestec.getData_final());
            }
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    /* Method to UPDATE salary for an employee */
    public void updatePrestec(Integer llibre_id, String data_final ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Prestec prestec = (Prestec) session.get(Prestec.class, llibre_id);
            prestec.setData_final( data_final );
            session.update(prestec);
            tx.commit();
        }catch (HibernateException e) {if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    /* Method to DELETE an employee from the records */
    public void deletePrestec(Integer llibre_id){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Prestec llibres = (Prestec) session.get(Prestec.class, llibre_id);
            session.delete(llibres);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
}
