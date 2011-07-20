package es.ual.scribene.session;

import es.ual.scribene.model.entity.*;
import es.ual.scribene.model.entity.Error;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("errorHome")
public class ErrorHome extends EntityHome<Error> {

	@In(create = true)
	DocumentoHome documentoHome;


	public void setErrorId(Long id) {
		setId(id);
	}

	public Long getErrorId() {
		return (Long) getId();
	}

	@Override
	protected Error createInstance() {
		Error error = new Error();
		return error;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Documento documento = documentoHome.getDefinedInstance();
		if (documento != null) {
			getInstance().setDocumento(documento);
		}

	}

	public boolean isWired() {
		return true;
	}

	public Error getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
