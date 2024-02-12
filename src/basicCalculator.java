import java.util.Scanner;

public class basicCalculator implements basicOperations{


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
        return Math.pow(b,2);
    }
    private double porcentaje(double a, double b) {
        return a * b/100;
    }

    private double potencia(double a, double b) {
        return Math.pow(a,b);
    }


    public double realizarOperacion ( double a, String operador){
            return realizarOperacion(a, operador, 0);
        }
        public double realizarOperacion ( double a, String operador,double b){
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
                case '^':
                    return potencia(a, b);
                case 's':
                    return raizsqr(a);
                default:
                    //excepcion de que se ha dado un argumento no valido
                    throw new IllegalArgumentException("Operador no válido");
            }
        }






}