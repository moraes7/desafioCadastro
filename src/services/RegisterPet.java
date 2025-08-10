package src.services;

import src.model.Pet;
import src.model.PetAdress;
import src.model.PetGender;
import src.model.PetType;
import src.repository.FileRepository;
import java.util.Scanner;

public class RegisterPet {
    public void registerPet() {
        Scanner scanner = new Scanner(System.in);
        Pet pet = new Pet();
        PetAdress petAdress = new PetAdress();

        // nome e sobrenome
        FileRepository.readSpecifyLineFile(1);
        pet.setPetName(scanner.nextLine());

        // tipo do animal
        FileRepository.readSpecifyLineFile(2);
        System.out.println("1 = Cachorro | 2 = Gato: ");
        int type = scanner.nextInt();
        scanner.nextLine();
        pet.setPetType(type == 1 ? PetType.CACHORRO : PetType.GATO);

        // genero
        FileRepository.readSpecifyLineFile(3);
        System.out.print("1 = Macho | 2 = Fêmea: ");
        int gender = scanner.nextInt();
        scanner.nextLine();
        pet.setPetGender(gender == 1 ? PetGender.MACHO : PetGender.FEMEA);

        // endereço
        FileRepository.readSpecifyLineFile(4);
        System.out.print("Rua: ");
        petAdress.setPetStreet(scanner.nextLine());
        System.out.print("Número: ");
        petAdress.setPetHouseNumber(scanner.nextLine());
        System.out.print("Cidade: ");
        petAdress.setPetCity(scanner.nextLine());
        pet.setPetAdress(petAdress);

        // idade aproximada
        FileRepository.readSpecifyLineFile(5);
        pet.setPetAge(scanner.nextLine());

        // peso aproximado
        FileRepository.readSpecifyLineFile(6);
        pet.setPetWeight(scanner.nextLine());

        // raça
        FileRepository.readSpecifyLineFile(7);
        pet.setPetBreed(scanner.nextLine());

    }
}
