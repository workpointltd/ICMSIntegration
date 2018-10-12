package ke.co.workpoint.icms.model.decl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import ke.co.workpoint.icms.model.exm.MessageHeader;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "dcl_response_message")
public class DclResponseMessage{

	@XmlElement(name = "message_header", required = true)
    protected MessageHeader messageHeader;
    
    @XmlElement(name = "message_body")
    protected DclResponseBody messageBody;

	public MessageHeader getMessageHeader() {
		return messageHeader;
	}

	public void setMessageHeader(MessageHeader messageHeader) {
		this.messageHeader = messageHeader;
	}

	public DclResponseBody getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(DclResponseBody messageBody) {
		this.messageBody = messageBody;
	}
    
}
