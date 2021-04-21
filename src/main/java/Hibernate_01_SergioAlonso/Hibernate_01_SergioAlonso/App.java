package Hibernate_01_SergioAlonso.Hibernate_01_SergioAlonso;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dataModelDAO.EmpleadoDAO;
import dataModelEntities.Empleado;
import dataModelUtils.HibernateUtil;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Logger logger = LogManager.getLogger(App.class);
	
	static SessionFactory sessionFactory;
	
    public static void main( String[] args )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        
        Empleado emple = EmpleadoDAO.getEmpleado(session, 1);
        
        System.out.println(emple.getNombre());
        
        EmpleadoDAO.insertEmpleados(session, new Empleado(10, "Sergio", "Alonso", "De Caso", "Zamora", 'a', "a", "a", "a", 1));
        
        System.out.println("FIN");
    }
}
