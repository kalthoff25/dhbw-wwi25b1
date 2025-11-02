package dhbw;


import com.google.gson.Gson;
import dhbw.Person;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JsonToJavaTest {

    @Test
    void parseJsonStringToJavaObject_andPrint() {
        String json = """
        {
          "firstname": "Ralf",
          "lastname": "Klemmer",
          "street": "Musterweg",
          "no": 12,
          "zip": 76133,
          "city": "Karlsruhe",
          "hobbies": ["Coding", "Bouldern", "Kaffee"],
          "company": {
            "name": "DHBW Solutions GmbH",
            "headquarter_city": "Stuttgart",
            "isFromKarlsruhe": true
          }
        }
        """;

        Person p = new Gson().fromJson(json, Person.class);

        System.out.println(p); // toString() nutzt den Separator aus application.properties

        assertThat(p.getFirstname()).isEqualTo("Ralf");
        assertThat(p.getCompany()).isNotNull();
        assertThat(p.getCompany().isFromKarlsruhe()).isTrue();
    }
}