package es.ual.scribene.session;

import es.ual.scribene.model.entity.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("dudaHome")
public class DudaHome extends EntityHome<Duda> {

	@In(create = true)
	CategoriaHome categoriaHome;

	public void setDudaId(Long id) {
		setId(id);
	}

	public Long getDudaId() {
		return (Long) getId();
	}

	@Override
	protected Duda createInstance() {
		Duda duda = new Duda();
		return duda;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Categoria categoria = categoriaHome.getDefinedInstance();
		if (categoria != null) {
			getInstance().setCategoria(categoria);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Duda getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<PatronError> getPatronesError() {
		return getInstance() == null ? null : new ArrayList<PatronError>(
				getInstance().getPatronesError());
	}

	public List<String> getCategorias() {
		return this
				.getEntityManager()
				.createQuery(
						"Select categoria.descripcion from Categoria categoria order by categoria.descripcion")
				.getResultList();
	}

	@Override
	public String persist() {

		try {
			Categoria categoria = null;

			categoria = (Categoria) this
					.getEntityManager()
					.createQuery(
							"Select categoria from Categoria categoria where descripcion = :descripcion")
					.setParameter("descripcion",
							categoriaHome.getInstance().getDescripcion())
					.getSingleResult();

			getInstance().setCategoria(categoria);

		} catch (Exception e) {
			getInstance().setCategoria(categoriaHome.getInstance());
			this.getEntityManager().persist(categoriaHome.getInstance());
		}
		return super.persist();
	}

	@Override
	public String update() {
		try {
			Categoria categoria = null;

			categoria = (Categoria) this
					.getEntityManager()
					.createQuery(
							"Select categoria from Categoria categoria where descripcion = :descripcion")
					.setParameter("descripcion",
							categoriaHome.getInstance().getDescripcion())
					.getSingleResult();

			getInstance().setCategoria(categoria);

		} catch (Exception e) {
			getInstance().setCategoria(categoriaHome.getInstance());
			this.getEntityManager().persist(categoriaHome.getInstance());
		}
		return super.update();
	}

}
