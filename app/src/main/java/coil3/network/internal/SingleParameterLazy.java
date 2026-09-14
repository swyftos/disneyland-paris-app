package coil3.network.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00060\u0003j\u0002`\u0004B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001a\u00028\u00012\u0006\u0010\u000b\u001a\u00028\u0000¢\u0006\u0002\u0010\fR\u001c\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, m1836d2 = {"Lcoil3/network/internal/SingleParameterLazy;", "P", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/atomicfu/locks/SynchronizedObject;", "initializer", "Lkotlin/Function1;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "_value", "get", "parameter", "(Ljava/lang/Object;)Ljava/lang/Object;", "coil-network-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class SingleParameterLazy<P, T> {
    private Object _value = UNINITIALIZED.INSTANCE;
    private Function1 initializer;

    public SingleParameterLazy(@NotNull Function1<? super P, ? extends T> function1) {
        this.initializer = function1;
    }

    public final T get(P parameter) {
        T t;
        T t2 = (T) this._value;
        UNINITIALIZED uninitialized = UNINITIALIZED.INSTANCE;
        if (t2 != uninitialized) {
            return t2;
        }
        synchronized (this) {
            t = (T) this._value;
            if (t == uninitialized) {
                Function1 function1 = this.initializer;
                Intrinsics.checkNotNull(function1);
                t = (T) function1.invoke(parameter);
                this._value = t;
                this.initializer = null;
            }
        }
        return t;
    }
}
