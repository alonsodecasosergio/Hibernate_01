package dataModelDAO;

import java.util.List;

import org.hibernate.Session;

import dataModelEntities.Empleado;

public abstract class EmpleadoDAO {
	
	public static void insertEmpleados(Session s, Empleado empleado) {
		
		s.save(empleado);
	}
	
	public static List<Empleado> getAllEmpleado(Session s){
		String hQuery = "from Empleado";
		List<Empleado> empleadoList = s.createQuery(hQuery, Empleado.class).list();
		
		return empleadoList;
	}
	
	public static Empleado getEmpleado(Session s, int empleadoId) {
		String hQuery = " from Empleado e where e.codigo = :codigo";
		Empleado empleado = s.createQuery(hQuery, Empleado.class)
									.setParameter("codigo", empleadoId)
									.setMaxResults(1)
									.uniqueResult();
		return empleado;
	}
	
	public static void deleteEmpleado(Session s, int empleadoId) {
		
		Empleado empleado = s.get(Empleado.class, empleadoId);
		
		s.delete(empleado);
		
	}
	
	public static void updateEmpleado(Session s, int empleadoId, Empleado empleActualizado) {
		
		Empleado empleado = s.get(Empleado.class, empleadoId);
		
		empleado.setNombre(empleActualizado.getNombre());
		empleado.setApellido1(empleActualizado.getApellido1());
		empleado.setApellido2(empleActualizado.getApellido2());
		empleado.setDireccion(empleActualizado.getDireccion());
		empleado.setFechaNacimiento(empleActualizado.getFechaNacimiento());
		empleado.setLugarNacimiento(empleActualizado.getLugarNacimiento());
		empleado.setPuesto(empleActualizado.getPuesto());
		empleado.setTelefono(empleActualizado.getTelefono());
		empleado.setCod_departamento(empleActualizado.getCod_departamento());
		
		s.update(empleado);
	}

}
