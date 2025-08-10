package src.model;


public class Pet {
    private String petName;
    private PetType petType;
    private PetGender petGender;
    private PetAdress petAdress;
    private String petAge;
    private String petWeight;
    private String petBreed;

    public static final String NAO_INFORMADO = "Não informado";

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
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

    public PetAdress getPetAdress() {
        return petAdress;
    }

    public void setPetAdress(PetAdress petAdress) {
        this.petAdress = petAdress;
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
}
