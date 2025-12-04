package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind;

import java.io.IOException;

/* loaded from: classes5.dex */
public abstract class KeyDeserializer {

    public static abstract class None extends KeyDeserializer {
    }

    public abstract Object deserializeKey(String str, DeserializationContext deserializationContext) throws IOException;
}
