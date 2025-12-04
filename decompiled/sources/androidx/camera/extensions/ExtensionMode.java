package androidx.camera.extensions;

import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class ExtensionMode {
    public static final int AUTO = 5;
    public static final int BOKEH = 1;
    public static final int FACE_RETOUCH = 4;
    public static final int HDR = 2;
    public static final int NIGHT = 3;
    public static final int NONE = 0;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Mode {
    }
}
