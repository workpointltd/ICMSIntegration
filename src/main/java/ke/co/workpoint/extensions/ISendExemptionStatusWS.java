package ke.co.workpoint.extensions;

import javax.jws.WebMethod;
import javax.jws.WebService;

import ke.co.workpoint.extensions.model.SendExemptionStatusRequest;
import ke.co.workpoint.extensions.model.SendExemptionStatusResponse;

@WebService(targetNamespace="http://workpoint.co.ke")
public interface ISendExemptionStatusWS {

	@WebMethod
	public SendExemptionStatusResponse sendExemptionStatus(SendExemptionStatusRequest exemption);
}