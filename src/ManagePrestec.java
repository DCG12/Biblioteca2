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
        ManageLlibres ME = new ManageLlibres();/* Add



few employee records in database */
        Integer  empID1 = ME.addLlibres("Zara", "Ali", 1000);
        Integer  empID2 = ME.addLlibres("Daisy", "Das", 5000);
        Integer  empID3 = ME.addLlibres("John", "Paul", 10000);

        /* List down all the employees */
        ME.listLlibres();
/* Update employee's records */
        ME.updateLlibres(empID1, 5000);
/* Delete an employee from the database */
        ME.deleteLlibres(empID2);
/* List down new list of the employees */
        ME.listLlibres();
    }
    /* Method to CREATE an employee in the database */
    public Integer addLlibres(String fname, String lname, int salary){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer employeeID = null;
        try{
            tx = session.beginTransaction();
            Llibres llibres = new Llibres(fname, lname, salary);
            employeeID = (Integer) session.save(llibres);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        return llibresID;
    }
    /* Method to READ all the employees */
    public void listEmployees( ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            List employees = session.createQuery("FROM Llibres").list();
            for (Iterator iterator =
                 employees.iterator(); iterator.hasNext();){
                Llibres llibres = (Llibres) iterator.next();
                System.out.print("First Name: " + llibres.getFirstName());
                System.out.print(" Last Name: " + llibres.getLastName());
                System.out.println(" Salary: " + llibres.getSalary());
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
    public void updateEmployee(Integer EmployeeID, int salary ){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Llibres llibres =
                    (Llibres)session.get(Llibres.class, EmployeeID);
            llibres.setSalary( salary );
            session.update(llibres);
            tx.commit();
        }catch (HibernateException e) {if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }
    /* Method to DELETE an employee from the records */
    public void deleteEmployee(Integer EmployeeID){
        Session session = factory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Llibres llibres = (Llibres)session.get(Llibres.class, EmployeeID);
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
