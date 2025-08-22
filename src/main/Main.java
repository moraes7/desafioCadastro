package src.main;

import src.repository.FileRepository;
import src.services.*;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        FileRepository fileRepository = new FileRepository();
        fileRepository.createFile();
        fileRepository.readFile();
        RegisterPet registerPet = new RegisterPet();
        SearchPet searchPet = new SearchPet();
        EditPet editPet = new EditPet();
        DeletePet deletePet = new DeletePet();

        boolean running = true;

        while (running) {
            int option = menu.printMenu();

            switch (option) {
                case 1:
                    registerPet.registerPet(); // cadastrar um novo pet
                    break;
                case 2:
                    editPet.editPet();
                    break;
                case 3:
                    deletePet.deletePet();
                    break;
                case 4:
                    searchPet.searchPet(); // listar todos os pets cadastrados
                    break;
                case 5:
                    // listar pets por algum critério
                    break;
                case 6:
                    System.out.println("Saindo do sistema...");
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }


        }

    }

}
