package coil3.network.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a4\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0000¨\u0006\u0006"}, m1836d2 = {"singleParameterLazy", "Lcoil3/network/internal/SingleParameterLazy;", "P", ExifInterface.GPS_DIRECTION_TRUE, "initializer", "Lkotlin/Function1;", "coil-network-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class SingleParameterLazyKt {
    @NotNull
    public static final <P, T> SingleParameterLazy<P, T> singleParameterLazy(@NotNull Function1<? super P, ? extends T> function1) {
        return new SingleParameterLazy<>(function1);
    }
}
