package dhbw;



import com.google.gson.Gson;
import de.dhbw.me.model.Person;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonFileReadTest {

    @Test
    void readJsonFromClasspath_andAssertAllFields() throws Exception {
        InputStream in = getClass().getClassLoader().getResourceAsStream("person.json");
        assertThat(in).as("person.json muss im Test-CLASSPATH liegen").isNotNull();

        String json = new String(in.readAllBytes(), StandardCharsets.UTF_8);
        Person p = new Gson().fromJson(json, Person.class);

        assertThat(p.getFirstname()).isEqualTo("Ralf");
        assertThat(p.getLastname()).isEqualTo("Klemmer");
        assertThat(p.getStreet()).isEqualTo("Musterweg");
        assertThat(p.getNo()).isEqualTo(12);
        assertThat(p.getZip()).isEqualTo(76133);
        assertThat(p.getCity()).isEqualTo("Karlsruhe");
        assertThat(p.getHobbies()).containsExactly("Coding", "Bouldern", "Kaffee");

        assertThat(p.getCompany())
                .asInstanceOf(InstanceOfAssertFactories.type(de.dhbw.me.model.Company.class))
                .satisfies(c -> {
                    assertThat(c.getName()).isEqualTo("DHBW Solutions GmbH");
                    assertThat(c.getHeadquarter_city()).isEqualTo("Stuttgart");
                    assertThat(c.isFromKarlsruhe()).isTrue();
                });

        // toString-Separator aus Properties prüfen
        assertThat(p.toString()).contains("Ralf#Klemmer");
    }
}
