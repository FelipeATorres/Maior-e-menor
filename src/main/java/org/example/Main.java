package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int quantNumeros = 0;
        int quantiaNumeros;

        Scanner sc = new Scanner(System.in);
        String mensagem = "Digite quantos números deseja analisar";

        while (true){
            quantiaNumeros = escolha(mensagem,quantNumeros,sc);

            if (quantiaNumeros > 0)
                break;
            if (quantiaNumeros < 0)
                System.out.println("É preciso digitar um número maior que 0 para ser analisado! Tente novamente!");
        }

        int[] resultados = maiorMenor(quantiaNumeros, sc);
        System.out.printf("Maior número digitado: %d\n",resultados[0]);
        System.out.printf("Menor número digitado: %d",resultados[1]);


        sc.close();
    }

    public static int escolha(String mensagem, int quantNumeros, Scanner sc) {
        while (true){
            try {
                System.out.printf("%s:",mensagem);
                quantNumeros = sc.nextInt();
            }
            catch (InputMismatchException e) {
                System.out.println("Só é possivel digitar números. Tente novamente!");
                sc.nextLine();
            }
            finally {
                return quantNumeros;
            }
        }
    }

    public static int[] maiorMenor(int quantidade, Scanner sc) {
        int numMaior = Integer.MIN_VALUE;
        int numMenor = Integer.MAX_VALUE;

        System.out.printf("Digite %d números\n",quantidade);

        for (int i = 0; i < quantidade; i++) {
            int numEscolhido = sc.nextInt();

            if (numEscolhido > numMaior) {
                numMaior = numEscolhido;
            }
            if (numEscolhido < numMenor) {
                numMenor = numEscolhido;
            }

        }
        return new int[]{numMaior,numMenor};
    }
}