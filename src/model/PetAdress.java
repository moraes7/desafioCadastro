package src.model;

public class PetAdress extends Pet{
    private String petStreet;
    private String petHouseNumber;
    private String petCity;


    @Override
    public String toString() {
        return "PetAdress{" +
                "petStreet='" + petStreet + '\'' +
                ", petHouseNumber='" + petHouseNumber + '\'' +
                ", petCity='" + petCity + '\'' +
                '}';
    }

    /*public String listAdress() {
        //return "Rua: "+this.petStreet+"\n"+"Número da casa: "+this.petHouseNumber+"\n"+"Cidade: "+this.petCity;
    }*/

    public String getPetHouseNumber() {
        return petHouseNumber;
    }

    public void setPetHouseNumber(String petHouseNumber) {
        this.petHouseNumber = petHouseNumber;
    }

    public String getPetCity() {
        return petCity;
    }

    public void setPetCity(String petCity) {
        this.petCity = petCity;
    }

    public String getPetStreet() {
        return petStreet;
    }

    public void setPetStreet(String petStreet) {
        this.petStreet = petStreet;
    }
}
