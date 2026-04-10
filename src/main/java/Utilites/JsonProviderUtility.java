package Utilites;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.FileReader;
import java.io.IOException;

public class JsonProviderUtility {

    public class JsonDataProvider {

        public static JsonArray readJsonFile(String filePath) {
            try {
                Gson gson = new Gson();
                FileReader reader = new FileReader(filePath);
                JsonArray jsonArray = gson.fromJson(reader, JsonArray.class);
                reader.close();
                return jsonArray;
            } catch (IOException e) {
                throw new RuntimeException("Failed to read JSON file: " + filePath, e);
            }
        }

        public static Object[][] getTestData(String filePath) {
            JsonArray jsonArray = readJsonFile(filePath);
            Object[][] testData = new Object[jsonArray.size()][1];

            for (int i = 0; i < jsonArray.size(); i++) {
                testData[i][0] = jsonArray.get(i).getAsJsonObject();
            }

            return testData;
        }
    }
}

