package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.module;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.BeanDescription;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationConfig;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.KeyDeserializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.KeyDeserializers;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type.ClassKey;
import java.io.Serializable;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class SimpleKeyDeserializers implements KeyDeserializers, Serializable {
    private static final long serialVersionUID = 1;
    protected HashMap<ClassKey, KeyDeserializer> _classMappings = null;

    public SimpleKeyDeserializers addDeserializer(Class<?> cls, KeyDeserializer keyDeserializer) {
        if (this._classMappings == null) {
            this._classMappings = new HashMap<>();
        }
        this._classMappings.put(new ClassKey(cls), keyDeserializer);
        return this;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.KeyDeserializers
    public KeyDeserializer findKeyDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription) {
        HashMap<ClassKey, KeyDeserializer> map = this._classMappings;
        if (map == null) {
            return null;
        }
        return map.get(new ClassKey(javaType.getRawClass()));
    }
}
