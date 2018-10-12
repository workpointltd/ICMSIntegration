package com.icms.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.lang.StringEscapeUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public abstract class ServiceBuilder {

	protected String xml = null;
	private String soapEndpointUrl = "https://icmspt.kra.go.ke/services/EPROMISService.EPROMISServiceHttpsSoap11Endpoint";
	private String soapAction = null;

	public ServiceBuilder(String soapEndpointUrl, String soapAction) {
		this.soapEndpointUrl = soapEndpointUrl;
		this.soapAction = soapAction;
	}
	
	protected String doSoapSubmission(String xml){
		this.xml = xml;
		return callSoapWebService(soapEndpointUrl, soapAction);
	}
	
	private String callSoapWebService(String soapEndpointUrl, String soapAction) {
		String result = null;
		try {
			// Create SOAP Connection
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();

			// Send SOAP Message to SOAP Server
			SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);

			// Print the SOAP Response
			ByteArrayOutputStream bio = new ByteArrayOutputStream();
			soapResponse.writeTo(bio);
			result = new String(bio.toByteArray());
			result = StringEscapeUtils.unescapeXml(result);
			bio.close();
			soapConnection.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return result;
	}
	
	public String extractMessage(String xmlDocument, String xPathExp, String rootNode) throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new InputSource(new StringReader(xmlDocument)));
		
		XPath xPath = XPathFactory.newInstance().newXPath();
        XPathExpression xPathExpression = xPath.compile(xPathExp);
        NodeList nodes = (NodeList) xPathExpression.
	                evaluate(document, XPathConstants.NODESET);
        nodes = nodes.item(0).getChildNodes();
		
		Document newXmlDocument = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder().newDocument();
		Element root = newXmlDocument.createElement(rootNode);
		newXmlDocument.appendChild(root);
		for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            Node copyNode = newXmlDocument.importNode(node, true);
            root.appendChild(copyNode);
        }
		
		DOMImplementationLS domImplementationLS = 
		        (DOMImplementationLS) newXmlDocument.getImplementation();
		    LSSerializer lsSerializer = 
		        domImplementationLS.createLSSerializer();
		    String string = lsSerializer.writeToString(newXmlDocument);
		    
		return string;
	}
	
	protected String getString(String tagName, Element element) {
        NodeList list = element.getElementsByTagName(tagName);
        if (list != null && list.getLength() > 0) {
            NodeList subList = list.item(0).getChildNodes();

            if (subList != null && subList.getLength() > 0) {
                return subList.item(0).getNodeValue();
            }
        }

        return null;
    }
	
	private SOAPMessage createSOAPRequest(String soapAction) throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();

		createSoapEnvelope(soapMessage);

		if(soapAction!=null && !soapAction.isEmpty()) {
			MimeHeaders headers = soapMessage.getMimeHeaders();
			headers.addHeader("SOAPAction", soapAction);
		}

		soapMessage.saveChanges();

		/* Print the request message, just for debugging purposes */
		System.out.println("Request SOAP Message:");
		soapMessage.writeTo(System.out);
		System.out.println("\n");

		return soapMessage;
	}
	
	protected abstract void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException;
	
	public abstract <T> T build();
}
