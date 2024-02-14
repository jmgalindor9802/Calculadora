import java.util.Scanner;

public class basicCalculator implements basicOperations, scientificOperations{


    public basicCalculator(Scanner scanner) {
    }

    @Override
    public double sumar(double a, double b) {
        return a+b;
    }

    @Override
    public double restar(double a, double b) {
        return a-b;
    }

    @Override
    public double multiplicar(double a, double b) {
        return a*b;
    }

    @Override
    public double dividir(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("No se puede dividir por cero");
            //se envia una excepcion de error aritmetico
            throw new ArithmeticException("Intento de división por cero");
        }
    }
    @Override
    public double raizsqr(double b) {
        return Math.sqrt(b);
    }
    @Override
    public double porcentaje(double a, double b) {
        return a * b/100;
    }
    @Override
    public double potencia2(double a) {
        return Math.pow(a,2);
    }



    public double realizarBasicOperacion(double a, String operador){
        char primerCaracter = operador.charAt(0);
        // Realizar la operación correspondiente
        switch (primerCaracter) {
            case '^':
                return potencia2(a);
            case 'q':
                return raizsqr(a);
            default:
                //excepcion de que se ha dado un argumento no valido
                throw new IllegalArgumentException("Operador no válido");
        }
        }
        public double realizarBasicOperacion(double a, String operador, double b){
            char primerCaracter = operador.charAt(0);

            // Realizar la operación correspondiente
            switch (primerCaracter) {
                case '+':
                    return sumar(a, b);
                case '-':
                    return restar(a, b);
                case '*':
                    return multiplicar(a, b);
                case '/':
                    return dividir(a, b);
                case '%':
                    return porcentaje(a, b);
                default:
                    //excepcion de que se ha dado un argumento no valido
                    throw new IllegalArgumentException("Operador no válido");
            }
        }

    public double realizarScientificOperacion(double a, String operador){
        char primerCaracter = operador.charAt(0);
        // Realizar la operación correspondiente
        switch (primerCaracter) {
            case 's':
                return senr(a);
            case 'c':
                return cosr(a);
            case 't':
                return tanr(a);
            default:
                //excepcion de que se ha dado un argumento no valido
                throw new IllegalArgumentException("Operador no válido");
        }
    }
    @Override
    public double senr(double a) {
        return Math.sin(a);
    }

    @Override
    public double cosr(double a) {
        return Math.cos(a);
    }

    @Override
    public double tanr(double a) {
        return Math.tan(a);
    }

    @Override
    public double seng(double a) {
        return 0;
    }

    @Override
    public double cosg(double a) {
        return 0;
    }

    @Override
    public double tang(double a) {
        return 0;
    }
}