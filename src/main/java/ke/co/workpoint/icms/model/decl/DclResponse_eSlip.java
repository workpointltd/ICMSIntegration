package ke.co.workpoint.icms.model.decl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "eslip")
public class DclResponse_eSlip {
	@XmlElement(name="dcl_num")
	public String dclNum;
	@XmlElement(name="consigner_name")
	private String consignerName;
	@XmlElement(name="eslip_num")
	private String eslipNum;
	@XmlElement(name="eslip_total_amount")
	private String eslipStatus;
	@XmlElement(name="eslip_total_amount")
	private Double eslipTotalAmount;

	public String getDclNum() {
		return dclNum;
	}

	public void setDclNum(String dclNum) {
		this.dclNum = dclNum;
	}

	public String getConsignerName() {
		return consignerName;
	}

	public void setConsignerName(String consignerName) {
		this.consignerName = consignerName;
	}

	public String getEslipStatus() {
		return eslipStatus;
	}

	public void setEslipStatus(String eslipStatus) {
		this.eslipStatus = eslipStatus;
	}

}
