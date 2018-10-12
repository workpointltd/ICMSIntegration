package ke.co.workpoint.icms.model.exm;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class ICMSValidator {

	public boolean validate(String xsdPath, String xml) {
		InputStream xsdIn = getClass().getClassLoader().getResourceAsStream(xsdPath);
		Source xmlFile = new StreamSource(new StringReader(xml));
		SchemaFactory schemaFactory = SchemaFactory
		    .newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		try {
		  Schema schema = schemaFactory.newSchema(new StreamSource(xsdIn));
		  Validator validator = schema.newValidator();
		  validator.validate(xmlFile);
		  
		  return true;
		} catch (SAXException e) {
		  System.out.println(xmlFile.getSystemId() + " is NOT valid reason:" + e);
		} catch (IOException e) {}
		
		
		return false;
	}
}
