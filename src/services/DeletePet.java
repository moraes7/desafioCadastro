package src.services;

import src.model.Pet;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class DeletePet {
    static Path pathPetCadastrados = Paths.get("src/data/pets-cadastrados");

    public void deletePet() {
        System.out.println("=== LISTA DE PETS CADASTRADOS ====");
        SearchPet searchPet = new SearchPet();
        ArrayList<Pet> pets = searchPet.searchPet();
        Scanner scanner = new Scanner(System.in);

        /*if (pets.isEmpty()) {
            System.out.println("Nenhum pet cadastrado.");
            return;
        }*/

        System.out.print("Digite o ID do pet que deseja excluir: ");
        String petID = scanner.nextLine().trim();

        File directory = pathPetCadastrados.toFile();
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Diretório não encontrado.");
            return;
        }

        File[] files = directory.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("Nenhum pet cadastrado.");
            return;
        }

        boolean deleted = false;
        for (File file : files) {
            String fileName = file.getName();
            String fileID = fileName.split(" - ")[0];
            if (fileID.equals(petID)) {
                if (file.delete()) {
                    System.out.println("Pet com ID "+petID+" deletado com sucesso!");
                    deleted = true;
                } else {
                    System.out.println("Falha ao deleter o pet com o ID "+petID);
                }
                break;
            }
        }
        if (!deleted) {
            System.out.println("Nenhum pet encontrado com o ID informado.");
        }

    }
}
