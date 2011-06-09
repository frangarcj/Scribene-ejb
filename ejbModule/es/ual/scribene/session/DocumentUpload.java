package es.ual.scribene.session;

import javax.ejb.Local;

@Local
public interface DocumentUpload
{
    public void documentUpload();
    public String getValue();
    public void setValue(String value);
    public void destroy();

    // add additional interface methods here

}
