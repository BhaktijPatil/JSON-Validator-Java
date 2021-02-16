package jsonvalidator;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class JSONValidator {
    JSONObject jsonSchema;
    JSONObject jsonObject;

    public JSONValidator(InputStream jsonSchemaInputStream, InputStream jsonObjectInputStream) {
        this.jsonSchema = new JSONObject(new JSONTokener(jsonSchemaInputStream));
        this.jsonObject = new JSONObject(new JSONTokener(jsonObjectInputStream));
    }

    public void printValidationResults() {
        try {
            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonObject);
        } catch (ValidationException validationException) {
            printCausingExceptions(validationException);
        }
    }

    private void printCausingExceptions(ValidationException validationException)
    {
        if(validationException.getCausingExceptions().size() != 0)
            for (ValidationException exception : validationException.getCausingExceptions())
            {
                printCausingExceptions(exception);
            }
        else
        {
            System.out.println(validationException.getMessage());
        }
    }
}
