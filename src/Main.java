import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// Elegi hacer el proyecto con java swing ya que tengo un poco mas de experiencia con esta interfaz ademas de que el uso de la interfaz
// del propio intellij es un poco compleja para mi al momento de desarrollar el programa
public class Main {
    public static void main(String[] args) {
        // Utilizo SwingUtilities.invokeLater para asegurar que la GUI se maneje en el Event Dispatch Thread,
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Colas de Carros");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
        // Instancia una nueva cola de carros.
            ColaCarros colaDeCarros = new ColaCarros();
            colaDeCarros.encolar(new CarroNombresCompletos("HPGJ0983", "Toyota", 2020, "Convertible"));
            colaDeCarros.encolar(new CarroNombresCompletos("GSD2134", "Great Wall", 2018, "JEEP"));
            colaDeCarros.encolar(new CarroNombresCompletos("PIJ0923", "Ford", 2018, "Deportivo"));
            colaDeCarros.encolar(new CarroNombresCompletos("OBB012", "Mazda", 2021, "JEEP"));
            colaDeCarros.encolar(new CarroNombresCompletos("LKI345", "Toyota", 2017, "Sedan"));

            JTextArea textAreaOriginal = new JTextArea(10, 30);
            textAreaOriginal.setText("Cola Original:\n" + colaDeCarros.mostrarCola());
            textAreaOriginal.setEditable(false);

            JTextArea textAreaCopia = new JTextArea(10, 30);
            textAreaCopia.setEditable(false);

            JTextArea textAreaCalculo = new JTextArea(10, 30);
            textAreaCalculo.setEditable(false);
    // Crea un botón para poder realizar la busqueda del auto que se requiera
            JButton btnCopiarToyota = new JButton("Buscar autos ");
            btnCopiarToyota.addActionListener(e -> {
                ColaCarros copiaToyota = colaDeCarros.copiarCarrosPorMarca("Ford");
                textAreaCopia.setText("Copia de autos:\n" + copiaToyota.mostrarCola());
            });
            // Crea un botón que calculará y mostrará el valor a pagar por cada carro en la cola.
            JButton btnCalcularPago = new JButton("Calcular Pago");
            btnCalcularPago.addActionListener(e -> colaDeCarros.mostrarInformacionYValor(textAreaCalculo));

            JPanel panelButtons = new JPanel(new GridLayout(1, 2));
            panelButtons.add(btnCopiarToyota);
            panelButtons.add(btnCalcularPago);

            JPanel panelTextAreas = new JPanel(new GridLayout(3, 1));
            panelTextAreas.add(new JScrollPane(textAreaOriginal));
            panelTextAreas.add(new JScrollPane(textAreaCopia));
            panelTextAreas.add(new JScrollPane(textAreaCalculo));

            frame.setLayout(new BorderLayout());
            frame.add(panelButtons, BorderLayout.NORTH);
            frame.add(panelTextAreas, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}