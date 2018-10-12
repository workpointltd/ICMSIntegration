package ke.co.workpoint.extensions.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="message_header")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "message_header", namespace = "http://workpoint.co.ke/")
public class ExemptionStatusHeader {

	@XmlElement(nillable=false)
	private String module="EXM";
	@XmlElement(nillable=false)
	private String action="EXM_IPMIS_02_Send_EXM_Status";
	@XmlElement(nillable=false)
	private String sender="iCMS";
	@XmlElement(nillable=false)
	private String receiver = "IPMIS";
	@XmlElement(nillable=false)
	private String information;
	@XmlElement(name="message_id", nillable=false)
	private String message_id= "Send Exemption approved/Reject status to IPMIS";
	@XmlElement(name="message_version", nillable=false)
	private String message_version="N/A";
	@XmlElement(nillable=false)
	private String message_date;
	
	public ExemptionStatusHeader() {
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getMessage_id() {
		return message_id;
	}

	public void setMessage_id(String message_id) {
		this.message_id = message_id;
	}

	public String getMessage_version() {
		return message_version;
	}

	public void setMessage_version(String message_version) {
		this.message_version = message_version;
	}

	public String getMessage_date() {
		return message_date;
	}

	public void setMessage_date(String message_date) {
		this.message_date = message_date;
	}
	
}
