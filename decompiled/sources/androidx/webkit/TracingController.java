package androidx.webkit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.webkit.internal.TracingControllerImpl;
import java.io.OutputStream;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public abstract class TracingController {

    private static class LAZY_HOLDER {
        static final TracingController INSTANCE = new TracingControllerImpl();
    }

    public abstract boolean isTracing();

    public abstract void start(@NonNull TracingConfig tracingConfig);

    public abstract boolean stop(@Nullable OutputStream outputStream, @NonNull Executor executor);

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public TracingController() {
    }

    @NonNull
    public static TracingController getInstance() {
        return LAZY_HOLDER.INSTANCE;
    }
}
