package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonFactory;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.format.InputAccessor;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.format.MatchStrength;
import java.io.IOException;

/* loaded from: classes5.dex */
public class MappingJsonFactory extends JsonFactory {
    private static final long serialVersionUID = -1;

    public MappingJsonFactory() {
        this(null);
    }

    public MappingJsonFactory(ObjectMapper objectMapper) {
        super(objectMapper);
        if (objectMapper == null) {
            setCodec(new ObjectMapper(this));
        }
    }

    public MappingJsonFactory(JsonFactory jsonFactory, ObjectMapper objectMapper) {
        super(jsonFactory, objectMapper);
        if (objectMapper == null) {
            setCodec(new ObjectMapper(this));
        }
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonFactory
    public final ObjectMapper getCodec() {
        return (ObjectMapper) this._objectCodec;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonFactory
    public JsonFactory copy() {
        _checkInvalidCopy(MappingJsonFactory.class);
        return new MappingJsonFactory(this, null);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonFactory
    public String getFormatName() {
        return "JSON";
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonFactory
    public MatchStrength hasFormat(InputAccessor inputAccessor) throws IOException {
        if (getClass() == MappingJsonFactory.class) {
            return hasJSONFormat(inputAccessor);
        }
        return null;
    }
}
