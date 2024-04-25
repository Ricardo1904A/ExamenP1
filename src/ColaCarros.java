import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


// Defino la clase ColaCarros.
class ColaCarros {
    private List<CarroNombresCompletos> cola;
    // Constructor
    public ColaCarros() {
        this.cola = new ArrayList<>();
    }
    // Método para agregar un carro a la cola.
    public void encolar(CarroNombresCompletos carro) {
        cola.add(carro);
    }
    // Método para copiar carros de una marca específica a una nueva cola.
    public ColaCarros copiarCarrosPorMarca(String marcaBuscada) {
        ColaCarros nuevaCola = new ColaCarros();
        for (CarroNombresCompletos carro : cola) {
            if (carro.getMarca().equalsIgnoreCase(marcaBuscada)) {
                nuevaCola.encolar(carro);
            }
        }
        return nuevaCola;
    }
    // Método para mostrar todos los carros en la cola.
    public String mostrarCola() {
        StringBuilder sb = new StringBuilder();
        for (CarroNombresCompletos carro : cola) {
            sb.append(carro.toString()).append("\n");
        }
        return sb.toString();
    }
    // Método para mostrar la información y el valor a pagar de cada carro, actualizando un JTextArea.
    public void mostrarInformacionYValor(JTextArea textArea) {
        StringBuilder sb = new StringBuilder();
        for (CarroNombresCompletos carro : cola) {
            int valorAPagar = carro.calcularValorAPagar();
            if (valorAPagar == -1) {
                sb.append(carro.toString()).append(" - Año no valido\n");
            } else {
                sb.append(carro.toString()).append(" - Valor a pagar: $").append(valorAPagar).append("\n");
            }
        }
        textArea.setText(sb.toString());
    }
}