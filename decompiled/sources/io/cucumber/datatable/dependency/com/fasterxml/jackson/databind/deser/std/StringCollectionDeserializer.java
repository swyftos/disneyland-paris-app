package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.std;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonToken;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationContext;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationFeature;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonDeserializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.NullValueProvider;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.ValueInstantiator;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import java.io.IOException;
import java.util.Collection;

@JacksonStdImpl
/* loaded from: classes5.dex */
public final class StringCollectionDeserializer extends ContainerDeserializerBase<Collection<String>> implements ContextualDeserializer {
    private static final long serialVersionUID = 1;
    protected final JsonDeserializer<Object> _delegateDeserializer;
    protected final JsonDeserializer<String> _valueDeserializer;
    protected final ValueInstantiator _valueInstantiator;

    public StringCollectionDeserializer(JavaType javaType, JsonDeserializer<?> jsonDeserializer, ValueInstantiator valueInstantiator) {
        this(javaType, valueInstantiator, null, jsonDeserializer, jsonDeserializer, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected StringCollectionDeserializer(JavaType javaType, ValueInstantiator valueInstantiator, JsonDeserializer<?> jsonDeserializer, JsonDeserializer<?> jsonDeserializer2, NullValueProvider nullValueProvider, Boolean bool) {
        super(javaType, nullValueProvider, bool);
        this._valueDeserializer = jsonDeserializer2;
        this._valueInstantiator = valueInstantiator;
        this._delegateDeserializer = jsonDeserializer;
    }

    protected StringCollectionDeserializer withResolved(JsonDeserializer<?> jsonDeserializer, JsonDeserializer<?> jsonDeserializer2, NullValueProvider nullValueProvider, Boolean bool) {
        return (this._unwrapSingle == bool && this._nullProvider == nullValueProvider && this._valueDeserializer == jsonDeserializer2 && this._delegateDeserializer == jsonDeserializer) ? this : new StringCollectionDeserializer(this._containerType, this._valueInstantiator, jsonDeserializer, jsonDeserializer2, nullValueProvider, bool);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonDeserializer
    public boolean isCachable() {
        return this._valueDeserializer == null && this._delegateDeserializer == null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0031  */
    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.ContextualDeserializer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonDeserializer<?> createContextual(io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationContext r6, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.BeanProperty r7) throws io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonMappingException {
        /*
            r5 = this;
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.ValueInstantiator r0 = r5._valueInstantiator
            r1 = 0
            if (r0 == 0) goto L31
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotatedWithParams r0 = r0.getArrayDelegateCreator()
            if (r0 == 0) goto L1a
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.ValueInstantiator r0 = r5._valueInstantiator
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationConfig r2 = r6.getConfig()
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType r0 = r0.getArrayDelegateType(r2)
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonDeserializer r0 = r5.findDeserializer(r6, r0, r7)
            goto L32
        L1a:
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.ValueInstantiator r0 = r5._valueInstantiator
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotatedWithParams r0 = r0.getDelegateCreator()
            if (r0 == 0) goto L31
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.ValueInstantiator r0 = r5._valueInstantiator
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationConfig r2 = r6.getConfig()
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType r0 = r0.getDelegateType(r2)
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonDeserializer r0 = r5.findDeserializer(r6, r0, r7)
            goto L32
        L31:
            r0 = r1
        L32:
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonDeserializer<java.lang.String> r2 = r5._valueDeserializer
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType r3 = r5._containerType
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType r3 = r3.getContentType()
            if (r2 != 0) goto L47
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonDeserializer r2 = r5.findConvertingContentDeserializer(r6, r7, r2)
            if (r2 != 0) goto L4b
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonDeserializer r2 = r6.findContextualValueDeserializer(r3, r7)
            goto L4b
        L47:
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonDeserializer r2 = r6.handleSecondaryContextualization(r2, r7, r3)
        L4b:
            java.lang.Class<java.util.Collection> r3 = java.util.Collection.class
            io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonFormat$Feature r4 = io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY
            java.lang.Boolean r3 = r5.findFormatFeature(r6, r7, r3, r4)
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.NullValueProvider r6 = r5.findContentNullProvider(r6, r7, r2)
            boolean r7 = r5.isDefaultDeserializer(r2)
            if (r7 == 0) goto L5e
            goto L5f
        L5e:
            r1 = r2
        L5f:
            io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer r5 = r5.withResolved(r0, r1, r6, r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.std.StringCollectionDeserializer.createContextual(io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationContext, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.BeanProperty):io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonDeserializer");
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public JsonDeserializer<Object> getContentDeserializer() {
        return this._valueDeserializer;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.ValueInstantiator.Gettable
    public ValueInstantiator getValueInstantiator() {
        return this._valueInstantiator;
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonDeserializer
    public Collection<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonDeserializer<Object> jsonDeserializer = this._delegateDeserializer;
        if (jsonDeserializer != null) {
            return (Collection) this._valueInstantiator.createUsingDelegate(deserializationContext, jsonDeserializer.deserialize(jsonParser, deserializationContext));
        }
        return deserialize(jsonParser, deserializationContext, (Collection<String>) this._valueInstantiator.createUsingDefault(deserializationContext));
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonDeserializer
    public Collection<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<String> collection) throws IOException {
        String str_parseString;
        if (!jsonParser.isExpectedStartArrayToken()) {
            return handleNonArray(jsonParser, deserializationContext, collection);
        }
        JsonDeserializer<String> jsonDeserializer = this._valueDeserializer;
        if (jsonDeserializer != null) {
            return deserializeUsingCustom(jsonParser, deserializationContext, collection, jsonDeserializer);
        }
        while (true) {
            try {
                String strNextTextValue = jsonParser.nextTextValue();
                if (strNextTextValue != null) {
                    collection.add(strNextTextValue);
                } else {
                    JsonToken currentToken = jsonParser.getCurrentToken();
                    if (currentToken == JsonToken.END_ARRAY) {
                        return collection;
                    }
                    if (currentToken == JsonToken.VALUE_NULL) {
                        if (!this._skipNullValues) {
                            str_parseString = (String) this._nullProvider.getNullValue(deserializationContext);
                        }
                    } else {
                        str_parseString = _parseString(jsonParser, deserializationContext);
                    }
                    collection.add(str_parseString);
                }
            } catch (Exception e) {
                throw JsonMappingException.wrapWithPath(e, collection, collection.size());
            }
        }
    }

    private Collection deserializeUsingCustom(JsonParser jsonParser, DeserializationContext deserializationContext, Collection collection, JsonDeserializer jsonDeserializer) throws IOException {
        Object objDeserialize;
        while (true) {
            if (jsonParser.nextTextValue() == null) {
                JsonToken currentToken = jsonParser.getCurrentToken();
                if (currentToken == JsonToken.END_ARRAY) {
                    return collection;
                }
                if (currentToken == JsonToken.VALUE_NULL) {
                    if (!this._skipNullValues) {
                        objDeserialize = this._nullProvider.getNullValue(deserializationContext);
                    }
                } else {
                    objDeserialize = jsonDeserializer.deserialize(jsonParser, deserializationContext);
                }
            } else {
                objDeserialize = jsonDeserializer.deserialize(jsonParser, deserializationContext);
            }
            collection.add((String) objDeserialize);
        }
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.std.StdDeserializer, io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonDeserializer
    public Object deserializeWithType(JsonParser jsonParser, DeserializationContext deserializationContext, TypeDeserializer typeDeserializer) throws IOException {
        return typeDeserializer.deserializeTypedFromArray(jsonParser, deserializationContext);
    }

    private final Collection handleNonArray(JsonParser jsonParser, DeserializationContext deserializationContext, Collection collection) {
        String str_parseString;
        Boolean bool = this._unwrapSingle;
        if (bool != Boolean.TRUE && (bool != null || !deserializationContext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            return (Collection) deserializationContext.handleUnexpectedToken(this._containerType.getRawClass(), jsonParser);
        }
        JsonDeserializer<String> jsonDeserializer = this._valueDeserializer;
        if (jsonParser.getCurrentToken() == JsonToken.VALUE_NULL) {
            if (this._skipNullValues) {
                return collection;
            }
            str_parseString = (String) this._nullProvider.getNullValue(deserializationContext);
        } else {
            str_parseString = jsonDeserializer == null ? _parseString(jsonParser, deserializationContext) : jsonDeserializer.deserialize(jsonParser, deserializationContext);
        }
        collection.add(str_parseString);
        return collection;
    }
}
