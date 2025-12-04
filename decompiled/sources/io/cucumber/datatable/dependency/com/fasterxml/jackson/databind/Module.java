package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonFactory;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonGenerator;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.JsonParser;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.ObjectCodec;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.Version;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.core.Versioned;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.cfg.MutableConfigOverride;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.Deserializers;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.KeyDeserializers;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.ValueInstantiators;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.jsontype.NamedType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.ser.Serializers;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type.TypeFactory;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type.TypeModifier;
import java.util.Collection;

/* loaded from: classes5.dex */
public abstract class Module implements Versioned {

    public interface SetupContext {
        void addAbstractTypeResolver(AbstractTypeResolver abstractTypeResolver);

        void addBeanDeserializerModifier(BeanDeserializerModifier beanDeserializerModifier);

        void addBeanSerializerModifier(BeanSerializerModifier beanSerializerModifier);

        void addDeserializationProblemHandler(DeserializationProblemHandler deserializationProblemHandler);

        void addDeserializers(Deserializers deserializers);

        void addKeyDeserializers(KeyDeserializers keyDeserializers);

        void addKeySerializers(Serializers serializers);

        void addSerializers(Serializers serializers);

        void addTypeModifier(TypeModifier typeModifier);

        void addValueInstantiators(ValueInstantiators valueInstantiators);

        void appendAnnotationIntrospector(AnnotationIntrospector annotationIntrospector);

        MutableConfigOverride configOverride(Class<?> cls);

        Version getMapperVersion();

        <C extends ObjectCodec> C getOwner();

        TypeFactory getTypeFactory();

        void insertAnnotationIntrospector(AnnotationIntrospector annotationIntrospector);

        boolean isEnabled(JsonFactory.Feature feature);

        boolean isEnabled(JsonGenerator.Feature feature);

        boolean isEnabled(JsonParser.Feature feature);

        boolean isEnabled(DeserializationFeature deserializationFeature);

        boolean isEnabled(MapperFeature mapperFeature);

        boolean isEnabled(SerializationFeature serializationFeature);

        void registerSubtypes(Collection<Class<?>> collection);

        void registerSubtypes(NamedType... namedTypeArr);

        void registerSubtypes(Class<?>... clsArr);

        void setClassIntrospector(ClassIntrospector classIntrospector);

        void setMixInAnnotations(Class<?> cls, Class<?> cls2);

        void setNamingStrategy(PropertyNamingStrategy propertyNamingStrategy);
    }

    public abstract String getModuleName();

    public abstract void setupModule(SetupContext setupContext);

    @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.core.Versioned
    public abstract Version version();

    public Object getTypeId() {
        return getClass().getName();
    }
}
