package com.icms.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.XMLConstants;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public abstract class SoapIntegrations {

	protected void validate(String xsdPath, String xml) throws SAXException, IOException {
		InputStream xsdIn = getClass().getClassLoader().getResourceAsStream(xsdPath);
		Source xmlFile = new StreamSource(new StringReader(xml));
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

		Schema schema = schemaFactory.newSchema(new StreamSource(xsdIn));
		Validator validator = schema.newValidator();
		validator.validate(xmlFile);
	}

	public XMLGregorianCalendar toGregorianCalendar(Date date) {
		GregorianCalendar greg = new GregorianCalendar();
		greg.setTime(new Date());
		XMLGregorianCalendar calendar = null;
		try {
			calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(greg);
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return calendar;
	}

}
