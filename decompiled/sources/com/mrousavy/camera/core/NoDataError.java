package com.mrousavy.camera.core;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/mrousavy/camera/core/NoDataError;", "Lcom/mrousavy/camera/core/RecorderError;", "cause", "", "<init>", "(Ljava/lang/Throwable;)V", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NoDataError extends RecorderError {
    public NoDataError(@Nullable Throwable th) {
        super("no-data", "The Video Recording failed because no data was received! (" + (th != null ? th.getMessage() : null) + ") Did you stop the recording before any Frames arrived?", false, th);
    }
}
