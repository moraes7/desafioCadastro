package src.main;


import src.model.Pet;
import src.repository.FileRepository;
import src.services.Menu;
import src.services.RegisterPet;
import src.services.SearchPet;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        FileRepository fileRepository = new FileRepository();
        fileRepository.createFile();
        fileRepository.readFile();
        RegisterPet registerPet = new RegisterPet();
        SearchPet searchPet = new SearchPet();
        //ArrayList<Pet> pets = searchPet.searchPet();

        boolean running = true;

        while (running) {
            int option = menu.printMenu();

            switch (option) {
                case 1:
                    registerPet.registerPet(); // cadastrar um novo pet
                    break;
                case 2:
                    searchPet.searchPet();
                    break;
                case 3:
                    System.out.println("Saindo do sistema...");
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }


        }

    }

}
