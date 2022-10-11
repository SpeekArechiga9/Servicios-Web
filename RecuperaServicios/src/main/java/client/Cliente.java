package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.Vector;

public class Cliente {
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        Scanner leer = new Scanner(System.in);
        String numSerie, modelo, marca, color, res = "";
        Object resultado;
        int opcMenu;
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1500"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        System.out.println(read(client));
    }

    public static String read(XmlRpcClient client) throws XmlRpcException {
        Vector<String> parametros = new Vector<String>();
        Scanner leer = new Scanner(System.in);
        String res = "";
        System.out.println("Elige la opcion");
        System.out.println("1.- Agregar");
        System.out.println("2.- Mostrar");
        System.out.println("3.- salir");
        int opcMenu = leer.nextInt();
        switch (opcMenu) {
            case 1:
                String numSeie, modelo, marca, color, num1,num2;
                System.out.println("Ingresa el numero de serie");
                numSeie = leer.next();
                System.out.println("modelo");
                modelo = leer.next();
                System.out.println("marca");
                marca = leer.next();
                System.out.println("color");
                color = leer.next();
                num1 = "3";
                num2 = "3";
                Object[] params1 = {numSeie, modelo, marca, color,num1, num2};
                parametros.addElement(num1);
                parametros.addElement(num2);
                /*parametros.addElement(marca);
                parametros.addElement(color); */
                boolean reult = (Boolean) client.execute("Handler.generarCarro", parametros);
                res = reult ? "Si se hizo" : "no se hizo";
                return res;
            case 2:
                break;
            case 3:
                System.out.println("Adios");
                break;
            default:
                System.out.println("adios");
        }
        return res;
    }
}



/*try{
            XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
            config.setServerURL(new URL("http://localhost:1500"));
            XmlRpcClient client = new XmlRpcClient();
            client.setConfig(config);
            Vector<String> parametros = new Vector<String>();
            JOptionPane.showMessageDialog(null,"Si se conecto papuuuuu");
            System.out.println("Elige la opcion " +
                    "\n 1.-Registrar" +
                    "\n 2.-Mostrar registros");
            opcMenu = leer.nextInt();
            switch (opcMenu){
                case 1:
                    System.out.println("ingresa el numero de serie del vehiculo:");
                    numSerie = leer.next();
                    System.out.println("Ingresa el modelo del vehiculo");
                    modelo = leer.next();
                    System.out.println("Ingresa la marca");
                    marca=leer.next();
                    System.out.println("Ingresa el color del vehiculo:");
                    color = leer.next();
                    parametros.addElement(numSerie);
                    parametros.addElement(modelo);
                    parametros.addElement(marca);
                    parametros.addElement(color);

                    resultado = client.execute("Handler.generarCarro",parametros);
                    System.out.println(resultado);
                    parametros.clear();
                    break;
                case 2:
                    resultado = client.execute("Handler.nosewe",parametros);
                    System.out.println(resultado);
                    break;
                default:
                    System.out.println("Elige una opcion correcta");
            }
        }catch(Exception e){

        }*/


