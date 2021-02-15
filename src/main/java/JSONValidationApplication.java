import com.google.gson.JsonObject;
import jsonvalidator.JSONValidator;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

public class JSONValidationApplication {

    public static void main(String[] args) throws FileNotFoundException {

        File jsonObjectFile = new File("JSON samples/JSON_Sample.json");
        InputStream jsonObjectInputStream = new FileInputStream(jsonObjectFile);

        File jsonSchemaFile = new File("JSON samples/JSON_Sample_Schema.json");
        InputStream jsonSchemaInputStream = new FileInputStream(jsonSchemaFile);

        JSONValidator jsonValidator = new JSONValidator(jsonSchemaInputStream, jsonObjectInputStream);
        jsonValidator.printValidationResults();

        System.out.println("Validation Success");
    }
}
