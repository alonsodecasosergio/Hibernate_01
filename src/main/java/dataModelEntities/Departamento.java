package dataModelEntities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name = "CODIGO")
	private int codigo;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	 @Column(name = "COD_RESPONASABLE")
	private int cod_responsable;
	
	public Departamento() {
		
	}
	
	public Departamento(int codigo, String nombre, int cod_responsable) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cod_responsable = cod_responsable;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCod_responsable() {
		return cod_responsable;
	}

	public void setCod_responsable(int cod_responsable) {
		this.cod_responsable = cod_responsable;
	}

	@Override
	public String toString() {
		return "Departamento [codigo=" + codigo + ", nombre=" + nombre + ", cod_responsable=" + cod_responsable + "]";
	}
	
	
	
	
}
