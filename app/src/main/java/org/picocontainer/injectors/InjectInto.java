package org.picocontainer.injectors;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes5.dex */
public class InjectInto implements Type {
    private Object intoKey;
    private Type intoType;

    public InjectInto(Type type, Object obj) {
        this.intoType = type;
        this.intoKey = obj;
    }

    public Type getIntoType() {
        return this.intoType;
    }

    public Class getIntoClass() {
        return (Class) getIntoType();
    }

    public Object getIntoKey() {
        return this.intoKey;
    }
}
