package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

@AutoValue
/* loaded from: classes.dex */
public abstract class CameraState {
    public static final int ERROR_CAMERA_DISABLED = 5;
    public static final int ERROR_CAMERA_FATAL_ERROR = 6;
    public static final int ERROR_CAMERA_IN_USE = 2;
    public static final int ERROR_DO_NOT_DISTURB_MODE_ENABLED = 7;
    public static final int ERROR_MAX_CAMERAS_IN_USE = 1;
    public static final int ERROR_OTHER_RECOVERABLE_ERROR = 3;
    public static final int ERROR_STREAM_CONFIG = 4;

    public enum ErrorType {
        RECOVERABLE,
        CRITICAL
    }

    public enum Type {
        PENDING_OPEN,
        OPENING,
        OPEN,
        CLOSING,
        CLOSED
    }

    @Nullable
    public abstract StateError getError();

    @NonNull
    public abstract Type getType();

    @NonNull
    public static CameraState create(@NonNull Type type) {
        return create(type, null);
    }

    @NonNull
    public static CameraState create(@NonNull Type type, @Nullable StateError stateError) {
        return new AutoValue_CameraState(type, stateError);
    }

    @AutoValue
    public static abstract class StateError {
        @Nullable
        public abstract Throwable getCause();

        public abstract int getCode();

        @NonNull
        public static StateError create(int i) {
            return create(i, null);
        }

        @NonNull
        public static StateError create(int i, @Nullable Throwable th) {
            return new AutoValue_CameraState_StateError(i, th);
        }

        @NonNull
        public ErrorType getType() {
            int code = getCode();
            if (code == 2 || code == 1 || code == 3) {
                return ErrorType.RECOVERABLE;
            }
            return ErrorType.CRITICAL;
        }
    }
}
