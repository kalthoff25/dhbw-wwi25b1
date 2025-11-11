package de.dhbw.me.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class Person {
    private String firstname;
    private String lastname;
    private String street;
    private int no;
    private int zip;
    private String city;
    private List<String> hobbies;
    private Company company;

    public Person() {}

    public Person(String firstname, String lastname, String street, int no, int zip,
                  String city, List<String> hobbies, Company company) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.street = street;
        this.no = no;
        this.zip = zip;
        this.city = city;
        this.hobbies = hobbies;
        this.company = company;
    }

    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getStreet() { return street; }
    public int getNo() { return no; }
    public int getZip() { return zip; }
    public String getCity() { return city; }
    public List<String> getHobbies() { return hobbies; }
    public Company getCompany() { return company; }

    public void setFirstname(String firstname) { this.firstname = firstname; }
    public void setLastname(String lastname) { this.lastname = lastname; }
    public void setStreet(String street) { this.street = street; }
    public void setNo(int no) { this.no = no; }
    public void setZip(int zip) { this.zip = zip; }
    public void setCity(String city) { this.city = city; }
    public void setHobbies(List<String> hobbies) { this.hobbies = hobbies; }
    public void setCompany(Company company) { this.company = company; }

    @Override
    public String toString() {
        String sep = "#"; // Default, falls Property fehlt
        try (InputStream in = Person.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (in != null) {
                Properties p = new Properties();
                p.load(in);
                String configured = p.getProperty("toString.separator");
                if (configured != null && !configured.isBlank()) {
                    sep = configured.trim();
                }
            }
        } catch (IOException ignored) {}

        return String.join(sep,
                ns(firstname),
                ns(lastname),
                ns(street),
                String.valueOf(no),
                String.valueOf(zip),
                ns(city),
                (hobbies == null ? "" : String.join(",", hobbies)),
                (company == null ? "" : ns(company.getName())),
                (company == null ? "" : ns(company.getHeadquarter_city())),
                (company == null ? "" : String.valueOf(company.isFromKarlsruhe()))
        );
    }

    private String ns(String s) { return Objects.toString(s, ""); }
}