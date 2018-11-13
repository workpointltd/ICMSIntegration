package com.icms.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import com.icms.service.ICMSDclManager.Builder;

import ke.co.workpoint.extensions.util.ObjectBinder;
import ke.co.workpoint.icms.model.exm.Eml;
import ke.co.workpoint.icms.model.exm.EmlBody;
import ke.co.workpoint.icms.model.exm.EmlHeader;
import ke.co.workpoint.icms.model.exm.Item;
import ke.co.workpoint.icms.model.exm.Items;
import ke.co.workpoint.icms.model.exm.Message;
import ke.co.workpoint.icms.model.exm.MessageBody;
import ke.co.workpoint.icms.model.exm.MessageHeader;
import ke.co.workpoint.icms.model.exm.response.ResponseMessage;

public class ICMSExmManager extends SoapIntegrations{

	public ICMSExmManager() {
	}
	
	public static Builder getBuilder() {
		return new ICMSExmManager().new Builder();
	}
	
	public class Builder extends ServiceBuilder{
		
		Eml eml = new Eml();
		EmlHeader emlHeader = new EmlHeader();
		MessageHeader header = new MessageHeader();
		Items items = new Items();		
		String xsdPath = "iPMIS01_XSD.xml";
		
		public Builder() {
			super("https://icmspt.kra.go.ke/services/EPROMISService.EPROMISServiceHttpsSoap11Endpoint", "INCOMING");
			setAction("eProMIS_01_Receive_EML");
			setMessageVersion("1");
			setModule("EXM");
			setReceiver("iCMS");
			setSender("iPMIS");
			setImplAgency("MFA");
			setExemptionChannel("ONLINE");
		}
		
		public Builder setAction(String action) {
			header.setAction(action);
			return this;
		}
		
		public Builder setInformation(String information) {
			header.setInformation(information);
			return this;
		}
		
		public Builder setMessageDate(Date date) {
			header.setMessageDate(toGregorianCalendar(date));
			return this;
		}
		
		public Builder setMessageHash(String messageHash) {
			header.setMessageHash(messageHash);
			return this;
		}
		
		public Builder setMessageVersion(String messageVersion) {
			header.setMessageVersion(messageVersion);
			return this;	
		}
		
		public Builder setModule(String module) {
			header.setModule(module);
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
		
		public Builder setEffectiveDate(Date date) {
			emlHeader.setEffectiveDate(toGregorianCalendar(date));
			return this;
		}
		
		public Builder setExemptionChannel(String exemptionChannel) {
			emlHeader.setExemptionChannel(exemptionChannel);
			return this;
		}
		
		public Builder setExpiryDate(Date date) {
			emlHeader.setExpiryDate(toGregorianCalendar(date));
			return this;
		}
		
		public Builder setImplAgency(String agency) {
			emlHeader.setImplAgency(agency);
			return this;
		}
		
		public Builder setThirdPartyIssueDate(Date date) {
			emlHeader.setThirdPartyIssueDate(toGregorianCalendar(date));
			return this;
		}
		
		public Builder setThirdPartyListRef(String caseNo) {
			emlHeader.setThirdPartyListRef(caseNo);
			return this;
		}
		
		public Builder setTin(String pin) {
			emlHeader.setTin(pin);
			return this;
		}
		
		public Builder addItem(String itemNum, String hsCode, String itemDesc, String measureUnit, Double unitNum,
				String unitCurrency, Double unitValue, String isImDutyExm, Double dutyPercentExempted,
				String isVatExm, String isExciseExm, String isIdfExempt, String isRdlExempt) {
			Item item = new Item();
			item.setItemNum(itemNum);
			item.setHsCode(hsCode);
			item.setItemDesc(itemDesc);
			item.setMeasureUnit(measureUnit);
			item.setUnitNum(new BigDecimal(unitNum));
			item.setUnitCurrency(unitCurrency);
			item.setUnitValue(new BigDecimal(unitValue));
			item.setIsImDutyExm(isImDutyExm);
			item.setDutyPercentExempted(new BigDecimal(dutyPercentExempted));
			item.setIsVatExm(isVatExm);
			item.setIsExciseExm(isExciseExm);
			item.setIsIdfExempt(isIdfExempt);
			item.setIsRdlExempt(isRdlExempt);
			items.add(item);
			return this;
		}
		
		public Builder addItem(Item item) {
			items.add(item);
			return this;
		}
		
		public ResponseMessage build() {
			EmlBody emlBody = new EmlBody();
			eml.setEmlBody(emlBody);
			eml.setEmlHeader(emlHeader);
			emlBody.setItems(items);
			
			MessageBody body = new MessageBody();
			body.setEml(eml);
			
			Message message = new Message();
			message.setMessageBody(body);
			message.setMessageHeader(header);
			
			ObjectBinder binder = new ObjectBinder();
			String xml = binder.marshall(message);
			
			try {
				validate(xsdPath, xml);
			}catch (Exception e) {
				throw new RuntimeException(e);
			}
			
			String response = doSoapSubmission(xml);
			try {
				response = extractMessage(response, "/Envelope/Body/in_comingResponse/return/message", "response_message");
			} catch (XPathExpressionException | SAXException | IOException | ParserConfigurationException e) {
				throw new RuntimeException(e);
			}
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
			SOAPElement baseTag = soapBody.addChildElement("in_coming", bullNs);	
			
			SOAPElement action = baseTag.addChildElement("Action");
			action.addTextNode("EPROMIS01_Exemption_Master_List");
			
			SOAPElement requestMessage = baseTag.addChildElement("RequestMSG");
			requestMessage.addTextNode("<![CDATA["+xml+"]]>");
		}
				
	}
}
