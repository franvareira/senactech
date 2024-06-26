package Framework.Utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakersGeneration {
    
    private Faker faker;
    private String firstName;
    private String lastName;
    private String zipCode;
    
    public FakersGeneration() {
        
        faker = new Faker(new Locale("pt-BR"));
    }
    
    public String getFirstName() {
        
       firstName = faker.name().firstName();
       return firstName;
       
       //return faker.name().firstName();
       
    }
    
    public String getLastName() {
        
        lastName = faker.name().lastName();
        return lastName;
    }
    
    public String getZipCode() {
        
        zipCode = faker.address().zipCode();
        return zipCode;
        
    }
    
    
    
}
