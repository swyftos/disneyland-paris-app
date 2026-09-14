package org.apache.commons.lang3.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes6.dex */
public abstract class TypeLiteral<T> implements Typed<T> {

    /* JADX INFO: renamed from: T */
    private static final TypeVariable f3990T = TypeLiteral.class.getTypeParameters()[0];
    private final String toString;
    public final Type value;

    protected TypeLiteral() {
        Map<TypeVariable<?>, Type> typeArguments = TypeUtils.getTypeArguments(getClass(), TypeLiteral.class);
        TypeVariable typeVariable = f3990T;
        Type type = (Type) Validate.notNull(typeArguments.get(typeVariable), "%s does not assign type parameter %s", getClass(), TypeUtils.toLongString(typeVariable));
        this.value = type;
        this.toString = String.format("%s<%s>", TypeLiteral.class.getSimpleName(), TypeUtils.toString(type));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TypeLiteral) {
            return TypeUtils.equals(this.value, ((TypeLiteral) obj).value);
        }
        return false;
    }

    @Override // org.apache.commons.lang3.reflect.Typed
    public Type getType() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode() | 592;
    }

    public String toString() {
        return this.toString;
    }
}
