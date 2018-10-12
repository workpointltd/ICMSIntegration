package ke.co.workpoint.extensions.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import ke.co.workpoint.extensions.model.Exemption;
import ke.co.workpoint.extensions.model.ExemptionStatusHeader;
import ke.co.workpoint.extensions.model.ExemptionStatusResponseBody;
import ke.co.workpoint.icms.model.decl.Dcl;
import ke.co.workpoint.icms.model.decl.DclMessage;
import ke.co.workpoint.icms.model.decl.DclMessageBody;
import ke.co.workpoint.icms.model.decl.DclMessageHeader;
import ke.co.workpoint.icms.model.decl.DclResponseBody;
import ke.co.workpoint.icms.model.decl.DclResponseMessage;
import ke.co.workpoint.icms.model.decl.DclResponse_eSlip;
import ke.co.workpoint.icms.model.exm.Eml;
import ke.co.workpoint.icms.model.exm.EmlBody;
import ke.co.workpoint.icms.model.exm.EmlHeader;
import ke.co.workpoint.icms.model.exm.Item;
import ke.co.workpoint.icms.model.exm.Items;
import ke.co.workpoint.icms.model.exm.Message;
import ke.co.workpoint.icms.model.exm.MessageBody;
import ke.co.workpoint.icms.model.exm.MessageHeader;
import ke.co.workpoint.icms.model.exm.response.EmlItem;
import ke.co.workpoint.icms.model.exm.response.EmlItems;
import ke.co.workpoint.icms.model.exm.response.ExemptionStatusMessage;
import ke.co.workpoint.icms.model.exm.response.ResponseInfo;
import ke.co.workpoint.icms.model.exm.response.ResponseMessage;
import ke.co.workpoint.icms.model.exm.response.ResponseMessageBody;

public class ObjectBinder {

	private static ObjectBinder binder = new ObjectBinder();
	private JAXBContext jaxbContext = null;
	
	public ObjectBinder() {
		try{
			jaxbContext = JAXBContext.newInstance(
					Exemption.class, ExemptionStatusHeader.class, 
					ExemptionStatusResponseBody.class, 
					Eml.class,
					EmlBody.class,
					EmlHeader.class,
					Item.class,
					Items.class,
					Message.class,
					MessageBody.class,
					MessageHeader.class,
					Dcl.class,
					DclMessage.class,
					DclMessageBody.class,
					DclMessageHeader.class,
					ResponseMessage.class,
					ResponseInfo.class,
					ResponseMessageBody.class,
					DclResponseBody.class,
					DclResponse_eSlip.class,
					DclResponseMessage.class,
					ExemptionStatusMessage.class,
					EmlItem.class,
					EmlItems.class
					);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public static ObjectBinder get() {
		return binder;
	}
	
	public <T> T unmarshall(String xml){
		StringReader reader = new StringReader(xml);
		try{
			@SuppressWarnings("unchecked")
			T t = (T)jaxbContext.createUnmarshaller().unmarshal(reader);
			return t;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public <T> String marshall(T object){
		StringWriter writer = new StringWriter();
		try{
			Marshaller marshaller =  jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(object, writer);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		
		return writer.toString();
	}

}
