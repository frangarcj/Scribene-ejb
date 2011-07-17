package es.ual.scribene.session;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Arrays;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.apache.tika.config.TikaConfig;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.sax.ContentHandlerDecorator;
import org.apache.tika.sax.TeeContentHandler;
import org.apache.tika.sax.XHTMLContentHandler;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.log.Log;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

@Stateful
@Name("documentView")
@Scope(ScopeType.CONVERSATION)
public class DocumentViewBean implements DocumentView {
	@Logger
	private Log log;

	@In
	StatusMessages statusMessages;

	@In(create = true)
	DocumentoHome documentoHome;

	@In(create = true)
	ErrorHome errorHome;

	@RequestParameter
	Long documentoId;

	private String documento;

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@Begin(join = true)
	public void documentView() {
		log.info(documentoHome.getId());
		log.info(documentoId);
		// implement your business logic here
		documentoHome.setDocumentoId(documentoId);
		TikaConfig tc = TikaConfig.getDefaultConfig();

		File f = new File("C:/Users/Paco/Mis Programas/Scribene/doc"
				+ documentoHome.getInstance().getId() + "-"
				+ documentoHome.getInstance().getNombreFichero());
		String txt = null;
		/*
		 * try { txt = ParseUtils.getStringContent(f, tc);
		 * org.apache.tika.parser.AutoDetectParser we = new
		 * AutoDetectParser(tc);
		 * 
		 * } catch (TikaException e) { // TODO Auto-generated catch block
		 * log.error(e); } catch (IOException e) { // TODO Auto-generated catch
		 * block log.error(e); }
		 */
		InputStream input = null;

		try {
			input = new FileInputStream(f);
			StringWriter htmlBuffer = new StringWriter();
			StringWriter textBuffer = new StringWriter();
			StringWriter xmlBuffer = new StringWriter();
			StringBuilder metadataBuffer = new StringBuilder();

			ContentHandler handler = new TeeContentHandler(
					getHtmlHandler(htmlBuffer),
					getTextContentHandler(textBuffer),
					getXmlContentHandler(xmlBuffer));
			Metadata md = new Metadata();
			md.set(Metadata.RESOURCE_NAME_KEY, f.getName());

			AutoDetectParser parser = new AutoDetectParser();
			parser.parse(input, handler, md);

			String[] names = md.names();
			Arrays.sort(names);
			for (String name : names) {
				metadataBuffer.append(name);
				metadataBuffer.append(": ");
				metadataBuffer.append(md.get(name));
				metadataBuffer.append("\n");
			}
			txt = htmlBuffer.toString();

		} catch (Exception e) {
		} finally {
			if (input != null)
				try {
					input.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		log.info(txt);
		documento = txt;
		/*
		 * documento = txt.replaceAll("\r\n", "<br/>"); documento =
		 * documento.replaceAll("\n", "<br/>"); documento =
		 * documento.replaceAll("   ", "&nbsp;&nbsp;"); documento =
		 * documento.replaceAll("  ", "&nbsp;&nbsp;"); documento =
		 * documento.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;");
		 */
		/* documento = documento.replaceAll("XPath", "<strong>XPath</strong>"); */
		log.info("documentView.documentView() action called");
		statusMessages.add("documentView");
	}

	private ContentHandler getHtmlHandler(Writer writer)
			throws TransformerConfigurationException {
		SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory
				.newInstance();
		TransformerHandler handler = factory.newTransformerHandler();
		handler.getTransformer().setOutputProperty(OutputKeys.METHOD, "html");
		handler.setResult(new StreamResult(writer));
		return new ContentHandlerDecorator(handler) {
			@Override
			public void startElement(String uri, String localName, String name,
					Attributes atts) throws SAXException {
				if (XHTMLContentHandler.XHTML.equals(uri)) {
					uri = null;
				}
				if (!"head".equals(localName)) {
					super.startElement(uri, localName, name, atts);
				}
			}

			@Override
			public void endElement(String uri, String localName, String name)
					throws SAXException {
				if (XHTMLContentHandler.XHTML.equals(uri)) {
					uri = null;
				}
				if (!"head".equals(localName)) {
					super.endElement(uri, localName, name);
				}
			}

			@Override
			public void startPrefixMapping(String prefix, String uri) {
			}

			@Override
			public void endPrefixMapping(String prefix) {
			}
		};
	}

	private ContentHandler getTextContentHandler(Writer writer) {
		return new BodyContentHandler(writer);
	}

	private ContentHandler getXmlContentHandler(Writer writer)
			throws TransformerConfigurationException {
		SAXTransformerFactory factory = (SAXTransformerFactory) SAXTransformerFactory
				.newInstance();
		TransformerHandler handler = factory.newTransformerHandler();
		handler.getTransformer().setOutputProperty(OutputKeys.METHOD, "xml");
		handler.setResult(new StreamResult(writer));
		return handler;
	}

	@Destroy
	@Remove
	public void destroy() {

	}

	// add additional action methods

}
