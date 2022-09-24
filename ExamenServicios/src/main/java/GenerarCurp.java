import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfig;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerarCurp {
    public static void main(String[] args) throws XmlRpcException, MalformedURLException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("https://localhost:1500"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        System.out.println(read(client));
    }

    public static String read (XmlRpcClient client) throws XmlRpcException{
        Scanner leer = new Scanner(System.in);
        String res = "";
        System.out.println("Elige la opcion");
        System.out.println("1.- Agregar");
        System.out.println("2.- Mostrar");
        System.out.println("3.- salir");
        int opcMenu = leer.nextInt();
        switch (opcMenu){
            case 1:
                String curp,nombre,primerApellido,segundoApellido,sexo = "H",edoNac,fecNac;
                int opcSexo;
                System.out.println("Ingresa los datos ;)" +
                        "\nNombre:");
                nombre = leer.next();
                System.out.println("Primer apellido:");
                primerApellido = leer.next();
                System.out.println("Segundo apellido:");
                segundoApellido = leer.next();
                System.out.println("Sexo" +
                        "\n 1.- Masculino (H)" +
                        "\n 2.- Femenino (M)");
                opcSexo=leer.nextInt();
                System.out.println("De haber elegido un velor erroneo se dara uno por defecto y este sera la primera opcion");
                if (opcSexo == 2)
                    sexo = "M";
                System.out.println("Estado de nacimiento su codigo para generar el CURP" +
                        "\n Por ejemplo: Morelos (MS)");
                edoNac = leer.next();
                System.out.println("Ingresa tu fecha de nacimiento con el formato YYYY-MM-DD (Guiones incluidos)");
                fecNac = leer.next();
                curp = generarCurp(nombre,primerApellido,segundoApellido,fecNac,sexo,edoNac);
                System.out.println("La curp generada es: "+ curp);
                Object[] params1 = {curp,nombre,primerApellido,segundoApellido,sexo,edoNac,fecNac};
                boolean result = (Boolean) client.execute("Handler.generarCurp",params1);
                res = result ? "Se registro exitosamente" : "No digas eso papuuu";
                return res;
            case 2:
                break;
            default:
                System.out.println("Elige una opcion correcta");
        }
        return res;
    }

    static String generarCurp(String nombre, String primerApellido, String segundoApellido, String fecNac, String sexo, String edoNac){
        int num1 = (int) Math.floor(Math.random()*10);
        int num2 = (int) Math.floor(Math.random()*10);
        String numCurp1 = String.valueOf(num1);
        String numCurp2 = String.valueOf(num2);
        String curp = ""+primerApellido.toUpperCase().charAt(0) + primerApellido.toUpperCase().charAt(1) + segundoApellido.toUpperCase().charAt(0)+ nombre.toUpperCase().charAt(0) + fecNac.charAt(2)+fecNac.charAt(3)+fecNac.charAt(5)+fecNac.charAt(6)+fecNac.charAt(8)+fecNac.charAt(9) + sexo + edoNac.toUpperCase() + primerApellido.toUpperCase().charAt(2) + segundoApellido.toUpperCase().charAt(1) + nombre.toUpperCase().charAt(1) + numCurp1 + numCurp2;
        return curp;
    }

    public static String recopilardatos(){
        Scanner leer = new Scanner(System.in);
        String res ="";
        String curp,nombre,primerApellido,segundoApellido,sexo = "H",edoNac,fecNac;
        int opcSexo;
        System.out.println("Ingresa los datos ;)" +
                "\nNombre:");
        nombre = leer.next();
        System.out.println("Primer apellido:");
        primerApellido = leer.next();
        System.out.println("Segundo apellido:");
        segundoApellido = leer.next();
        System.out.println("Sexo" +
                "\n 1.- Masculino (H)" +
                "\n 2.- Femenino (M)");
        opcSexo=leer.nextInt();
        System.out.println("De haber elegido un velor erroneo se dara uno por defecto y este sera la primera opcion");
        if (opcSexo == 2)
            sexo = "M";
        System.out.println("Estado de nacimiento su codigo para generar el CURP" +
                "\n Por ejemplo: Morelos (MS)");
        edoNac = leer.next();
        System.out.println("Ingresa tu fecha de nacimiento con el formato YYYY-MM-DD (Guiones incluidos)");
        fecNac = leer.next();
        curp = generarCurp(nombre,primerApellido,segundoApellido,fecNac,sexo,edoNac);
        System.out.println("La curp generada es: "+ curp);
        Object[] params1 = {curp,nombre,primerApellido,segundoApellido,sexo,edoNac,fecNac};
        boolean result = false;
        return "";
    }


}
