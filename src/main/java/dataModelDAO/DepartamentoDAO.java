package dataModelDAO;

import java.util.List;

import org.hibernate.Session;

import dataModelEntities.Departamento;

public abstract class DepartamentoDAO {
	
	public static void inserDepartamento(Session s, Departamento depar) {
		s.save(depar);
	}
	
	public static List<Departamento> getAllDepartamento(Session s){
		String hQuery = "from Departamento";
		List<Departamento> departamentoList = s.createQuery(hQuery, Departamento.class).list();
		
		return departamentoList;
	}
	
	public static Departamento getDepartamento(Session s, int departamentoId) {
		String hQuery = " from Departamento d where d.codigo = :codigo";
		Departamento departamento = s.createQuery(hQuery, Departamento.class)
											.setParameter("codigo", departamentoId)
											.setMaxResults(1)
											.uniqueResult();
		return departamento;
	}
	
	public static void deleteDepartamento(Session s, int departamentoId) {
		
		Departamento depar = s.get(Departamento.class, departamentoId);
		
		s.delete(depar);
	}
	
	public static void updateDepartamento(Session s, int departamentoId, Departamento deparActualizado) {
		
		Departamento depar = s.get(Departamento.class, departamentoId);
		
		depar.setCod_responsable(deparActualizado.getCod_responsable());
		depar.setNombre(deparActualizado.getNombre());
		
		s.update(depar);
	}

}
