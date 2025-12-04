package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.std;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.BeanDescription;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationConfig;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonDeserializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.KeyDeserializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.MapperFeature;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.KeyDeserializers;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.ClassUtil;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.EnumResolver;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: classes5.dex */
public class StdKeyDeserializers implements KeyDeserializers, Serializable {
    private static final long serialVersionUID = 1;

    public static KeyDeserializer constructEnumKeyDeserializer(EnumResolver enumResolver) {
        return new StdKeyDeserializer.EnumKD(enumResolver, null);
    }

    public static KeyDeserializer constructEnumKeyDeserializer(EnumResolver enumResolver, AnnotatedMethod annotatedMethod) {
        return new StdKeyDeserializer.EnumKD(enumResolver, annotatedMethod);
    }

    public static KeyDeserializer constructDelegatingKeyDeserializer(DeserializationConfig deserializationConfig, JavaType javaType, JsonDeserializer<?> jsonDeserializer) {
        return new StdKeyDeserializer.DelegatingKD(javaType.getRawClass(), jsonDeserializer);
    }

    public static KeyDeserializer findStringBasedKeyDeserializer(DeserializationConfig deserializationConfig, JavaType javaType) throws SecurityException {
        BeanDescription beanDescriptionIntrospect = deserializationConfig.introspect(javaType);
        Constructor<?> constructorFindSingleArgConstructor = beanDescriptionIntrospect.findSingleArgConstructor(String.class);
        if (constructorFindSingleArgConstructor != null) {
            if (deserializationConfig.canOverrideAccessModifiers()) {
                ClassUtil.checkAndFixAccess(constructorFindSingleArgConstructor, deserializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
            }
            return new StdKeyDeserializer.StringCtorKeyDeserializer(constructorFindSingleArgConstructor);
        }
        Method methodFindFactoryMethod = beanDescriptionIntrospect.findFactoryMethod(String.class);
        if (methodFindFactoryMethod == null) {
            return null;
        }
        if (deserializationConfig.canOverrideAccessModifiers()) {
            ClassUtil.checkAndFixAccess(methodFindFactoryMethod, deserializationConfig.isEnabled(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
        }
        return new StdKeyDeserializer.StringFactoryKeyDeserializer(methodFindFactoryMethod);
    }

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.KeyDeserializers
    public KeyDeserializer findKeyDeserializer(JavaType javaType, DeserializationConfig deserializationConfig, BeanDescription beanDescription) throws JsonMappingException {
        Class<?> rawClass = javaType.getRawClass();
        if (rawClass.isPrimitive()) {
            rawClass = ClassUtil.wrapperType(rawClass);
        }
        return StdKeyDeserializer.forType(rawClass);
    }
}
