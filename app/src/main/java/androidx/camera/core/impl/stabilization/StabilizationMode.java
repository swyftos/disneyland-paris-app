package androidx.camera.core.impl.stabilization;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class StabilizationMode {
    public static final int OFF = 1;

    /* JADX INFO: renamed from: ON */
    public static final int f21ON = 2;
    public static final int UNSPECIFIED = 0;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Mode {
    }
}
