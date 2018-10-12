package ke.co.workpoint.icms.model.decl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ke.co.workpoint.icms.model.exm.ErrorInfo;
import ke.co.workpoint.icms.model.exm.response.ResponseInfo;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message_body")
public class DclResponseBody{

	@XmlElement(name="response_info")
    protected ResponseInfo response;
    
	@XmlElement(name="error_info")
    protected ErrorInfo errorInfo;
	
	@XmlElement(name="eslip")
    protected DclResponse_eSlip eslip;

	public ResponseInfo getResponse() {
		return response;
	}

	public void setResponse(ResponseInfo response) {
		this.response = response;
	}

	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}

	public DclResponse_eSlip getEslip() {
		return eslip;
	}

	public void setEslip(DclResponse_eSlip eslip) {
		this.eslip = eslip;
	}
    
	
}
