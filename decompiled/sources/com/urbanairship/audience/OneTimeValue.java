package com.urbanairship.audience;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u00028\u0000¢\u0006\u0002\u0010\nR\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0002X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/audience/OneTimeValue;", ExifInterface.GPS_DIRECTION_TRUE, "", "fetcher", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "cached", "Ljava/lang/Object;", "lock", "getValue", "()Ljava/lang/Object;", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OneTimeValue<T> {
    private Object cached;
    private Function0 fetcher;
    private Object lock;

    public OneTimeValue(@NotNull Function0<? extends T> fetcher) {
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        this.fetcher = fetcher;
        this.lock = new Object();
    }

    public final T getValue() {
        T t;
        synchronized (this.lock) {
            try {
                t = (T) this.cached;
                if (t == null) {
                    t = (T) this.fetcher.invoke();
                }
                this.cached = t;
            } catch (Throwable th) {
                throw th;
            }
        }
        return t;
    }
}
