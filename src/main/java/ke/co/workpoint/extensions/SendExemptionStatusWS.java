package ke.co.workpoint.extensions;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import ke.co.workpoint.extensions.model.Exemption;
import ke.co.workpoint.extensions.model.ExemptionStatusHeader;
import ke.co.workpoint.extensions.model.ExemptionStatusResponseBody;
import ke.co.workpoint.extensions.model.SendExemptionStatusRequest;
import ke.co.workpoint.extensions.model.SendExemptionStatusResponse;
import ke.co.workpoint.extensions.util.ObjectBinder;

@WebService(targetNamespace = "http://workpoint.co.ke")
public class SendExemptionStatusWS implements ISendExemptionStatusWS {
	
	SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	@WebMethod
	public SendExemptionStatusResponse sendExemptionStatus(
			SendExemptionStatusRequest aRequest) {
		String loginId = aRequest.getLogin_id();
		String password = aRequest.getPassword();
		
		List<String> errors = new ArrayList<String>();
		int responseCode = validate(aRequest, errors);

		SendExemptionStatusResponse aResponse = generateResponse(aRequest, errors, responseCode);
		return aResponse;
	}

	private int validate(SendExemptionStatusRequest aRequest, List<String> buffer) {
		Exemption exemption = ObjectBinder.get().unmarshall(aRequest.getExm());
		ExemptionStatusHeader header = ObjectBinder.get().unmarshall(
				aRequest.getMessage_header());
		
		StringBuilder a41202 = new StringBuilder();
		int code = 41201;
		StringBuilder response_desc = new StringBuilder();
		if (exemption.getStatus() != null
				&& !exemption.getStatus().trim().isEmpty()) {
			if (exemption.getStatus().equals("ACTI")
					|| exemption.getStatus().equals("INAC")) {
				code = 41201;
				response_desc
						.append("IPMIS receive exemption status from iCMS successful.");
			} else{
				code = 41202;
				a41202
						.append("Receive exemption failed, the format of field status is incorrect."
								+ "The expected values are [ACTI|INAC], but you provided value["
								+ exemption.getStatus() + "]");
			}
			
		} else {
			code = 41202;
			// Status is null or empty
			a41202
					.append("Receive exemption failed, the accessibility of field status is mandatory");
		}

		StringBuilder a41203 = new StringBuilder();
		StringBuilder a41204 = new StringBuilder();
		
		code = coalesce(code, checkFormat(aRequest, "login_id", "^([a-zA-Z0-9]{0,20})$", a41203));
		code = coalesce(code, checkFormat(aRequest, "password", "^.{1,50}$", a41203));
		code = coalesce(code, checkFormat(header, "module", "^([a-zA-Z0-9]{0,20})$", a41203));
		code = coalesce(code, checkFormat(header, "action", "^([a-zA-Z0-9_]{0,30})$", a41203));
		code = coalesce(code, checkFormat(header, "sender", "^([a-zA-Z0-9_]{0,50})$", a41203));
		code = coalesce(code, checkFormat(header, "receiver", "^([a-zA-Z0-9_]{0,50})$", a41203));
		code = coalesce(code, checkFormat(header, "information", "^([a-zA-Z0-9\\s\\\\/]{0,200})$", a41203));
		code = coalesce(code, checkFormat(header, "message_id", "^([a-zA-Z0-9_\\\\/]{0,32})$", a41203));
		code = coalesce(code, checkFormat(header, "message_version", "^([a-zA-Z0-9_\\\\/]{0,5})$", a41203));
		
		try{
			if(header.getMessage_date()!=null){
				Date date = dateFormatter.parse(header.getMessage_date());
			}
		}catch(Exception e){
			code = coalesce(41203, code);
		}
	
		code = coalesce(code, checkMandatory(aRequest, "login_id", true, a41204));
		code = coalesce(code, checkMandatory(aRequest, "password", true, a41204));
		code = coalesce(code, checkMandatory(header, "module", true, a41204));
		code = coalesce(code, checkMandatory(header, "action", true, a41204));
		code = coalesce(code, checkMandatory(header, "sender", true, a41204));
		code = coalesce(code, checkMandatory(header, "receiver", true, a41204));
		code = coalesce(code, checkMandatory(header, "information", true, a41204));
		code = coalesce(code, checkMandatory(header, "message_id", true, a41204));
		code = coalesce(code, checkMandatory(header, "message_version", true, a41204));
		code = coalesce(code, checkMandatory(header, "message_date", true, a41204));

		if(!a41202.toString().isEmpty()){
			buffer.add(a41202.toString());
		}
		
		if(!a41203.toString().isEmpty()){
			buffer.add(a41203.toString());
		}
		
		if(!a41204.toString().isEmpty()){
			buffer.add(a41204.toString());
		}
		
		if(code==41201){
			buffer.add(0, response_desc.toString());
		}
		return code;
	}

	private int coalesce(int code, int newCode) {
		if(code==41201){
			return newCode;
		}
		
		if(newCode==41201){
			return code;
		}
		
		return Math.min(code, newCode);
	}

	private int checkFormat(Object obj, String field, String formatRegex,
			StringBuilder a41203Errors) {

		Class<?> clazz = obj.getClass();
		String fieldName = field.substring(0, 1).toUpperCase()
				+ field.substring(1);

		try {
			Method method = clazz.getMethod("get" + fieldName);
			Object value = method.invoke(obj);
			// Check format
			if (value != null) {
				String valueStr = value.toString();
				if (!valueStr.matches(formatRegex)) {
					if (a41203Errors.toString().isEmpty()) {
						a41203Errors.append("41203: Receive exemption failed");
					}
					a41203Errors.append(", the format of field [\"" + field
							+ "\"] is incorrect, " + "the expected format: \""
							+ field + "\", but you entered the value \"["
							+ valueStr + "]\" ");
					return 41203;
				}

			}
		} catch (Exception e) {
			throw new RuntimeException("Error - "+field, e);
		}
		return 41201;
	}

	private int checkMandatory(Object obj, String field, boolean mandatory,
			StringBuilder a41204Errors) {
		Class<?> clazz = obj.getClass();
		String fieldName = field.substring(0, 1).toUpperCase()
				+ field.substring(1);
		try {
			Method method = clazz.getMethod("get" + fieldName);
			Object value = method.invoke(obj);
			if (value == null && mandatory) {
				if (a41204Errors.toString().isEmpty()) {
					a41204Errors.append("41204: Receive exemption failed");
				}
				a41204Errors.append(", the accessibility of field [\"" + field
						+ "\"] is mandatory");
				return 41204;
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return 41201;
	}

	private SendExemptionStatusResponse generateResponse(SendExemptionStatusRequest aRequest, List<String> errors, int responseCode) {
		SendExemptionStatusResponse aResponse = new SendExemptionStatusResponse();
		// message header
		String message_header = aRequest.getMessage_header();
		aResponse.setMessage_header(message_header);

		StringBuilder response_desc = new StringBuilder();
		String[] err = new String[errors.size()];
		int i=0;
		for(String e: errors){
			err[i++] = e;
			response_desc.append(e);
		}
		//Exemption Body
		ExemptionStatusResponseBody body = new ExemptionStatusResponseBody();
		body.setResponse_code(responseCode);
		if(responseCode==41201){
			body.setResponse_desc(response_desc.toString());
		}else{
			body.setError_info(err);
		}
		aResponse.setMessage_body(ObjectBinder.get().marshall(body));
		
		Exemption exmInfo = ObjectBinder.get().unmarshall(aRequest.getExm());
		
		Exemption exmResp = new Exemption();
		exmResp.setExm_id(exmInfo.getExm_id());
		String exemptionResponse = ObjectBinder.get().marshall(exmResp); 
		System.out.println(exemptionResponse);
		aResponse.setExm("<![CDATA["+exemptionResponse+"]]>");
		//aResponse.setExm(exemptionResponse);
		
		ExemptionStatusHeader reqHeader = ObjectBinder.get().unmarshall(message_header);
		reqHeader.setMessage_date(dateFormatter.format(new Date()));
		reqHeader.setAction("EXM_IPMIS_02_Biz_Res");
		reqHeader.setSender("IPMIS");
		reqHeader.setReceiver("iCMS");
		reqHeader.setInformation("Business response for send Exemption status data to IPMIS");
		aResponse.setMessage_header(ObjectBinder.get().marshall(reqHeader));
		
		return aResponse;
	}
}
