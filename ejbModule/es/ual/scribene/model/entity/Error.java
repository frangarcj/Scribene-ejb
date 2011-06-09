package es.ual.scribene.model.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity(name = "Error")
@Table(name = "T_ERROR") 
public class Error {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ErrorGenerator")
	@SequenceGenerator(name = "ErrorGenerator")
	private long id;
	@Basic
	private String contexto;
	@ManyToOne
	private PatronError patronError;
	@ManyToOne
	private Documento documento;
	@Basic
	@Column(length = 100, nullable = false)
	private String error;
	@Basic
	private Long inicio;
	@Basic
	private Long fin;
	@ManyToOne
	private Duda duda;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setContexto(String param) {
		this.contexto = param;
	}

	public String getContexto() {
		return contexto;
	}

	public PatronError getPatronError() {
		return patronError;
	}

	public void setPatronError(PatronError param) {
		this.patronError = param;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento param) {
		this.documento = param;
	}

	public void setError(String param) {
		this.error = param;
	}

	public String getError() {
		return error;
	}

	public void setInicio(Long param) {
		this.inicio = param;
	}

	public Long getInicio() {
		return inicio;
	}

	public void setFin(Long param) {
		this.fin = param;
	}

	public Long getFin() {
		return fin;
	}

	public Duda getDuda() {
	    return duda;
	}

	public void setDuda(Duda param) {
	    this.duda = param;
	}

}