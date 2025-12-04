package com.mrousavy.camera.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/mrousavy/camera/core/RecorderError;", "Lcom/mrousavy/camera/core/CameraError;", "id", "", "message", "wasVideoRecorded", "", "cause", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Throwable;)V", "getWasVideoRecorded", "()Z", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public class RecorderError extends CameraError {
    private final boolean wasVideoRecorded;

    public final boolean getWasVideoRecorded() {
        return this.wasVideoRecorded;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecorderError(@NotNull String id, @NotNull String message, boolean z, @Nullable Throwable th) {
        super("capture", id, message, th);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(message, "message");
        this.wasVideoRecorded = z;
    }
}
