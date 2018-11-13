package com.icms.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.List;

import ke.co.workpoint.extensions.util.ObjectBinder;
import ke.co.workpoint.icms.model.decl.DclResponseBody;
import ke.co.workpoint.icms.model.decl.DclResponseMessage;
import ke.co.workpoint.icms.model.exm.ErrorInfo;
import ke.co.workpoint.icms.model.exm.response.EmlItems;
import ke.co.workpoint.icms.model.exm.response.ExemptionStatusMessage;
import ke.co.workpoint.icms.model.exm.response.ResponseInfo;
import ke.co.workpoint.icms.model.exm.response.ResponseMessage;

public class ICMSIntegrationMain {

	public static void main(String[] args) {
		//testExm();
		//testDcl();
		testExmStatus();
		
	}
	
	public static void testExmStatusXML() {
		InputStream is = ICMSIntegrationMain.class.getClassLoader().getResourceAsStream("exm_status.xml");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		
		StringBuilder xml = new StringBuilder();
		String in = "";
		try {
			while((in = reader.readLine())!=null) {
				xml.append(in);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResponseMessage responseBody = ObjectBinder.get().unmarshall(xml.toString());
		
		List<ExemptionStatusMessage> messages = responseBody.getMessageBody().getMessage();
		System.out.println(messages.size());
		
		EmlItems items = messages.get(0).getMessageBody().getEmlItems();
		System.out.println(items.getDocumentNo());
	}
	
	public static void testExmStatus() {
		ResponseMessage response = new ICMSExmStatusManager().new Builder()
			.build();
		ResponseInfo info = response.getMessageBody().getResponse();
		System.err.println(info.getResponseCode()+", "+info.getResponseDesc());
	}
	
	public static void testExm() {
		ResponseMessage response = ICMSExmManager.getBuilder()
				.setEffectiveDate(new Date())
				.setExpiryDate(new Date())
				.setThirdPartyIssueDate(new Date())
				.setThirdPartyListRef("Case-001001")
				.setTin("A000T123456")
				.addItem("1", "8447120000", "Red Wine", "UNT", 1000.00, "USD",
						1200.00, "Y", 10.00, "Y", "Y", 
						"Y", "Y")
				.addItem("1", "8447120000", "Red Wine", "UNT", 1000.00, "USD",
						1200.00, "Y", 10.00, "Y", "Y", 
						"Y", "Y")
				.setInformation("Receive approved EML data from iPMIS")
				.setMessageDate(new Date())
				.setMessageHash("system_generated")
				.build();
			
		ResponseInfo info = response.getMessageBody().getResponse();
		
		System.err.println(info.getResponseCode()+", "+info.getResponseDesc());
	}
	
	public static void testDcl() {
		
		DclResponseMessage result = new ICMSDclManager().new Builder()
				.setDclNum("17120IM400315039")
				.setAction("DCL_IPMIS_03_GET_DCL_ESLIP")
				.setInformation("Receive approved EML data from iPMIS")
				.setMessageDate(new Date())
				.setMessageId("23f398b580c5406396fe182c239b823e")
				.setMessageVersion(1)
				.setModule("DCL")
				.setReceiver("iCMS")
				.setSender("IPMIS")
				.build();
		
		DclResponseBody body = result.getMessageBody();
		ErrorInfo err = body.getErrorInfo();
		ResponseInfo info = body.getResponse();
		
		if(err!=null) {
			System.err.println("Err: - "+err.getResponseCode() + " "+err.getResponseDesc());
		}
		
		if(info!=null) {
			System.err.println("Info: -"+info.getResponseCode() + " "+info.getResponseDesc());
		}
		
	}
}
