package Server;

import java.util.ArrayList;

public class Methods {
    AutosDao daoautos = new AutosDao();
    public String llamar(String marca, String modelo, String color){
        callDao(marca,modelo,color);
        return "true";
    }


    public String history(String a){
        String response = "";
        ArrayList<AutosBean> aux = AutosDao.showAutos();
        for (int i = 0; i < aux.size(); i++){
            response += "#: " + aux.get(i).getNumSerie() + "\n"
                    + "Tipo de operación: " + aux.get(i).getMarca() + "\n"
                    + "Primer número: " + aux.get(i).getModelo() + "\n"
                    + "Segundo número: " + aux.get(i).getColor() + "\n";
        }
        return response;
    }

    public void callDao(String marca, String modelo, String color){
        AutosDao.generarCarro(marca,modelo,color);
    }
}
