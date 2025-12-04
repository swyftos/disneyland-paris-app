package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.std;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonLocation;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationConfig;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationContext;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.PropertyMetadata;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.PropertyName;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.CreatorProperty;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.ValueInstantiator;

/* loaded from: classes5.dex */
public class JsonLocationInstantiator extends ValueInstantiator.Base {
    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.ValueInstantiator
    public boolean canCreateFromObjectWith() {
        return true;
    }

    public JsonLocationInstantiator() {
        super((Class<?>) JsonLocation.class);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.ValueInstantiator
    public SettableBeanProperty[] getFromObjectArguments(DeserializationConfig deserializationConfig) {
        JavaType javaTypeConstructType = deserializationConfig.constructType(Integer.TYPE);
        JavaType javaTypeConstructType2 = deserializationConfig.constructType(Long.TYPE);
        return new SettableBeanProperty[]{creatorProp("sourceRef", deserializationConfig.constructType(Object.class), 0), creatorProp("byteOffset", javaTypeConstructType2, 1), creatorProp("charOffset", javaTypeConstructType2, 2), creatorProp("lineNr", javaTypeConstructType, 3), creatorProp("columnNr", javaTypeConstructType, 4)};
    }

    private static CreatorProperty creatorProp(String str, JavaType javaType, int i) {
        return new CreatorProperty(PropertyName.construct(str), javaType, null, null, null, null, i, null, PropertyMetadata.STD_REQUIRED);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.ValueInstantiator
    public Object createFromObjectWith(DeserializationContext deserializationContext, Object[] objArr) {
        return new JsonLocation(objArr[0], _long(objArr[1]), _long(objArr[2]), _int(objArr[3]), _int(objArr[4]));
    }

    private static final long _long(Object obj) {
        if (obj == null) {
            return 0L;
        }
        return ((Number) obj).longValue();
    }

    private static final int _int(Object obj) {
        if (obj == null) {
            return 0;
        }
        return ((Number) obj).intValue();
    }
}
