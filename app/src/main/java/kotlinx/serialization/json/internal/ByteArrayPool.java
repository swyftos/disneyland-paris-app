package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, m1836d2 = {"Lkotlinx/serialization/json/internal/ByteArrayPool;", "Lkotlinx/serialization/json/internal/ByteArrayPoolBase;", "()V", "release", "", "array", "", "take", "kotlinx-serialization-json"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
public final class ByteArrayPool extends ByteArrayPoolBase {

    @NotNull
    public static final ByteArrayPool INSTANCE = new ByteArrayPool();

    private ByteArrayPool() {
    }

    @NotNull
    public final byte[] take() {
        return super.take(512);
    }

    public final void release(@NotNull byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        releaseImpl(array);
    }
}
