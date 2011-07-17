package es.ual.scribene.session;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.remoting.WebRemote;
import org.jboss.seam.framework.EntityHome;
import org.richfaces.event.UploadEvent;
import org.richfaces.model.UploadItem;

import es.ual.scribene.model.entity.Documento;
import es.ual.scribene.model.entity.Error;
import es.ual.scribene.utils.FileUtils;

@Name("documentoHome")
public class DocumentoHome extends EntityHome<Documento> {

	public void setDocumentoId(Long id) {
		setId(id);
	}

	public Long getDocumentoId() {
		return (Long) getId();
	}

	@Override
	protected Documento createInstance() {
		Documento documento = new Documento();
		return documento;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Documento getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	@WebRemote   
	public List<Error> getErrores() {
		return getInstance() == null ? null : new ArrayList<Error>(
				getInstance().getErrores());
	}

	public void listener(UploadEvent event) throws Exception {
		UploadItem item = event.getUploadItem();
		getLog().info("En archivo? #0", item.isTempFile());
		instance.setNombreFichero(item.getFileName());
		getLog().info("Nombre #0", item.getFileName());
		getLog().info("Tamaño #0", item.getFile().getAbsolutePath());
		File archivo = new File(item.getFileName());
		getLog().info("Se guarda en #0 #1", archivo.getCanonicalPath(),
				instance.getId());
		this.persist();
		getLog().info("Se guarda en #0 #1", archivo.getCanonicalPath(),
				instance.getId());
		this.setId(instance.getId());
		FileUtils.copyFile(item.getFile(), new File(
				"C:/Users/Paco/Mis Programas/Scribene/doc" + instance.getId()
						+ "-" + instance.getNombreFichero()));

	}

}
