package com.mrousavy.camera.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/mrousavy/camera/core/InvalidTypeScriptUnionError;", "Lcom/mrousavy/camera/core/CameraError;", "unionName", "", "unionValue", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "react-native-vision-camera_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InvalidTypeScriptUnionError extends CameraError {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidTypeScriptUnionError(@NotNull String unionName, @Nullable String str) {
        super("parameter", "invalid-parameter", "The given value for " + unionName + " could not be parsed! (Received: " + str + ")", null, 8, null);
        Intrinsics.checkNotNullParameter(unionName, "unionName");
    }
}
