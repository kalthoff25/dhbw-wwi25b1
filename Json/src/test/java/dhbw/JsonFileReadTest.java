package dhbw;

import com.google.gson.Gson;
import de.dhbw.me.model.Person;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonFileReadTest {

    @Test
    void readJsonFromClasspath_andAssertAllFields() {
        InputStream in = getClass().getClassLoader().getResourceAsStream("person.json");
        assertThat(in).isNotNull();

        Person p = new Gson().fromJson(new InputStreamReader(in), Person.class);
        assertThat(p).isNotNull();

        // --- Person-Attribute ---
        assertThat(p.getFirstname()).isEqualTo("Kevin");
        assertThat(p.getLastname()).isEqualTo("Althoff");
        assertThat(p.getStreet()).isEqualTo("Wesetalstr.");
        assertThat(p.getNo()).isEqualTo(39);
        assertThat(p.getZip()).isEqualTo(34549);
        assertThat(p.getCity()).isEqualTo("Edertal");
        assertThat(p.getHobbies()).containsExactly("SKI", "Fußball", "Matcha");

        // --- Company-Attribute ---
        assertThat(p.getCompany()).isNotNull();
        assertThat(p.getCompany().getName()).isEqualTo("United Internet");
        assertThat(p.getCompany().getHeadquarter_city()).isEqualTo("Karlsruhe");
        assertThat(p.getCompany().isFromKarlsruhe()).isTrue();

        // --- Optional: Check der toString()-Methode ---
        assertThat(p.toString()).contains("Kevin#Althoff");
    }
}