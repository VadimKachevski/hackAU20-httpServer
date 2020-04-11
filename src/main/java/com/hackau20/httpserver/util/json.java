package com.hackau20.httpserver.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

public class json {
    private static ObjectMapper myObjectMapper = defaultObjectMapper();

    private static ObjectMapper defaultObjectMapper()
    {
        ObjectMapper om = new ObjectMapper();
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        return om;
    }
    public static JsonNode parse(String jsonSrc) throws JsonProcessingException {
        return myObjectMapper.readTree(jsonSrc);
    }
    public static <A> A fromJson(JsonNode node,Class<A> aClass) throws JsonProcessingException {
        return myObjectMapper.treeToValue(node,aClass);
    }

    public static JsonNode toJson(Object obj)
    {
        return myObjectMapper.valueToTree(obj);
    }
    public static String stringJsonUgly(JsonNode node) throws JsonProcessingException {
        return  generateJson(node,false);
    }
    public static String stringJsonPretty(JsonNode node) throws JsonProcessingException {
        return  generateJson(node,true);
    }
    private static String generateJson(Object o,boolean pretty) throws JsonProcessingException {
        ObjectWriter OW = myObjectMapper.writer();
        if(pretty)
        {
            OW = OW.with(SerializationFeature.INDENT_OUTPUT);
        }
      return  OW.writeValueAsString(o);
    }


}
