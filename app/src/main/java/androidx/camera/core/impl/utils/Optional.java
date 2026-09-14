package androidx.camera.core.impl.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.core.util.Supplier;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public abstract boolean equals(@Nullable Object obj);

    @NonNull
    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    @NonNull
    /* JADX INFO: renamed from: or */
    public abstract Optional<T> mo51or(@NonNull Optional<? extends T> optional);

    @NonNull
    /* JADX INFO: renamed from: or */
    public abstract T mo52or(@NonNull Supplier<? extends T> supplier);

    @NonNull
    /* JADX INFO: renamed from: or */
    public abstract T mo53or(@NonNull T t);

    @Nullable
    public abstract T orNull();

    @NonNull
    public abstract String toString();

    @NonNull
    public static <T> Optional<T> absent() {
        return Absent.withType();
    }

    @NonNull
    /* JADX INFO: renamed from: of */
    public static <T> Optional<T> m54of(@NonNull T t) {
        return new Present(Preconditions.checkNotNull(t));
    }

    @NonNull
    public static <T> Optional<T> fromNullable(@Nullable T t) {
        return t == null ? absent() : new Present(t);
    }

    Optional() {
    }
}
