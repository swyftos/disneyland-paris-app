package com.mrousavy.camera.core.extensions;

import androidx.camera.core.DynamicRange;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0004"}, d2 = {"isSDR", "", "Landroidx/camera/core/DynamicRange;", "(Landroidx/camera/core/DynamicRange;)Z", "react-native-vision-camera_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DynamicRange_isSDRKt {
    public static final boolean isSDR(@NotNull DynamicRange dynamicRange) {
        Intrinsics.checkNotNullParameter(dynamicRange, "<this>");
        return dynamicRange.getEncoding() == 1 || dynamicRange.getEncoding() == 0;
    }
}
