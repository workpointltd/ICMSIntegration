package ke.co.workpoint.extensions;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CDATAAdapter extends XmlAdapter<String, String>{

	@Override
	public String marshal(String val) throws Exception {
		return "<![CDATA[" + val + "]]>";
	}
	
	@Override
	public String unmarshal(String val) throws Exception {
		return val;
	}
}
