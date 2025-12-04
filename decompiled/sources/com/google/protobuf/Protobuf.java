package com.google.protobuf;

import com.google.firebase.messaging.Constants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes4.dex */
final class Protobuf {
    private static final Protobuf INSTANCE = new Protobuf();
    private final ConcurrentMap schemaCache = new ConcurrentHashMap();
    private final SchemaFactory schemaFactory = new ManifestSchemaFactory();

    public static Protobuf getInstance() {
        return INSTANCE;
    }

    public Schema schemaFor(Class cls) {
        Internal.checkNotNull(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        Schema schema = (Schema) this.schemaCache.get(cls);
        if (schema != null) {
            return schema;
        }
        Schema schemaCreateSchema = this.schemaFactory.createSchema(cls);
        Schema schemaRegisterSchema = registerSchema(cls, schemaCreateSchema);
        return schemaRegisterSchema != null ? schemaRegisterSchema : schemaCreateSchema;
    }

    public Schema schemaFor(Object obj) {
        return schemaFor((Class) obj.getClass());
    }

    public Schema registerSchema(Class cls, Schema schema) {
        Internal.checkNotNull(cls, Constants.FirelogAnalytics.PARAM_MESSAGE_TYPE);
        Internal.checkNotNull(schema, "schema");
        return (Schema) this.schemaCache.putIfAbsent(cls, schema);
    }

    private Protobuf() {
    }
}
