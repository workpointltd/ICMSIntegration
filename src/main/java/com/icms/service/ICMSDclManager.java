package com.icms.service;

import java.io.IOException;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.xpath.XPathExpressionException;

import org.apache.commons.lang.StringEscapeUtils;
import org.xml.sax.SAXException;

import ke.co.workpoint.extensions.util.ObjectBinder;
import ke.co.workpoint.icms.model.decl.Dcl;
import ke.co.workpoint.icms.model.decl.DclMessage;
import ke.co.workpoint.icms.model.decl.DclMessageBody;
import ke.co.workpoint.icms.model.decl.DclMessageHeader;
import ke.co.workpoint.icms.model.decl.DclResponseMessage;
import ke.co.workpoint.icms.model.exm.response.ResponseMessage;

public class ICMSDclManager extends SoapIntegrations{

	public ICMSDclManager() {
	}
	
	public class Builder extends ServiceBuilder{
		
		private DclMessageHeader header = new DclMessageHeader();
		private Dcl dcl = new Dcl();
		private DclMessage message = new DclMessage();
		private String xsdPath = null;
		
		public Builder() {
			super("https://icmspt.kra.go.ke/services/IPMIS.IPMISHttpsSoap11Endpoint", null);
			header.setAction("DCL_IPMIS_03_GET_DCL_ESLIP");
			xsdPath = "EXM-03.xsd";
		}
		
		public Builder setAction(String action) {
			header.setAction(action);
			return this;
		}
		
		public Builder setInformation(String information) {
			header.setInformation(information);
			return this;
		}
		
		public Builder setMessageId(String messageId) {
			header.setMessageId(messageId);
			return this;
		}
		
		public Builder setMessageVersion(Integer messageVersion) {
			header.setMessageVersion(messageVersion);
			return this;
		}
		
		public Builder setMessageDate(Date messageDate) {
			header.setMessageDate(toGregorianCalendar(messageDate));
			return this;
		}
		
		public Builder setReceiver(String receiver) {
			header.setReceiver(receiver);
			return this;
		}
		
		public Builder setSender(String sender) {
			header.setSender(sender);
			return this;
		}
		
		public Builder setModule(String module) {
			header.setModule(module);
			return this;
		}
		
		public Builder setDclNum(String dclNum) {
			dcl.setDclNum(dclNum);
			return this;
		}
		
		public DclResponseMessage build() {
			DclMessageBody body = new DclMessageBody();
			body.setDcl(dcl);
			message.setMessageBody(body);
			message.setMessageHeader(header);
			
			ObjectBinder binder = new ObjectBinder();
			String xml = binder.marshall(message);
			
			try {
				validate(xsdPath, xml);
			}catch (Exception e) {
				throw new RuntimeException(e);
			}
			
			//SOAP Send to ICMS
			String response = doSoapSubmission(xml);
			try {
				response = extractMessage(response, "/Envelope/Body/IPMIS03ReceiveDetailResponse/return/message", "dcl_response_message");
			} catch (XPathExpressionException | SAXException | IOException | ParserConfigurationException e) {
				throw new RuntimeException(e);
			}
			
			DclResponseMessage responseBody = ObjectBinder.get().unmarshall(response);
			return responseBody;
		}
		
		protected void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
			SOAPPart soapPart = soapMessage.getSOAPPart();

			String bullNs = "impl";
			String bullNsUri = "http://impl.service.ws.exm.ebiscus.bull.com/";

			// SOAP Envelope
			SOAPEnvelope envelope = soapPart.getEnvelope();
			envelope.addNamespaceDeclaration(bullNs, bullNsUri);

			// SOAP Body
			SOAPBody soapBody = envelope.getBody();
			SOAPElement incomingTag = soapBody.addChildElement("IPMIS03ReceiveDetail", bullNs);	
			SOAPElement loginId = incomingTag.addChildElement("loginID");
			loginId.addTextNode("IPMIS");
			SOAPElement password = incomingTag.addChildElement("password");
			password.addTextNode("Password@IPMIS");
			
			SOAPElement requestMessage = incomingTag.addChildElement("receiveXml");
			requestMessage.addTextNode("<![CDATA["+xml+"]]>");
		}
	}
}
