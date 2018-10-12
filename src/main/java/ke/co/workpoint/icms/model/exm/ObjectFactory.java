//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.09.20 at 11:01:46 AM EAT 
//


package ke.co.workpoint.icms.model.exm;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ke.co.workpoint.icms.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _IsExciseExm_QNAME = new QName("", "is_excise_exm");
    private final static QName _ThirdPartyIssueDate_QNAME = new QName("", "third_party_issue_date");
    private final static QName _IsVatExm_QNAME = new QName("", "is_vat_exm");
    private final static QName _HsCode_QNAME = new QName("", "hs_code");
    private final static QName _UnitCurrency_QNAME = new QName("", "unit_currency");
    private final static QName _DutyPercentExempted_QNAME = new QName("", "duty_percent_exempted");
    private final static QName _IsRdlExempt_QNAME = new QName("", "is_rdl_exempt");
    private final static QName _ExemptionChannel_QNAME = new QName("", "exemption_channel");
    private final static QName _MessageHash_QNAME = new QName("", "message_hash");
    private final static QName _ImplAgency_QNAME = new QName("", "impl_agency");
    private final static QName _EffectiveDate_QNAME = new QName("", "effective_date");
    private final static QName _Tin_QNAME = new QName("", "tin");
    private final static QName _UnitNum_QNAME = new QName("", "unit_num");
    private final static QName _UnitValue_QNAME = new QName("", "unit_value");
    private final static QName _Action_QNAME = new QName("", "action");
    private final static QName _ItemDesc_QNAME = new QName("", "item_desc");
    private final static QName _Receiver_QNAME = new QName("", "receiver");
    private final static QName _ExpiryDate_QNAME = new QName("", "expiry_date");
    private final static QName _IsIdfExempt_QNAME = new QName("", "is_idf_exempt");
    private final static QName _Module_QNAME = new QName("", "module");
    private final static QName _ThirdPartyListRef_QNAME = new QName("", "third_party_list_ref");
    private final static QName _ItemNum_QNAME = new QName("", "item_num");
    private final static QName _MessageVersion_QNAME = new QName("", "message_version");
    private final static QName _MeasureUnit_QNAME = new QName("", "measure_unit");
    private final static QName _Sender_QNAME = new QName("", "sender");
    private final static QName _MessageDate_QNAME = new QName("", "message_date");
    private final static QName _IsImDutyExm_QNAME = new QName("", "is_im_duty_exm");
    private final static QName _Information_QNAME = new QName("", "information");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ke.co.workpoint.icms.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Eml }
     * 
     */
    public Eml createEml() {
        return new Eml();
    }

    /**
     * Create an instance of {@link EmlHeader }
     * 
     */
    public EmlHeader createEmlHeader() {
        return new EmlHeader();
    }

    /**
     * Create an instance of {@link EmlBody }
     * 
     */
    public EmlBody createEmlBody() {
        return new EmlBody();
    }

    /**
     * Create an instance of {@link Items }
     * 
     */
    public Items createItems() {
        return new Items();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link MessageHeader }
     * 
     */
    public MessageHeader createMessageHeader() {
        return new MessageHeader();
    }

    /**
     * Create an instance of {@link MessageBody }
     * 
     */
    public MessageBody createMessageBody() {
        return new MessageBody();
    }

    /**
     * Create an instance of {@link Message }
     * 
     */
    public Message createMessage() {
        return new Message();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "is_excise_exm")
    public JAXBElement<String> createIsExciseExm(String value) {
        return new JAXBElement<String>(_IsExciseExm_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "third_party_issue_date")
    public JAXBElement<XMLGregorianCalendar> createThirdPartyIssueDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ThirdPartyIssueDate_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "is_vat_exm")
    public JAXBElement<String> createIsVatExm(String value) {
        return new JAXBElement<String>(_IsVatExm_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "hs_code")
    public JAXBElement<String> createHsCode(String value) {
        return new JAXBElement<String>(_HsCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "unit_currency")
    public JAXBElement<String> createUnitCurrency(String value) {
        return new JAXBElement<String>(_UnitCurrency_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "duty_percent_exempted")
    public JAXBElement<BigDecimal> createDutyPercentExempted(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_DutyPercentExempted_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "is_rdl_exempt")
    public JAXBElement<String> createIsRdlExempt(String value) {
        return new JAXBElement<String>(_IsRdlExempt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "exemption_channel")
    public JAXBElement<String> createExemptionChannel(String value) {
        return new JAXBElement<String>(_ExemptionChannel_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "message_hash")
    public JAXBElement<String> createMessageHash(String value) {
        return new JAXBElement<String>(_MessageHash_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "impl_agency")
    public JAXBElement<String> createImplAgency(String value) {
        return new JAXBElement<String>(_ImplAgency_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "effective_date")
    public JAXBElement<XMLGregorianCalendar> createEffectiveDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_EffectiveDate_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "tin")
    public JAXBElement<String> createTin(String value) {
        return new JAXBElement<String>(_Tin_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "unit_num")
    public JAXBElement<BigDecimal> createUnitNum(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_UnitNum_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "unit_value")
    public JAXBElement<BigDecimal> createUnitValue(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_UnitValue_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "action")
    public JAXBElement<String> createAction(String value) {
        return new JAXBElement<String>(_Action_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "item_desc")
    public JAXBElement<String> createItemDesc(String value) {
        return new JAXBElement<String>(_ItemDesc_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "receiver")
    public JAXBElement<String> createReceiver(String value) {
        return new JAXBElement<String>(_Receiver_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "expiry_date")
    public JAXBElement<XMLGregorianCalendar> createExpiryDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_ExpiryDate_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "is_idf_exempt")
    public JAXBElement<String> createIsIdfExempt(String value) {
        return new JAXBElement<String>(_IsIdfExempt_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "module")
    public JAXBElement<String> createModule(String value) {
        return new JAXBElement<String>(_Module_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "third_party_list_ref")
    public JAXBElement<String> createThirdPartyListRef(String value) {
        return new JAXBElement<String>(_ThirdPartyListRef_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "item_num")
    public JAXBElement<String> createItemNum(String value) {
        return new JAXBElement<String>(_ItemNum_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "message_version")
    public JAXBElement<String> createMessageVersion(String value) {
        return new JAXBElement<String>(_MessageVersion_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "measure_unit")
    public JAXBElement<String> createMeasureUnit(String value) {
        return new JAXBElement<String>(_MeasureUnit_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "sender")
    public JAXBElement<String> createSender(String value) {
        return new JAXBElement<String>(_Sender_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "message_date")
    public JAXBElement<XMLGregorianCalendar> createMessageDate(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_MessageDate_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "is_im_duty_exm")
    public JAXBElement<String> createIsImDutyExm(String value) {
        return new JAXBElement<String>(_IsImDutyExm_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "information")
    public JAXBElement<String> createInformation(String value) {
        return new JAXBElement<String>(_Information_QNAME, String.class, null, value);
    }

}
