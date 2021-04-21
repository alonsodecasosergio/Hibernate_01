package Hibernate_01_SergioAlonso.Hibernate_01_SergioAlonso;

import java.util.Locale;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import dataModelDAO.DepartamentoDAO;
import dataModelDAO.EmpleadoDAO;
import dataModelEntities.Departamento;
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
	
	static Scanner teclado = new Scanner(System.in);
	
    public static void main( String[] args )
    {
    	
    	teclado.useDelimiter(System.getProperty("line.separator"));
		teclado.useLocale(Locale.ENGLISH);
		
		
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        tx = session.beginTransaction();
        
        int opcion = 0;
        
        try {
        	
        	do {
            	
            	menu();
            	opcion = teclado.nextInt();
            	
            	switch(opcion) {
            		
            	case 1:
            			EmpleadoDAO.insertEmpleados(session, pedirEmpleado());
            		break;
            		
            	case 2:
    	        		System.out.println("Introduzca el codigo del empleado a borrar");
    	            	int id = teclado.nextInt();
    	            	EmpleadoDAO.deleteEmpleado(session, id);
            		break;
            		
            	case 3:
            			System.out.println("Introduzca el codigo del empleado a modificar");
            			id = teclado.nextInt();
            			EmpleadoDAO.updateEmpleado(session, id, pedirEmpleado());
            		break;
            		
            	case 4:
    	        		System.out.println("Introduzca el codigo del empleado a consultar");
    	    			id = teclado.nextInt();
    	    			EmpleadoDAO.getEmpleado(session, id).toString();
            		break;
            		
            	case 5:
            			DepartamentoDAO.inserDepartamento(session, pedirDepartamento());
            			
            		break;
            		
            	case 6:
    	        		System.out.println("Introduzca el codigo del departamento a borrar");
    	    			id = teclado.nextInt();
    	    			DepartamentoDAO.deleteDepartamento(session, id);
            		break;
            		
            	case 7:
            			System.out.println("Introduzca el codigo del departamento a modificar");
            			id = teclado.nextInt();
            			DepartamentoDAO.updateDepartamento(session, id, pedirDepartamento());
            		break;
            		
            	case 8:
        				System.out.println("Introduzca el codigo del departamento a consultar");
        				id = teclado.nextInt();
        				DepartamentoDAO.getDepartamento(session, id).toString();
            		break;
            	case 0:
            		System.out.println("Programa finalizado");
            		break;
            		
        		default:
        			System.out.println("Opcion incorrecta");
            	}
            	
            }while(opcion != 0);
            
            tx.commit();
        	
        }catch (Exception e) {
  		  if (tx != null) {
  		    tx.rollback();
  		  }
  			logger.error("Error en la ejecucion del programa");
  		}
  		finally {
  			if (session != null) {
  				session.close();
  			}
  		}
        
    }
    
    
    public static void menu() {
    	
    	System.out.println(" BASE DE DATOS EMPLEADOS");
    	System.out.println("1. INSERTAR EMPLEADO");
    	System.out.println("2. BORRAR EMPLEADO");
    	System.out.println("3. ACTUALIZAR EMPLEADO");
    	System.out.println("4. OBTENER EMPLEADO");
    	System.out.println("5. INSERTAR DEPARTAMENTO");
    	System.out.println("6. BORRAR DEPARTAMENTO");
    	System.out.println("7. ACTUALIZAR DEPARTAMENTO");
    	System.out.println("8. OBTENER DEPARTAMENTO");
    	System.out.println("0. SALIR");
    	System.out.println("INSERTE UN NUMERO");
    }
    
    public static Empleado pedirEmpleado() {
    	
    	System.out.println("Introduzca el codigo de empleado");
    	int cod = teclado.nextInt();
    	
    	System.out.println("Introduzca el nombre");
    	String nombre = teclado.next();
    	
    	System.out.println("Introduzca del primer apellido");
    	String apellido1 = teclado.next();
    	
    	System.out.println("Introduzca del segundo apellido");
    	String apellido2 = teclado.next();
    	
    	System.out.println("Introduzca el lugar de nacimiento");
    	String nacimiento = teclado.next();
    	
    	System.out.println("Introduzca el fecha de nacimiento");
    	char fechaNacimiento = teclado.next().charAt(0);
    	
    	System.out.println("Introduzca direccion");
    	String direccion = teclado.next();
    	
    	System.out.println("Introduzca telefono");
    	String telefono = teclado.next();
    	
    	System.out.println("Introduzca el puesto");
    	String puesto = teclado.next();
    	
    	System.out.println("Introduzca el codigo de departamento");
    	int codDepar= teclado.nextInt();
    	
    	Empleado emple = new Empleado(cod, nombre, apellido1, apellido2, nacimiento, fechaNacimiento, direccion, telefono, puesto, codDepar);
    	
    	return emple;
    }
    
    public static Departamento pedirDepartamento() {
    	
    	System.out.println("Introduzca el codigo");
    	int codigo = teclado.nextInt();
    	
    	System.out.println("Introduzca el nombre del departamento");
    	String nombre = teclado.next();
    	
    	System.out.println("Introduzca el codigo del responsable");
    	int codResponsable = teclado.nextInt();
    	
    	Departamento depar = new Departamento(codigo, nombre, codResponsable);
    	return depar;
    }
}
