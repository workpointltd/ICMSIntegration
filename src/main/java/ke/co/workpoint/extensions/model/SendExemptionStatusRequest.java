package ke.co.workpoint.extensions.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "sendExemptionStatusRequest", namespace = "http://workpoint.co.ke/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sendExemptionStatusRequest", namespace = "http://workpoint.co.ke/")
public class SendExemptionStatusRequest {

	@XmlElement(name="login_id", nillable=false, required=true, namespace="")
	private String login_id;
	
	@XmlElement(nillable=false)
	private String password;

	@XmlElement(name="message_header", nillable=false)
	private String message_header;
	
	@XmlElement(name="exm", nillable=false)
	private String exm;
	
	public SendExemptionStatusRequest() {
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin_id() {
		return login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getMessage_header() {
		return message_header;
	}

	public void setMessage_header(String message_header) {
		this.message_header = message_header;
	}

	public String getExm() {
		return exm;
	}

	public void setExm(String exm) {
		this.exm = exm;
	}
}
