
package lab.engr4790.jawxs.jaxws.nxtcommand;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the lab.engr4790.jawxs.jaxws.nxtcommand package. 
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

    private final static QName _ForwardResponse_QNAME = new QName("http://jawxs.engr4790.lab/jaxws/nxtcommand", "forwardResponse");
    private final static QName _Open_QNAME = new QName("http://jawxs.engr4790.lab/jaxws/nxtcommand", "open");
    private final static QName _Stop_QNAME = new QName("http://jawxs.engr4790.lab/jaxws/nxtcommand", "stop");
    private final static QName _StopResponse_QNAME = new QName("http://jawxs.engr4790.lab/jaxws/nxtcommand", "stopResponse");
    private final static QName _CloseResponse_QNAME = new QName("http://jawxs.engr4790.lab/jaxws/nxtcommand", "closeResponse");
    private final static QName _Backward_QNAME = new QName("http://jawxs.engr4790.lab/jaxws/nxtcommand", "backward");
    private final static QName _Forward_QNAME = new QName("http://jawxs.engr4790.lab/jaxws/nxtcommand", "forward");
    private final static QName _OpenResponse_QNAME = new QName("http://jawxs.engr4790.lab/jaxws/nxtcommand", "openResponse");
    private final static QName _BackwardResponse_QNAME = new QName("http://jawxs.engr4790.lab/jaxws/nxtcommand", "backwardResponse");
    private final static QName _Close_QNAME = new QName("http://jawxs.engr4790.lab/jaxws/nxtcommand", "close");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: lab.engr4790.jawxs.jaxws.nxtcommand
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Forward }
     * 
     */
    public Forward createForward() {
        return new Forward();
    }

    /**
     * Create an instance of {@link Backward }
     * 
     */
    public Backward createBackward() {
        return new Backward();
    }

    /**
     * Create an instance of {@link OpenResponse }
     * 
     */
    public OpenResponse createOpenResponse() {
        return new OpenResponse();
    }

    /**
     * Create an instance of {@link Close }
     * 
     */
    public Close createClose() {
        return new Close();
    }

    /**
     * Create an instance of {@link Open }
     * 
     */
    public Open createOpen() {
        return new Open();
    }

    /**
     * Create an instance of {@link Stop }
     * 
     */
    public Stop createStop() {
        return new Stop();
    }

    /**
     * Create an instance of {@link StopResponse }
     * 
     */
    public StopResponse createStopResponse() {
        return new StopResponse();
    }

    /**
     * Create an instance of {@link CloseResponse }
     * 
     */
    public CloseResponse createCloseResponse() {
        return new CloseResponse();
    }

    /**
     * Create an instance of {@link ForwardResponse }
     * 
     */
    public ForwardResponse createForwardResponse() {
        return new ForwardResponse();
    }

    /**
     * Create an instance of {@link BackwardResponse }
     * 
     */
    public BackwardResponse createBackwardResponse() {
        return new BackwardResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ForwardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", name = "forwardResponse")
    public JAXBElement<ForwardResponse> createForwardResponse(ForwardResponse value) {
        return new JAXBElement<ForwardResponse>(_ForwardResponse_QNAME, ForwardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Open }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", name = "open")
    public JAXBElement<Open> createOpen(Open value) {
        return new JAXBElement<Open>(_Open_QNAME, Open.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Stop }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", name = "stop")
    public JAXBElement<Stop> createStop(Stop value) {
        return new JAXBElement<Stop>(_Stop_QNAME, Stop.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StopResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", name = "stopResponse")
    public JAXBElement<StopResponse> createStopResponse(StopResponse value) {
        return new JAXBElement<StopResponse>(_StopResponse_QNAME, StopResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloseResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", name = "closeResponse")
    public JAXBElement<CloseResponse> createCloseResponse(CloseResponse value) {
        return new JAXBElement<CloseResponse>(_CloseResponse_QNAME, CloseResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Backward }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", name = "backward")
    public JAXBElement<Backward> createBackward(Backward value) {
        return new JAXBElement<Backward>(_Backward_QNAME, Backward.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Forward }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", name = "forward")
    public JAXBElement<Forward> createForward(Forward value) {
        return new JAXBElement<Forward>(_Forward_QNAME, Forward.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OpenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", name = "openResponse")
    public JAXBElement<OpenResponse> createOpenResponse(OpenResponse value) {
        return new JAXBElement<OpenResponse>(_OpenResponse_QNAME, OpenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BackwardResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", name = "backwardResponse")
    public JAXBElement<BackwardResponse> createBackwardResponse(BackwardResponse value) {
        return new JAXBElement<BackwardResponse>(_BackwardResponse_QNAME, BackwardResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Close }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://jawxs.engr4790.lab/jaxws/nxtcommand", name = "close")
    public JAXBElement<Close> createClose(Close value) {
        return new JAXBElement<Close>(_Close_QNAME, Close.class, null, value);
    }

}
