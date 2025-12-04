package androidx.core.os;

import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.os.ProfilingRequestBuilder;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi(api = 35)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b'\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002B\u0007\b\u0000¢\u0006\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u000bH%J\b\u0010\f\u001a\u00020\rH%J\r\u0010\u000e\u001a\u00028\u0000H%¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0007¢\u0006\u0002\u0010\u0015R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/core/os/ProfilingRequestBuilder;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "mCancellationSignal", "Landroid/os/CancellationSignal;", "mTag", "", "build", "Landroidx/core/os/ProfilingRequest;", "getParams", "Landroid/os/Bundle;", "getProfilingType", "", "getThis", "()Landroidx/core/os/ProfilingRequestBuilder;", "setCancellationSignal", "cancellationSignal", "(Landroid/os/CancellationSignal;)Landroidx/core/os/ProfilingRequestBuilder;", "setTag", "tag", "(Ljava/lang/String;)Landroidx/core/os/ProfilingRequestBuilder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ProfilingRequestBuilder<T extends ProfilingRequestBuilder<T>> {
    private android.os.CancellationSignal mCancellationSignal;
    private String mTag;

    @RestrictTo({RestrictTo.Scope.SUBCLASSES})
    @NotNull
    protected abstract Bundle getParams();

    @RestrictTo({RestrictTo.Scope.SUBCLASSES})
    protected abstract int getProfilingType();

    @RestrictTo({RestrictTo.Scope.SUBCLASSES})
    @NotNull
    protected abstract T getThis();

    @NotNull
    public final T setTag(@NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.mTag = tag;
        return (T) getThis();
    }

    @NotNull
    public final T setCancellationSignal(@NotNull android.os.CancellationSignal cancellationSignal) {
        Intrinsics.checkNotNullParameter(cancellationSignal, "cancellationSignal");
        this.mCancellationSignal = cancellationSignal;
        return (T) getThis();
    }

    @NotNull
    public final ProfilingRequest build() {
        return new ProfilingRequest(getProfilingType(), getMParams(), this.mTag, this.mCancellationSignal);
    }
}
