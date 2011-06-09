package es.ual.scribene.session;

import es.ual.scribene.model.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("dudaList")
public class DudaList extends EntityQuery<Duda> {

	private static final String EJBQL = "select duda from Duda duda";

	private static final String[] RESTRICTIONS = {
			"lower(duda.descripcion) like lower(concat(#{dudaList.duda.descripcion},'%'))",
			"lower(duda.ejemploBuenUso) like lower(concat(#{dudaList.duda.ejemploBuenUso},'%'))",
			"lower(duda.ejemploMalUso) like lower(concat(#{dudaList.duda.ejemploMalUso},'%'))",
			"lower(duda.fuente) like lower(concat(#{dudaList.duda.fuente},'%'))", };

	private Duda duda = new Duda();

	public DudaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Duda getDuda() {
		return duda;
	}
}
