package es.ual.scribene.session;

import es.ual.scribene.model.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("categoriaList")
public class CategoriaList extends EntityQuery<Categoria> {

	private static final String EJBQL = "select categoria from Categoria categoria";

	private static final String[] RESTRICTIONS = { "lower(categoria.descripcion) like lower(concat(#{categoriaList.categoria.descripcion},'%'))", };

	private Categoria categoria = new Categoria();

	public CategoriaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Categoria getCategoria() {
		return categoria;
	}
}
