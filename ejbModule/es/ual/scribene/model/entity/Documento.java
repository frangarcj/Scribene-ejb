package es.ual.scribene.model.entity;

import javax.persistence.*;
import java.lang.String;
import static javax.persistence.GenerationType.SEQUENCE;
import es.ual.scribene.model.entity.Error;
import java.util.List;
import java.util.ArrayList;

@Entity(name = "Documento")
@Table(name = "T_DOCUMENTO")
public class Documento {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "DocumentoGenerator")
	@SequenceGenerator(name = "DocumentoGenerator")
	private long id;
	@Basic
	private String nombreFichero;
	@OneToMany(mappedBy = "documento")
	private List<Error> errores = new ArrayList<Error>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNombreFichero(String param) {
		this.nombreFichero = param;
	}

	public String getNombreFichero() {
		return nombreFichero;
	}

	public List<Error> getErrores() {
	    return errores;
	}

	public void setErrores(List<Error> param) {
	    this.errores = param;
	}

}