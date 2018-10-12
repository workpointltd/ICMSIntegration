package com.icms.service;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import ke.co.workpoint.extensions.util.ObjectBinder;
import ke.co.workpoint.icms.model.exm.response.ResponseMessage;

public class ICMSExmStatusManager extends SoapIntegrations {

	public ICMSExmStatusManager() {
		
	}

	public class Builder extends ServiceBuilder {

		public Builder() {
			super("https://icmspt.kra.go.ke/services/EPROMISService.EPROMISServiceHttpsSoap11Endpoint",
					"OUTGOING");
		}
		
		@Override
		public ResponseMessage build() {
			String response = doSoapSubmission(xml);
			
			try {
				response = extractMessage(response, "/Envelope/Body/out_goingResponse/return/message", "response_message");
			} catch (XPathExpressionException | SAXException | IOException | ParserConfigurationException e) {
				throw new RuntimeException(e);
			}
			
			System.err.println(response);
			ResponseMessage responseBody = ObjectBinder.get().unmarshall(response);
			return responseBody;
		}

		@Override
		protected void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
			SOAPPart soapPart = soapMessage.getSOAPPart();

			String bullNs = "web";
			String bullNsUri = "http://webService.icms.bull.com/";

			// SOAP Envelope
			SOAPEnvelope envelope = soapPart.getEnvelope();
			envelope.addNamespaceDeclaration(bullNs, bullNsUri);

			// SOAP Body
			SOAPBody soapBody = envelope.getBody();
			SOAPElement baseTag = soapBody.addChildElement("out_going", bullNs);

			SOAPElement action = baseTag.addChildElement("Action");
			action.addTextNode("IPMIS01_Exemption_Master_List_Response");

		}
		
	}
}
