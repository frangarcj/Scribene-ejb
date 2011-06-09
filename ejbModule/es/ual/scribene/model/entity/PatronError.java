package es.ual.scribene.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import es.ual.scribene.model.entity.Error;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.OneToMany;
import es.ual.scribene.model.entity.Duda;
import javax.persistence.ManyToOne;

@Entity(name = "PatronError")
@Table(name = "T_PATRONERROR")
public class PatronError {

	@Id
	private String patron;
	@OneToMany(mappedBy = "patronError")
	private List<Error> errores = new ArrayList<Error>();
	@ManyToOne
	private Duda duda;
	public void setPatron(String param) {
		this.patron = param;
	}

	public String getPatron() {
		return patron;
	}

	public List<Error> getErrores() {
	    return errores;
	}

	public void setErrores(List<Error> param) {
	    this.errores = param;
	}

	public Duda getDuda() {
	    return duda;
	}

	public void setDuda(Duda param) {
	    this.duda = param;
	}

}