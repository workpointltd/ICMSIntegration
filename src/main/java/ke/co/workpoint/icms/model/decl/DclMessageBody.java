//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.10.05 at 03:12:43 PM EAT 
//


package ke.co.workpoint.icms.model.decl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for message_body complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="message_body">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dcl" type="{}dcl"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "message_body", propOrder = {
    "dcl"
})
public class DclMessageBody {

    @XmlElement(required = true)
    protected Dcl dcl;

    /**
     * Gets the value of the dcl property.
     * 
     * @return
     *     possible object is
     *     {@link Dcl }
     *     
     */
    public Dcl getDcl() {
        return dcl;
    }

    /**
     * Sets the value of the dcl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dcl }
     *     
     */
    public void setDcl(Dcl value) {
        this.dcl = value;
    }

}