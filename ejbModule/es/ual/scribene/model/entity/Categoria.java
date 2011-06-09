package es.ual.scribene.model.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import es.ual.scribene.model.entity.Duda;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.OneToMany;

@Entity(name = "Categoria")
@Table(name = "t_categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "CategoriaGenerator")
	@SequenceGenerator(name = "CategoriaGenerator")
	private long id;
	@Basic
	@Column(unique = true)
	private String descripcion;
	@OneToMany(mappedBy = "categoria")
	private List<Duda> dudas = new ArrayList<Duda>();
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

	public List<Duda> getDudas() {
	    return dudas;
	}

	public void setDudas(List<Duda> param) {
	    this.dudas = param;
	}

}