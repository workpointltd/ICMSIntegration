package ke.co.workpoint.extensions.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import ke.co.workpoint.extensions.model.Exemption;
import ke.co.workpoint.extensions.model.ExemptionStatusHeader;
import ke.co.workpoint.extensions.util.ObjectBinder;

public class ExemptionMain {

	public static void main(String[] args) {
		String login = "iCMS";
		System.err.println(login+" matches >> "+login.matches("^([a-zA-Z0-9]{0,20})$"));
		
		String password = "iCMS@Word123456789123456789123456789123456789";
		System.err.println(password+" matches >> "+password.matches("^.{1,50}$"));
		
		String information = "N/A";
		System.err.println(information+" matches >> "+information.matches("^([a-zA-Z0-9_\\\\/\\s+]{0,200})$"));
		
		information = "Send Exemption approved/Reject status to IPMIS";
		System.err.println(information+" >> len="+information.length()+" >> matches "+information.matches("^([a-zA-Z0-9\\s\\\\/]{0,200})$"));
		
		Exemption exm = new Exemption();
		exm.setStatus("ACTI");
		exm.setExm_id("123456789");
		String exmStr = ObjectBinder.get().marshall(exm);
		System.out.println("<![CDATA["+exmStr+"]]>");
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		ExemptionStatusHeader header = new ExemptionStatusHeader();
		header.setAction("EXM_IPMIS_02_Send_EXM_Status");
		header.setInformation("Send Exemption approved/Reject status to IPMIS");
		header.setMessage_date(dateFormatter.format(new Date()));
		header.setMessage_id("N/A");
		header.setMessage_version("1");
		header.setModule("EXM");
		header.setReceiver("IPMS");
		header.setSender("iCMS");
		String headerStr = ObjectBinder.get().marshall(header);
		System.out.println("<![CDATA["+headerStr+"]]>");
	}
}
