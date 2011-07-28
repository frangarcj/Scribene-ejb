package es.ual.scribene.session;

import es.ual.scribene.model.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("dudaList")
public class DudaList extends EntityQuery<Duda> {

	private static final String EJBQL = "select duda from Duda duda";

	private static final String[] RESTRICTIONS = {
			"lower(duda.nombre) like lower(concat('%',concat(#{dudaList.duda.nombre},'%')))",
			"lower(duda.descripcion) like lower(concat('%',concat(#{dudaList.duda.descripcion},'%')))",
			"lower(duda.ejemploBuenUso) like lower(concat('%',concat(#{dudaList.duda.ejemploBuenUso},'%')))",
			"lower(duda.ejemploMalUso) like lower(concat('%',concat(#{dudaList.duda.ejemploMalUso},'%')))",
			"lower(duda.fuente) like lower(concat('%',concat(#{dudaList.duda.fuente},'%')))", 
			"lower(duda.etiquetas) like lower(concat('%',concat(#{dudaList.duda.etiquetas},'%')))", };

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
