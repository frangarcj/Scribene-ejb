package es.ual.scribene.session;

import es.ual.scribene.model.entity.*;
import es.ual.scribene.model.entity.Error;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("errorList")
public class ErrorList extends EntityQuery<Error> {

	private static final String EJBQL = "select error from Error error";

	private static final String[] RESTRICTIONS = { "lower(error.contexto) like lower(concat(#{errorList.error.contexto},'%'))", };

	private Error error = new Error();

	public ErrorList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Error getError() {
		return error;
	}
}
