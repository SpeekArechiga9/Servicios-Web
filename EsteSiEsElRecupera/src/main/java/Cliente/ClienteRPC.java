package Cliente;

import Server.Methods;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ClienteRPC {
    public static void main(String[] args) throws XmlRpcException, MalformedURLException {
        Methods metodo = new Methods();
        Scanner leer = new Scanner(System.in);
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);
        String modelo = "", marca = "", color = "";
        Object response;
        int opc = 0;
        System.out.println("Elige");
        System.out.println("1.- Agregar");
        System.out.println("2.- Mostrar");
        opc = leer.nextInt();
        switch (opc){
            case 1:
                /*System.out.println("Numero de serie:");
                numSerie = leer.next();*/
                System.out.println("marca");
                marca = leer.next();
                System.out.println("Modelo");
                modelo = leer.next();
                System.out.println("Color");
                color = leer.next();
                Object [] datos = {marca,modelo,color};
                response = client.execute("Methods.llamar",datos);
                System.out.println(response);
                System.out.println("");
                break;
            case 2:
                System.out.println("HISTORIAL");
                Object[] data7 = {"a"};
                response = client.execute("Methods.history", data7);
                System.out.println(response);
                break;
            default:
                System.out.println("Opcion no valida");

        }
    }
}
