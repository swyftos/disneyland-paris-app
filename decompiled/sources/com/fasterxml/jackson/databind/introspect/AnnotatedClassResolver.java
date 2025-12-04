package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.ClassIntrospector;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.util.Annotations;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class AnnotatedClassResolver {
    private static final Annotations NO_ANNOTATIONS = AnnotationCollector.emptyAnnotations();
    private final TypeBindings _bindings;
    private final Class _class;
    private final MapperConfig _config;
    private final AnnotationIntrospector _intr;
    private final ClassIntrospector.MixInResolver _mixInResolver;
    private final Class _primaryMixin;
    private final JavaType _type;

    AnnotatedClassResolver(MapperConfig mapperConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        this._config = mapperConfig;
        this._type = javaType;
        Class<?> rawClass = javaType.getRawClass();
        this._class = rawClass;
        this._mixInResolver = mixInResolver;
        this._bindings = javaType.getBindings();
        this._intr = mapperConfig.isAnnotationProcessingEnabled() ? mapperConfig.getAnnotationIntrospector() : null;
        this._primaryMixin = mapperConfig.findMixInClassFor(rawClass);
    }

    AnnotatedClassResolver(MapperConfig mapperConfig, Class cls, ClassIntrospector.MixInResolver mixInResolver) {
        this._config = mapperConfig;
        this._type = null;
        this._class = cls;
        this._mixInResolver = mixInResolver;
        this._bindings = TypeBindings.emptyBindings();
        if (mapperConfig == null) {
            this._intr = null;
            this._primaryMixin = null;
        } else {
            this._intr = mapperConfig.isAnnotationProcessingEnabled() ? mapperConfig.getAnnotationIntrospector() : null;
            this._primaryMixin = mapperConfig.findMixInClassFor(cls);
        }
    }

    public static AnnotatedClass resolve(MapperConfig<?> mapperConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        if (javaType.isArrayType() && skippableArray(mapperConfig, javaType.getRawClass())) {
            return createArrayType(mapperConfig, javaType.getRawClass());
        }
        return new AnnotatedClassResolver(mapperConfig, javaType, mixInResolver).resolveFully();
    }

    public static AnnotatedClass resolveWithoutSuperTypes(MapperConfig<?> mapperConfig, Class<?> cls) {
        return resolveWithoutSuperTypes(mapperConfig, cls, mapperConfig);
    }

    public static AnnotatedClass resolveWithoutSuperTypes(MapperConfig<?> mapperConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        if (javaType.isArrayType() && skippableArray(mapperConfig, javaType.getRawClass())) {
            return createArrayType(mapperConfig, javaType.getRawClass());
        }
        return new AnnotatedClassResolver(mapperConfig, javaType, mixInResolver).resolveWithoutSuperTypes();
    }

    public static AnnotatedClass resolveWithoutSuperTypes(MapperConfig<?> mapperConfig, Class<?> cls, ClassIntrospector.MixInResolver mixInResolver) {
        if (cls.isArray() && skippableArray(mapperConfig, cls)) {
            return createArrayType(mapperConfig, cls);
        }
        return new AnnotatedClassResolver(mapperConfig, cls, mixInResolver).resolveWithoutSuperTypes();
    }

    private static boolean skippableArray(MapperConfig mapperConfig, Class cls) {
        return mapperConfig == null || mapperConfig.findMixInClassFor(cls) == null;
    }

    static AnnotatedClass createPrimordial(Class cls) {
        return new AnnotatedClass(cls);
    }

    static AnnotatedClass createArrayType(MapperConfig mapperConfig, Class cls) {
        return new AnnotatedClass(cls);
    }

    AnnotatedClass resolveFully() {
        List<JavaType> listFindSuperTypes = ClassUtil.findSuperTypes(this._type, (Class<?>) null, false);
        return new AnnotatedClass(this._type, this._class, listFindSuperTypes, this._primaryMixin, resolveClassAnnotations(listFindSuperTypes), this._bindings, this._intr, this._mixInResolver, this._config.getTypeFactory());
    }

    AnnotatedClass resolveWithoutSuperTypes() {
        List listEmptyList = Collections.emptyList();
        Class cls = this._class;
        Class cls2 = this._primaryMixin;
        Annotations annotationsResolveClassAnnotations = resolveClassAnnotations(listEmptyList);
        TypeBindings typeBindings = this._bindings;
        AnnotationIntrospector annotationIntrospector = this._intr;
        MapperConfig mapperConfig = this._config;
        return new AnnotatedClass(null, cls, listEmptyList, cls2, annotationsResolveClassAnnotations, typeBindings, annotationIntrospector, mapperConfig, mapperConfig.getTypeFactory());
    }

    private Annotations resolveClassAnnotations(List list) {
        if (this._intr == null) {
            return NO_ANNOTATIONS;
        }
        AnnotationCollector annotationCollectorEmptyCollector = AnnotationCollector.emptyCollector();
        Class cls = this._primaryMixin;
        if (cls != null) {
            annotationCollectorEmptyCollector = _addClassMixIns(annotationCollectorEmptyCollector, this._class, cls);
        }
        AnnotationCollector annotationCollector_addAnnotationsIfNotPresent = _addAnnotationsIfNotPresent(annotationCollectorEmptyCollector, ClassUtil.findClassAnnotations(this._class));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            JavaType javaType = (JavaType) it.next();
            if (this._mixInResolver != null) {
                Class<?> rawClass = javaType.getRawClass();
                annotationCollector_addAnnotationsIfNotPresent = _addClassMixIns(annotationCollector_addAnnotationsIfNotPresent, rawClass, this._mixInResolver.findMixInClassFor(rawClass));
            }
            annotationCollector_addAnnotationsIfNotPresent = _addAnnotationsIfNotPresent(annotationCollector_addAnnotationsIfNotPresent, ClassUtil.findClassAnnotations(javaType.getRawClass()));
        }
        ClassIntrospector.MixInResolver mixInResolver = this._mixInResolver;
        if (mixInResolver != null) {
            annotationCollector_addAnnotationsIfNotPresent = _addClassMixIns(annotationCollector_addAnnotationsIfNotPresent, Object.class, mixInResolver.findMixInClassFor(Object.class));
        }
        return annotationCollector_addAnnotationsIfNotPresent.asAnnotations();
    }

    private AnnotationCollector _addClassMixIns(AnnotationCollector annotationCollector, Class cls, Class cls2) {
        if (cls2 != null) {
            annotationCollector = _addAnnotationsIfNotPresent(annotationCollector, ClassUtil.findClassAnnotations(cls2));
            Iterator<Class<?>> it = ClassUtil.findSuperClasses(cls2, cls, false).iterator();
            while (it.hasNext()) {
                annotationCollector = _addAnnotationsIfNotPresent(annotationCollector, ClassUtil.findClassAnnotations(it.next()));
            }
        }
        return annotationCollector;
    }

    private AnnotationCollector _addAnnotationsIfNotPresent(AnnotationCollector annotationCollector, Annotation[] annotationArr) {
        if (annotationArr != null) {
            for (Annotation annotation : annotationArr) {
                if (!annotationCollector.isPresent(annotation)) {
                    annotationCollector = annotationCollector.addOrOverride(annotation);
                    if (this._intr.isAnnotationBundle(annotation)) {
                        annotationCollector = _addFromBundleIfNotPresent(annotationCollector, annotation);
                    }
                }
            }
        }
        return annotationCollector;
    }

    private AnnotationCollector _addFromBundleIfNotPresent(AnnotationCollector annotationCollector, Annotation annotation) {
        for (Annotation annotation2 : ClassUtil.findClassAnnotations(annotation.annotationType())) {
            if (!(annotation2 instanceof Target) && !(annotation2 instanceof Retention) && !annotationCollector.isPresent(annotation2)) {
                annotationCollector = annotationCollector.addOrOverride(annotation2);
                if (this._intr.isAnnotationBundle(annotation2)) {
                    annotationCollector = _addFromBundleIfNotPresent(annotationCollector, annotation2);
                }
            }
        }
        return annotationCollector;
    }
}
