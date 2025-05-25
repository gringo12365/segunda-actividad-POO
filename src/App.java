import modelo.Persona;

import java.util.ArrayList;
import java.util.Scanner;

//feat: implementar método para capturar datos de 5 personas usando Scanner

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Persona> personas = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("📋 Captura de datos de 5 personas:");
        capturarPersonas(5);  // Punto b

        System.out.println("\n✅ Nombres y géneros:");
        mostrarNombresYGeneros(); // Punto b

        System.out.println("\n📊 Promedio de edades: " + calcularPromedioEdad()); // Punto c

        System.out.println("\n👨 Cantidad de personas con género Masculino: " + contarGenero("Masculino")); // Punto d

        System.out.println("\n👩 Cantidad de personas con género Femenino: " + contarGenero("Femenino")); // Punto e
    }

    private static void capturarPersonas(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            System.out.println("\n🔹 Persona " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Apellido: ");
            String apellido = scanner.nextLine();

            System.out.print("Género (Masculino/Femenino): ");
            String genero = scanner.nextLine();

            System.out.print("Edad: ");
            int edad = Integer.parseInt(scanner.nextLine());

            personas.add(new Persona(nombre, apellido, genero, edad));
        }
    }

    private static void mostrarNombresYGeneros() {
        for (Persona p : personas) {
            System.out.println("Nombre: " + p.getNombre() + ", Género: " + p.getGenero());
        }
    }

    private static double calcularPromedioEdad() {
        if (personas.isEmpty()) return 0;
        int sumaEdades = 0;
        for (Persona p : personas) {
            sumaEdades += p.getEdad();
        }
        return (double) sumaEdades / personas.size();
    }

    private static int contarGenero(String generoBuscado) {
        int contador = 0;
        for (Persona p : personas) {
            if (p.getGenero().equalsIgnoreCase(generoBuscado)) {
                contador++;
            }
        }
        return contador;
    }



}