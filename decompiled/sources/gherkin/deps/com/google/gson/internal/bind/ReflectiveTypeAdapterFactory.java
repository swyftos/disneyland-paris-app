package gherkin.deps.com.google.gson.internal.bind;

import gherkin.deps.com.google.gson.FieldNamingStrategy;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.JsonSyntaxException;
import gherkin.deps.com.google.gson.TypeAdapter;
import gherkin.deps.com.google.gson.TypeAdapterFactory;
import gherkin.deps.com.google.gson.annotations.JsonAdapter;
import gherkin.deps.com.google.gson.annotations.SerializedName;
import gherkin.deps.com.google.gson.internal.C$Gson$Types;
import gherkin.deps.com.google.gson.internal.ConstructorConstructor;
import gherkin.deps.com.google.gson.internal.Excluder;
import gherkin.deps.com.google.gson.internal.ObjectConstructor;
import gherkin.deps.com.google.gson.internal.Primitives;
import gherkin.deps.com.google.gson.reflect.TypeToken;
import gherkin.deps.com.google.gson.stream.JsonReader;
import gherkin.deps.com.google.gson.stream.JsonToken;
import gherkin.deps.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public final class ReflectiveTypeAdapterFactory implements TypeAdapterFactory {
    private final ConstructorConstructor constructorConstructor;
    private final Excluder excluder;
    private final FieldNamingStrategy fieldNamingPolicy;

    public ReflectiveTypeAdapterFactory(ConstructorConstructor constructorConstructor, FieldNamingStrategy fieldNamingStrategy, Excluder excluder) {
        this.constructorConstructor = constructorConstructor;
        this.fieldNamingPolicy = fieldNamingStrategy;
        this.excluder = excluder;
    }

    public boolean excludeField(Field field, boolean z) {
        return excludeField(field, z, this.excluder);
    }

    static boolean excludeField(Field field, boolean z, Excluder excluder) {
        return (excluder.excludeClass(field.getType(), z) || excluder.excludeField(field, z)) ? false : true;
    }

    private String getFieldName(Field field) {
        return getFieldName(this.fieldNamingPolicy, field);
    }

    static String getFieldName(FieldNamingStrategy fieldNamingStrategy, Field field) {
        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
        return serializedName == null ? fieldNamingStrategy.translateName(field) : serializedName.value();
    }

    @Override // gherkin.deps.com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        if (Object.class.isAssignableFrom(rawType)) {
            return new Adapter(this.constructorConstructor.get(typeToken), getBoundFields(gson, typeToken, rawType));
        }
        return null;
    }

    private BoundField createBoundField(Gson gson, Field field, String str, TypeToken typeToken, boolean z, boolean z2) {
        return new BoundField(str, z, z2, gson, field, typeToken, Primitives.isPrimitive(typeToken.getRawType())) { // from class: gherkin.deps.com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.1
            final TypeAdapter typeAdapter;
            final /* synthetic */ Gson val$context;
            final /* synthetic */ Field val$field;
            final /* synthetic */ TypeToken val$fieldType;
            final /* synthetic */ boolean val$isPrimitive;

            {
                this.val$context = gson;
                this.val$field = field;
                this.val$fieldType = typeToken;
                this.val$isPrimitive = z;
                this.typeAdapter = ReflectiveTypeAdapterFactory.this.getFieldAdapter(gson, field, typeToken);
            }

            @Override // gherkin.deps.com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void write(JsonWriter jsonWriter, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException {
                new TypeAdapterRuntimeTypeWrapper(this.val$context, this.typeAdapter, this.val$fieldType.getType()).write(jsonWriter, this.val$field.get(obj));
            }

            @Override // gherkin.deps.com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            void read(JsonReader jsonReader, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException {
                Object obj2 = this.typeAdapter.read(jsonReader);
                if (obj2 == null && this.val$isPrimitive) {
                    return;
                }
                this.val$field.set(obj, obj2);
            }

            @Override // gherkin.deps.com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.BoundField
            public boolean writeField(Object obj) {
                return this.serialized && this.val$field.get(obj) != obj;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public TypeAdapter getFieldAdapter(Gson gson, Field field, TypeToken typeToken) {
        TypeAdapter typeAdapter;
        JsonAdapter jsonAdapter = (JsonAdapter) field.getAnnotation(JsonAdapter.class);
        return (jsonAdapter == null || (typeAdapter = JsonAdapterAnnotationTypeAdapterFactory.getTypeAdapter(this.constructorConstructor, gson, typeToken, jsonAdapter)) == null) ? gson.getAdapter(typeToken) : typeAdapter;
    }

    private Map getBoundFields(Gson gson, TypeToken typeToken, Class cls) throws SecurityException {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type type = typeToken.getType();
        TypeToken typeToken2 = typeToken;
        Class rawType = cls;
        while (rawType != Object.class) {
            for (Field field : rawType.getDeclaredFields()) {
                boolean zExcludeField = excludeField(field, true);
                boolean zExcludeField2 = excludeField(field, false);
                if (zExcludeField || zExcludeField2) {
                    field.setAccessible(true);
                    BoundField boundFieldCreateBoundField = createBoundField(gson, field, getFieldName(field), TypeToken.get(C$Gson$Types.resolve(typeToken2.getType(), rawType, field.getGenericType())), zExcludeField, zExcludeField2);
                    BoundField boundField = (BoundField) linkedHashMap.put(boundFieldCreateBoundField.name, boundFieldCreateBoundField);
                    if (boundField != null) {
                        throw new IllegalArgumentException(type + " declares multiple JSON fields named " + boundField.name);
                    }
                }
            }
            typeToken2 = TypeToken.get(C$Gson$Types.resolve(typeToken2.getType(), rawType, rawType.getGenericSuperclass()));
            rawType = typeToken2.getRawType();
        }
        return linkedHashMap;
    }

    static abstract class BoundField {
        final boolean deserialized;
        final String name;
        final boolean serialized;

        abstract void read(JsonReader jsonReader, Object obj);

        abstract void write(JsonWriter jsonWriter, Object obj);

        abstract boolean writeField(Object obj);

        protected BoundField(String str, boolean z, boolean z2) {
            this.name = str;
            this.serialized = z;
            this.deserialized = z2;
        }
    }

    public static final class Adapter<T> extends TypeAdapter<T> {
        private final Map boundFields;
        private final ObjectConstructor constructor;

        private Adapter(ObjectConstructor objectConstructor, Map map) {
            this.constructor = objectConstructor;
            this.boundFields = map;
        }

        @Override // gherkin.deps.com.google.gson.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            T t = (T) this.constructor.construct();
            try {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    BoundField boundField = (BoundField) this.boundFields.get(jsonReader.nextName());
                    if (boundField == null || !boundField.deserialized) {
                        jsonReader.skipValue();
                    } else {
                        boundField.read(jsonReader, t);
                    }
                }
                jsonReader.endObject();
                return t;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // gherkin.deps.com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            if (t == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            try {
                for (BoundField boundField : this.boundFields.values()) {
                    if (boundField.writeField(t)) {
                        jsonWriter.name(boundField.name);
                        boundField.write(jsonWriter, t);
                    }
                }
                jsonWriter.endObject();
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }
    }
}
