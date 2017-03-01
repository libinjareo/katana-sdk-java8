package com.katana.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.katana.sdk.common.Serializer;
import org.msgpack.jackson.dataformat.MessagePackFactory;

import java.io.IOException;

/**
 * Created by juan on 25/09/16.
 */
public class MessagePackSerializer implements Serializer {

    private ObjectMapper msgPackMapper = new ObjectMapper(new MessagePackFactory());
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * @param message
     * @param aClass
     * @param <T>
     * @return
     */
    @Override
    public <T> T deserialize(byte[] message, Class<T> aClass) throws IOException {
        return msgPackMapper.readValue(message, aClass);
    }

    @Override
    public <T> T deserialize(String jsonMessage, Class<T> aClass) throws IOException {
        return objectMapper.readValue(jsonMessage, aClass);
    }

    /**
     * @param message
     * @return
     */
    @Override
    public byte[] serializeInBytes(Object message) throws JsonProcessingException {
        msgPackMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return msgPackMapper.writeValueAsBytes(message);
    }

    @Override
    public String serializeInJson(Object message) throws JsonProcessingException {
        return objectMapper.writeValueAsString(message);
    }

}
