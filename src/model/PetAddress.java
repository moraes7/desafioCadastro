package src.model;

public class PetAddress extends Pet{
    private String petStreet;
    private String petHouseNumber;
    private String petCity;

    @Override
    public String toString() {
        return "PetAddress{" +
                "petStreet='" + petStreet + '\'' +
                ", petHouseNumber='" + petHouseNumber + '\'' +
                ", petCity='" + petCity + '\'' +
                '}';
    }

    public String getPetStreet() {
        return petStreet;
    }

    public void setPetStreet(String petStreet) {
        this.petStreet = petStreet;
    }

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
}
