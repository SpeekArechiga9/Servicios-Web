import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.webserver.WebServer;
import java.io.IOException;

public class RpcServer {
    public static void main(String[] args) throws IOException, XmlRpcException {
        System.out.println("Incializando server");
        PropertyHandlerMapping mapping = new PropertyHandlerMapping();
        mapping.addHandler("Handler",Handler.class);

        WebServer server = new WebServer(1500);
        server.getXmlRpcServer().setHandlerMapping(mapping);
        server.start();
        System.out.println("Esperanding....");
    }
}
