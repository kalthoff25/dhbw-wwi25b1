package dhbw;



import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import de.dhbw.me.model.Company;
import de.dhbw.me.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JavaToJsonTest {

    @Test
    void serializeJavaObjectToJson_andPrint() {
        Person p = new Person(
                "Mia", "Mustermann",
                "Hauptstraße", 5, 70173, "Stuttgart",
                List.of("Lesen", "Joggen"),
                new Company("ACME GmbH", "Karlsruhe", false)
        );

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(p);

        System.out.println(json);
    }
}