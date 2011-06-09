package es.ual.scribene.session;

import es.ual.scribene.model.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("patronErrorList")
public class PatronErrorList extends EntityQuery<PatronError> {

	private static final String EJBQL = "select patronError from PatronError patronError";

	private static final String[] RESTRICTIONS = { "lower(patronError.patron) like lower(concat(#{patronErrorList.patronError.patron},'%'))", };

	private PatronError patronError = new PatronError();

	public PatronErrorList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public PatronError getPatronError() {
		return patronError;
	}
}
