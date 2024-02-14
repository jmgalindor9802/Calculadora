import java.util.Scanner;

public class Main extends basicCalculator {

    public Main(Scanner scanner) {
        super(scanner);
    }
    // funcion para validar el operador
    private static boolean esOperadorBasicoValido(String entrada){
        char primerCaracter = entrada.charAt(0);
        return (primerCaracter == '+' ||primerCaracter == 'q' || primerCaracter == 'e' || primerCaracter == '-' || primerCaracter == '*' || primerCaracter == '/' || primerCaracter == '%' || primerCaracter == '^' || primerCaracter == 's');
    }
    private static boolean esOperadorCientificoValido(String entrada){
        char primerCaracter = entrada.charAt(0);
        return (primerCaracter == 's' || primerCaracter == 'c' || primerCaracter == 't' );
    }

    private static void mostrarMenu() {
        System.out.println("*****MENU*****");
        System.out.println("Seleccione una opción:");
        System.out.println("1. Operaciones Básicas (+, -, *, /, %, (^)Potencia cuadrada ,(q)Raiz cuadrada)");
        System.out.println("2. Operaciones Científicas (seno, coseno, tangente)");
        System.out.println("3. Salir");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main calculadora = new Main(scanner);

        double numeroAnterior = 0;
        double numeroActual = 0;


        boolean salir1 = false;
        boolean salir2= false;
        boolean salir3= false;

        do {
            try {
                //mostrar menu
                mostrarMenu();
                int opcion = scanner.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println("*****CALCULADORA BÁSICA*****");
                        // Pedir el primer número
                        System.out.print("Ingrese el primer número: ");
                        numeroAnterior = scanner.nextDouble();
                        do {
                            // pedir el operador
                            System.out.print("Ingrese un operador (+, -, *, /,%,(^)Potencia cuadrada ,(q)Raiz cuadrada)), 'c' para reiniciar, 'e' para volver al menu:");
                            String operadorInicial = scanner.next();

                            if (operadorInicial.equalsIgnoreCase("c")) {
                                // reiniciar los números
                                System.out.println("Reiniciando números.");
                                // pedir el primer número
                                System.out.print("Ingrese el primer número: ");
                                numeroAnterior = scanner.nextDouble();
                            }else if (operadorInicial.equalsIgnoreCase("e")) {
                               salir1=true;
                            } else if (esOperadorBasicoValido(operadorInicial)) {
                                // pedir el segundo número
                                if (operadorInicial.equalsIgnoreCase("q") || operadorInicial.equalsIgnoreCase("^")) {
                                    double resultado = calculadora.realizarBasicOperacion(numeroAnterior, operadorInicial);
                                    System.out.println("El resultado es: " + resultado);
                                    numeroAnterior = resultado;
                                } else if (!operadorInicial.equalsIgnoreCase("q") || !operadorInicial.equalsIgnoreCase("^")) {
                                    System.out.print("Ingrese el segundo número: ");
                                    numeroActual = scanner.nextDouble();
                                    // realizar la operación
                                    double resultado = calculadora.realizarBasicOperacion(numeroAnterior, operadorInicial, numeroActual);
                                    System.out.println("El resultado es: " + resultado);
                                    numeroAnterior = resultado;
                                }
                            }else {
                                    System.out.println("Por favor, ingrese un operador válido (+, -, *, /,%,^) o 'c' para reiniciar.");
                                }

                        }while (!salir1);
                        break;

                    case 2:
                        System.out.println("*****CALCULADORA CIENTIFICA*****");
                        // Pedir el primer número

                        do {
                            // pedir el operador
                            System.out.print("Ingrese un operador [s]Seno,[c]Coseno, [t]Tangente, 'c' para reiniciar, 'e' volver al menu:");
                            String operadorInicial = scanner.next();
                        if (operadorInicial.equalsIgnoreCase("c")) {
                            // reiniciar los números
                            System.out.println("Reiniciando números.");
                            // pedir el primer número
                            System.out.print("Ingrese el primer número: ");
                            numeroAnterior = scanner.nextDouble();
                        }else if (operadorInicial.equalsIgnoreCase("e")) {
                            salir3=true;
                        } else if (esOperadorCientificoValido(operadorInicial)) {
                            // pedir el  número
                            System.out.print("Ingrese el primer número: ");
                            numeroAnterior = scanner.nextDouble();
                                double resultado = calculadora.realizarScientificOperacion(numeroAnterior, operadorInicial);
                                System.out.println("El resultado es: " + resultado);
                                numeroAnterior = resultado;

                        }else {
                            System.out.println("Por favor, ingrese un operador válido (+, -, *, /,%,^) o 'c' para reiniciar.");
                        }

                }while (!salir3);
                break;
                    }
                } catch(ArithmeticException e){
                    // Manejar excepción específica relacionada con la división por cero
                    System.out.println("Error de división por cero: " + e.getMessage());
                }

            } while (!salir2) ;

    }

    }

