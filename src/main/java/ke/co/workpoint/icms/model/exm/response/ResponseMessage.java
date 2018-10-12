package ke.co.workpoint.icms.model.exm.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ke.co.workpoint.icms.model.exm.MessageHeader;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "response_message")
public class ResponseMessage {


    @XmlElement(name = "message_header", required = true)
    protected MessageHeader messageHeader;
    
    @XmlElement(name = "message_body")
    protected ResponseMessageBody messageBody;

	public ResponseMessage() {
	}

	public MessageHeader getMessageHeader() {
		return messageHeader;
	}

	public void setMessageHeader(MessageHeader messageHeader) {
		this.messageHeader = messageHeader;
	}

	public ResponseMessageBody getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(ResponseMessageBody messageBody) {
		this.messageBody = messageBody;
	}
}
