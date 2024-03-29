
package lab.engr4790.jawxs.jaxws.nxtcommand;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-hudson-752-
 * Generated source version: 2.2
 * 
 */
@WebService(name = "NXTRobotWS", targetNamespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface NXTRobotWS {


    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "stop", targetNamespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", className = "lab.engr4790.jawxs.jaxws.nxtcommand.Stop")
    @ResponseWrapper(localName = "stopResponse", targetNamespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", className = "lab.engr4790.jawxs.jaxws.nxtcommand.StopResponse")
    @Action(input = "http://jawxs.engr4790.lab/jaxws/nxtcommand/NXTRobotWS/stopRequest", output = "http://jawxs.engr4790.lab/jaxws/nxtcommand/NXTRobotWS/stopResponse")
    public void stop(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "close", targetNamespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", className = "lab.engr4790.jawxs.jaxws.nxtcommand.Close")
    @ResponseWrapper(localName = "closeResponse", targetNamespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", className = "lab.engr4790.jawxs.jaxws.nxtcommand.CloseResponse")
    @Action(input = "http://jawxs.engr4790.lab/jaxws/nxtcommand/NXTRobotWS/closeRequest", output = "http://jawxs.engr4790.lab/jaxws/nxtcommand/NXTRobotWS/closeResponse")
    public void close();

    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "open", targetNamespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", className = "lab.engr4790.jawxs.jaxws.nxtcommand.Open")
    @ResponseWrapper(localName = "openResponse", targetNamespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", className = "lab.engr4790.jawxs.jaxws.nxtcommand.OpenResponse")
    @Action(input = "http://jawxs.engr4790.lab/jaxws/nxtcommand/NXTRobotWS/openRequest", output = "http://jawxs.engr4790.lab/jaxws/nxtcommand/NXTRobotWS/openResponse")
    public void open();

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "forward", targetNamespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", className = "lab.engr4790.jawxs.jaxws.nxtcommand.Forward")
    @ResponseWrapper(localName = "forwardResponse", targetNamespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", className = "lab.engr4790.jawxs.jaxws.nxtcommand.ForwardResponse")
    @Action(input = "http://jawxs.engr4790.lab/jaxws/nxtcommand/NXTRobotWS/forwardRequest", output = "http://jawxs.engr4790.lab/jaxws/nxtcommand/NXTRobotWS/forwardResponse")
    public void forward(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "backward", targetNamespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", className = "lab.engr4790.jawxs.jaxws.nxtcommand.Backward")
    @ResponseWrapper(localName = "backwardResponse", targetNamespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", className = "lab.engr4790.jawxs.jaxws.nxtcommand.BackwardResponse")
    @Action(input = "http://jawxs.engr4790.lab/jaxws/nxtcommand/NXTRobotWS/backwardRequest", output = "http://jawxs.engr4790.lab/jaxws/nxtcommand/NXTRobotWS/backwardResponse")
    public void backward(
        @WebParam(name = "arg0", targetNamespace = "")
        int arg0);

}
