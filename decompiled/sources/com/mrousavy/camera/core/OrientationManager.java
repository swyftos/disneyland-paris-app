package com.mrousavy.camera.core;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.Log;
import android.view.Display;
import android.view.OrientationEventListener;
import com.mrousavy.camera.core.types.Orientation;
import com.mrousavy.camera.core.types.OutputOrientation;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b*\u0002\u0012\u0016\u0018\u0000 $2\u00020\u0001:\u0002$%B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u0006\u0010\u001f\u001a\u00020\u001eJ\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\tJ\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001a¨\u0006&"}, d2 = {"Lcom/mrousavy/camera/core/OrientationManager;", "", "context", "Landroid/content/Context;", "callback", "Lcom/mrousavy/camera/core/OrientationManager$Callback;", "<init>", "(Landroid/content/Context;Lcom/mrousavy/camera/core/OrientationManager$Callback;)V", "targetOutputOrientation", "Lcom/mrousavy/camera/core/types/OutputOrientation;", "lastOutputOrientation", "Lcom/mrousavy/camera/core/types/Orientation;", "lastPreviewOrientation", "screenRotation", "", "displayManager", "Landroid/hardware/display/DisplayManager;", "displayListener", "com/mrousavy/camera/core/OrientationManager$displayListener$1", "Lcom/mrousavy/camera/core/OrientationManager$displayListener$1;", "deviceRotation", "orientationListener", "com/mrousavy/camera/core/OrientationManager$orientationListener$1", "Lcom/mrousavy/camera/core/OrientationManager$orientationListener$1;", "previewOrientation", "getPreviewOrientation", "()Lcom/mrousavy/camera/core/types/Orientation;", "outputOrientation", "getOutputOrientation", "maybeNotifyOrientationChanged", "", "stopOrientationUpdates", "setTargetOutputOrientation", "targetOrientation", "degreesToSurfaceRotation", "degrees", "Companion", "Callback", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class OrientationManager {
    private final Callback callback;
    private final Context context;
    private int deviceRotation;
    private final OrientationManager$displayListener$1 displayListener;
    private final DisplayManager displayManager;
    private Orientation lastOutputOrientation;
    private Orientation lastPreviewOrientation;
    private final OrientationManager$orientationListener$1 orientationListener;
    private int screenRotation;
    private OutputOrientation targetOutputOrientation;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, d2 = {"Lcom/mrousavy/camera/core/OrientationManager$Callback;", "", "onOutputOrientationChanged", "", "outputOrientation", "Lcom/mrousavy/camera/core/types/Orientation;", "onPreviewOrientationChanged", "previewOrientation", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Callback {
        void onOutputOrientationChanged(@NotNull Orientation outputOrientation);

        void onPreviewOrientationChanged(@NotNull Orientation previewOrientation);
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OutputOrientation.values().length];
            try {
                iArr[OutputOrientation.DEVICE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OutputOrientation.PREVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int degreesToSurfaceRotation(int degrees) {
        if (45 <= degrees && degrees < 136) {
            return 3;
        }
        if (135 > degrees || degrees >= 226) {
            return (225 > degrees || degrees >= 316) ? 0 : 1;
        }
        return 2;
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [com.mrousavy.camera.core.OrientationManager$displayListener$1] */
    /* JADX WARN: Type inference failed for: r3v6, types: [com.mrousavy.camera.core.OrientationManager$orientationListener$1] */
    public OrientationManager(@NotNull final Context context, @NotNull Callback callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.context = context;
        this.callback = callback;
        this.targetOutputOrientation = OutputOrientation.DEVICE;
        Object systemService = context.getSystemService("display");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.display.DisplayManager");
        this.displayManager = (DisplayManager) systemService;
        this.displayListener = new DisplayManager.DisplayListener() { // from class: com.mrousavy.camera.core.OrientationManager$displayListener$1
            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayAdded(int displayId) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayRemoved(int displayId) {
            }

            @Override // android.hardware.display.DisplayManager.DisplayListener
            public void onDisplayChanged(int displayId) {
                Display display = this.this$0.displayManager.getDisplay(displayId);
                if (display == null) {
                    return;
                }
                this.this$0.screenRotation = display.getRotation();
                this.this$0.maybeNotifyOrientationChanged();
            }
        };
        this.orientationListener = new OrientationEventListener(context) { // from class: com.mrousavy.camera.core.OrientationManager$orientationListener$1
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int rotationDegrees) {
                if (rotationDegrees == -1) {
                    return;
                }
                OrientationManager orientationManager = this.this$0;
                orientationManager.deviceRotation = orientationManager.degreesToSurfaceRotation(rotationDegrees);
                this.this$0.maybeNotifyOrientationChanged();
            }
        };
    }

    @NotNull
    public final Orientation getPreviewOrientation() {
        return Orientation.INSTANCE.fromSurfaceRotation(this.screenRotation);
    }

    @NotNull
    public final Orientation getOutputOrientation() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.targetOutputOrientation.ordinal()];
        if (i == 1) {
            return Orientation.INSTANCE.fromSurfaceRotation(this.deviceRotation);
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return getPreviewOrientation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void maybeNotifyOrientationChanged() {
        Orientation previewOrientation = getPreviewOrientation();
        if (this.lastPreviewOrientation != previewOrientation) {
            this.callback.onPreviewOrientationChanged(previewOrientation);
            this.lastPreviewOrientation = previewOrientation;
        }
        Orientation outputOrientation = getOutputOrientation();
        if (this.lastOutputOrientation != outputOrientation) {
            this.callback.onOutputOrientationChanged(outputOrientation);
            this.lastOutputOrientation = outputOrientation;
        }
    }

    public final void stopOrientationUpdates() {
        this.displayManager.unregisterDisplayListener(this.displayListener);
        disable();
    }

    public final void setTargetOutputOrientation(@NotNull OutputOrientation targetOrientation) {
        Intrinsics.checkNotNullParameter(targetOrientation, "targetOrientation");
        Log.i("OrientationManager", "Target Orientation changed " + this.targetOutputOrientation + " -> " + targetOrientation + "!");
        this.targetOutputOrientation = targetOrientation;
        stopOrientationUpdates();
        int i = WhenMappings.$EnumSwitchMapping$0[targetOrientation.ordinal()];
        if (i == 1) {
            Log.i("OrientationManager", "Starting streaming device and screen orientation updates...");
            enable();
            this.displayManager.registerDisplayListener(this.displayListener, null);
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            Log.i("OrientationManager", "Starting streaming device and screen orientation updates...");
            this.displayManager.registerDisplayListener(this.displayListener, null);
        }
    }
}
