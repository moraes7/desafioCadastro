package src.services;

import src.model.Pet;
import src.model.PetAdress;
import src.model.PetGender;
import src.model.PetType;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class SearchPet {
    static Path pathPetCadastrados = Paths.get("src/data/pets-cadastrados");

    public ArrayList<Pet> searchPet() {
        File folder = new File(String.valueOf(pathPetCadastrados.toAbsolutePath()));
        //folder = new File(folder.getAbsolutePath());
        File[] files = folder.listFiles();

        ArrayList<Pet> petsList = new ArrayList<>();

        if (files != null) {
            System.out.println("Nenhum arquivo encontrado em: " + folder.getAbsolutePath());
            return petsList;
        }


        for (File file : files) {
            if (file.getName().endsWith(".txt")) {
                try (BufferedReader br = new BufferedReader(new FileReader(file));
                ) {
                    String name = safeReadAndSplit(br, " - ", 0);
                    String type = safeReadAndSplit(br, " - ", 0);
                    String gender = safeReadAndSplit(br, " - ", 0);
                    String adress = safeReadAndSplit(br, " - ", 0);
                    String age = safeReadAndSplit(br, " - ", 0);
                    String weight = safeReadAndSplit(br, " - ", 0);
                    String breed = safeReadAndSplit(br, " - ", 0);

                    Pet pet = new Pet();
                    PetAdress petAdress = new PetAdress();

                    String[] adressParts = adress.split(",");
                    petAdress.setPetStreet(adressParts[0].trim());
                    petAdress.setPetHouseNumber(adressParts[1].trim());
                    petAdress.setPetCity(adressParts[2].trim());

                    pet.setPetName(name);
                    pet.setPetType(PetType.valueOf(type.toUpperCase()));
                    pet.setPetGender(PetGender.valueOf(gender.toUpperCase()));
                    petAdress.setPetAdress(petAdress);
                    pet.setPetAge(age.split(" ")[0]);
                    pet.setPetWeight(weight.split("kg")[0].trim());
                    pet.setPetBreed(breed);

                    petsList.add(pet);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return petsList;
    }

    private String safeReadAndSplit(BufferedReader br, String delimiter, int index) throws IOException {
        String line = br.readLine();
        if (line == null) return "";
        String[] parts = line.split(delimiter);
        return (index < parts.length) ? parts[index].trim() : "";
    }
}


