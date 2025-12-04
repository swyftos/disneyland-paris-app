package dagger.internal;

import dagger.Lazy;

/* loaded from: classes5.dex */
public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {
    private static final InstanceFactory NULL_INSTANCE_FACTORY = new InstanceFactory(null);
    private final Object instance;

    public static <T> Factory<T> create(T t) {
        return new InstanceFactory(Preconditions.checkNotNull(t, "instance cannot be null"));
    }

    public static <T> Factory<T> createNullable(T t) {
        if (t == null) {
            return nullInstanceFactory();
        }
        return new InstanceFactory(t);
    }

    private static InstanceFactory nullInstanceFactory() {
        return NULL_INSTANCE_FACTORY;
    }

    private InstanceFactory(Object obj) {
        this.instance = obj;
    }

    @Override // javax.inject.Provider
    public T get() {
        return (T) this.instance;
    }
}
