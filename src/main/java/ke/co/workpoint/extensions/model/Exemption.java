package ke.co.workpoint.extensions.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.sun.xml.internal.txw2.annotation.XmlCDATA;

@XmlRootElement(name="exm")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "exm", namespace = "http://workpoint.co.ke/")
public class Exemption {

	@XmlElement(name="exm_id", nillable=false)
	private String exm_id;
	
	@XmlElement(nillable=false)
	private String status= null;//"ACTI";
	
	public Exemption() {
	}

	public String getExm_id() {
		return exm_id;
	}

	public void setExm_id(String exm_id) {
		this.exm_id = exm_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
