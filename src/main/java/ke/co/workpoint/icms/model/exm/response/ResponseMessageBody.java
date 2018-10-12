package ke.co.workpoint.icms.model.exm.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ke.co.workpoint.icms.model.exm.ErrorInfo;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "message_body")
public class ResponseMessageBody {

    @XmlElement(name="response_info")
    protected ResponseInfo response;
    
    @XmlElement(name="error_info")
    protected ErrorInfo errorInfo;
    
    @XmlElement(name = "eml")
    protected EmlItems emlItems;
    
    @XmlElement
    protected List<ExemptionStatusMessage> message;
    
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

	public EmlItems getEmlItems() {
		return emlItems;
	}

	public void setEmlItems(EmlItems emlItems) {
		this.emlItems = emlItems;
	}

	public List<ExemptionStatusMessage> getMessage() {
		return message;
	}

	public void setMessage(List<ExemptionStatusMessage> message) {
		this.message = message;
	}

}
