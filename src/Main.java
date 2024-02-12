import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora(scanner);

        double numeroAnterior = 0;
        double numeroActual = 0;

        // Pedir el primer número
        System.out.print("Ingrese el primer número: ");
        numeroAnterior = scanner.nextDouble();

        boolean salir = false;

        do {
            try {
                // Pedir el operador
                System.out.print("Ingrese un operador (+, -, *, /), 'c' para reiniciar o un valor no numérico para salir: ");
                String operadorInicial = scanner.next();

                if (operadorInicial.equalsIgnoreCase("c")) {
                    // Reiniciar los números
                    System.out.println("Reiniciando números.");
                    // Pedir el primer número
                    System.out.print("Ingrese el primer número: ");
                    numeroAnterior = scanner.nextDouble();
                } else if (esOperadorValido(operadorInicial)) {
                    // Pedir el segundo número
                    System.out.print("Ingrese el segundo número: ");
                    numeroActual = scanner.nextDouble();

                    // Realizar la operación
                    double resultado = calculadora.realizarOperacion(numeroAnterior, operadorInicial, numeroActual);
                    System.out.println("El resultado de la operación es: " + resultado);
                    numeroAnterior = resultado;
                } else {
                    System.out.println("Por favor, ingrese un operador válido (+, -, *, /) o 'c' para reiniciar.");
                }
            } catch (java.util.InputMismatchException | NumberFormatException e) {
                // Si se ingresa un valor no numérico, salir del bucle
                System.out.println("Programa terminado.");
                salir = true;
            }
        } while (!salir);

        // Cerrar el scanner
        scanner.close();
    }

    private static boolean esOperadorValido(String entrada) {
        char primerCaracter = entrada.charAt(0);
        return (primerCaracter == '+' || primerCaracter == '-' || primerCaracter == '*' || primerCaracter == '/');
    }
}
