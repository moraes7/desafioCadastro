package src.services;

import java.util.Scanner;

public class Menu {
    public int printMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("==== CADASTRAR PET ====");
        System.out.println("1. Cadastrar um novo pet");
        System.out.println("2. Alterar os dados do pet cadastrado");
        System.out.println("3. Deletar um pet cadastrado");
        System.out.println("4. Listar todos os pets cadastrados");
        System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
        System.out.println("6. Sair");
        int escolha = numberInRange(scanner);
        return escolha;
    }

    public static int numberInRange(Scanner scanner) {
        while (true) {
            System.out.println("Escolha as opções de 1 a 6: ");

            if(scanner.hasNextInt()) {
                int num = scanner.nextInt();
                scanner.nextLine();

                if(num >= 1 && num <= 6) {
                    return num;
                } else {
                    System.out.println("Os números válidos são apenas de 1 até 6");
                }
            } else {
                System.out.println("ERRO: Caracteres não são aceitos, digite apenas números");
                scanner.nextLine();
            }
        }
    }
}
