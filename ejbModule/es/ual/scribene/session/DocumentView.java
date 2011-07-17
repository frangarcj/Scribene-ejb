package es.ual.scribene.session;



import javax.ejb.Local;

import org.jboss.seam.annotations.remoting.WebRemote;

@Local
public interface DocumentView
{
    // seam-gen method
	@WebRemote
	public void documentView();
    @WebRemote
    public String getDocumento();
    @WebRemote
    public void setDocumento(String documento);
    @WebRemote
	public void destroy();

    // add additional interface methods here

}
