package androidx.camera.core.impl;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import java.util.concurrent.Executor;

@AutoValue
/* loaded from: classes.dex */
public abstract class CameraThreadConfig {
    @NonNull
    public abstract Executor getCameraExecutor();

    @NonNull
    public abstract Handler getSchedulerHandler();

    @NonNull
    public static CameraThreadConfig create(@NonNull Executor executor, @NonNull Handler handler) {
        return new AutoValue_CameraThreadConfig(executor, handler);
    }
}
