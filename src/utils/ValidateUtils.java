package src.utils;

import src.model.Pet;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidateUtils {
    public static final String NAO_INFORMADO = "Não informado.";

    public String readValidName(Scanner scanner) {
        try {
            String givenName = scanner.nextLine();
            Pet pet = new Pet();
            return pet.setPetName(givenName);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: "+e.getMessage()+" Tente novamente.");
            return readValidName(scanner);
        }
    }

    public int readOneOrTwoValid(Scanner scanner) {
        try {
            System.out.print("Digite um número: ");
            int validNum = scanner.nextInt();
            if (validNum == 1 || validNum == 2) {
                scanner.nextLine();
                return validNum;
            } else {
                System.out.println("Entrada inválida! Digite um número válido.");
                return readOneOrTwoValid(scanner);
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Digite um número válido.");
            scanner.nextLine();
            return readOneOrTwoValid(scanner);
        }
    }

    public int readValidNum(Scanner scanner) {
        try {
            System.out.print("Digite um número: ");
            int validNum = scanner.nextInt();
            scanner.nextLine();
            return validNum;
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida! Digite um número válido.");
            scanner.nextLine();
            return readValidNum(scanner);
        }
    }

    public String readValidNumberHouse(Scanner scanner) {
        System.out.print("digite o número da casa: ");
        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            return Pet.NAO_INFORMADO;
        }

        if (input.matches("\\d+")) {
            return input;
        } else {
            System.out.println("Entrada inválida! Digite apenas números ou pressione Enter para deixar como 'Não informado'.");
            return readValidNumberHouse(scanner);
        }
    }

    public String readValidAge(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();

            if (input.trim().isEmpty()) {
                return Pet.NAO_INFORMADO;
            }

            try {
                float age = Float.parseFloat(input);
                if (age <= 0 || age > 20) {
                    throw new IllegalArgumentException("Idade inválida. O Pet deve ter entre 1 e 20 anos de idade");
                }
                return String.valueOf(age);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Entrada inválida! Digite apenas números.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String readValidWeight(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();

            if (input.trim().isEmpty()) {
                return Pet.NAO_INFORMADO;
            }

            try {
                float validNum = Float.parseFloat(input);
                if (validNum <= 0 || validNum >= 60) {
                    throw new IllegalArgumentException("Peso inválido. O Pet deve ter mais de 0kg ou 60kg+.");
                }
                return String.valueOf(validNum);
            } catch (NumberFormatException e) {
                System.out.println("Erro: Entrada inválida! Digite apenas números.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
