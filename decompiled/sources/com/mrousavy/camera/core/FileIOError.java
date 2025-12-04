package com.mrousavy.camera.core;

import com.amazonaws.services.s3.model.InstructionFileId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/mrousavy/camera/core/FileIOError;", "Lcom/mrousavy/camera/core/CameraError;", "throwable", "", "<init>", "(Ljava/lang/Throwable;)V", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FileIOError extends CameraError {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileIOError(@NotNull Throwable throwable) {
        super("capture", "file-io-error", "An unexpected File IO error occurred! Error: " + throwable.getMessage() + InstructionFileId.DOT, throwable);
        Intrinsics.checkNotNullParameter(throwable, "throwable");
    }
}
