package kotlin.reflect.jvm.internal.impl.types.checker;

import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class Ref<T> {
    private Object value;

    @NotNull
    public final T getValue() {
        return (T) this.value;
    }
}
