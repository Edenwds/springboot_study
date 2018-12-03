package com.example.redis.serialize;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import static org.springframework.util.ObjectUtils.isEmpty;

public class ObjectSerializer implements RedisSerializer<Object> {
    private Converter<Object,byte[]> serializer = new SerializingConverter();
    private Converter<byte[],Object> deserializer = new DeserializingConverter();

    static final byte[] EMPTY_APPAY = new byte[0];

    @Override
    public byte[] serialize(Object o) throws SerializationException {
        if(o == null){
            return EMPTY_APPAY;
        }
        return serializer.convert(o);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if(isEmpty(bytes)){
            return null;
        }
        return deserializer.convert(bytes);
    }


}
