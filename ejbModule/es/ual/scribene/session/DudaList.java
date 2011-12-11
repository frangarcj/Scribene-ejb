package es.ual.scribene.session;

import es.ual.scribene.model.entity.*;

import org.apache.commons.lang3.StringEscapeUtils;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Scope(ScopeType.CONVERSATION)
@Name("dudaList")
public class DudaList extends EntityQuery<Duda> {

	private static final String EJBQL = "select duda from Duda duda";

	private static final String[] RESTRICTIONS = {
			"lower(duda.nombre) like lower(concat('%',concat(#{dudaList.duda.nombre},'%')))",
			"lower(duda.descripcion) like lower(concat('%',concat(#{dudaList.descripcion},'%')))",
			"lower(duda.ejemploBuenUso) like lower(concat('%',concat(#{dudaList.ejemploBuenUso},'%')))",
			"lower(duda.ejemploMalUso) like lower(concat('%',concat(#{dudaList.ejemploMalUso},'%')))",
			"lower(duda.categoria.descripcion) like lower(concat('%',concat(#{dudaList.duda.categoria.descripcion},'%')))",
			"lower(duda.fuente) like lower(concat('%',concat(#{dudaList.duda.fuente},'%')))", 
			"lower(duda.etiquetas) like lower(concat('%',concat(#{dudaList.duda.etiquetas},'%')))", };

	private Duda duda = new Duda();

	public DudaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
		duda.setCategoria(new Categoria());
		
	}

	public Duda getDuda() {
		return duda;
	}
	
	

	public String getDescripcion() {
		return StringEscapeUtils.escapeHtml4(duda.getDescripcion());
	}
	
	public String getEjemploMalUso() {
		return StringEscapeUtils.escapeHtml4(duda.getEjemploMalUso());
	}

	public String getEjemploBuenUso() {
		return StringEscapeUtils.escapeHtml4(duda.getEjemploBuenUso());
	}
}
