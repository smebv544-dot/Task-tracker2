import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;

import java.util.*;

public class JsonOperations {
    private static ObjectMapper object1 = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    private static final File file = new File("mytasks.json");
    private static TypeReference<List<task>> ref = new TypeReference<List<task>>() {
    };

    public static List<task> loadList() throws StreamReadException, DatabindException, IOException {
        if (!file.exists()) {
            return new ArrayList<>();
        }
        List<task> tk2 = object1.readValue(file, ref);
        return tk2;
    }

    public static void saveList(List<task> lt) throws StreamWriteException, DatabindException, IOException {
        object1.writeValue(file, lt);
    }
}