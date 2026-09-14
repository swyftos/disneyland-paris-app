package gherkin.deps.com.google.gson.internal;

import gherkin.deps.com.google.gson.ExclusionStrategy;
import gherkin.deps.com.google.gson.FieldAttributes;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.TypeAdapter;
import gherkin.deps.com.google.gson.TypeAdapterFactory;
import gherkin.deps.com.google.gson.annotations.Expose;
import gherkin.deps.com.google.gson.annotations.Since;
import gherkin.deps.com.google.gson.annotations.Until;
import gherkin.deps.com.google.gson.reflect.TypeToken;
import gherkin.deps.com.google.gson.stream.JsonReader;
import gherkin.deps.com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class Excluder implements TypeAdapterFactory, Cloneable {
    public static final Excluder DEFAULT = new Excluder();
    private boolean requireExpose;
    private double version = -1.0d;
    private int modifiers = 136;
    private boolean serializeInnerClasses = true;
    private List serializationStrategies = Collections.emptyList();
    private List deserializationStrategies = Collections.emptyList();

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Excluder m5275clone() {
        try {
            return (Excluder) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    public Excluder withVersion(double d) {
        Excluder excluderM5275clone = m5275clone();
        excluderM5275clone.version = d;
        return excluderM5275clone;
    }

    public Excluder withModifiers(int... iArr) {
        Excluder excluderM5275clone = m5275clone();
        excluderM5275clone.modifiers = 0;
        for (int i : iArr) {
            excluderM5275clone.modifiers = i | excluderM5275clone.modifiers;
        }
        return excluderM5275clone;
    }

    public Excluder disableInnerClassSerialization() {
        Excluder excluderM5275clone = m5275clone();
        excluderM5275clone.serializeInnerClasses = false;
        return excluderM5275clone;
    }

    public Excluder excludeFieldsWithoutExposeAnnotation() {
        Excluder excluderM5275clone = m5275clone();
        excluderM5275clone.requireExpose = true;
        return excluderM5275clone;
    }

    public Excluder withExclusionStrategy(ExclusionStrategy exclusionStrategy, boolean z, boolean z2) {
        Excluder excluderM5275clone = m5275clone();
        if (z) {
            ArrayList arrayList = new ArrayList(this.serializationStrategies);
            excluderM5275clone.serializationStrategies = arrayList;
            arrayList.add(exclusionStrategy);
        }
        if (z2) {
            ArrayList arrayList2 = new ArrayList(this.deserializationStrategies);
            excluderM5275clone.deserializationStrategies = arrayList2;
            arrayList2.add(exclusionStrategy);
        }
        return excluderM5275clone;
    }

    @Override // gherkin.deps.com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        Class<? super T> rawType = typeToken.getRawType();
        final boolean zExcludeClass = excludeClass(rawType, true);
        final boolean zExcludeClass2 = excludeClass(rawType, false);
        if (zExcludeClass || zExcludeClass2) {
            return new TypeAdapter() { // from class: gherkin.deps.com.google.gson.internal.Excluder.1
                private TypeAdapter delegate;

                @Override // gherkin.deps.com.google.gson.TypeAdapter
                public Object read(JsonReader jsonReader) throws IOException {
                    if (zExcludeClass2) {
                        jsonReader.skipValue();
                        return null;
                    }
                    return delegate().read(jsonReader);
                }

                @Override // gherkin.deps.com.google.gson.TypeAdapter
                public void write(JsonWriter jsonWriter, Object obj) throws IOException {
                    if (zExcludeClass) {
                        jsonWriter.nullValue();
                    } else {
                        delegate().write(jsonWriter, obj);
                    }
                }

                private TypeAdapter delegate() {
                    TypeAdapter typeAdapter = this.delegate;
                    if (typeAdapter != null) {
                        return typeAdapter;
                    }
                    TypeAdapter delegateAdapter = gson.getDelegateAdapter(Excluder.this, typeToken);
                    this.delegate = delegateAdapter;
                    return delegateAdapter;
                }
            };
        }
        return null;
    }

    public boolean excludeField(Field field, boolean z) {
        Expose expose;
        if ((this.modifiers & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.version != -1.0d && !isValidVersion((Since) field.getAnnotation(Since.class), (Until) field.getAnnotation(Until.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.requireExpose && ((expose = (Expose) field.getAnnotation(Expose.class)) == null || (!z ? expose.deserialize() : expose.serialize()))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(field.getType())) || isAnonymousOrLocal(field.getType())) {
            return true;
        }
        List list = z ? this.serializationStrategies : this.deserializationStrategies;
        if (list.isEmpty()) {
            return false;
        }
        FieldAttributes fieldAttributes = new FieldAttributes(field);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((ExclusionStrategy) it.next()).shouldSkipField(fieldAttributes)) {
                return true;
            }
        }
        return false;
    }

    public boolean excludeClass(Class<?> cls, boolean z) {
        if (this.version != -1.0d && !isValidVersion((Since) cls.getAnnotation(Since.class), (Until) cls.getAnnotation(Until.class))) {
            return true;
        }
        if ((!this.serializeInnerClasses && isInnerClass(cls)) || isAnonymousOrLocal(cls)) {
            return true;
        }
        Iterator it = (z ? this.serializationStrategies : this.deserializationStrategies).iterator();
        while (it.hasNext()) {
            if (((ExclusionStrategy) it.next()).shouldSkipClass(cls)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAnonymousOrLocal(Class cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean isInnerClass(Class cls) {
        return cls.isMemberClass() && !isStatic(cls);
    }

    private boolean isStatic(Class cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    private boolean isValidVersion(Since since, Until until) {
        return isValidSince(since) && isValidUntil(until);
    }

    private boolean isValidSince(Since since) {
        return since == null || since.value() <= this.version;
    }

    private boolean isValidUntil(Until until) {
        return until == null || until.value() > this.version;
    }
}
