package kotlin.reflect.jvm.internal.impl.storage;

/* loaded from: classes6.dex */
class SingleThreadValue {
    private final Thread thread = Thread.currentThread();
    private final Object value;

    SingleThreadValue(Object obj) {
        this.value = obj;
    }

    public boolean hasValue() {
        return this.thread == Thread.currentThread();
    }

    public Object getValue() {
        if (!hasValue()) {
            throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
        }
        return this.value;
    }
}
