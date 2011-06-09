package es.ual.scribene.session;

import es.ual.scribene.model.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("documentoList")
public class DocumentoList extends EntityQuery<Documento> {

	private static final String EJBQL = "select documento from Documento documento";

	private static final String[] RESTRICTIONS = { "lower(documento.nombreFichero) like lower(concat(#{documentoList.documento.nombreFichero},'%'))", };

	private Documento documento = new Documento();

	public DocumentoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Documento getDocumento() {
		return documento;
	}
}
