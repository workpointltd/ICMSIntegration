package ke.co.workpoint.icms.model.exm.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "eml")
public class EmlItems {

	@XmlElement(name="eml_document_no")
	private String documentNo;
	
	@XmlElement(name="status")
	private String status;
	
    @XmlElement(required = true)
    protected List<EmlItem> item;

	public List<EmlItem> getItem() {
		return item;
	}

	public void setItem(List<EmlItem> item) {
		this.item = item;
	}

	public String getDocumentNo() {
		return documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
