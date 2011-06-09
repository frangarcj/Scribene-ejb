package es.ual.scribene.session;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.log.Log;
import org.jboss.seam.international.StatusMessages;
import org.hibernate.validator.Length;

import es.ual.scribene.model.entity.Documento;

@Stateful
@Name("documentUpload")
public class DocumentUploadBean implements DocumentUpload
{
    @Logger private Log log;

    @In StatusMessages statusMessages;
    
    
    private String value;

    public void documentUpload()
    {
        // implement your business logic here
        log.info("documentUpload.documentUpload() action called with: #{documentUpload.value}");
        statusMessages.add("documentUpload #{documentUpload.value}");
    }

    // add additional action methods

    @Length(max = 10)
    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    @Remove
    public void destroy() {}

}
