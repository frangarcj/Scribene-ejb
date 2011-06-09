package es.ual.scribene.session;

import es.ual.scribene.model.entity.*;
import es.ual.scribene.model.entity.Error;

import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("patronErrorHome")
public class PatronErrorHome extends EntityHome<PatronError> {

	@In(create = true)
	DudaHome dudaHome;

	public void setPatronErrorPatron(String id) {
		setId(id);
	}

	public String getPatronErrorPatron() {
		return (String) getId();
	}

	@Override
	protected PatronError createInstance() {
		PatronError patronError = new PatronError();
		return patronError;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Duda duda = dudaHome.getDefinedInstance();
		if (duda != null) {
			getInstance().setDuda(duda);
		}
	}

	public boolean isWired() {
		return true;
	}

	public PatronError getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Error> getErrores() {
		return getInstance() == null ? null : new ArrayList<Error>(
				getInstance().getErrores());
	}

}
