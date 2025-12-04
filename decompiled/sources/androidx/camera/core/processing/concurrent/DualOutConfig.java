package androidx.camera.core.processing.concurrent;

import androidx.annotation.NonNull;
import androidx.camera.core.processing.util.OutConfig;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class DualOutConfig {
    @NonNull
    public abstract OutConfig getPrimaryOutConfig();

    @NonNull
    public abstract OutConfig getSecondaryOutConfig();

    @NonNull
    public static DualOutConfig of(@NonNull OutConfig outConfig, @NonNull OutConfig outConfig2) {
        return new AutoValue_DualOutConfig(outConfig, outConfig2);
    }
}
