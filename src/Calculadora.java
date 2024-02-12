import java.util.Scanner;

class DivisionPorCeroException extends RuntimeException {
    public DivisionPorCeroException(String mensaje) {
        super(mensaje);
    }
}

public class Calculadora {
    private final Scanner scanner;

    public Calculadora(Scanner scanner) {
        this.scanner = scanner;
    }

    public double sumar(double a, double b) {
        return a + b;
    }

    public double restar(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new DivisionPorCeroException("No se puede dividir por cero.");
        }
    }

    public double realizarOperacion(double a, String operador) {
        return realizarOperacion(a, operador, 0);
    }

    public double realizarOperacion(double a, String operador, double b) {
        char primerCaracter = operador.charAt(0);

        if ((primerCaracter == '+' || primerCaracter == '-' || primerCaracter == '*' || primerCaracter == '/')
                && operador.length() == 1) {

            if (primerCaracter == '/') {
                // En el caso de la división, asegurarse de que el divisor no sea cero
                System.out.print("Ingrese el divisor para la operación: ");
                double divisor = scanner.nextDouble();

                return dividir(a, divisor);
            } else {
                // Realizar la operación correspondiente
                switch (primerCaracter) {
                    case '+':
                        return sumar(a, b);
                    case '-':
                        return restar(a, b);
                    case '*':
                        return multiplicar(a, b);
                    default:
                        throw new IllegalArgumentException("Operador no válido");
                }
            }
        }
        // Operador no válido
        throw new IllegalArgumentException("Operador no válido");
    }
}
