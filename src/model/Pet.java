package src.model;

import src.services.SearchPet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pet {
    private String petID;
    private String petName;
    private PetType petType;
    private PetGender petGender;
    private PetAddress petAddress;
    private String petAge;
    private String petWeight;
    private String petBreed;

    private static int contadorID = 1;

    public static final String NAO_INFORMADO = "Não informado";

    public String getPetID() {
        this.petID = String.valueOf(contadorID++);
        return petID;
    }

    public void setPetID(String petID) {
        this.petID = petID;
    }

    public static Path getPathCadastrar() {
        return pathCadastrar;
    }

    public static void setPathCadastrar(Path pathCadastrar) {
        Pet.pathCadastrar = pathCadastrar;
    }

    public String getPetName() {
        return petName;
    }

    public String setPetName(String petName) {
        this.petName = petName;
        return petName;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public PetGender getPetGender() {
        return petGender;
    }

    public void setPetGender(PetGender petGender) {
        this.petGender = petGender;
    }

    public PetAddress getPetAddress() {
        return petAddress;
    }

    public void setPetAddress(PetAddress petAddress) {
        this.petAddress = petAddress;
    }

    public String getPetAge() {
        return petAge;
    }

    public void setPetAge(String petAge) {
        this.petAge = petAge;
    }

    public String getPetWeight() {
        return petWeight;
    }

    public void setPetWeight(String petWeight) {
        this.petWeight = petWeight;
    }

    public String getPetBreed() {
        return petBreed;
    }

    public void setPetBreed(String petBreed) {
        this.petBreed = petBreed;
    }

    static Path pathCadastrar = Paths.get("src/data/pets-cadastrados");

    public void savePetFile() {
        String formattedID = getPetID();
        String formattedName = getPetName().replace(" ", "").toUpperCase();
        SearchPet searchPet = new SearchPet();
        LocalDateTime dateNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String dateTimeFormatter = dateNow.format(formatter);

        String fileName = formattedID+" - "+dateTimeFormatter+" - "+formattedName+".txt";

        File directory = new File(String.valueOf(pathCadastrar.toAbsolutePath()));
        File file = new File(directory, fileName);
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Diretório criado com sucesso!");
            } else {
                System.out.println("Falha ao criar o diretório");
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            bw.write("1 - "+getPetName());
            bw.newLine();
            bw.write("2 - "+getPetType());
            bw.newLine();
            bw.write("3 - "+getPetGender());
            bw.newLine();
            bw.write("4 - "+getPetAddress().getPetStreet()+", "+getPetAddress().getPetHouseNumber()+", "+getPetAddress().getPetCity());
            bw.newLine();
            bw.write("5 - "+getPetAge()+" anos");
            bw.newLine();
            bw.write("6 - "+getPetWeight()+" kg");
            bw.newLine();
            bw.write("7 - "+ getPetBreed());
            bw.flush();
        } catch (IOException e) {
            System.out.println("Erro ao criar ou escrever no arquivo: "+e.getMessage());
        }

        System.out.println("Pet salvo com sucesso!");
        searchPet.searchPet();
    }
}
