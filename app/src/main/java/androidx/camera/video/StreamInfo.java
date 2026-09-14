package androidx.camera.video;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.ConstantObservable;
import androidx.camera.core.impl.Observable;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@AutoValue
@RestrictTo({RestrictTo.Scope.LIBRARY})
public abstract class StreamInfo {
    static final StreamInfo STREAM_INFO_ANY_INACTIVE = m78of(0, StreamState.INACTIVE);
    static final Set NON_SURFACE_STREAM_ID = Collections.unmodifiableSet(new HashSet(Arrays.asList(0, -1)));
    static final Observable ALWAYS_ACTIVE_OBSERVABLE = ConstantObservable.withValue(m78of(0, StreamState.ACTIVE));

    enum StreamState {
        ACTIVE,
        INACTIVE
    }

    public abstract int getId();

    @Nullable
    public abstract SurfaceRequest.TransformationInfo getInProgressTransformationInfo();

    @NonNull
    public abstract StreamState getStreamState();

    StreamInfo() {
    }

    /* JADX INFO: renamed from: of */
    static StreamInfo m78of(int i, StreamState streamState) {
        return new AutoValue_StreamInfo(i, streamState, null);
    }

    /* JADX INFO: renamed from: of */
    static StreamInfo m79of(int i, StreamState streamState, SurfaceRequest.TransformationInfo transformationInfo) {
        return new AutoValue_StreamInfo(i, streamState, transformationInfo);
    }
}
