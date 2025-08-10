package src.main;


import src.model.Pet;
import src.model.PetAdress;
import src.model.PetGender;
import src.model.PetType;
import src.repository.FileRepository;
import src.services.Menu;
import src.services.RegisterPet;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pet pet = new Pet();
        Menu menu = new Menu();
        FileRepository fileRepository = new FileRepository();
        fileRepository.createFile();
        fileRepository.readFile();
        RegisterPet registerPet = new RegisterPet();

        boolean running = true;

        while (running) {
            int option = menu.printMenu();

            switch (option) {
                case 1:
                    registerPet.registerPet();
                    break;
                case 2:
                    System.out.println("Em desenvolvimento");
                    break;
                case 3:
                    System.out.println("Em desenvolvimento");
                    break;
                case 4:
                    System.out.println("Em desenvolvimento");
                    break;
                case 5:
                    System.out.println("Em desenvolvimento");
                    break;
                case 6:
                    System.out.println("Em desenvolvimento");
                    break;
                case 7:
                    System.out.println("Em desenvolvimento");
                    break;
                case 8:
                    System.out.println("Saindo do sistema...");
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");

            }
        }

    }
}
