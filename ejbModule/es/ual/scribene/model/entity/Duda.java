package es.ual.scribene.model.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import es.ual.scribene.model.entity.Error;
import java.util.Collection;
import java.lang.String;
import javax.persistence.Column;

@Entity(name = "Duda")
@Table(name = "T_DUDA")
public class Duda {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "NormativaGenerator")
	@SequenceGenerator(name = "NormativaGenerator")
	private long id;
	@Basic
	private String descripcion;
	@Basic
	private String ejemploMalUso;
	@Basic
	private String fuente;
	@OneToMany(mappedBy = "duda")
	private List<PatronError> patronesError = new ArrayList<PatronError>();
	@ManyToOne
	private Categoria categoria;
	@OneToMany(mappedBy = "duda")
	private Collection<Error> errores = new ArrayList<Error>();
	@Basic
	private String ejemploBuenUso;
	@Basic
	@Column(unique = true, length = 50)
	private String nombre;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setDescripcion(String param) {
		this.descripcion = param;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setEjemploMalUso(String param) {
		this.ejemploMalUso = param;
	}

	public String getEjemploMalUso() {
		return ejemploMalUso;
	}

	public void setFuente(String param) {
		this.fuente = param;
	}

	public String getFuente() {
		return fuente;
	}

	public List<PatronError> getPatronesError() {
		return patronesError;
	}

	public void setPatronesError(List<PatronError> param) {
		this.patronesError = param;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria param) {
		this.categoria = param;
	}

	public Collection<Error> getErrores() {
		return errores;
	}

	public void setErrores(Collection<Error> param) {
		this.errores = param;
	}

	public void setEjemploBuenUso(String param) {
		this.ejemploBuenUso = param;
	}

	public String getEjemploBuenUso() {
		return ejemploBuenUso;
	}

	public void setNombre(String param) {
		this.nombre = param;
	}

	public String getNombre() {
		return nombre;
	}

}