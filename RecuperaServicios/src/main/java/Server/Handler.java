package Server;

import java.util.ArrayList;
import java.util.List;

public class Handler {
    List<Vehiculo> vehiculos = new ArrayList<>();

    public String generarCarro(String num1, String num2){
        /*Vehiculo vehiculoNew = new Vehiculo();
        vehiculoNew.setNoSerie(numSerie);
        vehiculoNew.setModelo(modelo);
        vehiculoNew.setMarca(marca);
        vehiculoNew.setColor(color);
        vehiculos.add(vehiculoNew);
        return "si";*/
        return String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2));
    }

    public void nosewe(){
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.toString());
        }
    }
}