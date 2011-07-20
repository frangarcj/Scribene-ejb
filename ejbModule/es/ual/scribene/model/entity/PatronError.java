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
	@ManyToOne
	private Duda duda;
	public void setPatron(String param) {
		this.patron = param;
	}

	public String getPatron() {
		return patron;
	}



	public Duda getDuda() {
	    return duda;
	}

	public void setDuda(Duda param) {
	    this.duda = param;
	}

}