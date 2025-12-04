package org.picocontainer;

import java.io.Serializable;
import java.lang.annotation.Annotation;

/* loaded from: classes6.dex */
public class BindKey<T> implements Serializable {
    private final Class annotation;
    private final Class type;

    public BindKey(Class<T> cls, Class<? extends Annotation> cls2) {
        this.type = cls;
        this.annotation = cls2;
    }

    public Class<T> getType() {
        return this.type;
    }

    public Class<? extends Annotation> getAnnotation() {
        return this.annotation;
    }

    public String toString() {
        return this.type.getName() + ":" + this.annotation.getName();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BindKey bindKey = (BindKey) obj;
        return this.annotation.equals(bindKey.annotation) && this.type.equals(bindKey.type);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.annotation.hashCode();
    }

    public static <T> BindKey<T> bindKey(Class<T> cls, Class<? extends Annotation> cls2) {
        return new BindKey<>(cls, cls2);
    }
}
