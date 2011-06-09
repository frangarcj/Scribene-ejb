package es.ual.scribene.session;

import javax.ejb.Local;

@Local
public interface DocumentView
{
    // seam-gen method
    public void documentView();
    public String getDocumento();
    public void setDocumento(String documento);
	public void remove();

    // add additional interface methods here

}
