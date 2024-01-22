package com.mycompany.modelo.duenio;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mycompany.modelo.mascota.Mascota;

@Entity
@Table(name="tbduenios")
public class Duenio {
	
 // ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDuenio;
	
	@Column(length = 60)
	private String nombreDuenio;
	
	@Column(length = 10, unique = true)
	private String telefono;
	
	@Column(length = 300)
	private String direccion;
	
	private Boolean activo;
	
	@OneToMany(mappedBy = "duenio", 
			   cascade= {CascadeType.PERSIST,CascadeType.REMOVE},
			   fetch = FetchType.LAZY)
	private List<Mascota> mascota;
	
 // CONSTRUCTORES
	public Duenio() {
		
	}
	
	public Duenio(Integer idDuenio, String nombreDuenio, String telefono) {
		this.idDuenio = idDuenio;
		this.nombreDuenio = nombreDuenio;
		this.telefono = telefono;
	}
	
	public Duenio(String nombreDuenio, String telefono, String direccion) {
		this.nombreDuenio = nombreDuenio;
		this.telefono = telefono;
		this.direccion = direccion;
		this.activo = true;
	}
	
	public Duenio(Integer idDuenio, String nombreDuenio, String telefono, String direccion) {
		this(nombreDuenio, telefono, direccion);
		this.idDuenio = idDuenio;		
		this.activo = true;
	}

 // MÉTODOS	
	public Integer getIdDuenio() {
		return idDuenio;
	}

	public void setIdDuenio(Integer idDuenio) {
		this.idDuenio = idDuenio;
	}

	public String getNombreDuenio() {
		return nombreDuenio;
	}

	public void setNombreDuenio(String nombreDuenio) {
		this.nombreDuenio = nombreDuenio;
	}


	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public List<Mascota> getMascota() {
		return mascota;
	}

	public void setMascota(List<Mascota> mascota) {
		this.mascota = mascota;
	}

	@Override
	public String toString() {
		return "Duenio [idDuenio=" + idDuenio + ", nombreDuenio=" + nombreDuenio + ", apellidoPaternoDuenio="
				+ ", telefono=" + telefono + ", direccion=" + direccion + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(activo, direccion, idDuenio, mascota, nombreDuenio, telefono);
	}	
}
