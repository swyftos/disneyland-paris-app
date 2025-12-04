package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public interface ImageProcessor {

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface OutputFormats {
    }

    public interface Request {
        @NonNull
        ImageProxy getInputImage();

        int getOutputFormat();
    }

    public interface Response {
        @NonNull
        ImageProxy getOutputImage();
    }

    @NonNull
    Response process(@NonNull Request request) throws ProcessingException;
}
