package Server;

public class AutosBean {
    private Integer numSerie;
    private String modelo;
    private String marca;
    private String color;

    public AutosBean(){}

    public AutosBean(Integer numSerie, String modelo, String marca, String color) {
        this.numSerie = numSerie;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
    }

    public Integer getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(Integer numSerie) {
        this.numSerie = numSerie;
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
}
