package dhbw;

public class Company {
    private String name;
    private String headquarter_city;
    private boolean isFromKarlsruhe;

    public Company() {}

    public Company(String name, String headquarter_city, boolean isFromKarlsruhe) {
        this.name = name;
        this.headquarter_city = headquarter_city;
        this.isFromKarlsruhe = isFromKarlsruhe;
    }

    public String getName() { return name; }
    public String getHeadquarter_city() { return headquarter_city; }
    public boolean isFromKarlsruhe() { return isFromKarlsruhe; }

    public void setName(String name) { this.name = name; }
    public void setHeadquarter_city(String headquarter_city) { this.headquarter_city = headquarter_city; }
    public void setFromKarlsruhe(boolean fromKarlsruhe) { isFromKarlsruhe = fromKarlsruhe; }
}