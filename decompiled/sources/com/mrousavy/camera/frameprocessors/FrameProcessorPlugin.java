package com.mrousavy.camera.frameprocessors;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.proguard.annotations.DoNotStrip;
import java.util.Map;

@DoNotStrip
@Keep
/* loaded from: classes4.dex */
public abstract class FrameProcessorPlugin {
    @DoNotStrip
    @Keep
    @Nullable
    public abstract Object callback(@NonNull Frame frame, @Nullable Map<String, Object> map) throws Throwable;
}
