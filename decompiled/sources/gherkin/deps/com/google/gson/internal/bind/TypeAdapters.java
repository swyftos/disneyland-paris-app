package gherkin.deps.com.google.gson.internal.bind;

import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.JsonArray;
import gherkin.deps.com.google.gson.JsonElement;
import gherkin.deps.com.google.gson.JsonIOException;
import gherkin.deps.com.google.gson.JsonNull;
import gherkin.deps.com.google.gson.JsonObject;
import gherkin.deps.com.google.gson.JsonPrimitive;
import gherkin.deps.com.google.gson.JsonSyntaxException;
import gherkin.deps.com.google.gson.TypeAdapter;
import gherkin.deps.com.google.gson.TypeAdapterFactory;
import gherkin.deps.com.google.gson.annotations.SerializedName;
import gherkin.deps.com.google.gson.internal.LazilyParsedNumber;
import gherkin.deps.com.google.gson.reflect.TypeToken;
import gherkin.deps.com.google.gson.stream.JsonReader;
import gherkin.deps.com.google.gson.stream.JsonToken;
import gherkin.deps.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import org.slf4j.Marker;

/* loaded from: classes5.dex */
public final class TypeAdapters {
    public static final TypeAdapter<BigDecimal> BIG_DECIMAL;
    public static final TypeAdapter<BigInteger> BIG_INTEGER;
    public static final TypeAdapter<BitSet> BIT_SET;
    public static final TypeAdapterFactory BIT_SET_FACTORY;
    public static final TypeAdapter<Boolean> BOOLEAN;
    public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING;
    public static final TypeAdapterFactory BOOLEAN_FACTORY;
    public static final TypeAdapter<Number> BYTE;
    public static final TypeAdapterFactory BYTE_FACTORY;
    public static final TypeAdapter<Calendar> CALENDAR;
    public static final TypeAdapterFactory CALENDAR_FACTORY;
    public static final TypeAdapter<Character> CHARACTER;
    public static final TypeAdapterFactory CHARACTER_FACTORY;
    public static final TypeAdapter<Class> CLASS;
    public static final TypeAdapterFactory CLASS_FACTORY;
    public static final TypeAdapter<Number> DOUBLE;
    public static final TypeAdapterFactory ENUM_FACTORY;
    public static final TypeAdapter<Number> FLOAT;
    public static final TypeAdapter<InetAddress> INET_ADDRESS;
    public static final TypeAdapterFactory INET_ADDRESS_FACTORY;
    public static final TypeAdapter<Number> INTEGER;
    public static final TypeAdapterFactory INTEGER_FACTORY;
    public static final TypeAdapter<JsonElement> JSON_ELEMENT;
    public static final TypeAdapterFactory JSON_ELEMENT_FACTORY;
    public static final TypeAdapter<Locale> LOCALE;
    public static final TypeAdapterFactory LOCALE_FACTORY;
    public static final TypeAdapter<Number> LONG;
    public static final TypeAdapter<Number> NUMBER;
    public static final TypeAdapterFactory NUMBER_FACTORY;
    public static final TypeAdapter<Number> SHORT;
    public static final TypeAdapterFactory SHORT_FACTORY;
    public static final TypeAdapter<String> STRING;
    public static final TypeAdapter<StringBuffer> STRING_BUFFER;
    public static final TypeAdapterFactory STRING_BUFFER_FACTORY;
    public static final TypeAdapter<StringBuilder> STRING_BUILDER;
    public static final TypeAdapterFactory STRING_BUILDER_FACTORY;
    public static final TypeAdapterFactory STRING_FACTORY;
    public static final TypeAdapterFactory TIMESTAMP_FACTORY;
    public static final TypeAdapter<URI> URI;
    public static final TypeAdapterFactory URI_FACTORY;
    public static final TypeAdapter<URL> URL;
    public static final TypeAdapterFactory URL_FACTORY;
    public static final TypeAdapter<UUID> UUID;
    public static final TypeAdapterFactory UUID_FACTORY;

    static {
        TypeAdapter<Class> typeAdapter = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.1
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Class cls) throws IOException {
                if (cls == null) {
                    jsonWriter.nullValue();
                    return;
                }
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?");
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public Class read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
            }
        };
        CLASS = typeAdapter;
        CLASS_FACTORY = newFactory(Class.class, typeAdapter);
        TypeAdapter<BitSet> typeAdapter2 = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.2
            /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.util.BitSet read(gherkin.deps.com.google.gson.stream.JsonReader r7) throws java.io.IOException {
                /*
                    r6 = this;
                    gherkin.deps.com.google.gson.stream.JsonToken r6 = r7.peek()
                    gherkin.deps.com.google.gson.stream.JsonToken r0 = gherkin.deps.com.google.gson.stream.JsonToken.NULL
                    if (r6 != r0) goto Ld
                    r7.nextNull()
                    r6 = 0
                    return r6
                Ld:
                    java.util.BitSet r6 = new java.util.BitSet
                    r6.<init>()
                    r7.beginArray()
                    gherkin.deps.com.google.gson.stream.JsonToken r0 = r7.peek()
                    r1 = 0
                    r2 = r1
                L1b:
                    gherkin.deps.com.google.gson.stream.JsonToken r3 = gherkin.deps.com.google.gson.stream.JsonToken.END_ARRAY
                    if (r0 == r3) goto L82
                    int[] r3 = gherkin.deps.com.google.gson.internal.bind.TypeAdapters.AnonymousClass32.$SwitchMap$com$google$gson$stream$JsonToken
                    int r4 = r0.ordinal()
                    r3 = r3[r4]
                    r4 = 1
                    if (r3 == r4) goto L70
                    r5 = 2
                    if (r3 == r5) goto L6b
                    r5 = 3
                    if (r3 != r5) goto L54
                    java.lang.String r0 = r7.nextString()
                    int r0 = java.lang.Integer.parseInt(r0)     // Catch: java.lang.NumberFormatException -> L3d
                    if (r0 == 0) goto L3b
                    goto L76
                L3b:
                    r4 = r1
                    goto L76
                L3d:
                    gherkin.deps.com.google.gson.JsonSyntaxException r6 = new gherkin.deps.com.google.gson.JsonSyntaxException
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>()
                    java.lang.String r1 = "Error: Expecting: bitset number value (1, 0), Found: "
                    r7.append(r1)
                    r7.append(r0)
                    java.lang.String r7 = r7.toString()
                    r6.<init>(r7)
                    throw r6
                L54:
                    gherkin.deps.com.google.gson.JsonSyntaxException r6 = new gherkin.deps.com.google.gson.JsonSyntaxException
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder
                    r7.<init>()
                    java.lang.String r1 = "Invalid bitset value type: "
                    r7.append(r1)
                    r7.append(r0)
                    java.lang.String r7 = r7.toString()
                    r6.<init>(r7)
                    throw r6
                L6b:
                    boolean r4 = r7.nextBoolean()
                    goto L76
                L70:
                    int r0 = r7.nextInt()
                    if (r0 == 0) goto L3b
                L76:
                    if (r4 == 0) goto L7b
                    r6.set(r2)
                L7b:
                    int r2 = r2 + 1
                    gherkin.deps.com.google.gson.stream.JsonToken r0 = r7.peek()
                    goto L1b
                L82:
                    r7.endArray()
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.AnonymousClass2.read(gherkin.deps.com.google.gson.stream.JsonReader):java.util.BitSet");
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
                if (bitSet == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginArray();
                for (int i = 0; i < bitSet.length(); i++) {
                    jsonWriter.value(bitSet.get(i) ? 1L : 0L);
                }
                jsonWriter.endArray();
            }
        };
        BIT_SET = typeAdapter2;
        BIT_SET_FACTORY = newFactory(BitSet.class, typeAdapter2);
        TypeAdapter<Boolean> typeAdapter3 = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.3
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public Boolean read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                if (jsonReader.peek() == JsonToken.STRING) {
                    return Boolean.valueOf(Boolean.parseBoolean(jsonReader.nextString()));
                }
                return Boolean.valueOf(jsonReader.nextBoolean());
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
                if (bool == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value(bool.booleanValue());
                }
            }
        };
        BOOLEAN = typeAdapter3;
        BOOLEAN_AS_STRING = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.4
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public Boolean read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return Boolean.valueOf(jsonReader.nextString());
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
                jsonWriter.value(bool == null ? "null" : bool.toString());
            }
        };
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, typeAdapter3);
        TypeAdapter<Number> typeAdapter4 = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.5
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return Byte.valueOf((byte) jsonReader.nextInt());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.value(number);
            }
        };
        BYTE = typeAdapter4;
        BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, typeAdapter4);
        TypeAdapter<Number> typeAdapter5 = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.6
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return Short.valueOf((short) jsonReader.nextInt());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.value(number);
            }
        };
        SHORT = typeAdapter5;
        SHORT_FACTORY = newFactory(Short.TYPE, Short.class, typeAdapter5);
        TypeAdapter<Number> typeAdapter6 = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.7
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return Integer.valueOf(jsonReader.nextInt());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.value(number);
            }
        };
        INTEGER = typeAdapter6;
        INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, typeAdapter6);
        LONG = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.8
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return Long.valueOf(jsonReader.nextLong());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.value(number);
            }
        };
        FLOAT = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.9
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return Float.valueOf((float) jsonReader.nextDouble());
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.value(number);
            }
        };
        DOUBLE = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.10
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return Double.valueOf(jsonReader.nextDouble());
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.value(number);
            }
        };
        TypeAdapter<Number> typeAdapter7 = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.11
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                JsonToken jsonTokenPeek = jsonReader.peek();
                int i = AnonymousClass32.$SwitchMap$com$google$gson$stream$JsonToken[jsonTokenPeek.ordinal()];
                if (i == 1) {
                    return new LazilyParsedNumber(jsonReader.nextString());
                }
                if (i == 4) {
                    jsonReader.nextNull();
                    return null;
                }
                throw new JsonSyntaxException("Expecting number, got: " + jsonTokenPeek);
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.value(number);
            }
        };
        NUMBER = typeAdapter7;
        NUMBER_FACTORY = newFactory(Number.class, typeAdapter7);
        TypeAdapter<Character> typeAdapter8 = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.12
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public Character read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String strNextString = jsonReader.nextString();
                if (strNextString.length() != 1) {
                    throw new JsonSyntaxException("Expecting character, got: " + strNextString);
                }
                return Character.valueOf(strNextString.charAt(0));
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Character ch2) throws IOException {
                jsonWriter.value(ch2 == null ? null : String.valueOf(ch2));
            }
        };
        CHARACTER = typeAdapter8;
        CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, typeAdapter8);
        TypeAdapter<String> typeAdapter9 = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.13
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public String read(JsonReader jsonReader) throws IOException {
                JsonToken jsonTokenPeek = jsonReader.peek();
                if (jsonTokenPeek == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                if (jsonTokenPeek == JsonToken.BOOLEAN) {
                    return Boolean.toString(jsonReader.nextBoolean());
                }
                return jsonReader.nextString();
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, String str) throws IOException {
                jsonWriter.value(str);
            }
        };
        STRING = typeAdapter9;
        BIG_DECIMAL = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.14
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public BigDecimal read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return new BigDecimal(jsonReader.nextString());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, BigDecimal bigDecimal) throws IOException {
                jsonWriter.value(bigDecimal);
            }
        };
        BIG_INTEGER = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.15
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public BigInteger read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return new BigInteger(jsonReader.nextString());
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
                jsonWriter.value(bigInteger);
            }
        };
        STRING_FACTORY = newFactory(String.class, typeAdapter9);
        TypeAdapter<StringBuilder> typeAdapter10 = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.16
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public StringBuilder read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return new StringBuilder(jsonReader.nextString());
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, StringBuilder sb) throws IOException {
                jsonWriter.value(sb == null ? null : sb.toString());
            }
        };
        STRING_BUILDER = typeAdapter10;
        STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, typeAdapter10);
        TypeAdapter<StringBuffer> typeAdapter11 = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.17
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public StringBuffer read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return new StringBuffer(jsonReader.nextString());
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
                jsonWriter.value(stringBuffer == null ? null : stringBuffer.toString());
            }
        };
        STRING_BUFFER = typeAdapter11;
        STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, typeAdapter11);
        TypeAdapter<URL> typeAdapter12 = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.18
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public URL read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                String strNextString = jsonReader.nextString();
                if ("null".equals(strNextString)) {
                    return null;
                }
                return new URL(strNextString);
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, URL url) throws IOException {
                jsonWriter.value(url == null ? null : url.toExternalForm());
            }
        };
        URL = typeAdapter12;
        URL_FACTORY = newFactory(URL.class, typeAdapter12);
        TypeAdapter<URI> typeAdapter13 = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.19
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public URI read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    String strNextString = jsonReader.nextString();
                    if ("null".equals(strNextString)) {
                        return null;
                    }
                    return new URI(strNextString);
                } catch (URISyntaxException e) {
                    throw new JsonIOException(e);
                }
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, URI uri) throws IOException {
                jsonWriter.value(uri == null ? null : uri.toASCIIString());
            }
        };
        URI = typeAdapter13;
        URI_FACTORY = newFactory(URI.class, typeAdapter13);
        TypeAdapter<InetAddress> typeAdapter14 = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.20
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public InetAddress read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return InetAddress.getByName(jsonReader.nextString());
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
                jsonWriter.value(inetAddress == null ? null : inetAddress.getHostAddress());
            }
        };
        INET_ADDRESS = typeAdapter14;
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, typeAdapter14);
        TypeAdapter<UUID> typeAdapter15 = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.21
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public UUID read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                return UUID.fromString(jsonReader.nextString());
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, UUID uuid) throws IOException {
                jsonWriter.value(uuid == null ? null : uuid.toString());
            }
        };
        UUID = typeAdapter15;
        UUID_FACTORY = newFactory(UUID.class, typeAdapter15);
        TIMESTAMP_FACTORY = new TypeAdapterFactory() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.22
            @Override // gherkin.deps.com.google.gson.TypeAdapterFactory
            public TypeAdapter create(Gson gson, TypeToken typeToken) {
                if (typeToken.getRawType() != Timestamp.class) {
                    return null;
                }
                final TypeAdapter adapter = gson.getAdapter(Date.class);
                return new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.22.1
                    @Override // gherkin.deps.com.google.gson.TypeAdapter
                    public Timestamp read(JsonReader jsonReader) {
                        Date date = (Date) adapter.read(jsonReader);
                        if (date != null) {
                            return new Timestamp(date.getTime());
                        }
                        return null;
                    }

                    @Override // gherkin.deps.com.google.gson.TypeAdapter
                    public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
                        adapter.write(jsonWriter, timestamp);
                    }
                };
            }
        };
        TypeAdapter<Calendar> typeAdapter16 = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.23
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public Calendar read(JsonReader jsonReader) throws IOException, NumberFormatException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                jsonReader.beginObject();
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                while (jsonReader.peek() != JsonToken.END_OBJECT) {
                    String strNextName = jsonReader.nextName();
                    int iNextInt = jsonReader.nextInt();
                    if ("year".equals(strNextName)) {
                        i = iNextInt;
                    } else if ("month".equals(strNextName)) {
                        i2 = iNextInt;
                    } else if ("dayOfMonth".equals(strNextName)) {
                        i3 = iNextInt;
                    } else if ("hourOfDay".equals(strNextName)) {
                        i4 = iNextInt;
                    } else if ("minute".equals(strNextName)) {
                        i5 = iNextInt;
                    } else if ("second".equals(strNextName)) {
                        i6 = iNextInt;
                    }
                }
                jsonReader.endObject();
                return new GregorianCalendar(i, i2, i3, i4, i5, i6);
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Calendar calendar) throws IOException {
                if (calendar == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginObject();
                jsonWriter.name("year");
                jsonWriter.value(calendar.get(1));
                jsonWriter.name("month");
                jsonWriter.value(calendar.get(2));
                jsonWriter.name("dayOfMonth");
                jsonWriter.value(calendar.get(5));
                jsonWriter.name("hourOfDay");
                jsonWriter.value(calendar.get(11));
                jsonWriter.name("minute");
                jsonWriter.value(calendar.get(12));
                jsonWriter.name("second");
                jsonWriter.value(calendar.get(13));
                jsonWriter.endObject();
            }
        };
        CALENDAR = typeAdapter16;
        CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, typeAdapter16);
        TypeAdapter<Locale> typeAdapter17 = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.24
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public Locale read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), "_");
                String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                if (strNextToken2 == null && strNextToken3 == null) {
                    return new Locale(strNextToken);
                }
                if (strNextToken3 == null) {
                    return new Locale(strNextToken, strNextToken2);
                }
                return new Locale(strNextToken, strNextToken2, strNextToken3);
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, Locale locale) throws IOException {
                jsonWriter.value(locale == null ? null : locale.toString());
            }
        };
        LOCALE = typeAdapter17;
        LOCALE_FACTORY = newFactory(Locale.class, typeAdapter17);
        TypeAdapter<JsonElement> typeAdapter18 = new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.25
            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public JsonElement read(JsonReader jsonReader) throws IOException {
                switch (AnonymousClass32.$SwitchMap$com$google$gson$stream$JsonToken[jsonReader.peek().ordinal()]) {
                    case 1:
                        return new JsonPrimitive((Number) new LazilyParsedNumber(jsonReader.nextString()));
                    case 2:
                        return new JsonPrimitive(Boolean.valueOf(jsonReader.nextBoolean()));
                    case 3:
                        return new JsonPrimitive(jsonReader.nextString());
                    case 4:
                        jsonReader.nextNull();
                        return JsonNull.INSTANCE;
                    case 5:
                        JsonArray jsonArray = new JsonArray();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            jsonArray.add(read(jsonReader));
                        }
                        jsonReader.endArray();
                        return jsonArray;
                    case 6:
                        JsonObject jsonObject = new JsonObject();
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            jsonObject.add(jsonReader.nextName(), read(jsonReader));
                        }
                        jsonReader.endObject();
                        return jsonObject;
                    default:
                        throw new IllegalArgumentException();
                }
            }

            @Override // gherkin.deps.com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
                if (jsonElement == null || jsonElement.isJsonNull()) {
                    jsonWriter.nullValue();
                    return;
                }
                if (jsonElement.isJsonPrimitive()) {
                    JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                    if (asJsonPrimitive.isNumber()) {
                        jsonWriter.value(asJsonPrimitive.getAsNumber());
                        return;
                    } else if (asJsonPrimitive.isBoolean()) {
                        jsonWriter.value(asJsonPrimitive.getAsBoolean());
                        return;
                    } else {
                        jsonWriter.value(asJsonPrimitive.getAsString());
                        return;
                    }
                }
                if (jsonElement.isJsonArray()) {
                    jsonWriter.beginArray();
                    Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                    while (it.hasNext()) {
                        write(jsonWriter, it.next());
                    }
                    jsonWriter.endArray();
                    return;
                }
                if (jsonElement.isJsonObject()) {
                    jsonWriter.beginObject();
                    for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                        jsonWriter.name(entry.getKey());
                        write(jsonWriter, entry.getValue());
                    }
                    jsonWriter.endObject();
                    return;
                }
                throw new IllegalArgumentException("Couldn't write " + jsonElement.getClass());
            }
        };
        JSON_ELEMENT = typeAdapter18;
        JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, typeAdapter18);
        ENUM_FACTORY = new TypeAdapterFactory() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.26
            @Override // gherkin.deps.com.google.gson.TypeAdapterFactory
            public TypeAdapter create(Gson gson, TypeToken typeToken) {
                Class rawType = typeToken.getRawType();
                if (!Enum.class.isAssignableFrom(rawType) || rawType == Enum.class) {
                    return null;
                }
                if (!rawType.isEnum()) {
                    rawType = rawType.getSuperclass();
                }
                return new EnumTypeAdapter(rawType);
            }
        };
    }

    /* renamed from: gherkin.deps.com.google.gson.internal.bind.TypeAdapters$32, reason: invalid class name */
    static /* synthetic */ class AnonymousClass32 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$google$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private static final class EnumTypeAdapter extends TypeAdapter {
        private final Map nameToConstant = new HashMap();
        private final Map constantToName = new HashMap();

        public EnumTypeAdapter(Class cls) {
            try {
                for (Enum r3 : (Enum[]) cls.getEnumConstants()) {
                    String strName = r3.name();
                    SerializedName serializedName = (SerializedName) cls.getField(strName).getAnnotation(SerializedName.class);
                    strName = serializedName != null ? serializedName.value() : strName;
                    this.nameToConstant.put(strName, r3);
                    this.constantToName.put(r3, strName);
                }
            } catch (NoSuchFieldException unused) {
                throw new AssertionError();
            }
        }

        @Override // gherkin.deps.com.google.gson.TypeAdapter
        public Enum read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            return (Enum) this.nameToConstant.get(jsonReader.nextString());
        }

        @Override // gherkin.deps.com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Enum r2) throws IOException {
            jsonWriter.value(r2 == null ? null : (String) this.constantToName.get(r2));
        }
    }

    public static <TT> TypeAdapterFactory newFactory(final TypeToken<TT> typeToken, final TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.27
            @Override // gherkin.deps.com.google.gson.TypeAdapterFactory
            public TypeAdapter create(Gson gson, TypeToken typeToken2) {
                if (typeToken2.equals(typeToken)) {
                    return typeAdapter;
                }
                return null;
            }
        };
    }

    public static <TT> TypeAdapterFactory newFactory(final Class<TT> cls, final TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.28
            @Override // gherkin.deps.com.google.gson.TypeAdapterFactory
            public TypeAdapter create(Gson gson, TypeToken typeToken) {
                if (typeToken.getRawType() == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> TypeAdapterFactory newFactory(final Class<TT> cls, final Class<TT> cls2, final TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.29
            @Override // gherkin.deps.com.google.gson.TypeAdapterFactory
            public TypeAdapter create(Gson gson, TypeToken typeToken) {
                Class rawType = typeToken.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + Marker.ANY_NON_NULL_MARKER + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(final Class<TT> cls, final Class<? extends TT> cls2, final TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.30
            @Override // gherkin.deps.com.google.gson.TypeAdapterFactory
            public TypeAdapter create(Gson gson, TypeToken typeToken) {
                Class rawType = typeToken.getRawType();
                if (rawType == cls || rawType == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + Marker.ANY_NON_NULL_MARKER + cls2.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static <TT> TypeAdapterFactory newTypeHierarchyFactory(final Class<TT> cls, final TypeAdapter<TT> typeAdapter) {
        return new TypeAdapterFactory() { // from class: gherkin.deps.com.google.gson.internal.bind.TypeAdapters.31
            @Override // gherkin.deps.com.google.gson.TypeAdapterFactory
            public TypeAdapter create(Gson gson, TypeToken typeToken) {
                if (cls.isAssignableFrom(typeToken.getRawType())) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }
}
