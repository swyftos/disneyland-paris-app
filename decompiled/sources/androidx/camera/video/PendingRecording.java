package androidx.camera.video;

import android.content.Context;
import androidx.annotation.CheckResult;
import androidx.annotation.RequiresPermission;
import androidx.camera.core.impl.utils.ContextUtil;
import androidx.core.content.PermissionChecker;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0000H\u0007J\b\u0010\u0014\u001a\u00020\u0003H\u0001J\u0010\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0001J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0001J\b\u0010\u0017\u001a\u00020\u0007H\u0001J\b\u0010\u0018\u001a\u00020\u0005H\u0001J\b\u0010\r\u001a\u00020\u000eH\u0001J\b\u0010\u000f\u001a\u00020\u000eH\u0001J\b\u0010\u0010\u001a\u00020\u000eH\u0001J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0007J\u0012\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u001d\u001a\u00020\u000eH\u0007R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/camera/video/PendingRecording;", "", "context", "Landroid/content/Context;", "recorder", "Landroidx/camera/video/Recorder;", "outputOptions", "Landroidx/camera/video/OutputOptions;", "(Landroid/content/Context;Landroidx/camera/video/Recorder;Landroidx/camera/video/OutputOptions;)V", "applicationContext", "eventListener", "Landroidx/core/util/Consumer;", "Landroidx/camera/video/VideoRecordEvent;", "isAudioEnabled", "", "isAudioInitialMuted", "isPersistent", "listenerExecutor", "Ljava/util/concurrent/Executor;", "asPersistentRecording", "getApplicationContext", "getEventListener", "getListenerExecutor", "getOutputOptions", "getRecorder", ViewProps.START, "Landroidx/camera/video/Recording;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "withAudioEnabled", "initialMuted", "camera-video_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PendingRecording {
    private final Context applicationContext;
    private Consumer eventListener;
    private boolean isAudioEnabled;
    private boolean isAudioInitialMuted;
    private boolean isPersistent;
    private Executor listenerExecutor;
    private final OutputOptions outputOptions;
    private final Recorder recorder;

    @RequiresPermission("android.permission.RECORD_AUDIO")
    @JvmOverloads
    @NotNull
    public final PendingRecording withAudioEnabled() {
        return withAudioEnabled$default(this, false, 1, null);
    }

    public PendingRecording(@NotNull Context context, @NotNull Recorder recorder, @NotNull OutputOptions outputOptions) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(recorder, "recorder");
        Intrinsics.checkNotNullParameter(outputOptions, "outputOptions");
        this.recorder = recorder;
        this.outputOptions = outputOptions;
        Context applicationContext = ContextUtil.getApplicationContext(context);
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(context)");
        this.applicationContext = applicationContext;
    }

    @JvmName(name = "getApplicationContext")
    @NotNull
    public final Context getApplicationContext() {
        return this.applicationContext;
    }

    @JvmName(name = "getRecorder")
    @NotNull
    public final Recorder getRecorder() {
        return this.recorder;
    }

    @JvmName(name = "getOutputOptions")
    @NotNull
    public final OutputOptions getOutputOptions() {
        return this.outputOptions;
    }

    @JvmName(name = "getListenerExecutor")
    @Nullable
    public final Executor getListenerExecutor() {
        return this.listenerExecutor;
    }

    @JvmName(name = "getEventListener")
    @Nullable
    public final Consumer<VideoRecordEvent> getEventListener() {
        return this.eventListener;
    }

    @JvmName(name = "isAudioEnabled")
    /* renamed from: isAudioEnabled, reason: from getter */
    public final boolean getIsAudioEnabled() {
        return this.isAudioEnabled;
    }

    @JvmName(name = "isAudioInitialMuted")
    /* renamed from: isAudioInitialMuted, reason: from getter */
    public final boolean getIsAudioInitialMuted() {
        return this.isAudioInitialMuted;
    }

    @JvmName(name = "isPersistent")
    /* renamed from: isPersistent, reason: from getter */
    public final boolean getIsPersistent() {
        return this.isPersistent;
    }

    public static /* synthetic */ PendingRecording withAudioEnabled$default(PendingRecording pendingRecording, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return pendingRecording.withAudioEnabled(z);
    }

    @RequiresPermission("android.permission.RECORD_AUDIO")
    @JvmOverloads
    @NotNull
    public final PendingRecording withAudioEnabled(boolean initialMuted) {
        if (PermissionChecker.checkSelfPermission(this.applicationContext, "android.permission.RECORD_AUDIO") == -1) {
            throw new SecurityException("Attempted to enable audio for recording but application does not have RECORD_AUDIO permission granted.");
        }
        Preconditions.checkState(this.recorder.isAudioSupported(), "The Recorder this recording is associated to doesn't support audio.");
        this.isAudioEnabled = true;
        this.isAudioInitialMuted = initialMuted;
        return this;
    }

    @ExperimentalPersistentRecording
    @NotNull
    public final PendingRecording asPersistentRecording() {
        this.isPersistent = true;
        return this;
    }

    @CheckResult
    @NotNull
    public final Recording start(@NotNull Executor listenerExecutor, @NotNull Consumer<VideoRecordEvent> listener) {
        Intrinsics.checkNotNullParameter(listenerExecutor, "listenerExecutor");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Preconditions.checkNotNull(listenerExecutor, "Listener Executor can't be null.");
        Preconditions.checkNotNull(listener, "Event listener can't be null");
        this.listenerExecutor = listenerExecutor;
        this.eventListener = listener;
        Recording recordingStart = this.recorder.start(this);
        Intrinsics.checkNotNullExpressionValue(recordingStart, "recorder.start(this)");
        return recordingStart;
    }
}
