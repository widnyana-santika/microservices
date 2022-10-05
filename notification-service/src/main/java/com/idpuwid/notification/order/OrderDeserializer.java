package com.idpuwid.notification.order;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

public class OrderDeserializer implements Deserializer {

    @Override
    public Object deserialize(String s, byte[] arg) {
        ObjectMapper mapper = new ObjectMapper();
        OrderDTO user = null;
        try {
            user = mapper.readValue(arg, OrderDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
