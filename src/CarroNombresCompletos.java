import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

// Clase CarroNombresCompletos
public class CarroNombresCompletos {
    private String placa;
    private String marca;
    private int año;
    private String tipo;

    public CarroNombresCompletos() {
        this.placa = "PAS";
        this.marca = "Ferrari";
        this.año = 2021;
        this.tipo = "Deportivo";
    }
    // Constructor que permite especificar valores para los atributos del carro.
    public CarroNombresCompletos(String placa, String marca, int año, String tipo) {
        this.placa = placa;
        this.marca = marca;
        this.año = año;
        this.tipo = tipo;
    }


    // Método para calcular el valor a pagar basado en el año y tipo del carro.
    public int calcularValorAPagar() {
        int añoActual = 2024;
        if (año < 1950 || año > añoActual) {
            return -1;
        }
        int antiguedad = añoActual - año;
        return tipo.equalsIgnoreCase("Deportivo") ? 100 * antiguedad : 50 * antiguedad;
    }
    // Método toString proporciona una representación en cadena del carro, use String.format para poder definir el formato de los datos
    @Override
    public String toString() {
        return String.format("Placa: %s, Marca: %s, Año: %d, Tipo: %s", placa, marca, año, tipo);
    }


    // Métodos getter y setter para cada uno de los atributos.
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}