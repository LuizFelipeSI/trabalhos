package br.edu.univas;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Poligonos {

    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);

        double altura;
        double resultado;
        double base;
        double baseMenor;

        do {
            System.out.println("--------------------");
            System.out.println("1. Quadrado");
            System.out.println("2. Triangulo");
            System.out.println("3. Retangulo");
            System.out.println("4. Trapezio");
            System.out.println("9. Sair");
            System.out.println("--------------------");
            String n = leitura.next();

            if (Pattern.matches("[a-zA-Z]+", n)){
                System.out.println("Somente números são válidos!");

            } else {
                int numero = Integer.parseInt(n);

                if (numero == 1) {
                    System.out.println("QUADRADO");
                    System.out.println("Digite a altura ou a base:");
                    altura = leitura.nextInt();
                    resultado = altura*altura;
                    System.out.println("A área do quadrado é igual a: " + resultado);

                } else if (numero == 2) {
                    System.out.println("TRIANGULO");
                    System.out.println("Digite a base:");
                    base = leitura.nextInt();
                    System.out.println("Digite a altura:");
                    altura = leitura.nextInt();
                    resultado = (base*altura)/2;
                    System.out.println("A área do triangulo é igual a: " + resultado);

                } else if (numero == 3) {
                    System.out.println("RETANGULO");
                    System.out.println("Digite a base:");
                    base = leitura.nextInt();
                    System.out.println("Digite a altura (diferente da base):");
                    altura = leitura.nextInt();
                    if (base == altura) {
                        System.out.println("Base e altura são iguais, opção redefinida para 1. Quadrado:");
                        resultado = base*altura;
                        System.out.println("A área do quadrado é igual a: " + resultado);
                    } else {
                        resultado = base*altura;
                        System.out.println("A área do retangulo é igual a: " + resultado);
                    }

                } else if (numero == 4) {
                    System.out.println("TRAPEZIO");
                    do {
                    System.out.println("Digite a base maior:");
                    base = leitura.nextInt();
                    System.out.println("Digite a base menor:");
                    baseMenor = leitura.nextInt();
                    if (base < baseMenor) {
                        System.out.println("Base maior é menor que a base menor, por favor digite medidas válidas:");
                        }
                    else if (base == baseMenor) {
                        System.out.println("Base maior é igual a base menor, por favor digite medidas válidas:");
                    }

                    else {
                        break;
                    }

                    } while (true);

                    System.out.println("Digite a altura:");
                    altura = leitura.nextInt();
                    resultado = ((base+baseMenor)*altura)/2;
                    System.out.println("A área do trapezio é igual a: " + resultado);


                } else if (numero == 9) {
                    System.out.println("Programa encerrado!");
                    break;

                } else {
                    System.out.println("Opção inválida! Por favor, digite a opção correta!");
                }
            }

        } while (true);
    }
}
