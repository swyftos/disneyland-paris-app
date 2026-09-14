package androidx.camera.core.processing.concurrent;

import androidx.annotation.NonNull;
import androidx.camera.core.processing.util.OutConfig;
import com.google.auto.value.AutoValue;

/* JADX INFO: loaded from: classes.dex */
@AutoValue
public abstract class DualOutConfig {
    @NonNull
    public abstract OutConfig getPrimaryOutConfig();

    @NonNull
    public abstract OutConfig getSecondaryOutConfig();

    @NonNull
    /* JADX INFO: renamed from: of */
    public static DualOutConfig m61of(@NonNull OutConfig outConfig, @NonNull OutConfig outConfig2) {
        return new AutoValue_DualOutConfig(outConfig, outConfig2);
    }
}
