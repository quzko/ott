package ru.ott.autotest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import ru.ott.autotest.model.ImportantFields;

import java.util.List;

import static org.testng.Assert.assertNotNull;

public class SuggestRequestOnlyImportantFields {

    @Test(description = "Проверка типа и наличия не пустых данных в ответе в зависиомсти от него", priority = 1)
    public void getCityId() {
        String json = RestAssured.get("https://www.onetwotrip.com/_hotels/api/suggestRequest?query=Москва&limit=7&locale=ru&currency=rub&lang=ru").asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement fields = parsed.getAsJsonObject().get("result");
        List<ImportantFields> listOfFields = new Gson().fromJson(fields, new TypeToken<List<ImportantFields>>(){}.getType());
        for (ImportantFields c : listOfFields) {
            if (c.getType().equals("geo")) {
                assertNotNull(c.getCountry());
                assertNotNull(c.getCity_id());
                assertNotNull(c.getIata());
                assertNotNull(c.getName());
            }
            else if(c.getType().equals("hotel")){
                assertNotNull(c.getCountry());
                assertNotNull(c.getCity_id());
                assertNotNull(c.getName());
                assertNotNull(c.getCity_name());
            }
            else if(c.getType().equals("airport")){
                assertNotNull(c.getCountry());
                assertNotNull(c.getCity_id());
                assertNotNull(c.getName());
                assertNotNull(c.getCity());
                assertNotNull(c.getIata());
            }
        }
    }
}
