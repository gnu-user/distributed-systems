import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import lejos.nxt.*;
import lejos.pc.comm.*;

@WebService(
		serviceName = "NXTCommand",
		portName = "NXTCommandPort",	
		targetNamespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand")
public class NXTRobotWS {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static NXTComm NXTConn;
	
	public NXTRobotWS()  {
		super( );
		try {
			NXTConn = NXTCommFactory.createNXTComm(NXTCommFactory.USB);
			System.out.println("Created NXT Connection");
		}
		catch(NXTCommException e) {
			System.out.println("Error - creating NXT connection");
		}
	}
	
	@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,use=SOAPBinding.Use.LITERAL,parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
	@WebMethod
	public void open() { 
	}
	
	@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,use=SOAPBinding.Use.LITERAL,parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
	@WebMethod
	public void close() { 
	}
	
	@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,use=SOAPBinding.Use.LITERAL,parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
	@WebMethod
	public void forward(char motorLabel) {
		switch (motorLabel) {
		case 'A':
			Motor.A.forward();
			break;
		case 'B':
			Motor.B.forward();
			break;
		case 'C':
			Motor.C.forward();
			break;
		default:
		}
	}
	
	@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,use=SOAPBinding.Use.LITERAL,parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
	@WebMethod
	public void backward(char motorLabel) {
		switch (motorLabel) {
		case 'A':
			Motor.A.backward();
			break;
		case 'B':
			Motor.B.backward();
			break;
		case 'C':
			Motor.C.backward();
			break;
		default:
		}
	}
	
	@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,use=SOAPBinding.Use.LITERAL,parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
	@WebMethod
	public void stop(char motorLabel) {
		switch (motorLabel) {
		case 'A':
			 Motor.A.stop();
		case 'B':
			 Motor.B.stop();
		case 'C':
			 Motor.C.stop();
		default:
		}
	}
}
