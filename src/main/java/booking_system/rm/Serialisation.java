package booking_system.rm;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.util.ArrayList;

public class Serialisation {

    private static final ObjectMapper mapperJson = new ObjectMapper();
    private static final XmlMapper mapperXML = new XmlMapper();


    public static String serialiseToJson(ArrayList<Customer> customers) throws JsonProcessingException {
        return mapperJson.writeValueAsString(customers);
    }

    public static String serialiseToXml(ArrayList<Customer> customers) throws JsonProcessingException {
        return mapperXML.writeValueAsString(customers);
    }

    public static <T> T deserialiseFromJson(String customers, Class<T> c) throws JsonProcessingException{
        return mapperJson.readValue(customers, c);
    }

    public static <T> T deserialiseFromXml(String customers, Class<T> c) throws JsonProcessingException {
        return mapperXML.readValue(customers, c);
    }
}
