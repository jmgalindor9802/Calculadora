import java.util.Scanner;

public class Main extends basicCalculator {

    public Main(Scanner scanner) {
        super(scanner);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main calculadora = new Main(scanner);

        double numeroAnterior = 0;
        double numeroActual = 0;

        // Pedir el primer número
        System.out.print("Ingrese el primer número: ");
        numeroAnterior = scanner.nextDouble();

        boolean salir = false;

        do {
            try {
                // pedir el operador
                System.out.print("Ingrese un operador (+, -, *, /,%,^), 'c' para reiniciar:");
                String operadorInicial = scanner.next();

                if (operadorInicial.equalsIgnoreCase("c")) {
                    // reiniciar los números
                    System.out.println("Reiniciando números.");
                    // pedir el primer número
                    System.out.print("Ingrese el primer número: ");
                    numeroAnterior = scanner.nextDouble();
                } else if (esOperadorValido(operadorInicial)) {
                    // pedir el segundo número
                    if (esOperadorValido("s")||(esOperadorValido("^"))){
                        numeroActual = 0;
                    }else{
                        System.out.print("Ingrese el segundo número: ");
                        numeroActual = scanner.nextDouble();
                    }
                    // realizar la operación
                    double resultado = calculadora.realizarOperacion(numeroAnterior, operadorInicial, numeroActual);
                    System.out.println("El resultado es: " + resultado);
                    numeroAnterior = resultado;
                } else {
                    System.out.println("Por favor, ingrese un operador válido (+, -, *, /,%,^) o 'c' para reiniciar.");
                }
            }catch (ArithmeticException e) {
                // Manejar excepción específica relacionada con la división por cero
                System.out.println("Error de división por cero: " + e.getMessage());
            }

        } while (!salir);
    }
// funcion para validar el operador
    private static boolean esOperadorValido(String entrada) {
        char primerCaracter = entrada.charAt(0);
        return (primerCaracter == '+' || primerCaracter == '-' || primerCaracter == '*' || primerCaracter == '/'  || primerCaracter == '%'|| primerCaracter == '^'|| primerCaracter == 's');
    }
}
