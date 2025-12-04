package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.impl;

import androidx.media3.exoplayer.upstream.CmcdData;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.DeserializationContext;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JavaType;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonDeserializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.JsonMappingException;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.deser.std.StdDelegatingDeserializer;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.type.TypeFactory;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Converter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public abstract class JavaUtilCollectionsDeserializers {
    private static final Class CLASS_AS_ARRAYS_LIST = Arrays.asList(null, null).getClass();
    private static final Class CLASS_SINGLETON_LIST;
    private static final Class CLASS_SINGLETON_MAP;
    private static final Class CLASS_SINGLETON_SET;
    private static final Class CLASS_UNMODIFIABLE_LIST;
    private static final Class CLASS_UNMODIFIABLE_LIST_ALIAS;
    private static final Class CLASS_UNMODIFIABLE_MAP;
    private static final Class CLASS_UNMODIFIABLE_SET;
    public static final int TYPE_AS_LIST = 7;

    static {
        Boolean bool = Boolean.TRUE;
        Set setSingleton = Collections.singleton(bool);
        CLASS_SINGLETON_SET = setSingleton.getClass();
        CLASS_UNMODIFIABLE_SET = Collections.unmodifiableSet(setSingleton).getClass();
        List listSingletonList = Collections.singletonList(bool);
        CLASS_SINGLETON_LIST = listSingletonList.getClass();
        CLASS_UNMODIFIABLE_LIST = Collections.unmodifiableList(listSingletonList).getClass();
        CLASS_UNMODIFIABLE_LIST_ALIAS = Collections.unmodifiableList(new LinkedList()).getClass();
        Map mapSingletonMap = Collections.singletonMap(CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY, "b");
        CLASS_SINGLETON_MAP = mapSingletonMap.getClass();
        CLASS_UNMODIFIABLE_MAP = Collections.unmodifiableMap(mapSingletonMap).getClass();
    }

    public static JsonDeserializer<?> findForCollection(DeserializationContext deserializationContext, JavaType javaType) throws JsonMappingException {
        JavaUtilCollectionsConverter javaUtilCollectionsConverterConverter;
        if (javaType.hasRawClass(CLASS_AS_ARRAYS_LIST)) {
            javaUtilCollectionsConverterConverter = converter(7, javaType, List.class);
        } else if (javaType.hasRawClass(CLASS_SINGLETON_LIST)) {
            javaUtilCollectionsConverterConverter = converter(2, javaType, List.class);
        } else if (javaType.hasRawClass(CLASS_SINGLETON_SET)) {
            javaUtilCollectionsConverterConverter = converter(1, javaType, Set.class);
        } else if (javaType.hasRawClass(CLASS_UNMODIFIABLE_LIST) || javaType.hasRawClass(CLASS_UNMODIFIABLE_LIST_ALIAS)) {
            javaUtilCollectionsConverterConverter = converter(5, javaType, List.class);
        } else {
            if (!javaType.hasRawClass(CLASS_UNMODIFIABLE_SET)) {
                return null;
            }
            javaUtilCollectionsConverterConverter = converter(4, javaType, Set.class);
        }
        return new StdDelegatingDeserializer(javaUtilCollectionsConverterConverter);
    }

    public static JsonDeserializer<?> findForMap(DeserializationContext deserializationContext, JavaType javaType) throws JsonMappingException {
        JavaUtilCollectionsConverter javaUtilCollectionsConverterConverter;
        if (javaType.hasRawClass(CLASS_SINGLETON_MAP)) {
            javaUtilCollectionsConverterConverter = converter(3, javaType, Map.class);
        } else {
            if (!javaType.hasRawClass(CLASS_UNMODIFIABLE_MAP)) {
                return null;
            }
            javaUtilCollectionsConverterConverter = converter(6, javaType, Map.class);
        }
        return new StdDelegatingDeserializer(javaUtilCollectionsConverterConverter);
    }

    static JavaUtilCollectionsConverter converter(int i, JavaType javaType, Class cls) {
        return new JavaUtilCollectionsConverter(i, javaType.findSuperType(cls));
    }

    private static class JavaUtilCollectionsConverter implements Converter {
        private final JavaType _inputType;
        private final int _kind;

        private JavaUtilCollectionsConverter(int i, JavaType javaType) {
            this._inputType = javaType;
            this._kind = i;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Converter
        public Object convert(Object obj) {
            if (obj == null) {
                return null;
            }
            switch (this._kind) {
                case 1:
                    Set set = (Set) obj;
                    _checkSingleton(set.size());
                    return Collections.singleton(set.iterator().next());
                case 2:
                    List list = (List) obj;
                    _checkSingleton(list.size());
                    return Collections.singletonList(list.get(0));
                case 3:
                    Map map = (Map) obj;
                    _checkSingleton(map.size());
                    Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
                    return Collections.singletonMap(entry.getKey(), entry.getValue());
                case 4:
                    return Collections.unmodifiableSet((Set) obj);
                case 5:
                    return Collections.unmodifiableList((List) obj);
                case 6:
                    return Collections.unmodifiableMap((Map) obj);
                default:
                    return obj;
            }
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Converter
        public JavaType getInputType(TypeFactory typeFactory) {
            return this._inputType;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Converter
        public JavaType getOutputType(TypeFactory typeFactory) {
            return this._inputType;
        }

        private void _checkSingleton(int i) {
            if (i == 1) {
                return;
            }
            throw new IllegalArgumentException("Can not deserialize Singleton container from " + i + " entries");
        }
    }
}
