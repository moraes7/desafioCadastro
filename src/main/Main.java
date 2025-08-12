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
        int option = menu.printMenu();
        RegisterPet registerPet = new RegisterPet();
        SearchPet searchPet = new SearchPet();
        //ArrayList<Pet> pets = searchPet.searchPet();

        do {
            if (option == 1) {
                registerPet.registerPet();
            }
            if (option == 2) {
                searchPet.searchPet();
            }
           option = menu.printMenu();

        } while (option != 6);
        }

}
