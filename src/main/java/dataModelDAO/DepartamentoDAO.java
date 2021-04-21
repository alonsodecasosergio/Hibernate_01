package dataModelDAO;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import Hibernate_01_SergioAlonso.Hibernate_01_SergioAlonso.App;
import dataModelEntities.Departamento;

public abstract class DepartamentoDAO {
	
	private static Logger logger = LogManager.getLogger(App.class);
	
	public static void inserDepartamento(Session s, Departamento depar) {
		s.save(depar);
		logger.info("Inserccion del departamento " + depar.toString());
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
		
		logger.info("Borrado del departamento: " + depar.toString());
		
	}
	
	public static void updateDepartamento(Session s, int departamentoId, Departamento deparActualizado) {
		
		Departamento depar = s.get(Departamento.class, departamentoId);
		
		depar.setCod_responsable(deparActualizado.getCod_responsable());
		depar.setNombre(deparActualizado.getNombre());
		
		s.update(depar);
		
		logger.info("Actualizacion del departamento: " + depar.toString());
	}

}
