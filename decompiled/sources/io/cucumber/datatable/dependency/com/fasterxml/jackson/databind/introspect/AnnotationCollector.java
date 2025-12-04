package io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Annotations;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class AnnotationCollector {
    protected static final Annotations NO_ANNOTATIONS = new NoAnnotations();
    protected final Object _data;

    public abstract AnnotationCollector addOrOverride(Annotation annotation);

    public abstract AnnotationMap asAnnotationMap();

    public abstract Annotations asAnnotations();

    public abstract boolean isPresent(Annotation annotation);

    protected AnnotationCollector(Object obj) {
        this._data = obj;
    }

    public static Annotations emptyAnnotations() {
        return NO_ANNOTATIONS;
    }

    public static AnnotationCollector emptyCollector() {
        return EmptyCollector.instance;
    }

    public static AnnotationCollector emptyCollector(Object obj) {
        return new EmptyCollector(obj);
    }

    public Object getData() {
        return this._data;
    }

    static class EmptyCollector extends AnnotationCollector {
        public static final EmptyCollector instance = new EmptyCollector(null);

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public boolean isPresent(Annotation annotation) {
            return false;
        }

        EmptyCollector(Object obj) {
            super(obj);
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public Annotations asAnnotations() {
            return AnnotationCollector.NO_ANNOTATIONS;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public AnnotationMap asAnnotationMap() {
            return new AnnotationMap();
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public AnnotationCollector addOrOverride(Annotation annotation) {
            return new OneCollector(this._data, annotation.annotationType(), annotation);
        }
    }

    static class OneCollector extends AnnotationCollector {
        private Class _type;
        private Annotation _value;

        public OneCollector(Object obj, Class cls, Annotation annotation) {
            super(obj);
            this._type = cls;
            this._value = annotation;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public Annotations asAnnotations() {
            return new OneAnnotation(this._type, this._value);
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public AnnotationMap asAnnotationMap() {
            return AnnotationMap.of(this._type, this._value);
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public boolean isPresent(Annotation annotation) {
            return annotation.annotationType() == this._type;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public AnnotationCollector addOrOverride(Annotation annotation) {
            Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
            Class<? extends Annotation> cls = this._type;
            if (cls == clsAnnotationType) {
                this._value = annotation;
                return this;
            }
            return new NCollector(this._data, cls, this._value, clsAnnotationType, annotation);
        }
    }

    static class NCollector extends AnnotationCollector {
        protected final HashMap _annotations;

        public NCollector(Object obj, Class cls, Annotation annotation, Class cls2, Annotation annotation2) {
            super(obj);
            HashMap map = new HashMap();
            this._annotations = map;
            map.put(cls, annotation);
            map.put(cls2, annotation2);
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public Annotations asAnnotations() {
            if (this._annotations.size() == 2) {
                Iterator it = this._annotations.entrySet().iterator();
                Map.Entry entry = (Map.Entry) it.next();
                Map.Entry entry2 = (Map.Entry) it.next();
                return new TwoAnnotations((Class) entry.getKey(), (Annotation) entry.getValue(), (Class) entry2.getKey(), (Annotation) entry2.getValue());
            }
            return new AnnotationMap(this._annotations);
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public AnnotationMap asAnnotationMap() {
            AnnotationMap annotationMap = new AnnotationMap();
            Iterator it = this._annotations.values().iterator();
            while (it.hasNext()) {
                annotationMap.add((Annotation) it.next());
            }
            return annotationMap;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public boolean isPresent(Annotation annotation) {
            return this._annotations.containsKey(annotation.annotationType());
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.AnnotationCollector
        public AnnotationCollector addOrOverride(Annotation annotation) {
            this._annotations.put(annotation.annotationType(), annotation);
            return this;
        }
    }

    public static class NoAnnotations implements Annotations, Serializable {
        private static final long serialVersionUID = 1;

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Annotations
        public <A extends Annotation> A get(Class<A> cls) {
            return null;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Annotations
        public boolean has(Class<?> cls) {
            return false;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Annotations
        public boolean hasOneOf(Class<? extends Annotation>[] clsArr) {
            return false;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Annotations
        public int size() {
            return 0;
        }

        NoAnnotations() {
        }
    }

    public static class OneAnnotation implements Annotations, Serializable {
        private static final long serialVersionUID = 1;
        private final Class _type;
        private final Annotation _value;

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Annotations
        public int size() {
            return 1;
        }

        public OneAnnotation(Class<?> cls, Annotation annotation) {
            this._type = cls;
            this._value = annotation;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Annotations
        public <A extends Annotation> A get(Class<A> cls) {
            if (this._type == cls) {
                return (A) this._value;
            }
            return null;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Annotations
        public boolean has(Class<?> cls) {
            return this._type == cls;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Annotations
        public boolean hasOneOf(Class<? extends Annotation>[] clsArr) {
            for (Class<? extends Annotation> cls : clsArr) {
                if (cls == this._type) {
                    return true;
                }
            }
            return false;
        }
    }

    public static class TwoAnnotations implements Annotations, Serializable {
        private static final long serialVersionUID = 1;
        private final Class _type1;
        private final Class _type2;
        private final Annotation _value1;
        private final Annotation _value2;

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Annotations
        public int size() {
            return 2;
        }

        public TwoAnnotations(Class<?> cls, Annotation annotation, Class<?> cls2, Annotation annotation2) {
            this._type1 = cls;
            this._value1 = annotation;
            this._type2 = cls2;
            this._value2 = annotation2;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Annotations
        public <A extends Annotation> A get(Class<A> cls) {
            if (this._type1 == cls) {
                return (A) this._value1;
            }
            if (this._type2 == cls) {
                return (A) this._value2;
            }
            return null;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Annotations
        public boolean has(Class<?> cls) {
            return this._type1 == cls || this._type2 == cls;
        }

        @Override // io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.util.Annotations
        public boolean hasOneOf(Class<? extends Annotation>[] clsArr) {
            for (Class<? extends Annotation> cls : clsArr) {
                if (cls == this._type1 || cls == this._type2) {
                    return true;
                }
            }
            return false;
        }
    }
}
