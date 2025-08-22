package src.services;

import src.model.Pet;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class SearchPet {

    private static final Path pathPetCadastrados = Paths.get("src/data/pets-cadastrados");

    public ArrayList<Pet> searchPet() {
        ArrayList<Pet> petList = new ArrayList<>();
        File directory = pathPetCadastrados.toFile();

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Nenhum pet cadastrado ainda.");
            return petList;
        }

        File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("Nenhum arquivo de pet encontrado.");
            return petList;
        }

        for (File file : files) {
            System.out.println("\nArquivo: " + file.getName());
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            }
        }
        return petList;
    }
}