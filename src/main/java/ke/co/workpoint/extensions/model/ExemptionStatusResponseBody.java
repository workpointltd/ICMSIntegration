package ke.co.workpoint.extensions.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="exemptionStatusResponseBody")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exemptionStatusResponseBody", namespace = "http://workpoint.co.ke/")
public class ExemptionStatusResponseBody {

	@XmlElement(name="response_code")
	private Integer response_code; 
	
	@XmlElement(name="response_desc")
	private String response_desc;
	
	private String[] error_info;
	
	public ExemptionStatusResponseBody() {
	}

	public String getResponse_desc() {
		return response_desc;
	}

	public void setResponse_desc(String response_desc) {
		this.response_desc = response_desc;
	}

	public String[] getError_info() {
		return error_info;
	}

	public void setError_info(String[] error_info) {
		this.error_info = error_info;
	}

	public Integer getResponse_code() {
		return response_code;
	}

	public void setResponse_code(Integer response_code) {
		this.response_code = response_code;
	}

}
