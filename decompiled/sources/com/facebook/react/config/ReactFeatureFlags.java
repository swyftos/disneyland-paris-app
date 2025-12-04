package com.facebook.react.config;

import com.facebook.proguard.annotations.DoNotStripAny;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Deprecated(message = "Use com.facebook.react.internal.featureflags.ReactNativeFeatureFlags instead.")
@DoNotStripAny
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/react/config/ReactFeatureFlags;", "", "<init>", "()V", "dispatchPointerEvents", "", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReactFeatureFlags {

    @NotNull
    public static final ReactFeatureFlags INSTANCE = new ReactFeatureFlags();

    @JvmField
    public static boolean dispatchPointerEvents;

    private ReactFeatureFlags() {
    }
}
