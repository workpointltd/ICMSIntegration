package ke.co.workpoint.extensions.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.sun.xml.internal.txw2.annotation.XmlCDATA;

import ke.co.workpoint.extensions.CDATAAdapter;

@XmlRootElement(name = "sendExemptionStatusResponse", namespace = "http://workpoint.co.ke/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendExemptionStatusResponse", namespace = "http://workpoint.co.ke/")
public class SendExemptionStatusResponse {

	@XmlElement(name="message_header", nillable=false)
	@XmlJavaTypeAdapter(value= CDATAAdapter.class)
	private String message_header;
	
	@XmlElement(name="message_body", nillable=false)
	@XmlJavaTypeAdapter(value= CDATAAdapter.class)
	private String message_body;
	
	@XmlElement(name="exm", nillable=false)
	private String exm;
	
	public SendExemptionStatusResponse() {
	}

	public String getMessage_header() {
		return message_header;
	}

	public void setMessage_header(String message_header) {
		this.message_header = message_header;
	}
	
	public String getMessage_body() {
		return message_body;
	}

	public void setMessage_body(String message_body) {
		this.message_body = message_body;
	}

	public String getExm() {
		return exm;
	}

	public void setExm(String exm) {
		this.exm = exm;
	}
	
}
