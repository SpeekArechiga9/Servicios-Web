package Server;

public class Vehiculo {
    private String modelo;
    private String marca;
    private String color;
    private String noSerie;

    public Vehiculo() {
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    @Override
    public String toString() {
        return "--------------------------------\nVehiculo: " + "\nModelo: " + modelo + "\nMarca: " + marca + "\nColor: " + color + "\nNo de Serie: " + noSerie;
    }
}
