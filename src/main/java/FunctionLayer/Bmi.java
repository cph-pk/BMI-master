package FunctionLayer;

import java.time.LocalDateTime;

public class Bmi {

    public Bmi(String dato, String height, String weight, double bmi, String status, String color) {
        this.dato = dato;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.status = status;
        this.color = color;
    }

    private int id;
    private String dato;
    private String height;
    private String weight;
    private double bmi;
    private String status;
    private String color;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
}
