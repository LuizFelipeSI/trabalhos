package br.edu.univas;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Dicionario {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String[] portuguese = new String[100];
        String[] english = new String[100];

        do {
            System.out.println("--------------------");
            System.out.println("1) Cadastrar");
            System.out.println("2) Editar");
            System.out.println("3) Excluir");
            System.out.println("4) Consultar");
            System.out.println("5) Sair");
            System.out.println("--------------------");
            String n = scan.next();

            if (Pattern.matches("[a-zA-Z]+", n)) {
                System.out.println("Somente números são válidos!");

            } else {
            int number = Integer.parseInt(n);

                if (number == 1) {
                    registration(portuguese, english);
                } else if (number == 2) {
                    edit(portuguese, english);
                }else if (number == 3) {
                    delete(portuguese, english);
                }else if (number == 4) {
                    consult(portuguese, english);
                } else if (number == 5) {
                    break;
                } else {
                    System.out.println("Por favor, digite uma opção válida.");
                }
            }

        } while (true);
    }

    public static void registration(String[] portuguese, String[] english){

        Scanner scan = new Scanner(System.in);

        String answer;

        for(int j = 0; j < 100; j++) {

            for (int i = 0; i < 100; i++) {

                if (english[i] == null && portuguese[i] == null) {
                    System.out.println("Digite a palavar em inglês que deseja cadastrar");
                    String englishWord = scan.next().toLowerCase();
                    System.out.println("Digite a palavar em português que deseja cadastrar");
                    String portugueseWord = scan.next().toLowerCase();

                    for(int k = 0; k < 100; k++){
                        if (englishWord.equals(english[k])) {
                            System.out.println("Palavra em inglês já cadastrada");
                            break;
                        } else if (portugueseWord.equals(portuguese[k])) {
                            System.out.println("Palavra em português já cadastrada");
                            break;
                        } else if (k == 99){
                            portuguese[i] = portugueseWord;
                            english[i] = englishWord;
                            break;
                        }
                    }
                    break;

                } else if (i == 99 && english[i] != null) {
                    System.out.println("A lista de palavras já está cheia");
                    break;
                }
            }

            if (english[99] == null || english[98] == null) {
                System.out.println("Deseja cadastrar outro produto?  s / n");
                answer = scan.next().toLowerCase();

                if (Pattern.matches("[0-10]+", answer)) {
                System.out.println("Opção inválida!");
                break;

                } else {

                    if (answer.equals("n")) {
                        break;
                    } else if (answer.equals("s")) {
                        continue;
                    } else {
                        System.out.println("Opção inválida!");
                        break;
                    }
                }
            } else {
                break;
            }
        }
    }

    public static void edit(String[] portuguese, String[] english){

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a palavra em inglês que deseja editar (seu siginificado também será editado):");
        String word = scan.next().toLowerCase();
        String englishWord;
        String portuguesehWord;

        for (int i = 0; i < 100; i++) {
            if (word.equals(english[i])) {
                System.out.println("Digite a nova palavra");
                englishWord = scan.next().toLowerCase();
                System.out.println("Digite seu significado");
                portuguesehWord = scan.next().toLowerCase();

                for (int j = 0; j < 100; j++) {
                    if (englishWord.equals(english[j])) {
                        System.out.println("Palavra em inglês já está cadastrada");
                        break;
                    } else if (portuguesehWord.equals(portuguese[j])) {
                        System.out.println("Palavra em português já está cadastrada");
                        break;
                    } else if (j == 99) {
                        if (!englishWord.equals(english[j])) {
                            english[i] = englishWord;
                            portuguese[i] = portuguesehWord;
                            System.out.println("Palavra editada");
                        }
                    }
                }

                break;

            } else if (i == 99){
                if (!word.equals(english[i])) {
                    System.out.println("Essa palavra não está cadastrada, por favor, digite uma palavra cadastrada");
                }
            }
        }
    }

    public static void delete(String[] portuguese, String[] english){

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a palavra em inglês que deseja excluir (seu siginificado também será excluído):");
        String word = scan.next().toLowerCase();

        for (int i = 0; i < 100; i++) {
            if (word.equals(english[i])) {
                english[i] = null;
                portuguese[i] = null;
                System.out.println("Palavra excluída");
                break;

            } else if (i == 99) {
                if (!word.equals(english[i])) {
                    System.out.println("Essa palavra não está cadastrada, por favor, digite uma palavra cadastrada");
                }

            }
        }
    }

    public static void consult(String[] portuguese, String[] english){

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a palavra em inglês que deseja consultar o significado:");
        String word = scan.next().toLowerCase();

        for (int i = 0; i < 100; i++) {
            if (word.equals(english[i])) {
                System.out.println("Significado: " + portuguese[i]);
                break;
            } else if (i == 99) {
                if (!word.equals(english[i])) {
                    System.out.println("Essa palavra não está cadastrada, por favor, digite uma palavra cadastrada");
                }
            }
        }
    }
}