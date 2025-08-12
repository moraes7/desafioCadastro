package src.services;

import java.io.*;
import java.nio.file.*;

public class SearchPet {

    private static final Path pathCadastrar = Paths.get("src/data/pets-cadastrados");

    public void searchPet() {
        File directory = pathCadastrar.toFile();

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Nenhum pet cadastrado ainda.");
            return;
        }

        File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".txt"));

        if (files == null || files.length == 0) {
            System.out.println("Nenhum arquivo de pet encontrado.");
            return;
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
    }
}
