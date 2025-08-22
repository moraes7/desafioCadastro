package src.services;

import src.model.Pet;
import src.repository.FileDelete;
import src.utils.ValidateUtils;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class EditPet {

    private static final Path pathPetCadastrados = Paths.get("src/data/pets-cadastrados");

    public void editPet() {
        System.out.println("=== LISTA DE PETS CADASTRADOS ====");
        SearchPet searchPet = new SearchPet();
        ArrayList<Pet> listPets = searchPet.searchPet();
        /*if(listPets.isEmpty()) {
            System.out.println("Nenhum pet encontrado.");
            return;
        }*/

        Scanner scanner = new Scanner(System.in);
        ValidateUtils validateUtils = new ValidateUtils();
        FileDelete fileDelete = new FileDelete();

        searchPet.searchPet();
        System.out.print("Digite o número do pet que deseja editar: ");
        int petNumber = validateUtils.readValidNum(scanner);

        if (petNumber < 1 || petNumber > listPets.size()) {
            System.out.println("Número inválido! Tente novamente");
            editPet();
        }

        Pet petSelecionado = listPets.get(petNumber - 1);
        String oldPetName = petSelecionado.getPetName();

        System.out.println("Editando o nome do pet: "+petSelecionado.getPetName());

        System.out.println("Novo nome: ");
        System.out.println("(ou pressione Enter para manter o nome)");
        String newPetName = scanner.nextLine();

        if (newPetName.isBlank()) {
            System.out.println("Nome mantido: "+petSelecionado.getPetName());
        } else {
            petSelecionado.setPetName(newPetName);
            System.out.println("Nome atualizado para: "+newPetName);
        }

        System.out.println("Novo endereço (Rua, Número da Casa, Cidade)");
        System.out.println("Pressione Enter para manter o mesmo endereço");
        String newPetAddress = scanner.nextLine();
        if (!newPetAddress.isBlank()) {
            String[] address = newPetAddress.split(",");
            petSelecionado.getPetAddress().setPetStreet(address[0].trim());
            petSelecionado.getPetAddress().setPetHouseNumber(address[1].trim());
            petSelecionado.getPetAddress().setPetCity(address[2].trim());
        }

        System.out.println("Nova idade (anos):");
        System.out.println("Pressione Enter para manter a mesma idade");
        String newPetAge = validateUtils.readValidAge(scanner);
        if (newPetAge.isBlank()) {
            System.out.println("Idade mantida: "+petSelecionado.getPetAge()+" anos");
        } else {
            petSelecionado.setPetAge(newPetAge);
            System.out.println("Idade do pet atualizada: "+newPetAge+" anos");
        }

        System.out.println("Novo peso: ");
        System.out.println("Pressione Enter para manter o mesmo peso");
        String newPetWeight = validateUtils.readValidWeight(scanner);
        if (newPetWeight.isBlank()) {
            System.out.println("Peso mantido: "+petSelecionado.getPetWeight()+" kg");
        } else {
            petSelecionado.setPetWeight(newPetWeight);
            System.out.println("Peso do pet atualizado: "+newPetWeight+" kg");
        }

        System.out.println("Mudar a raça: ");
        System.out.println("Pressione Enter para manter a mesma raça");
        String newPetBreed = scanner.nextLine();
        if (newPetBreed.isBlank()) {
            System.out.println("Raça do pet mantida: "+petSelecionado.getPetBreed());
        } else {
            petSelecionado.setPetBreed(newPetBreed);
            System.out.println("Raça atualizada: "+newPetBreed);
        }

        System.out.println("Pet atualizado com sucesso!");

        fileDelete.deletarArquivoAntigo(oldPetName);
        System.out.println(oldPetName);

        String nomeFormatado = petSelecionado.getPetName().replace(" ", "").toUpperCase();

        LocalDateTime dateNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        String dataHoraFormatada = dateNow.format(formatter);

        String nomeArquivo = dataHoraFormatada+" - "+nomeFormatado+".txt";

        File directory = new File(String.valueOf(pathPetCadastrados.toAbsolutePath()));
        File file = new File(directory, nomeFormatado);
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Diretório criado com sucesso!");
            } else {
                System.out.println("Falha ao criar o diretório");
            }
        }

    }
}
