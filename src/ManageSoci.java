
import java.util.List;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageSoci {

    private static SessionFactory factory;
    public static void main(String[] args) {
        try{
            factory = new Configuration().configure().buildSessionFactory();
        }catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        ManageSoci ME = new ManageSoci();/* Add



few employee records in database */
        Integer  empID1 = ME.addSocis(5521, "Cristian", "Ramirez", 21, "En casa de su suegros", 645217942);
        Integer  empID2 = ME.addSocis(9521, "Fabian", "Puig", 40, "Castellon", 611926452);
        Integer  empID3 = ME.addSocis(7410, "Marcos", "Canton", 33, "a unos 20 minutos del insti", 688214239);

        /* List down all the employees */
        ME.listSoci();
/* Update employee's records */
       // ME.updateEmployee(empID1, 5000);
/* Delete an employee from the database */
        //ME.deleteEmployee(empID2);
/* List down new list of the employees */
        ME.listSoci();
    }
    /* Method to CREATE an employee in the database */
    public Integer addSocis(int soci_id, String nom, String cognom, int edat, String direccio, int telefon){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try{
            tx = session.beginTransaction();
            Soci soci = new Soci(soci_id, nom, cognom, edat, direccio, telefon);
            //soci_id = (Integer) session.save(soci);
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
    public void listSoci( ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List socis = session.createQuery("FROM Soci").list();
            for (Iterator iterator =
                 socis.iterator(); iterator.hasNext();){
                Soci soci = (Soci) iterator.next();
                System.out.print(" Id: " + soci.getSoci_id());
                System.out.print(" Nom: " + soci.getNom());
                System.out.println(" Cognom: " + soci.getCognom());
                System.out.print(" edat: " + soci.getEdat());
                System.out.print(" direcció: " + soci.getDireccio());
                System.out.println(" telefon: " + soci.getTelefon());
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
    public void updateSoci(Integer soci_id, String direccio ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Soci soci = (Soci)session.get(Soci.class, soci_id);
            soci.setDireccio();
            session.update(soci);
            tx.commit();
        }catch (HibernateException e) {if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    /* Method to DELETE an employee from the records */
    public void deleteSoci(Integer soci_id){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Soci soci = (Soci) session.get(Soci.class, soci_id);
            session.delete(soci);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

}
